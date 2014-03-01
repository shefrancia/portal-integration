package com.uportal.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.uportal.domain.User;
import com.uportal.services.AdminRequestService;
import com.uportal.services.UserService;

@Controller
public class AdminRequestController {

	@Autowired
	AdminRequestService adminRequestService;
	
	@Autowired
	UserService userService;
		
	@RequestMapping("/send")
	public String sendRequest(ModelMap model, Principal principal, RedirectAttributes redirectAttributes, @RequestParam String typeid) {
		String name = principal.getName();
		model.addAttribute("username", name);
		User user= userService.getUser(name);
		if(adminRequestService.addAdminRequest(user.getUserId(),Integer.parseInt(typeid)) == 0)
			redirectAttributes.addAttribute("request_success", "true");
		else
			redirectAttributes.addAttribute("request_success", "false");
		return "redirect:/request";
	}
	
}
