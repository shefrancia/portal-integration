package com.uportal.dao;

import java.util.ArrayList;
import java.sql.*;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;

import com.uportal.domain.User;
import com.uportal.jdbc.UserRowMapper;

public class UserDaoImpl implements UserDao {

	private boolean isDBinit = false;
	
	@Autowired
	DataSource dataSource;
	
	@SuppressWarnings("deprecation")
	public int insertData(User user) {
		String department = user.getDepartment();
		String dept = department.replaceAll("[^0-9]", "");
		String course = user.getCourse();
		String courseid = course.replaceAll("[^0-9]", "");
		String sql = "INSERT INTO users "
				+ "(firstname, lastname, email, username, password, collegeid, departmentid, courseid ) VALUES (?,?,?,?,?,?,?,?);";
		

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		final String usernameCheck = "select count(*) from users where username = ?;";
		int usernameResult= jdbcTemplate.queryForInt(usernameCheck, new Object[]{String.valueOf(user.getUsername())});
		final String emailCheck = "select count(*) from users where email = ?;";
		int emailResult= jdbcTemplate.queryForInt(emailCheck, new Object[]{String.valueOf(user.getEmail())});
		
		if (usernameResult == 0 && emailResult == 0 && dept != ""){
			ShaPasswordEncoder passwordEncoder = new ShaPasswordEncoder();
			String hashedPassword = passwordEncoder.encodePassword(user.getPassword(),null);
			if(user.getCollege().toString().equals("null")){
				
				sql = "INSERT INTO users "
						+ "(firstname, lastname, email, username, password ) VALUES (?,?,?,?,?);";
				jdbcTemplate.update(
						sql,
						new Object[] { user.getFirstName(), user.getLastName(),
								user.getEmail(), user.getUsername(), hashedPassword});
			}else if(dept.equals("")){
				sql = "INSERT INTO users "
						+ "(firstname, lastname, email, username, password, collegeid, courseid ) VALUES (?,?,?,?,?,?,?);";
				jdbcTemplate.update(
						sql,
						new Object[] { user.getFirstName(), user.getLastName(),
								user.getEmail(), user.getUsername(), hashedPassword, user.getCollege(), Integer.parseInt(courseid) });
			}else{
				jdbcTemplate.update(
						sql,
						new Object[] { user.getFirstName(), user.getLastName(),
								user.getEmail(), user.getUsername(), hashedPassword, user.getCollege(), Integer.parseInt(dept), Integer.parseInt(courseid) });
			}
			
			sql = "select userid from users where username = ?";
			int userid = (int)jdbcTemplate.queryForInt(
					sql, new Object[] { user.getUsername() });
			sql = "select typeid from userTypes where typename = ?";
			int typeid = (int)jdbcTemplate.queryForInt(sql, new Object[] { user.getRole() });
			sql = "INSERT INTO userRoles" 
					+ "(userid, typeid) VALUES (?,?)";
			
			jdbcTemplate.update(
					sql,
					new Object[] {userid, typeid}
					);
			return 0;
		}
		
		else if (usernameResult > 0 && emailResult > 0){
			return 3;
		}

		else if (usernameResult > 0){
			return 1;
		}
		
		else{
			return 2;
		}
		
	}

	public List<User> getUserList() {
		ArrayList<User> userList = new ArrayList<User>();
		String sql = "select * from users";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		userList = (ArrayList<User>) jdbcTemplate.query(sql, new UserRowMapper());
		return userList;
	}

	@Override
	public void deleteData(String userid) {
		String sql = "delete from users where userid=" + userid;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql);

	}

	@Override
	public void updateData(User user) {

		String sql = "UPDATE users set firstname = ?,lastname = ?, email = ?, username = ?, password = ? where userid = ?;";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.update(
				sql,
				new Object[] { user.getFirstName(), user.getLastName(),
						user.getEmail(), user.getUsername(), user.getPassword(), user.getUserId() });

	}

	@Override
	public User getUser(String username) {
		List<User> userList = new ArrayList<User>();
		String sql = "select userid,firstname,lastname,email,username,password,collegeid,departmentid,courseid from users where username= \"" + username+ "\"";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		userList = jdbcTemplate.query(sql, new UserRowMapper());
		return userList.get(0);
	}
	

}
