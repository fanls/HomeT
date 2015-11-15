package com.integration.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.integration.dao.BlogDAO;
import com.integration.entity.Blog;

public class BlogDAOImpl extends HibernateDaoSupport implements BlogDAO{

	@Override
	public void addBlog(Blog blog) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(blog);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Blog> findAllBlog() {
		// TODO Auto-generated method stub
		String hql = "from Blog";
		List<Blog> blogs = this.getHibernateTemplate().find(hql);
		return blogs;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Blog> findByUser(int uid) {
		// TODO Auto-generated method stub
		String hql ="SELECT";
		List<Blog> blogs = this.getHibernateTemplate().find(hql);
		return blogs;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Blog> findByLabel(String label) {
		// TODO Auto-generated method stub
		String hql ="SELECT";
		List<Blog> blogs = this.getHibernateTemplate().find(hql);
		return blogs;
	}

	@Override
	public void updateBlog(Blog blog) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(blog);
	}

	@Override
	public void deleteBlog(int bid) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(bid);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Blog> findByBid(int bid) {
		// TODO Auto-generated method stub
		String hql ="FROM Blog WHERE BID='"+bid+"'";
		List<Blog> blogs = (List<Blog>) this.getHibernateTemplate().find(hql);
		return blogs;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Blog> findByUid(int uid) {
		// TODO Auto-generated method stub
		String hql ="FROM Blog WHERE UID='"+uid+"'";
		List<Blog> blogs = (List<Blog>) this.getHibernateTemplate().find(hql);
		return blogs;
	}

}
