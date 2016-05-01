package com.homet.dao;

import java.util.List;

import com.homet.entity.Note;

public interface NoteDAO {
	/**
	 * 添加日记
	 * @param note
	 */
	public void addNote(Note note);
	/**
	 * 根据日记ID查找日记
	 * @param nid
	 * @return
	 */
	public List<Note> findByNid(int nid);
	/**
	 * 根据用户ID查找日记
	 * @param uid
	 * @param page
	 * @return
	 */
	public List<Note> findByUid(String uid,int page);
	/**
	 * 查找所有的日记
	 * @return
	 */
	public List<Note> findAllNote();
	/**
	 * 查找标签分类
	 * @param uid
	 * @return
	 */
	public List findLabel(int uid);
	/**
	 * 归档日期分类
	 * @param uid
	 * @return
	 */
	public List findDate(int uid);
	/**
	 * 通过标签查找
	 * @param label
	 * @param uid
	 * @param page
	 * @return
	 */
	public List<Note> findByLabel(String label,String uid,int page);
	/**
	 * 通过归档日期查询
	 * @param createDate
	 * @param uid
	 * @param page
	 * @return
	 */
	public List<Note> findByDate(String createDate,String uid,int page);
	/**
	 * 更新
	 * @param note
	 */
	public void updateNote(Note note);
	/**
	 * 删除
	 * @param Nid
	 */
	public void deleteNote(int Nid);
	/**
	 * 根据用户ID列表查询
	 * @param uids
	 * @param page
	 * @return
	 */
	public List<Note> findByGroup(List<Integer> uids,int page);
	/**
	 * 根据UId列表查找组日记
	 * @param uids
	 * @return
	 */
	public List<Note> findByGroup(List<String> uids);
}
