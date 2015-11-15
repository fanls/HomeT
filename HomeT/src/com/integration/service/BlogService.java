package com.integration.service;

import java.util.List;

import com.integration.entity.Blog;

public interface BlogService {
	public void addBlog(Blog blog);
	public void deleteBlog(int bid);
	public void updateBlog(Blog blog);
	public List<Blog> findByUid(int uid);
	public List<Blog> findALLBlog();
	public List<Blog> findBlogById(int bid);
}
