package com.uportal.controller;

import java.security.Principal;
import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.ModelMap;  

import com.uportal.domain.User;
import com.uportal.domain.ValueTuple;
import com.uportal.domain.AdminRequest;
import com.uportal.services.AdminRequestService;
import com.uportal.services.ResourceService;
import com.uportal.services.UserService;

@Controller
public class HomePageController {

 @Autowired
 UserService userService;
 @Autowired
 ResourceService resourceService;
 @Autowired
 AdminRequestService adminRequestService;
 @Autowired
 DataSource dataSource;
 
 
 /*
 public String homePage(ModelMap model, Principal principal,@CookieValue(value = "hitCounter", defaultValue = "0") Long hitCounter,
 HttpServletResponse response ) { */
 @RequestMapping(value="/home", method = RequestMethod.GET )
   public String homePage(ModelMap model, Principal principal) {
	 if(principal != null){
		 return "redirect:/welcome";
	 }
	 /*
 	 hitCounter++;
 	 Cookie counter = new Cookie("hitCounter", hitCounter.toString());
 	 response.addCookie(counter);
	 */
	 int newViews = resourceService.getHomePageCounter()+1;
	 resourceService.updateHomePageCounter(newViews);
	 model.addAttribute("homePageCounter", newViews);
	 return "home";

 }
 
 @RequestMapping(value="/private", method = RequestMethod.GET)
	public String privatePage(ModelMap model, Principal principal ) {

		String name = principal.getName();
		model.addAttribute("username", name);
		model.addAttribute("message", "This is a private feature");
		return "private";

	}
 
 @RequestMapping("/public")
 public String publicPage(ModelMap model, Principal principal){
	 if(principal != null){
		 String name = principal.getName();
			model.addAttribute("username", name);
	 	}
	 return "public";
 }
 
 @RequestMapping("/hotlines")
 public String hotlinesPage(ModelMap model, Principal principal){
	 if(principal != null){
		 String name = principal.getName();
		 model.addAttribute("username", name);
		 User user= userService.getUser(name);
		 List<String> roles= resourceService.getRoles(user.getUserId());
		 if(roles.indexOf("GOD") >= 0 || roles.indexOf("ADMIN_CLASS") >= 0 || roles.indexOf("ADMIN_BUDDY") >= 0 || roles.indexOf("ADMIN_GYM") >= 0 || roles.indexOf("ADMIN_MAPS") >= 0 || roles.indexOf("ADMIN_PORTAL") >= 0)
			 model.addAttribute("isAdmin", true);
	 	}
	 List<ValueTuple> hotlineList = new ArrayList<ValueTuple>();
	 hotlineList = resourceService.getHotlines();
	 List<ValueTuple> hotlineList1 = new ArrayList<ValueTuple>();
	 List<ValueTuple> hotlineList2 = new ArrayList<ValueTuple>();
	 int size = hotlineList.size(), y = (int) Math.ceil(size/2);
	 for (int i=0; i<y; i++){
		 hotlineList1.add(hotlineList.get(i));
	 }
	 for (int i=y; i<size; i++){
		 hotlineList2.add(hotlineList.get(i));
	 }
	 model.addAttribute("hotlineList1", hotlineList1);
	 model.addAttribute("hotlineList2", hotlineList2);
	 return "hotlines";
 }
 
 @RequestMapping("/AdminPage")
 public String AdminPage(ModelMap model, Principal principal, @RequestParam(required = false) String request, @RequestParam(required = false) String seeAdminList, @RequestParam(required = false) String reset_success){
	 if(request != null)
		 model.addAttribute("request", request);
	 if(seeAdminList != null)
		 model.addAttribute("seeAdminList", seeAdminList);
	 if(reset_success != null)
		 model.addAttribute("reset_success", reset_success);
	 String name = principal.getName();
	 model.addAttribute("username", name);
	 model.addAttribute("isAdmin", "true");
	 List<ValueTuple> hotlineList = new ArrayList<ValueTuple>();
	 hotlineList = resourceService.getHotlines();
	 model.addAttribute("hotlineList", hotlineList);
	 model.addAttribute("homePageCounter", resourceService.getHomePageCounter());
	 User user= userService.getUser(name);
	 List<String> roles= resourceService.getRoles(user.getUserId());
	 if(roles.indexOf("GOD") >= 0)
	 {
		 model.addAttribute("numberOfAdminRequests", adminRequestService.getNumberOfAdminRequests());
		 List<AdminRequest> adminRequestList = new ArrayList<AdminRequest>();
		 adminRequestList = adminRequestService.getAdminRequestList();
		 model.addAttribute("adminRequestList", adminRequestList);
		 List<AdminRequest> adminList = new ArrayList<AdminRequest>();
		 adminList = adminRequestService.getAdminList();
		 model.addAttribute("adminList", adminList);
	 }
	 else
	 {
		 int numberOfAdminRequests = 0;
		 List<AdminRequest> adminRequestList = new ArrayList<AdminRequest>();
		 List<AdminRequest> adminList = new ArrayList<AdminRequest>();
		 if(roles.indexOf("ADMIN_PORTAL") >= 0)
		 {
			adminRequestList.addAll(adminRequestService.getAdminRequestList(4)); 
			adminList.addAll(adminRequestService.getAdminListWithoutUser(4,name)); 
			numberOfAdminRequests += adminRequestService.getNumberOfAdminRequests(4);
		 }
		 if(roles.indexOf("ADMIN_MAPS") >= 0)
		 {
			adminRequestList.addAll(adminRequestService.getAdminRequestList(5)); 
			adminList.addAll(adminRequestService.getAdminListWithoutUser(5,name)); 
			numberOfAdminRequests += adminRequestService.getNumberOfAdminRequests(5);
		 }
		 if(roles.indexOf("ADMIN_BUDDY") >= 0)
		 {
			adminRequestList.addAll(adminRequestService.getAdminRequestList(6)); 
			adminList.addAll(adminRequestService.getAdminListWithoutUser(6,name)); 
			numberOfAdminRequests += adminRequestService.getNumberOfAdminRequests(6);
		 }
		 if(roles.indexOf("ADMIN_CLASS") >= 0)
		 {
			adminRequestList.addAll(adminRequestService.getAdminRequestList(7)); 
			adminList.addAll(adminRequestService.getAdminListWithoutUser(7,name)); 
			numberOfAdminRequests += adminRequestService.getNumberOfAdminRequests(7);
		 }
		 if(roles.indexOf("ADMIN_GYM") >= 0)
		 {
			adminRequestList.addAll(adminRequestService.getAdminRequestList(8)); 
			adminList.addAll(adminRequestService.getAdminListWithoutUser(8,name)); 
			numberOfAdminRequests += adminRequestService.getNumberOfAdminRequests(8);
		 }
		 model.addAttribute("numberOfAdminRequests", numberOfAdminRequests);
		 model.addAttribute("adminRequestList", adminRequestList);
		 model.addAttribute("adminList", adminList);
	 }
	 return "AdminPage";
 }
 
 @RequestMapping("/description")
 public String descriptionsPage(ModelMap model, Principal principal){
	 if(principal != null){
		 String name = principal.getName();
			model.addAttribute("username", name);
	 	}
	 return "description";
 }
 
 @RequestMapping("/userList")
 public String userPage(ModelMap model, Principal principal){
	 if(principal != null){
		 String name = principal.getName();
			model.addAttribute("username", name);
	 	}
	 return "userList";
 }
 
 @ExceptionHandler(Exception.class)
 public String handleError(HttpServletRequest req, Exception exception) {
   return "redirect:/notfound";
 }
}
