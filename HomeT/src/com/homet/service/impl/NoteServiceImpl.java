package com.homet.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.homet.dao.NoteDAO;
import com.homet.dao.UserDAO;
import com.homet.entity.Note;
import com.homet.entity.User;
import com.homet.service.NoteService;

public class NoteServiceImpl implements NoteService {
	private NoteDAO noteDAO;
	private UserDAO userDAO;
	@Override
	public void addNote(Note note) {
		// TODO Auto-generated method stub
		noteDAO.addNote(note);
	}

	@Override
	public void deleteNote(int nid) {
		// TODO Auto-generated method stub
		noteDAO.deleteNote(nid);
	}

	@Override
	public void updateNote(Note note) {
		// TODO Auto-generated method stub
		noteDAO.updateNote(note);
	}
	@Override
	public List<Note> findNoteById(int nid) {
		// TODO Auto-generated method stub
		List<Note> note= noteDAO.findByNid(nid);
		return note;
	}

	@Override
	public List findLabel(int uid) {
		// TODO Auto-generated method stub
		List labels = noteDAO.findLabel(uid);
		return labels;
	}

	@Override
	public List findDate(int uid) {
		// TODO Auto-generated method stub
		List dates = noteDAO.findDate(uid);
		return dates;
	}

	public List findByLabel(String label,int uid) {
		// TODO Auto-generated method stub
		//List labels = noteDAO.findByLabel(label,uid);
		return null;
	}
	public List<Note> queryNote(String uid ,String label,int page){
		List<Note> notes = null ;
		if(uid==null){
			notes=noteDAO.findAllNote();
		}else if("".equals(label)||label==null){
			notes=(List<Note>) noteDAO.findByUid(uid,page);
		}else{
			notes=(List<Note>) noteDAO.findByLabel(label, uid,page);
		}
		return notes;
	}

	@Override
	public List<Note> queryByDate(String uid, String createDate,int page) {
		List<Note> notes;
		if(uid == null){
			notes =noteDAO.findAllNote();
		}else{
			String date = createDate.substring(0, 4)+"-"+createDate.substring(4);
			notes = noteDAO.findByDate(date,uid,page);
		}
		return notes;
	}

	@Override
	public List<Note> findGroupNote(String uid, int page) {
		List<Note> notes =null;
		List<Integer> uids =new ArrayList<Integer>();
		int group = 0 ;
		if(uid!=null){
			group =userDAO.findById(Integer.valueOf(uid)).getGroupId();
		}
		List<User> users = userDAO.findByGroup(group);
		for(User u:users){
			uids.add(u.getUid());
		}
		Map<Integer,String> uidToNameMap = new HashMap<Integer, String>();
		for(User u:users){
			uidToNameMap.put(u.getUid(), u.getName());
		}
		notes = noteDAO.findByGroup(uids,page);
		for(Note n: notes){
			n.setLabel(uidToNameMap.get(n.getUid()));//用label属性保存用户名
			
		}
		return notes;
	}
//=============================getter AND setter=======================================
	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	public NoteDAO getNoteDAO() {
		return noteDAO;
	}

	public void setNoteDAO(NoteDAO noteDAO) {
		this.noteDAO = noteDAO;
	}
}
