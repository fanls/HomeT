package com.integration.service.impl;

import java.util.List;

import com.integration.dao.BlogDAO;
import com.integration.entity.Blog;
import com.integration.service.BlogService;

public class BlogServiceImpl implements BlogService {
	private BlogDAO blogDAO;
	@Override
	public void addBlog(Blog blog) {
		// TODO Auto-generated method stub
		blogDAO.addBlog(blog);
	}

	@Override
	public void deleteBlog(int bid) {
		// TODO Auto-generated method stub
		blogDAO.deleteBlog(bid);
	}

	@Override
	public void updateBlog(Blog blog) {
		// TODO Auto-generated method stub
		blogDAO.updateBlog(blog);
	}

	@Override
	public List<Blog> findALLBlog() {
		// TODO Auto-generated method stub
		List<Blog> blogs =blogDAO.findAllBlog();
		return blogs;
	}

	public BlogDAO getBlogDAO() {
		return blogDAO;
	}

	public void setBlogDAO(BlogDAO blogDAO) {
		this.blogDAO = blogDAO;
	}

	@Override
	public List<Blog> findBlogById(int bid) {
		// TODO Auto-generated method stub
		List<Blog> blogs = blogDAO.findByBid(bid);
		return blogs;
	}

	@Override
	public List<Blog> findByUid(int uid) {
		// TODO Auto-generated method stub
		List<Blog> blogs = blogDAO.findByUid(uid);
		return blogs;
	}

}
