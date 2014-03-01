package com.uportal.controller;

import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.ModelMap;  
import com.uportal.services.UserService;

@Controller
public class ExceptionsController {

 @Autowired
 UserService userService;

 	
 @RequestMapping(value="/notfound", method = RequestMethod.GET)
	public String notFoundPage(ModelMap model, Principal principal ) {
	 	if(principal != null){
	 		String name = principal.getName();
			model.addAttribute("username", name);
			model.addAttribute("message", "Spring Security Custom Form example");
	 	}
		
		return "/exceptions/notfound";

	}
}
