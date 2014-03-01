package com.goup.services;

import java.util.List;

//import java.util.List;
import com.goup.domain.MyPlace;

public interface MyPlaceService {
	
	public void insertData(MyPlace myPlace);
	public void deleteData(MyPlace myPlace);
	public List<MyPlace> getMyPlaces(String userId);

}