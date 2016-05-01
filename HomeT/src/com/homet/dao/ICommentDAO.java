package com.homet.dao;

import java.util.List;

import com.homet.entity.Comment;
import com.homet.entity.Note;

public interface ICommentDAO {
	/**
	 * 添加评论
	 * @param comment
	 */
	public void addComment(Comment comment);
	/**
	 * 根据日记Id查找
	 * @param nid
	 * @param page
	 * @return
	 */
	public List<Comment> findByNid(int nid,int page);
	/**
	 * 根据用户ID查找
	 * @param uid
	 * @return
	 */
	public List<Comment> findByUid(int uid);
	/**
	 * 删除
	 * @param cid
	 */
	public void deleteByCid(int cid);
	/**
	 * 找最近四条评论
	 * @return
	 */
	public List<Comment> nearlyComment(List<String> group);
}
