package com.lti.service;

import java.util.List;

import com.lti.dao.UserDao;
import com.lti.model.Users;

public class UserServiceImpl implements UserService {
	UserDao dao = null;

	public UserDao getDao() {
		return dao;
	}

	public void setDao(UserDao dao) {
		this.dao = dao;
	}

	public UserServiceImpl() {
	}

	public boolean checkLogin(String username, String password) {
		int result = dao.readLogin(username, password);
		if (result ==1) {
			return true;
		}
		return false;
	}

	public List<Users> findAllUsers() {
		List<Users> mylist = dao.readAllUsers();
		return mylist;
	}

	public boolean removeUser(String username) {
		int result = dao.deleteUser(username);
		if (result == 1) {
			return true;
		} else {
			return false;
		}
	}

	public boolean addUser(Users user) {
		int result = dao.createUser(user);
		if (result == 1) {
			return true;
		} else {
			return false;
		}
	}

	public boolean updateUser(Users user) {
		int result = dao.updateUser(user);
		if (result == 1) {
			return true;
		} else {
			return false;
		}
	}

	public Users findUser(String username) {
		return dao.findbyusername(username);
	}
}
