package com.homet.service;

import java.util.List;

import com.homet.entity.Comment;
import com.homet.entity.Note;

public interface ICommentService {
	public void addComment(Comment comment);
	public void deleteComment(int nid);
	public List<Comment> findByNid(int nid,int page);
	public List<Comment> findByUid(int uid);
}
