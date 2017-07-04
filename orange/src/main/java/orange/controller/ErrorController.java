package orange.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController {

	@RequestMapping("error")
	public String error()
	{
		return "redirect:/errorpage";
	}
	
	@RequestMapping("errorpage")
	public String showErrorPage()
	{
		return "error";
	}
}
