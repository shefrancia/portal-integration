package com.goup.jdbc;  

  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import org.springframework.jdbc.core.RowMapper;  
import com.goup.domain.Category;  
  
public class CategoryRowMapper implements RowMapper<Category> {  
  
 @Override  
 public Category mapRow(ResultSet resultSet, int line) throws SQLException {  
	 CategoryExtractor categoryExtractor = new CategoryExtractor();  
	 return categoryExtractor.extractData(resultSet);  
 }  
  
}  