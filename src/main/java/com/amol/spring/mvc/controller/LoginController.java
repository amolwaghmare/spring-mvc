package com.amol.spring.mvc.controller; 
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.amol.spring.mvc.model.User;

/**
 * @author Amol Waghmare
 *
 */
@Controller
public class LoginController {
	
	
	//value parameter is alias to path - both are equivalent.
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView welcome() {
		System.out.println("LoginController -> welcome");
		
		//Go to next view named "login.jsp", pass the empty User object as command object.
		
		return new ModelAndView("login", "user", new User());
	}
	
	@RequestMapping(path="/login", method=RequestMethod.POST)
	public String login(@ModelAttribute ("user") User user, ModelMap model) {
		System.out.println("LoginController -> login user name=" + user.getUserName());
		System.out.println("LoginController -> login user password=" + user.getPassword());
		
		
		model.addAttribute("user", user.getUserName());
		return "welcome";
		
	}

}
