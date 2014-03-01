package com.uportal.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.ui.ModelMap;  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.uportal.domain.AdminRequest;
import com.uportal.domain.User;
import com.uportal.domain.ValueTuple;
import com.uportal.services.AdminRequestService;
import com.uportal.services.ResourceService;
import com.uportal.services.UserService;

@Controller

public class AdminController {
	@Autowired
	 UserService userService;
	
	@Autowired
	 ResourceService resourceService;
	
	@Autowired
	AdminRequestService adminRequestService;
	
	@RequestMapping("/getList")
	 public ModelAndView getUserLIst() {
	  List<User> userList = userService.getUserList();
	  return new ModelAndView("userList", "userList", userList);
	 }

	 @RequestMapping("/edit")
	 public ModelAndView editUser(@RequestParam String userid,
	   @ModelAttribute User user) {

	  user = userService.getUser(userid);

	  Map<String, Object> map = new HashMap<String, Object>();
	  map.put("user", user);

	  return new ModelAndView("edit", "map", map);

	 }

	 @RequestMapping("/update")
	 public String updateUser(@ModelAttribute User user) {
	  userService.updateData(user);
	  return "redirect:/update";

	 }

	 @RequestMapping("/delete")
	 public String deleteUser(@RequestParam String userid) {
	  System.out.println("userid = " + userid);
	  userService.deleteData(userid);
	  return "redirect:/getList";
	 }
	 
	 @RequestMapping("/requestList")
	 public String request(ModelMap model, Principal principal, RedirectAttributes redirectAttributes) {
		 redirectAttributes.addAttribute("request", "true");
		 return "redirect:/AdminPage";
	 }
	 
	 @RequestMapping("/decline_admin")
	 public String declineAdmin(@RequestParam String userid, @RequestParam String typeid) {
		 System.out.println(userid + " " + typeid);
		 adminRequestService.deleteAdminRequest(userid,typeid);
		 return "redirect:/requestList";
	 }
	 
	 @RequestMapping("/approve_admin")
	 public String approveAdmin(@RequestParam String userid, @RequestParam String typeid) {
		 adminRequestService.addAdmin(userid,typeid);
		 adminRequestService.deleteAdminRequest(userid, typeid);
		 return "redirect:/requestList";
	 }
	 
	 @RequestMapping(value="/hotline_update", method=RequestMethod.GET)
	 public @ResponseBody String updateHotline(@RequestParam String id, @RequestParam String name, @RequestParam String info){
		 resourceService.updateHotline(id, name, info);
		 return "redirect:/AdminPage";
	 }
	 
	 @RequestMapping(value="/hotline_delete", method=RequestMethod.GET)
	 public @ResponseBody String deleteHotline(@RequestParam String id){
		 resourceService.deleteHotline(id);
		 return "redirect:/AdminPage";
	 }

	 @RequestMapping("/delete_admin")
	 public String deleteAdmin(@RequestParam String userid, @RequestParam String typeid, ModelMap model, Principal principal, RedirectAttributes redirectAttributes) {
		 adminRequestService.deleteAdmin(userid,typeid);
		 redirectAttributes.addAttribute("seeAdminList", "true");
		 return "redirect:/AdminPage";
	 }
}
