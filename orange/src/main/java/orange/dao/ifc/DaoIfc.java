package orange.dao.ifc;

import java.util.List;

import controller.query.model.BookingModel;
import orange.bus.Bus;
import orange.bus.seats.Seat;
import orange.stops.StopsIfc;
import orange.user.ifc.UserIfc;

public interface DaoIfc {
	
	public boolean isValidUser(UserIfc user);
	
	public List<StopsIfc> getAllStops();

	public List<Bus> getBusList(BookingModel queryModel);

	public List<Seat> getSeatStatus(BookingModel query);

	public BookingModel bookSeats(BookingModel booking);

}
