package com.goup.dao;

//import java.util.List;
import com.goup.domain.MyPlace;
import java.util.*;

public interface MyPlaceDao {
	public void insertData(MyPlace myPlace);
	public void deleteData(MyPlace myPlace);
	public List<MyPlace> getMyPlaces(String userId);
	
}
