package com.integration.dao;

import java.util.List;

import com.integration.entity.Blog;

public interface BlogDAO {
	public void addBlog(Blog blog);
	public List<Blog> findByBid(int bid);
	public List<Blog> findByUid(int uid);
	public List<Blog> findAllBlog();
	public List<Blog> findByUser(int uid);
	public List<Blog> findByLabel(String label);
	public void updateBlog(Blog blog);
	public void deleteBlog(int bid);
}
