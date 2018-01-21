package com.amol.spring.mvc.controller; 
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Amol Waghmare
 *
 */
@Controller
public class WelcomeController {
	
	//value parameter is alias to path - both are equivalent.
	@RequestMapping(value="/welcome/guest")
	public String welcome() {
		System.out.println("LoginController -> welcome");
		//Go to next view names "welcome"
		return "welcome";
	}
	
	//http://localhost:8080/springmvc/welcome?username=Amol
	@RequestMapping(path="/welcome", method=RequestMethod.GET)
	public String login(@RequestParam(name="username") String userName, ModelMap model) {
		System.out.println("LoginController -> login user name=" + userName);
		model.addAttribute("user", userName);
		return "welcome";
		
	}

}
