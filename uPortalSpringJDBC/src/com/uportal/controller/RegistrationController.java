package com.uportal.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.ModelMap;  
import org.springframework.validation.BindingResult; 

import com.uportal.domain.User;
import com.uportal.domain.ValueTuple;
import com.uportal.services.ResourceService;
import com.uportal.services.UserService;
import com.uportal.validator.FormValidation;

@Controller
public class RegistrationController {

 @Autowired
 UserService userService;
 @Autowired
 ResourceService resourceService;

 private void setOptions(ModelMap model){
	
	 model.addAttribute("resourceService", resourceService);
 }
 
 @RequestMapping("/register")
 public ModelAndView registerUser(@ModelAttribute User user, ModelMap model, Principal principal) {
	 if(principal != null){
		 String name = principal.getName();
			model.addAttribute("username", name);
			return new ModelAndView("home");
	 	}
	 setOptions(model);
	 return new ModelAndView("register", "model", model);
 }

 @RequestMapping("/submit")  
 public ModelAndView saveForm(User user, BindingResult result, ModelMap model, Principal principal) {  
	  FormValidation formValidation = new FormValidation();  
	  
	  formValidation.validate(user, result);  
	  
	  if (result.hasErrors()) { 
		  setOptions(model);
		  return new ModelAndView("register", "model", model);
	  }else{
		  user = (User) result.getModel().get("user");  
		 int unique =  userService.insertData(user);
		 if(unique == 3){
			 setOptions(model);
			 model.addAttribute("msg_failed", "3");
			 return new ModelAndView("register", "model", model);
		 }
		 else if (unique == 1){
			 setOptions(model);
			 model.addAttribute("msg_failed", "1");
			 return new ModelAndView("register", "model", model);
		 }else if (unique == 2){
			 setOptions(model);
			 model.addAttribute("msg_failed", "2");
			 return new ModelAndView("register", "model", model);
		 }else{
		  System.out.println(user.getUserId()); 
			 model.addAttribute("msg_success", "true");
			 return new ModelAndView("home");
		 }
	  }
	   
 }  
}
