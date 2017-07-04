package orange.controller;

import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import controller.query.model.BookingModel;
import orange.data.manager.ifc.DataManagerIfc;
import orange.user.ifc.UserIfc;
import orange.user.impl.User;
import orange.validator.LoginValidator;

@Controller
@SessionAttributes("bookingModel")
public class LoginController {

	private static final Logger logger = Logger.getLogger(LoginController.class);

	@Autowired
	WebApplicationContext context;

	@Autowired
	DataManagerIfc manager;

	@RequestMapping("/welcome")
	public String welcome(Model model, HttpServletRequest request) {

		logger.info("processing /welcome");
		UserIfc command = context.getBean("user", UserIfc.class);
		model.addAttribute("user", command);
		return "redirect:/home";
	}

	@RequestMapping("/auth")
	public String authorization(@ModelAttribute User user, BindingResult result, Model model, Locale locale) {

		LoginValidator validator = context.getBean("loginValidator", LoginValidator.class);
		validator.validate(user, result);

		if (result.hasErrors()) {
			return "/login";
		} else {
			/*
			 * if (manager.isValidUser(user)) {
			 * 
			 * } else { model.addAttribute("actionError",context.getMessage(
			 * "global.login.notvaliduser", null,locale )); return "/login"; }
			 */

		}

		return "redirect:/home";
	}

	// Spring Security see this :
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, HttpServletRequest request,
			HttpServletResponse response, Locale locale) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", context.getMessage("global.login.notvaliduser", null, locale));
		}

		if (logout != null) {
			model.addObject("msg", context.getMessage("user.loggedout.success", null, locale));
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			if (auth != null) {
				new SecurityContextLogoutHandler().logout(request, response, auth);
			}
		}
		model.setViewName("slogin");

		return model;

	}

	@RequestMapping("/home")
	public String home(Model model, Locale locale) {
		BookingModel bookingModel = context.getBean("queryModel", BookingModel.class);

		model.addAttribute("bookingModel", bookingModel);

		Map<String, String> locations = manager.getAllStops(locale);

		model.addAttribute("sourceList", locations);
		model.addAttribute("destinationList", locations);

		return "home";
	}

	public WebApplicationContext getContext() {
		return context;
	}

	public void setContext(WebApplicationContext context) {
		this.context = context;
	}

	public DataManagerIfc getManager() {
		return manager;
	}

	public void setManager(DataManagerIfc manager) {
		this.manager = manager;
	}

}
