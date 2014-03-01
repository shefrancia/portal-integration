package com.goup.jdbc;  

  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import org.springframework.jdbc.core.RowMapper;  
import com.goup.domain.Place;  
  
public class PlaceRowMapper implements RowMapper<Place> {  
  
 @Override  
 public Place mapRow(ResultSet resultSet, int line) throws SQLException {  
  PlaceExtractor placeExtractor = new PlaceExtractor();  
  return placeExtractor.extractData(resultSet);  
 }  
  
}  