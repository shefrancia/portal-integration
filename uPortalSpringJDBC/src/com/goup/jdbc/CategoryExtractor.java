package com.goup.jdbc;  
  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import org.springframework.dao.DataAccessException;  
import org.springframework.jdbc.core.ResultSetExtractor;  
import com.goup.domain.Category;  
  
public class CategoryExtractor implements ResultSetExtractor<Category> {  
  
 public Category extractData(ResultSet resultSet) throws SQLException,  
   DataAccessException {  
    
	 Category category = new Category();  
  
	 category.setCategoryId(resultSet.getString(1));
	 category.setCategoryName(resultSet.getString(2));

    
	 return category;  
 }  
  
}  