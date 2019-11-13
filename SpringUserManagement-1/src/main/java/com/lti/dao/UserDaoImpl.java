package com.lti.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.lti.model.Users;

public class UserDaoImpl implements UserDao {

	private JdbcTemplate template = null;

	private static final String READ_USER_LOGIN = "Select * from Users where Username =? AND Password=?";
	private static final String READ_ALL_USERS = "Select * from Users";
	private static final String DELETE_USER = "Delete from Users where USERNAME = ?";
	private static final String CREATE_USER = "Insert into Users (USERNAME,PASSWORD,FIRSTNAME,LASTNAME,PHONE) values(?,?,?,?,?) ";
	private static final String UPDATE_USER = "Update Users SET PASSWORD=?, FIRSTNAME=? ,LASTNAME=?, PHONE=? where Username=?";
	private static final String FIND_A_USER = "Select * from Users Where Username=?";

	public UserDaoImpl() {
	}

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public int readLogin(String username, String password) {
		List<Users> mylist = template.query(READ_USER_LOGIN, new Object[] {username ,password} , new rowMapper());
		return mylist!=null?mylist.size():0;
		
	}

	public List<Users> readAllUsers() {
		List<Users> mylist = template.query(READ_ALL_USERS, new rowMapper());
		return mylist;
	}

	public int deleteUser(String username) {
		int result = template.update(DELETE_USER, username);
		return result;
	}

	public int createUser(Users user) {
		int result = template.update(CREATE_USER, user.getUsername(),user.getPassword(), user.getFirstname() ,user.getLastname(), user.getMobilenumber());
		return result;
	}

	public int updateUser(Users user) {
	int result = template.update(UPDATE_USER,user.getPassword(),user.getFirstname(),user.getLastname(),user.getMobilenumber(),user.getUsername());
	return result;
	}

	public Users findbyusername(String username) {
		List<Users> mylist =  template.query(FIND_A_USER,new Object[] {username}, new rowMapper());
		for(Users u: mylist)
		{
			return u;
		}
		return null;
	}

}
