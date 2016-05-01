package com.homet.service;
import java.util.List;

import com.homet.entity.User;
public interface UserService {
	/**
	 * 添加用户
	 * @param user
	 */
	void saveUser(User user);
	/**
	 * 删除用户
	 * @param id
	 */
	void deleteUser(int id);
	/**
	 * 更新
	 * @param user
	 */
	void updateUser(User user);
	/**
	 * 通过用户ID 查找
	 * @param id
	 * @return
	 */
	User findUserById(int id);
	/**
	 * 获得全部用户
	 * @return
	 */
	List<User> findAll();
	/**
	 * 
	 */
	List<User> userInGroup(int group);
}
