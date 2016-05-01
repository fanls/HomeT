package com.homet.action;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.homet.entity.User;
import com.homet.service.UserService;
@SuppressWarnings("serial")
public class LoginAction extends BaseAction {
	String username;
	String password;
	int group;
	private UserService userService;

	public String login(){
		HttpServletRequest request = ServletActionContext.getRequest();
		List<User> list = (List<User>) userService.findAll();
		User u = new User();
		Iterator<User> it=list.iterator(); 
		while(it.hasNext()){
			 u = (User)it.next();
			 if(username.trim().equals(u.getName())&&password.trim().equals(u.getPassword())){
				 request.getSession().setAttribute("uid",u.getUid() );
				  return "success";
			 }
		}
		addActionMessage(getText("error.message.not.exist"));
		return "failer";
	}
	public String registry(){
		User u=new User();
		u.setName(username);
		u.setPassword(password);
		u.setGroupId(group);
		userService.saveUser(u);
		ServletActionContext.getRequest().getSession().setAttribute("uid",u.getUid() );
		return SUCCESS;
	}
	public int getGroup() {
		return group;
	}
	public void setGroup(int usertype) {
		this.group= usertype;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
	