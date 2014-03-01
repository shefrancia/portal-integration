package com.uportal.services;

import java.util.List;

import com.uportal.domain.AdminRequest;
 
public interface AdminRequestService {
	 public int addAdminRequest(int userid,int typeid);
	 public void deleteAdminRequest(String userid,String typeid);
	 public void addAdmin(String userid, String typeid);
	 public int getNumberOfAdminRequests();
	 public List<AdminRequest> getAdminRequestList();
	 public List<AdminRequest> getAdminList();
	 public void deleteAdmin(String userid, String typeid);
	 public int getNumberOfAdminRequests(int typeid);
	 public List<AdminRequest> getAdminRequestList(int typeid);
	 public List<AdminRequest> getAdminList(int typeid);
	 public List<AdminRequest> getAdminListWithoutUser(int typeid, String username);
}
