package com.homet.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.homet.entity.Note;
import com.homet.entity.User;
import com.homet.service.NoteService;
import com.homet.service.UserService;

@SuppressWarnings("serial")
public class NoteMgrAction extends BaseAction {
	private NoteService noteService;
	private UserService userService;
	private Note note;
	private User user;
//=========================动作跳转控制===============================	
	public String showUser(){
		String uid =this.getRequest().getParameter("uid");
		User u = new User();
		u = userService.findUserById(Integer.valueOf(uid));
		u.setPassword("个人");
		this.getRequest().setAttribute("user", u);
		return "userNote";
	}
	public String showOwn(){
		int uid =(Integer) this.getRequest().getSession().getAttribute("uid");
		User u = new User();
		u.setUid(uid);
		u.setName("我");
		u.setPassword("个人");
		this.getRequest().setAttribute("user", u);
		return "ownNote";
	}
	public String showGroup(){
		int uid =(Integer) this.getRequest().getSession().getAttribute("uid");
		User u = new User();
		u.setName("我");
		u.setPassword("好友");
		u.setUid(uid);
		this.getRequest().setAttribute("user", u);
		return "groupNote";
	}
	public String detail(){
		String uid =this.getRequest().getParameter("uid");
		User u = new User();
		u = userService.findUserById(Integer.valueOf(uid));
		this.getRequest().setAttribute("user", u);
		return "detail";
	}
	public String write(){
		User u = new User();
		u.setName("我");
		this.getRequest().setAttribute("user",u);
		return "write";
	}
	public String update(){
		String nid =this.getRequest().getParameter("nid");
		User u = new User();
		u.setName("我");
		List<Note> notes = noteService.findNoteById(Integer.valueOf(nid));
		note = notes.get(0);
		this.getRequest().setAttribute("user",u);
		return "update";
	}
//=========================怎删改查功能=============================
	/**
	 * 查找好友日记
	 * @return
	 * @throws IOException
	 */
	public String query() throws IOException{
		String uid =this.getRequest().getParameter("uid");
		String msg =this.getRequest().getParameter("param");
		String op = this.getRequest().getParameter("op");
		String page = this.getRequest().getParameter("page");
		List<Note> notes;
		if("2".equals(op)){
			notes =noteService.queryByDate(uid.toString(), msg,Integer.valueOf(page));
		}else{
			notes =noteService.queryNote(uid.toString(), msg,Integer.valueOf(page));
		//	this.printJSON(notes);
		}
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("data", JSONArray.fromObject(notes));
		ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
		ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8;");
		ServletActionContext.getResponse().getWriter().print(jsonObject.toString());
		return null;
	}
	/**
	 * 查找登录用户的好友日记
	 * @return
	 */
	public String queryGroup(){
		Object uid =this.getRequest().getSession().getAttribute("uid");
		String page = this.getRequest().getParameter("page");
		List<Note> notes =noteService.findGroupNote(uid.toString(), Integer.valueOf(page));
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("data", JSONArray.fromObject(notes));
		ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
		ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8;");
		try {
			ServletActionContext.getResponse().getWriter().print(jsonObject.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 查找用户日记标签及个数
	 * @return
	 * @throws Exception
	 */
	public String queryLabel() throws Exception{
		String uid = this.getRequest().getParameter("uid");
		List labels =noteService.findLabel(Integer.valueOf(uid));
		this.printJSON(labels);
		return null;
	}
	/**
	 * 查找用户日记建档日记及个数
	 * @return
	 * @throws Exception
	 */
	public String queryDate() throws Exception{
		String uid = this.getRequest().getParameter("uid");
		List dates =noteService.findDate(Integer.valueOf(uid));
		this.printJSON(dates);
		return null;
	}
	/**
	 * 根据日记id查找日记详情
	 * @return
	 */
	public String queryByNid(){
		try {
			String str =this.getRequest().getParameter("nid");
			String uid =this.getRequest().getParameter("uid");
			User u = new User();
			u = userService.findUserById(Integer.valueOf(uid));
			u.setPassword(null);
			this.getRequest().setAttribute("user", u);
			Integer nid = Integer.valueOf(str);
			List<Note> notes = noteService.findNoteById(nid);
			note = notes.get(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "detail";
	}
	/**
	 * 添加日记
	 * @return
	 */
	public String add(){
		Note b=new Note();
		int uid =(Integer) this.getRequest().getSession().getAttribute("uid");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
		b.setArticle(note.getArticle());
		b.setCreateDate(df.format(new Date()));
		b.setLabel(note.getLabel());
		b.setTitle(note.getTitle());
		b.setUid(uid);
		b.setNid(note.getNid());
		noteService.addNote(b);
		return SUCCESS;
	}
	/**
	 * 删除日记
	 * @return
	 */
	public String delete(){
		int id = note.getNid();
		noteService.deleteNote(id); 
		return SUCCESS;
	}
	/**
	 * 跟新日记
	 * @return
	 */
	public String doUpdate(){
		if(noteService.findNoteById(note.getNid())!=null)
		{	
			setNote(note);
			noteService.updateNote(note);
			try {
				this.getResponse().sendRedirect("../user/queryByNidNote?nid="+note.getNid()+"&uid="+note.getUid());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		addActionMessage(getText("error.message.not.exist"));
		return INPUT;
	}
	/**
	 * 
	 * @return
	 */
	public String queryByLabel(){
//		int uid =(Integer) this.getRequest().getSession().getAttribute("uid");
		Object uid =this.getRequest().getSession().getAttribute("uid");
		try {
			String msg =this.getRequest().getParameter("flabel");
			String str=new String(msg.getBytes("ISO-8859-1"),"UTF-8");
			List<Note> labels =noteService.queryNote(uid.toString(), str,0);
		
			this.printJSON(labels);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "detail";
	}
	public String userInGroup(){
		int uid =(Integer) this.getRequest().getSession().getAttribute("uid");
		User user = new User();
		user = userService.findUserById(uid);
		int group = user.getGroupId();
		try {
			this.printJSON(userService.userInGroup(group));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
//=========================getter AND setter==============================
	public NoteService getNoteService() {
		return noteService;
	}

	public void setNoteService(NoteService noteService) {
		this.noteService = noteService;
	}

	public Note getNote() {
		return note;
	}

	public void setNote(Note note) {
		this.note = note;
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
