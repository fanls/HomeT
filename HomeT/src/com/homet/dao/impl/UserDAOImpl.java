package com.homet.dao.impl;
import java.util.List;

import com.homet.dao.UserDAO;
import com.homet.entity.User;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
public class UserDAOImpl extends HibernateDaoSupport implements UserDAO{
	public void save(User user) {
		this.getHibernateTemplate().save(user);		
	}
	public void delete(int id) {
			this.getHibernateTemplate().delete(findById(id));
	}	
	public void update(User user){
			this.getHibernateTemplate().update(user);
	}
	@SuppressWarnings("unchecked")
	public User findById(int id) {
		User user = (User) this.getHibernateTemplate().get(User.class, id);
		return user;
	}	
	@SuppressWarnings("unchecked")
	public List<User> findAll() {
			String queryString = "from User";
			List<User> list =this.getHibernateTemplate().find(queryString);
			return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<User> findByGroup(int group) {
		String hsql = "from User u where u.groupId ="+group;
		List<User> list = this.getHibernateTemplate().find(hsql);
		return list;
	}
}