package com.uportal.jdbc;

import java.sql.ResultSet;  
import java.sql.SQLException;  
import org.springframework.dao.DataAccessException;  
import org.springframework.jdbc.core.ResultSetExtractor;  
import com.uportal.domain.AdminRequest;  
  
public class AdminRequestExtractor implements ResultSetExtractor<AdminRequest> {  
  
 public AdminRequest extractData(ResultSet resultSet) throws SQLException,  
   DataAccessException {  
    
  AdminRequest request = new AdminRequest();
  
  request.setUserid(resultSet.getInt(1));
  request.setTypeid(resultSet.getInt(2));
  request.setUsername(resultSet.getString(3));
  request.setTypename(resultSet.getString(4));
  
  return request;  
 }  
  
}
