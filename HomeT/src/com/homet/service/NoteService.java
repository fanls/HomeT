package com.homet.service;

import java.util.List;

import com.homet.entity.Note;

public interface NoteService {
	/**
	 * 添加
	 * @param note
	 */
	public void addNote(Note note);
	/**
	 * 删除
	 * @param nid
	 */
	public void deleteNote(int nid);
	/**
	 * 更新
	 * @param note
	 */
	public void updateNote(Note note);
	/**
	 * 通过日记ID查找日记
	 * @param nid
	 * @return
	 */
	public List<Note> findNoteById(int nid);
	/**
	 * 查找日记标签
	 * @param uid
	 * @return
	 */
	public List findLabel(int uid);
	/**
	 * 查找日记建档日期
	 * @param uid
	 * @return
	 */
	public List findDate(int uid);
	/**
	 * 根据标签查找
	 * @param label
	 * @param uid
	 * @return
	 */
	public List<Note> findByLabel(String label,int uid);
	/**
	 * 根据标签查找日记
	 * @param uid
	 * @param label
	 * @param page
	 * @return
	 */
	public List<Note> queryNote(String uid ,String label,int page);
	/**
	 * 根据建档日期查找日记
	 * @param uid
	 * @param createDate
	 * @param page
	 * @return
	 */
	public List<Note> queryByDate(String uid, String createDate,int page);
	/**
	 * 根据用户ID查找日记
	 * @param uid
	 * @param page
	 * @return
	 */
	public List<Note> findGroupNote(String uid,int page);
}
