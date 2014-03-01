package com.uportal.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.uportal.domain.AdminRequest;
import com.uportal.jdbc.AdminRequestRowMapper;

public class AdminRequestDaoImpl implements AdminRequestDao {

	@Autowired
	DataSource dataSource;
	
	@SuppressWarnings("deprecation")
	@Override
	public int addAdminRequest(int userid, int typeid) {
		String checkduplicate = "select count(*) from adminRequests where userid=" + userid + " and typeid=" + typeid;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		int count = jdbcTemplate.queryForInt(checkduplicate);
		if(count > 0)
			return count;
		else
		{
			String sql = "insert into adminRequests(userid,typeid) values (" + userid + "," + typeid + ")";
			jdbcTemplate.update(sql);
			return 0;
		}
	}
	
	@Override
	public void deleteAdminRequest(String userid,String typeid) {
		String sql = "delete from adminRequests where userid=" + userid + " and typeid=" + typeid;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql);
	}
	
	@Override
	public void addAdmin(String userid, String typeid) {
		String sql = "insert into userRoles(userid,typeid) values (" + userid + "," + typeid + ")";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public int getNumberOfAdminRequests(){
		String sql = "select count(*) from adminRequests";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate.queryForInt(sql);
	}
	
	@Override
	public List<AdminRequest> getAdminRequestList(){
		ArrayList<AdminRequest> adminRequestList = new ArrayList<AdminRequest>();
		String sql = "select users.userid,userTypes.typeid,username,typename from adminRequests,users,userTypes where adminRequests.userid=users.userid and userTypes.typeid=adminRequests.typeid";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		adminRequestList = (ArrayList<AdminRequest>) jdbcTemplate.query(sql, new AdminRequestRowMapper());
		return adminRequestList;
	}
	
	@Override
	public List<AdminRequest> getAdminList(){
		ArrayList<AdminRequest> adminRequestList = new ArrayList<AdminRequest>();
		String sql = "select users.userid,userTypes.typeid,username,typename from userRoles,users,userTypes where userRoles.userid=users.userid and userTypes.typeid=userRoles.typeid and userRoles.typeid>=4 and userRoles.typeid<9";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		adminRequestList = (ArrayList<AdminRequest>) jdbcTemplate.query(sql, new AdminRequestRowMapper());
		return adminRequestList;
	}
	
	@Override
	public void deleteAdmin(String userid, String typeid){
		String sql = "delete from userRoles where userid=" + userid + " and typeid=" + typeid;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public int getNumberOfAdminRequests(int typeid){
		String sql = "select count(*) from adminRequests where typeid="+typeid;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate.queryForInt(sql);
	}
	
	@Override
	public List<AdminRequest> getAdminRequestList(int typeid){
		ArrayList<AdminRequest> adminRequestList = new ArrayList<AdminRequest>();
		String sql = "select users.userid,userTypes.typeid,username,typename from adminRequests,users,userTypes where adminRequests.userid=users.userid and userTypes.typeid=adminRequests.typeid and adminRequests.typeid="+typeid;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		adminRequestList = (ArrayList<AdminRequest>) jdbcTemplate.query(sql, new AdminRequestRowMapper());
		return adminRequestList;
	}
	
	@Override
	public List<AdminRequest> getAdminList(int typeid){
		ArrayList<AdminRequest> adminRequestList = new ArrayList<AdminRequest>();
		String sql = "select users.userid,userTypes.typeid,username,typename from userRoles,users,userTypes where userRoles.userid=users.userid and userTypes.typeid=userRoles.typeid and userRoles.typeid="+typeid;

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		adminRequestList = (ArrayList<AdminRequest>) jdbcTemplate.query(sql, new AdminRequestRowMapper());
		return adminRequestList;
	}
	
	@Override
	public List<AdminRequest> getAdminListWithoutUser(int typeid, String username){
		ArrayList<AdminRequest> adminRequestList = new ArrayList<AdminRequest>();
		String sql = "select users.userid,userTypes.typeid,username,typename from userRoles,users,userTypes where userRoles.userid=users.userid and userTypes.typeid=userRoles.typeid and userRoles.typeid="+typeid+" and users.username !=\'"+username+"\'";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		adminRequestList = (ArrayList<AdminRequest>) jdbcTemplate.query(sql, new AdminRequestRowMapper());
		return adminRequestList;
	}
}
