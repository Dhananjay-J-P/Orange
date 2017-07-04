package orange.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

@Controller
public class TestController {
	
	private static final Logger logger = Logger.getLogger(TestController.class);
	
	@RequestMapping("/og")	
	public String loadTest(Model model,HttpServletRequest request)
	{
		model.addAttribute("test", new Test());
		logger.info("now processing /og , client IP"+request.getRemoteAddr());
		return "ot";
	}
	
	@RequestMapping(value="/oTT",method=RequestMethod.POST)
	public String test(@ModelAttribute Test test,BindingResult result,Model models,SessionStatus status){
		status.setComplete();
		return "ot";
		
	}

}
