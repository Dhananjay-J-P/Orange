package orange.data.manager.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;

import controller.query.model.BookingModel;
import orange.bus.Bus;
import orange.bus.seats.Seat;
import orange.dao.ifc.DaoIfc;
import orange.data.manager.ifc.DataManagerIfc;
import orange.stops.StopsIfc;
import orange.user.ifc.UserIfc;

public class DataManager implements DataManagerIfc {

	DaoIfc dao;

	@Autowired
	WebApplicationContext context;

	public DaoIfc getDao() {
		return dao;
	}

	public void setDao(DaoIfc dao) {
		this.dao = dao;
	}


	public boolean isValidUser(UserIfc user) {
		// TODO Auto-generated method stub
		return dao.isValidUser(user);
	}

	List<StopsIfc> stopList = new ArrayList<StopsIfc>();


	public Map<String, String> getAllStops(Locale locale) {
		// TODO Auto-generated method stub
		if (stopList.isEmpty()) {

			stopList = dao.getAllStops();

		}

		Map<String, String> locations = new HashMap<String, String>();

		for (StopsIfc stop : stopList) {
			locations.put(stop.getStopId(), context.getMessage(stop.getStopMessageCode(), null, locale));
		}

		return locations;
	}


	public List<Bus> getBusList(BookingModel queryModel) {
		// TODO Auto-generated method stub
		return dao.getBusList(queryModel);
	}

	
	public Map<String, Seat[]> getSeatStatus(BookingModel query) {

		List<Seat> seatList = dao.getSeatStatus(query);

		if(seatList.isEmpty())
		{
			throw new NullPointerException();
		}
		
		int numberOfColumns = seatList.size() / 4;

		Seat[] firstRow = new Seat[numberOfColumns];
		Seat[] secondRow = new Seat[numberOfColumns];
		Seat[] thirdRow = new Seat[numberOfColumns];
		Seat[] fourthRow = new Seat[numberOfColumns];

		Map<String, Seat[]> seatMap = new HashMap<String, Seat[]>();

		int k = 0;
		for (int j = 0; j < numberOfColumns; j++) {
			firstRow[j] = seatList.get(k);
			k++;
			secondRow[j] = seatList.get(k);
			k++;
			thirdRow[j] = seatList.get(k);
			k++;
			fourthRow[j] = seatList.get(k);
			k++;
		}
		seatMap.put("firstRow", firstRow);
		seatMap.put("secondRow", secondRow);
		seatMap.put("thirdRow", thirdRow);
		seatMap.put("fourthRow", fourthRow);

		return seatMap;
	}

	public BookingModel bookSeats(BookingModel booking) {
		// TODO Auto-generated method stub
		BookingModel model= dao.bookSeats(booking);
		
		return model;
	}

}
