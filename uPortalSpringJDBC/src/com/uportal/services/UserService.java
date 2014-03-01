package com.uportal.services;

import java.util.List;  

import com.uportal.domain.User;  
  
public interface UserService {  
  
 public int insertData(User user);  
 public List<User> getUserList();  
 public void deleteData(String id);  
 public User getUser(String username);  
 public void updateData(User user);
}  