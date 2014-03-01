package com.uportal.services;

import java.util.List;

import com.uportal.domain.AdminRequest;
import com.uportal.domain.ValueTuple;

public interface ResourceService {
	public List<ValueTuple> getCollegeList();
	public List<ValueTuple> getDeptList(int collegeid);
	public List<ValueTuple> getCourseList(int deptid);
	public List<ValueTuple> getHotlines();
	public int getDeptCount(int collegeid);
	public String getCourse(int courseid);
	public String getDept(int deptid);
	public String getCollege(int collegeid);
	public List<String> getRoles(int userid);
	public int getHomePageCounter();
	public void updateHomePageCounter(int views);
	public void updateHotline(String id, String name, String info);
	public void deleteHotline(String id);
}
