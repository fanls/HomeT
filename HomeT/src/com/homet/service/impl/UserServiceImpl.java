package com.homet.service.impl;
import java.util.ArrayList;
import java.util.List;

import com.homet.dao.UserDAO;
import com.homet.entity.User;
import com.homet.service.UserService;
public class UserServiceImpl implements UserService {
	private UserDAO userDAO;
	public void setUserDAO(UserDAO userDAO){
		this.userDAO=userDAO;
	}
	public void saveUser(User user) {
			userDAO.save(user);
	}
	public User getUser(String name) {
		return userDAO.getUser(name);
	}
	public void deleteUser(int id) {
		if(userDAO.findById(id)!=null)
			userDAO.delete(id);
		
	}
	public void updateUser(User user) {
		if(userDAO.findById(user.getUid())!=null)
			userDAO.update(user);
	}
	public User findUserById(int id) {
		return userDAO.findById(id);
	}
	public List<User> findAll() {
		return userDAO.findAll();
	}
	@Override
	public String findByName(String name) {
		// TODO Auto-generated method stub
		List<User> user = new ArrayList<User>();
		user = userDAO.findByName(name);
		String psw = user.get(0).getPassword();
		return psw;
	}

	
	
}
