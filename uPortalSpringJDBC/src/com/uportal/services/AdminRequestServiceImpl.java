package com.uportal.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;  

import com.uportal.dao.AdminRequestDao;  
import com.uportal.domain.AdminRequest;

public class AdminRequestServiceImpl implements AdminRequestService{

	 @Autowired
	 AdminRequestDao adminrequestdao;
	
	 @Override
	 public int addAdminRequest(int userid,int typeid) {
		 return adminrequestdao.addAdminRequest(userid,typeid);
	 }
	 
	 @Override
	 public void deleteAdminRequest(String userid,String typeid) {
		 adminrequestdao.deleteAdminRequest(userid,typeid);
	 }
	 
	 @Override
	 public void addAdmin(String userid, String typeid) {
		 adminrequestdao.addAdmin(userid, typeid);
	 }
	 
	@Override
	public int getNumberOfAdminRequests() {
		return adminrequestdao.getNumberOfAdminRequests();
	}
		
	@Override
	public List<AdminRequest> getAdminRequestList(){
		return adminrequestdao.getAdminRequestList();
	}
	
	@Override
	public List<AdminRequest> getAdminList(){
		return adminrequestdao.getAdminList();
	}
	
	@Override
	public void deleteAdmin(String userid, String typeid){
		adminrequestdao.deleteAdmin(userid, typeid);
	}
	
	@Override
	public int getNumberOfAdminRequests(int typeid){
		return adminrequestdao.getNumberOfAdminRequests(typeid);
	}
	
	@Override
	public List<AdminRequest> getAdminRequestList(int typeid){
		return adminrequestdao.getAdminRequestList(typeid);
	}
	
	@Override
	public List<AdminRequest> getAdminList(int typeid){
		return adminrequestdao.getAdminList(typeid);
	}
	
	@Override
	public List<AdminRequest> getAdminListWithoutUser(int typeid, String username){
		return adminrequestdao.getAdminListWithoutUser(typeid,username);
	}
}
