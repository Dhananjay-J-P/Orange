/**
 * 
 */
package orange.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import controller.query.model.BookingModel;
import orange.bus.Bus;
import orange.bus.seats.Seat;
import orange.dao.ifc.DaoIfc;
import orange.stops.Stops;
import orange.stops.StopsIfc;
import orange.user.ifc.UserIfc;
import orange.user.impl.User;

/**
 * @author Dhananjay P
 *
 */
public class HibernateDaoImpl implements DaoIfc {

	/*
	 * (non-Javadoc)
	 * 
	 * @see orange.dao.ifc.DaoIfc#isValidUser(orange.user.ifc.UserIfc)
	 * 
	 */

	SessionFactory sessionFactory;

	public boolean isValidUser(UserIfc user) {

		boolean result = false;
		Session session = sessionFactory.getCurrentSession();

		User userFromDb = (User) session.get(User.class, user.getUsername());

		if (userFromDb != null) {
			result = userFromDb.getPassword().equals(user.getPassword());
		}
		return result;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<StopsIfc> getAllStops() {
		// TODO Auto-generated method stub
		Session session = getSessionFactory().openSession();
		String query = " from Stops";
		List<StopsIfc> list = session.createQuery(query).list();
		session.flush();
		session.close();
		return list;
	}

	public List<Bus> getBusList(BookingModel queryModel) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		String query = " from Bus b where b.srcStop='" + queryModel.getBusFrom() + "' and b.destStop='"
				+ queryModel.getBusTo() + "' and  b.busid in (select distinct(busId) from Seat s where s.travelDate='"
				+ queryModel.getTravelDate() + "' and s.status='Available')";
		List<Bus> list = session.createQuery(query).list();
		session.flush();
		session.close();
		return list;
	}

	public List<Seat> getSeatStatus(BookingModel queryModel) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		String query = " from Seat s where s.busId='" + queryModel.getBusId() + "' and s.travelDate='"
				+ queryModel.getTravelDate() + "'";
		List<Seat> list = session.createQuery(query).list();
		session.flush();
		session.close();
		return list;
	}

	public BookingModel bookSeats(BookingModel booking) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();

		try {
			String[] seats = booking.getSeatArray();
			session.beginTransaction();
			for (String s : seats) {
				
				/*Seat seat = new Seat(booking.getBusId(), booking.getTravelDate(), s, "Booked");
*/
				String queryString = "UPDATE Seat SET status = :status WHERE busId=:busId and travelDate=:travelDate and seatId=:seatId and  status like 'Available' ";
				Query query = session.createQuery(queryString);
				query.setParameter("status", "Booked");
				query.setParameter("busId", booking.getBusId());
				query.setParameter("travelDate", booking.getTravelDate());
				query.setParameter("seatId", s);

				int result = query.executeUpdate();
				
				if(result==0)
				{
					throw new NullPointerException();
				}

			}

			Bus bus = (Bus) session.get(Bus.class, booking.getBusId());
			booking.setBusTime(bus.getBusTime());

			Stops stop = (Stops) session.get(Stops.class, booking.getBusFrom());
			booking.setBoardingPoint(stop.getStopMessageCode());

			String bookingId = "";
			bookingId += booking.getUserId().toUpperCase();
			bookingId += booking.getBusId().toUpperCase();
			bookingId += new SimpleDateFormat("hhmmss").format(new Date());

			booking.setBookingId(bookingId);
			booking.setNoOfSeats(seats.length);

			User user = (User) session.get(User.class, booking.getUserId());

			booking.setUser(user);
			user.getBookings().add(booking);
			// session.merge(user);

			booking.setBus(bus);
			bus.getBookings().add(booking);

			session.merge(booking);
			session.getTransaction().commit();
		} catch (Exception e) {

			session.getTransaction().rollback();
			booking.setBookingId(null);
		}

		session.flush();
		session.close();

		return booking;
	}

}
