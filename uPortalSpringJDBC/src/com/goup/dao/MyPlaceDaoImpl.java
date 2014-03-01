package com.goup.dao;


import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.jdbc.core.JdbcTemplate;

import com.goup.domain.MyPlace;
import com.goup.jdbc.MyPlaceRowMapper; 

public class MyPlaceDaoImpl implements MyPlaceDao {
	
	@Autowired  
	DataSource mapDataSource;
	
	public void insertData(MyPlace myPlace){
		String sql = "INSERT INTO myplace" + "(user_id,place_id)" +
				"VALUES (? ,?)";
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(mapDataSource);
		
		jdbcTemplate.update(
				sql,
				new Object[] {myPlace.getUserId(),myPlace.getPlaceId() });
				
	}
	
	public void deleteData(MyPlace myPlace){
		String sql = "DELETE from myplace where user_id=? and place_id=?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(mapDataSource);
		
		jdbcTemplate.update(
				sql,
				new Object[] { myPlace.getUserId(), myPlace.getPlaceId()}
				);
		
		
		
	}
	
	public List<MyPlace> getMyPlaces(String userId){
		List<MyPlace> myPlaceList = new ArrayList<MyPlace>();
		String sql = "SELECT myplace.user_id, myplace.place_id, place.place_name from myplace right join place on myplace.place_id=place.place_id where user_id=" +userId;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(mapDataSource);
		myPlaceList = jdbcTemplate.query(sql, new MyPlaceRowMapper());
		return myPlaceList;
	}
	
	

	
}