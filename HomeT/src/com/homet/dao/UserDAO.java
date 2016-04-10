package com.homet.dao;
import java.util.List;

import com.homet.entity.User;
public interface UserDAO {
	 void save(User user);
	 User getUser(String name);
	 void delete(int id);
	 void update(User user);
	 User findById(int id);
	 List<User> findByName(String name);
	 List<User> findAll();
}