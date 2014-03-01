package com.goup.dao;

/**
*
* @author Andie Rabino
*
*/

//import java.util.ArrayList;
//import java.util.List;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.jdbc.core.JdbcTemplate;

import com.goup.domain.Place; 
import com.goup.jdbc.PlaceRowMapper; 

public class PlaceDaoImpl implements PlaceDao {
	
	@Autowired  
	DataSource mapDataSource;
	
	public void insertData(Place place){
		String sql = "INSERT INTO place" + "(place_name,place_lat,place_long)" +
				"VALUES (? ,? ,?)";
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(mapDataSource);
		
		jdbcTemplate.update(
				sql,
				new Object[] {place.getPlaceName(), place.getPlaceLat(), place.getPlaceLong() });
				
	}
	
	public List<Place> searchPlaceByName(String placeName){
		List<Place> placeList = new ArrayList<Place>();
		String sql = "select * from place right join categories on place.place_category=categories.category_id where place_name like \"%"+placeName+"%\"";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(mapDataSource);
		placeList = jdbcTemplate.query(sql, new PlaceRowMapper());
		if(placeList.size()>0)
			return placeList;
		else
			return null;
		
	}
	
	public List<Place> searchPlaceByCategory(String category){
		
		List<Place> placeList = new ArrayList<Place>();
		String sql = "select * from place right join categories on place.place_category=categories.category_id where place_category like \"%" + category +"%\"";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(mapDataSource);
		placeList = jdbcTemplate.query(sql, new PlaceRowMapper());
		
		if(placeList.size()>0)
			return placeList;
	
		else
			return null;
		
	}
	
	
	public List<Place> searchPlaceByCategoryAndName(String category, String placeName){
		
		List<Place> placeList = new ArrayList<Place>();
		String sql = "select * from place right join categories on place.place_category=categories.category_id where place_category like \"%" + category +"%\" " +
				"and (place_name like \"%" + placeName +"%\" or place_category like \"%" +placeName + 
				"%\" or place_category in (select category_id from categories" +
				" where category_name like \"%" + placeName +"%\"))";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(mapDataSource);
		placeList = jdbcTemplate.query(sql, new PlaceRowMapper());
		
		if(placeList.size()>0)
			return placeList;
	
		else
			return null;
		
	}
	

	
}