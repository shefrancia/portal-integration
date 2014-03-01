package com.uportal.jdbc;

import java.sql.ResultSet;  
import java.sql.SQLException;  
import org.springframework.dao.DataAccessException;  
import org.springframework.jdbc.core.ResultSetExtractor;  
import com.uportal.domain.User;  
  
public class UserExtractor implements ResultSetExtractor<User> {  
  
 public User extractData(ResultSet resultSet) throws SQLException,  
   DataAccessException {  
    
  User user = new User();  
    
  user.setUserid(resultSet.getInt(1));  
  user.setFirstName(resultSet.getString(2));  
  user.setLastName(resultSet.getString(3));  
  user.setEmail(resultSet.getString(4));  
  user.setUsername(resultSet.getString(5));
  user.setPassword(resultSet.getString(6));
  user.setCollege(resultSet.getString(7));
  user.setDepartment(resultSet.getString(8));
  user.setCourse(resultSet.getString(9));
    
  return user;  
 }  
  
}  