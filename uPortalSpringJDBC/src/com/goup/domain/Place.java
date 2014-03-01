package com.goup.domain;

public class Place {
	
	private int placeId;
	private String placeName;
	private double placeLat;
	private double placeLong;
	private String placeCategory;
	
	public int getPlaceId(){
		return placeId;
	}
	
	public void setPlaceId(int placeId){
		this.placeId = placeId;
	}
	
	public String getPlaceName(){
		return placeName;
	}
	
	public void setPlaceName(String placeName){
		this.placeName = placeName;
	}
	
	public double getPlaceLat(){
		return placeLat;
	}
	
	public void setPlaceLat(double placeLat){
		this.placeLat = placeLat;
	}
	
	public double getPlaceLong(){
		return placeLong;
	}
	
	public void setPlaceLong(double placeLong){
		this.placeLong = placeLong;
	}
	
	public String getPlaceCategory(){
		return placeCategory;
	}
	
	public void setPlaceCategory(String placeCategory){
		this.placeCategory = placeCategory;
	}
	
}