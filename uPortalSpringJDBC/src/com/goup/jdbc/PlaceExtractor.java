package com.goup.jdbc;  

  
  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import org.springframework.dao.DataAccessException;  
import org.springframework.jdbc.core.ResultSetExtractor;  
import com.goup.domain.Place;  
  
public class PlaceExtractor implements ResultSetExtractor<Place> {  
  
 public Place extractData(ResultSet resultSet) throws SQLException,  
   DataAccessException {  
    
  Place place = new Place();  
  
  place.setPlaceId(resultSet.getInt(1));
  place.setPlaceName(resultSet.getString(2));
  place.setPlaceLat(resultSet.getDouble(3));  
  place.setPlaceLong(resultSet.getDouble(4));  
  place.setPlaceCategory(resultSet.getString(8));
  
    
  return place;  
 }  
  
}  