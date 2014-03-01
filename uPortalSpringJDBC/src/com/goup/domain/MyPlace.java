package com.goup.domain;

public class MyPlace {

	private String userId;
	private int placeId;
	private String placeName;
	
	public void setUserId(String userId){
		this.userId = userId;
	}
	
	public String getUserId(){
		return this.userId;
	}
	
	public void setPlaceId(int placeId){
		this.placeId = placeId;
	}
	
	public int getPlaceId(){
		return this.placeId;
	}
	
	public void setPlaceName(String placeName){
		this.placeName = placeName;
	}
	
	public String getPlaceName(){
		return this.placeName;
	}
}
