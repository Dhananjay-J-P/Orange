package orange.data.manager.ifc;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import controller.query.model.BookingModel;
import orange.bus.Bus;
import orange.bus.seats.Seat;
import orange.user.ifc.UserIfc;

public interface DataManagerIfc {
	
	public boolean isValidUser(UserIfc user);
	
	public Map<String,String> getAllStops(Locale locale);

	public List<Bus> getBusList(BookingModel queryModel);

	public Map<String, Seat[]> getSeatStatus(BookingModel query);

	public BookingModel bookSeats(BookingModel booking);

}
