package com.homet.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.homet.entity.User;
import com.homet.service.UserService;
@SuppressWarnings("serial")
public class UserMgrAction extends BaseAction {
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	private User user;
	public String addUser(){
		User u=new User();
		u.setName(user.getName());
		u.setPassword(user.getPassword());
		u.setGroupId(user.getGroupId());
		userService.saveUser(u);
		return SUCCESS;
	}
	public String deleteUser(){
		int id = user.getUid();
		userService.deleteUser(id);
		return SUCCESS;
	}
	public String queryUser(){
		List<User> userl=userService.findAll();
		ServletActionContext.getRequest().setAttribute("userlist", userl);
		return SUCCESS;
	}
	public String updateUser(){
		if(userService.findUserById(user.getUid())!=null)
		{	
			setUser(user);
			userService.updateUser(user);
			return SUCCESS;
		}
		addActionMessage(getText("error.message.not.exist"));
		return INPUT;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
