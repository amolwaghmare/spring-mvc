package com.amol.spring.mvc.controller; 

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.amol.spring.data.jpa.entity.Address;
import com.amol.spring.data.jpa.repository.AddressRepository;
import com.amol.spring.data.jpa.repository.UserRepository;
import com.amol.spring.mvc.model.User;

/**
 * @author Amol Waghmare
 *
 */
@Controller
public class LoginController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	AddressRepository addressRepository;

	
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
		
		com.amol.spring.data.jpa.entity.User userEntity = new com.amol.spring.data.jpa.entity.User();
		userEntity.setName(user.getUserName());
		
		Address addressEntity = new Address();
		addressEntity.setAddressLine1("addressLine1");
		addressEntity.setAddressLine2("addressLine2");
		addressEntity.setPostCode("AB1 2CD");
		
		Address addressEntity2 = new Address();
		addressEntity2.setAddressLine1("addressLine1");
		addressEntity2.setAddressLine2("addressLine2");
		addressEntity2.setPostCode("AB1 2CD");
		
		//object references an unsaved transient instance - save the transient instance before flushing: 
		//com.amol.spring.data.jpa.entity.Address
		// FIX- CascadeType.ALL
	
		Set<Address> addresses = new HashSet<Address>();
		addresses.add(addressEntity);
		addresses.add(addressEntity2);
		userEntity.setAddresses(addresses);
		
		userRepository.save(userEntity);
		
		model.addAttribute("user", user.getUserName());
		return "welcome";
		
	}

}
