package com.goup.jdbc;

import java.sql.ResultSet;  
import java.sql.SQLException;  
import org.springframework.dao.DataAccessException;  
import org.springframework.jdbc.core.ResultSetExtractor;  
import com.goup.domain.MyPlace; 

public class MyPlaceExtractor implements ResultSetExtractor<MyPlace>{
	
	public MyPlace extractData(ResultSet resultSet) throws SQLException,  
	   DataAccessException {  
	    
	  MyPlace myPlace = new MyPlace();  
	  
	  myPlace.setUserId(resultSet.getString(1));
	  myPlace.setPlaceId(resultSet.getInt(2));
	  myPlace.setPlaceName(resultSet.getString(3));
	  
	    
	  return myPlace;  
	 }  
	
}
