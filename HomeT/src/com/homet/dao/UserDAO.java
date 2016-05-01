package com.homet.dao;
import java.util.List;

import com.homet.entity.User;
public interface UserDAO {
	/**
	 * 增加用户
	 * @param user
	 */
	 void save(User user);
	 /**
	  * 删除用户
	  * @param id
	  */
	 void delete(int id);
	 /**
	  * 更新用户
	  * @param user
	  */
	 void update(User user);
	 /**
	  * 根绝用户ID查找用户
	  * @param id
	  * @return
	  */
	 User findById(int id);
	 /**
	  * 查找所有用户
	  * @return
	  */
	 List<User> findAll();
	 /**
	  * 根据分组查找用户
	  * @param group
	  * @return
	  */
	 List<User> findByGroup(int group);
}