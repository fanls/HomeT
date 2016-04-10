package com.homet.service;
import java.util.List;

import com.homet.entity.User;
public interface UserService {
	void saveUser(User user);
	User getUser(String name);
	void deleteUser(int id);
	void updateUser(User user);
	User findUserById(int id);
	List<User> findAll();
	String findByName(String name);
}
