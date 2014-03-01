package com.goup.domain;

public class Category {

	private String categoryId;
	private String categoryName;
	
	public void setCategoryId(String categoryId){
		this.categoryId = categoryId;
	}
	
	public String getCategoryId(){
		return this.categoryId;
	}
	
	
	public void setCategoryName(String categoryName){
		this.categoryName = categoryName;
	}
	
	public String getCategoryName(){
		return this.categoryName;
	}
}
