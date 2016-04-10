package com.homet.dao;

import java.util.List;

import com.homet.entity.Comment;
import com.homet.entity.Note;

public interface ICommentDAO {
	public void addComment(Comment comment);
	public List<Comment> findByNid(int nid,int page);
	public List<Comment> findByUid(int uid);
	public void deleteComment(int Nid);
}
