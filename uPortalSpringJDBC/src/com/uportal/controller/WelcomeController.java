package com.uportal.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.uportal.domain.User;
import com.uportal.services.ResourceService;
import com.uportal.services.UserService;
 
@Controller

public class WelcomeController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	ResourceService resourceService;
	
	@RequestMapping("/request")
	public String requestAdmin(ModelMap model, Principal principal, @RequestParam(required = false) String request_success) {
		String name = principal.getName();
		model.addAttribute("username", name);
		if(request_success != null)
			model.addAttribute("request_success", request_success);
		
		User user= userService.getUser(name);
		List<String> roles= resourceService.getRoles(user.getUserId());
		model.addAttribute("roles", roles);
		
		if(roles.indexOf("GOD") >= 0 || roles.indexOf("ADMIN_CLASS") >= 0 || roles.indexOf("ADMIN_BUDDY") >= 0 || roles.indexOf("ADMIN_GYM") >= 0 || roles.indexOf("ADMIN_MAPS") >= 0 || roles.indexOf("ADMIN_PORTAL") >= 0)
			 model.addAttribute("isAdmin", true);
		
		if(roles.indexOf("GOD") >= 0)
			 model.addAttribute("isGod", "true");
		if(roles.indexOf("ADMIN_PORTAL") >= 0)
			 model.addAttribute("isPortalAdmin", "true");
		if(roles.indexOf("ADMIN_MAPS") >= 0)
			 model.addAttribute("isMapAdmin", "true");
		if(roles.indexOf("ADMIN_BUDDY") >= 0)
			 model.addAttribute("isBuddyAdmin", "true");
		if(roles.indexOf("ADMIN_CLASS") >= 0)
			 model.addAttribute("isClassAdmin", "true");
		if(roles.indexOf("ADMIN_GYM") >= 0)
			 model.addAttribute("isGymAdmin", "true");
		
		if(user.getCollege() != null){
			String college= resourceService.getCollege(Integer.parseInt(user.getCollege()));
			model.addAttribute("college", college);
		}
		if(user.getDepartment() != null){
			String department= resourceService.getDept(Integer.parseInt(user.getDepartment())).trim();
			if(department.length() > 0)
				model.addAttribute("department", department);
		}
		if(user.getCourse() != null){
			String course= resourceService.getCourse(Integer.parseInt(user.getCourse()));
			model.addAttribute("course", course);
		}
		return "request";
	}
	
	
}
