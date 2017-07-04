package orange.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import controller.query.model.BookingModel;
import orange.bus.Bus;
import orange.bus.seats.Seat;
import orange.data.manager.ifc.DataManagerIfc;
import orange.validator.BusSearchValidator;

@Controller
@SessionAttributes("bookingModel")
public class BusController {

	@Autowired
	WebApplicationContext context;

	@Autowired
	DataManagerIfc manager;

	@RequestMapping("/search")
	public String searchBusess(@ModelAttribute BookingModel bookingModel, BindingResult result, Model model,
			Locale locale, RedirectAttributes redirectAttributes) {
		// Validation part

		BusSearchValidator validator = context.getBean("searchValidator", BusSearchValidator.class);

		boolean error = validator.validate(bookingModel, result, model, context, locale);

		List<Bus> busList = null;
		if (!error) {
			busList = manager.getBusList(bookingModel);
			if (busList.isEmpty()) {
				error = true;
				model.addAttribute("SearchError", context.getMessage("error.bus.not.found", null, locale));
			}

		}
		if (result.hasErrors() || error) {
			Map<String, String> locations = manager.getAllStops(locale);
			model.addAttribute("sourceList", locations);
			model.addAttribute("destinationList", locations);

			return "/home";
		}
		redirectAttributes.addFlashAttribute("busList", busList);

		return "redirect:/buses";
	}

	@RequestMapping("/buses")
	public String showBuses(@ModelAttribute ArrayList<Bus> busList, Model model, Locale locale) {

		if (busList.isEmpty()) {
			return "redirect:/home";
		}
		return "buslist";
	}

	@RequestMapping("/sub")
	public String showBus(@RequestParam(value = "busid") String busid, Model model, Locale locale) {

		BookingModel query = (BookingModel) model.asMap().get("bookingModel");

		query.setBusId(busid);

		Map<String, Seat[]> seatMap = manager.getSeatStatus(query);

		model.addAttribute("firstRow", seatMap.get("firstRow"));
		model.addAttribute("secondRow", seatMap.get("secondRow"));
		model.addAttribute("thirdRow", seatMap.get("thirdRow"));
		model.addAttribute("fourthRow", seatMap.get("fourthRow"));

		return "busseatstatus";
	}

	@RequestMapping("/book")
	public String bookSeats(@ModelAttribute BookingModel booking, Model model, Locale locale, RedirectAttributes redirectAttributes) {
		
		if (booking.getSeatArray() == null || (booking.getSeatArray()!=null && booking.getSeatArray().length<1)) {
			model.addAttribute("msg", "Please choose atleast one seat");
			Map<String, Seat[]> seatMap = manager.getSeatStatus(booking);
			model.addAttribute("firstRow", seatMap.get("firstRow"));
			model.addAttribute("secondRow", seatMap.get("secondRow"));
			model.addAttribute("thirdRow", seatMap.get("thirdRow"));
			model.addAttribute("fourthRow", seatMap.get("fourthRow"));
			return "busseatstatus";
		}
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User)authentication.getPrincipal();
		
		booking.setUserId(user.getUsername());
		
		BookingModel bookingAfter= manager.bookSeats(booking);
		
		if (bookingAfter.getBookingId()==null) {
			model.addAttribute("msg", "Sorry we could not process your request currently");
			Map<String, Seat[]> seatMap = manager.getSeatStatus(booking);
			model.addAttribute("firstRow", seatMap.get("firstRow"));
			model.addAttribute("secondRow", seatMap.get("secondRow"));
			model.addAttribute("thirdRow", seatMap.get("thirdRow"));
			model.addAttribute("fourthRow", seatMap.get("fourthRow"));
			return "busseatstatus";
		}
		
		redirectAttributes.addFlashAttribute("bookingAfter",bookingAfter);
		
		return "redirect:/bookingDone";
	}
	
	@RequestMapping("/bookingDone")
	public String bookingDone(@ModelAttribute BookingModel bookingAfter,Model model)
	{
		model.addAttribute("bookingAfter",bookingAfter);
		return "bookingsuccess";
	}
	
}
