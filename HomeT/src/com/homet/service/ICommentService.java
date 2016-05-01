package com.homet.service;

import java.util.List;

import com.homet.entity.Comment;
import com.homet.entity.Note;

public interface ICommentService {
	/**
	 * 增加
	 * @param comment
	 */
	public void addComment(Comment comment);
	/**
	 * 删除
	 * @param nid
	 */
	public void deleteByCid(int cid);
	/**
	 * 通过日记ID查找
	 * @param nid
	 * @param page
	 * @return
	 */
	public List<Comment> findByNid(int nid,int page);
	/**
	 * 通过用户ID查找
	 * @param uid
	 * @return
	 */
	public List<Comment> findByUid(int uid);
	/**
	 * 查找跟uid在同一个组里最近四条评论
	 * @param uid
	 * @return
	 */
	public List<Comment> nearlyCommentInGroup(int uid);
}
