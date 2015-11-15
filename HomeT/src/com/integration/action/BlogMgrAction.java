package com.integration.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.integration.entity.Blog;
import com.integration.entity.User;
import com.integration.service.BlogService;
import com.integration.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class BlogMgrAction extends ActionSupport {
	private BlogService blogService;
	private UserService userService;
	private Blog blog;
	private User user;
	
	public String add(){
		Blog b=new Blog();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		b.setArticle(blog.getArticle());
		b.setCreateDate(df.format(new Date()));
		b.setLabel(blog.getLabel());
		b.setTitle(blog.getTitle());
		b.setUid(blog.getUid());
		b.setBid(blog.getBid());
		b.setBlog(blog.getBlog());
		blogService.addBlog(b);
		return SUCCESS;
	}
	public String delete(){
		int id = blog.getBid();
		blogService.deleteBlog(id);
		return SUCCESS;
	}
	public String query(){
		List<User> userl=userService.findAll();
		ServletActionContext.getRequest().setAttribute("userlist", userl);
		if(user==null){
			List<Blog> blogs=blogService.findALLBlog();
			ServletActionContext.getRequest().setAttribute("bloglist", blogs);
		}else{
			List<Blog> blogs=blogService.findByUid(user.getId());
			ServletActionContext.getRequest().setAttribute("bloglist", blogs);
		}
		return "query";
	}
	public String update(){
		if(blogService.findBlogById(blog.getBid())!=null)
		{	
			setBlog(blog);
			blogService.updateBlog(blog);
			return SUCCESS;
		}
		addActionMessage(getText("error.message.not.exist"));
		return INPUT;
	}
	public String show(){
		List<Blog> b=blogService.findBlogById(blog.getBid());
		ServletActionContext.getRequest().setAttribute("blog", b);
		return "showblog";
	}

	public BlogService getBlogService() {
		return blogService;
	}

	public void setBlogService(BlogService blogService) {
		this.blogService = blogService;
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
