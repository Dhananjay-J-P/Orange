package orange.validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.context.WebApplicationContext;

import controller.query.model.BookingModel;

@Component("searchValidator")
public class BusSearchValidator implements Validator {

	
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return BookingModel.class.isAssignableFrom(clazz);
	}

	
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmpty(errors, "busFrom", "error.start.point.null");
		ValidationUtils.rejectIfEmpty(errors, "busTo", "error.end.point.null");
		ValidationUtils.rejectIfEmpty(errors, "travelDate", "error.date.null");

	}

	public boolean validate(Object target, Errors errors, Model page, WebApplicationContext context, Locale locale) {

		boolean error = false;

		validate(target, errors);
		if (!errors.hasErrors()) {
			BookingModel model = (BookingModel) target;
			if (model.getBusFrom().equalsIgnoreCase(model.getBusTo())) {
				page.addAttribute("SearchError", context.getMessage("error.start.end.same", null, locale));
				error = true;
			}

			if (!error) {
				Date travelDate = null;
				try {
					travelDate = new SimpleDateFormat("yyyy-MM-dd").parse(model.getTravelDate());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (travelDate != null && travelDate.before(new Date())) {
					page.addAttribute("SearchError", context.getMessage("error.traveldate.past", null, locale));
					error = true;
				}
			}

		} else {
			error = true;
		}
		return error;
	}

}
