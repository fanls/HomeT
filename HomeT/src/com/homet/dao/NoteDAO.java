package com.homet.dao;

import java.util.List;

import com.homet.entity.Note;

public interface NoteDAO {
	public void addNote(Note note);
	public List<Note> findByNid(int nid);
	public List<Note> findByUid(String uid,int page);
	public List<Note> findAllNote();
	public List<Note> findByUser(int uid);
	public List findLabel(int uid);
	public List findDate(int uid);
	public List<Note> findByLabel(String label,String uid,int page);
	public void updateNote(Note note);
	public void deleteNote(int Nid);
	public List<Note> findByDate(String createDate,String uid,int page);
	public List<Note> findAllByPage(int page);
}
