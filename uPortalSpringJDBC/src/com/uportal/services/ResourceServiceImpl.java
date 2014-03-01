package com.uportal.services;

import java.util.List;

import com.uportal.domain.AdminRequest;
import com.uportal.domain.ValueTuple;

import org.springframework.beans.factory.annotation.Autowired;  

import com.uportal.dao.ResourceDao; 

public class ResourceServiceImpl implements ResourceService {
	@Autowired
	ResourceDao resourcedao;
	
	@Override
	public List<ValueTuple> getCollegeList(){
		return resourcedao.getCollegeList();
	}
	
	@Override
	public List<ValueTuple> getDeptList(int collegeid){
		return resourcedao.getDeptList(collegeid);
	}
	
	@Override
	public List<ValueTuple> getCourseList(int deptid){
		return resourcedao.getCourseList(deptid);
	}
	
	@Override
	public List<ValueTuple> getHotlines(){
		return resourcedao.getHotlines();
	}
	
	@Override
	public int getDeptCount(int collegeid){
		return resourcedao.getDeptCount(collegeid);
	}
	
	@Override
	public String getCourse(int courseid) {
		return resourcedao.getCourse(courseid);
	}
	
	@Override
	public String getDept(int deptid){
		return resourcedao.getDept(deptid);
	}
	
	@Override
	public String getCollege(int collegeid){
		return resourcedao.getCollege(collegeid);
	}
	
	@Override
	public List<String> getRoles(int userid){
		return resourcedao.getRoles(userid);
	}

	@Override
	public int getHomePageCounter() {
		return resourcedao.getHomePageCounter();
	}

	@Override
	public void updateHomePageCounter(int views) {
		resourcedao.updateHomePageCounter(views);
	}

	@Override
	public void updateHotline(String ID, String name, String info){
		resourcedao.updateHotline(ID, name, info);
	}
	
	@Override
	public void deleteHotline(String ID){
		resourcedao.deleteHotline(ID);
	}
}
