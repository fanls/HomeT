package com.homet.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.homet.dao.NoteDAO;
import com.homet.entity.Note;
import com.homet.service.NoteService;

public class NoteServiceImpl implements NoteService {
	private NoteDAO noteDAO;
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
	public List<Note> findALLNote() {
		// TODO Auto-generated method stub
		List<Note> notes =noteDAO.findAllNote();
		return notes;
	}

	public NoteDAO getNoteDAO() {
		return noteDAO;
	}

	public void setNoteDAO(NoteDAO noteDAO) {
		this.noteDAO = noteDAO;
	}

	@Override
	public List<Note> findNoteById(int nid) {
		// TODO Auto-generated method stub
		List<Note> note= noteDAO.findByNid(nid);
		return note;
	}

	@Override
	public List<Note> findByUid(String uid) {
		// TODO Auto-generated method stub
		//List<Note> notes = noteDAO.findByUid(uid);
		return null;
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
}
