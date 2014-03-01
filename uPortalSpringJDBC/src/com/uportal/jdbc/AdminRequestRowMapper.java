package com.uportal.jdbc;

import java.sql.ResultSet;  
import java.sql.SQLException;  
import org.springframework.jdbc.core.RowMapper;  
import com.uportal.domain.AdminRequest;  
  
public class AdminRequestRowMapper implements RowMapper<AdminRequest> {  
  
 @Override  
 public AdminRequest mapRow(ResultSet resultSet, int line) throws SQLException {  
  AdminRequestExtractor adminRequestExtractor = new AdminRequestExtractor();  
  return adminRequestExtractor.extractData(resultSet);  
 }  
  
}
