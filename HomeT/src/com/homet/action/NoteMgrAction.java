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
	public String delete(){
		int id = note.getNid();
		noteService.deleteNote(id); 
		return SUCCESS;
	}
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
	public String query() throws IOException{
		Object uid =this.getRequest().getSession().getAttribute("uid");
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
//		List<User> userl=userService.findAll();
//		Object uid =this.getRequest().getSession().getAttribute("uid");
//		List<Note> notes = noteService.queryNote(uid.toString(),null);
////		ServletActionContext.getRequest().setAttribute("notelist", notes);

		return null;
	}
	public String queryByNid(){
		try {
			String str =this.getRequest().getParameter("nid");
			Integer nid = Integer.valueOf(str);
			List<Note> notes = noteService.findNoteById(nid);
			note = notes.get(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "detail";
	}
	public String update(){
		if(noteService.findNoteById(note.getNid())!=null)
		{	
			setNote(note);
			noteService.updateNote(note);
			return SUCCESS;
		}
		addActionMessage(getText("error.message.not.exist"));
		return INPUT;
	}
	public String show(){
		List<Note> b=noteService.findNoteById(note.getNid());
		ServletActionContext.getRequest().setAttribute("note", b);
		return "shownote";
	}
	public String queryLabel() throws Exception{
		int uid =(Integer) this.getRequest().getSession().getAttribute("uid");
		List labels =noteService.findLabel(uid);
		this.printJSON(labels);
/*		Object[] s = labels.toArray();
		for(int i=0;i<labels.size();i++){
//			Object[] s = labels.toArray();
		}
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("data", JSONArray.fromObject(s));
		ServletActionContext.getResponse().getWriter().print(jsonObject.toString());*/
		return null;
	}
	public String queryDate() throws Exception{
		int uid =(Integer) this.getRequest().getSession().getAttribute("uid");
		List dates =noteService.findDate(uid);
		this.printJSON(dates);
/*		Object[] s = labels.toArray();
		for(int i=0;i<labels.size();i++){
//			Object[] s = labels.toArray();
		}
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("data", JSONArray.fromObject(s));
		ServletActionContext.getResponse().getWriter().print(jsonObject.toString());*/
		return null;
	}
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
