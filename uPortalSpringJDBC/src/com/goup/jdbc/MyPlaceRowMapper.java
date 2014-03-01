package com.goup.jdbc;  

  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import org.springframework.jdbc.core.RowMapper;  
import com.goup.domain.MyPlace;  
  
public class MyPlaceRowMapper implements RowMapper<MyPlace> {  
  
 @Override  
 public MyPlace mapRow(ResultSet resultSet, int line) throws SQLException {  
  MyPlaceExtractor myPlaceExtractor = new MyPlaceExtractor();  
  return myPlaceExtractor.extractData(resultSet);  
 }  
  
}  