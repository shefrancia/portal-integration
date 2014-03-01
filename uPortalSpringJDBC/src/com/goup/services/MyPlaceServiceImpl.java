package com.goup.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;  
import com.goup.dao.MyPlaceDao; 
import com.goup.domain.MyPlace;

public class MyPlaceServiceImpl implements MyPlaceService {
	
	@Autowired
	MyPlaceDao myplacedao;
	
	@Override
	public void insertData(MyPlace myPlace){
		myplacedao.insertData(myPlace);
	}
	public void deleteData(MyPlace myPlace){
		myplacedao.deleteData(myPlace);
	}
	public List<MyPlace> getMyPlaces(String userId){
		return myplacedao.getMyPlaces(userId);
	}

}