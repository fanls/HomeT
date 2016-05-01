package com.homet.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.homet.entity.Comment;
import com.homet.entity.User;
import com.homet.service.ICommentService;
import com.homet.service.UserService;

public class CommentMgrAction extends BaseAction {
	private ICommentService commentService;
	private UserService userService;
	private Comment comment;
	
	public String add(){
		int uid = (Integer) this.getRequest().getSession().getAttribute("uid");
		String nid = this.getRequest().getParameter("nid");
		String data = this.getRequest().getParameter("data");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Comment comm = new Comment();
		comm.setUid(uid);
		comm.setNid(Integer.valueOf(nid));
		comm.setData(data);
		comm.setCreateDate(df.format(new Date()));
		comm.setType(0);
		commentService.addComment(comm);
		return "success";
	}
	public String queryByNid(){
		try {
			String str = this.getRequest().getParameter("nid");
			String strpage = this.getRequest().getParameter("page");
			int nid =Integer.valueOf(str);
			int page =Integer.valueOf(strpage);
			List<Comment> comments = commentService.findByNid(nid,page);
			List<User> users = userService.findAll();
			Map<Integer,String> uidToNameMap = new HashMap<Integer,String>();
			for(User user:users){
				uidToNameMap.put(user.getUid(), user.getName());
			}
			for(Comment comm:comments){
				comm.setAuthor(uidToNameMap.get(comm.getUid()));
			}
			this.printJSON(comments);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public String getNearly(){
		int uid = (Integer) this.getRequest().getSession().getAttribute("uid");
		List<Comment> comms = commentService.nearlyCommentInGroup(uid);
		try {
			this.printJSON(comms);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public void deleteByCid(){
		String cid = this.getRequest().getParameter("cid");
		String nid = this.getRequest().getParameter("nid");
		String uid = this.getRequest().getParameter("uid");
		commentService.deleteByCid(Integer.valueOf(cid));
		try {
			this.getResponse().sendRedirect("../user/queryByNidNote?nid="+nid+"&uid="+uid);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ICommentService getCommentService() {
		return commentService;
	}

	public void setCommentService(ICommentService commentService) {
		this.commentService = commentService;
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
