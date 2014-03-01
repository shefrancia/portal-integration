package com.uportal.controller;

import java.security.Principal;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.uportal.services.ResourceService;

@Controller
public class CounterController {

	@Autowired
	ResourceService resourceService;
	
	/*
	@RequestMapping("/counter")
	public String updateCounter(
			@CookieValue(value = "hitCounter", defaultValue = "0") Long hitCounter,
			HttpServletResponse response, ModelMap model, Principal principal ) {
		
		if(principal != null){
			 String name = principal.getName();
				model.addAttribute("username", name);
		 	}
		
		Cookie counter = new Cookie("hitCounter", hitCounter.toString());
		response.addCookie(counter);
		return "counter";
	}
	*/
	
	@RequestMapping("/counter")
	public String seeCounter(ModelMap model, Principal principal) {
		if(principal != null){
			 String name = principal.getName();
				model.addAttribute("username", name);
		 	}
		model.addAttribute("homePageCounter", resourceService.getHomePageCounter());
		return "counter";
	}
	
	@RequestMapping("/reset")
	/*public String checkCounter(
			@CookieValue(value = "hitCounter", defaultValue = "0") Long hitCounter,
			HttpServletResponse response, ModelMap model, Principal principal) { */
	public String checkCounter(ModelMap model, Principal principal, RedirectAttributes redirectAttributes) {
		/*
		hitCounter -= hitCounter;
		Cookie counter = new Cookie("hitCounter", hitCounter.toString());
		response.addCookie(counter);
		*/
		if(principal != null)
		{
			String name = principal.getName();
			model.addAttribute("username", name);
		}
		int newViews = 0;
		resourceService.updateHomePageCounter(newViews);
		//model.addAttribute("homePageCounter", newViews);
		redirectAttributes.addAttribute("reset_success", "true");
		return "redirect:/AdminPage";
	}

}
