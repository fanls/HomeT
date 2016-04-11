package com.homet.service;

import java.util.List;

import com.homet.entity.Note;

public interface NoteService {
	public void addNote(Note note);
	public void deleteNote(int nid);
	public void updateNote(Note note);
	public List<Note> findByUid(String uid);
	public List<Note> findALLNote();
	public List<Note> findNoteById(int nid);
	public List findLabel(int uid);
	public List findDate(int uid);
	public List<Note> findByLabel(String label,int uid);
	public List<Note> queryNote(String uid ,String label,int page);
	public List<Note> queryByDate(String uid, String createDate,int page);
	public List<Note> findGroupNote(String uid,int page);
}
