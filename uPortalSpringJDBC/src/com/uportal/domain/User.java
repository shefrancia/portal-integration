package com.uportal.domain;

public class User {  
    
private int userid;  
private String firstName;  
private String lastName;  
private String email;  
private String username;  
private String password;
private String confirmPassword;
private String role;
private String college;
private String department;
private String course;

	public int getUserId() {  
		return userid;  
	}  
	 
	public void setUserid(int userid) {  
		this.userid = userid;  
	}  
	 
	public String getFirstName() {  
		return firstName;  
	}  
	 
	public void setFirstName(String firstName) {  
		this.firstName = firstName;  
	}  
	 
	public String getLastName() {  
		return lastName;  
	}  
	 
	public void setLastName(String lastName) {  
		this.lastName = lastName;  
	}  
	 
	public String getEmail() {  
		return email;  
	}  
	 
	public void setEmail(String email) {  
		this.email = email;  
	}  
	 
	public String getUsername() {  
		return username;  
	}  
	 
	public void setUsername(String username) {  
		this.username = username;  
	}  
	
	public String getPassword() {  
	    return password;  
	}  
	        
	public void setPassword(String password) {  
		this.password = password;  
	}  
	   
	public String getConfirmPassword() {  
		return confirmPassword;  
	}  
	        
	public void setConfirmPassword(String confirmPassword) {  
		this.confirmPassword = confirmPassword;  
	}
   
	public String getRole(){
		return role;
	}
	
	public void setRole(String role){
		this.role = role;
	}
	
	public String getCollege(){
		return college;
	}
	
	public void setCollege(String college){
		this.college = college;
	}
	
	public String getDepartment(){
		return department;
	}
	
	public void setDepartment(String department){
		this.department = department;
	}
	
	public String getCourse(){
		return course;
	}
	
	public void setCourse(String course){
		this.course = course;
	}
}  


