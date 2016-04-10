package com.homet.service.impl;

import java.util.List;
import com.homet.dao.ICommentDAO;
import com.homet.entity.Comment;
import com.homet.service.ICommentService;

public class CommentServiceImpl implements ICommentService {
	private ICommentDAO commentDAO;

	@Override
	public void addComment(Comment comment) {
		// TODO Auto-generated method stub
		commentDAO.addComment(comment);
	}

	@Override
	public void deleteComment(int nid) {
		// TODO Auto-generated method stub
		commentDAO.deleteComment(nid);
	}

	@Override
	public List<Comment> findByNid(int nid,int page) {
		// TODO Auto-generated method stub
		return commentDAO.findByNid(nid,page);
	}

	@Override
	public List<Comment> findByUid(int uid) {
		// TODO Auto-generated method stub
		return commentDAO.findByUid(uid);
	}

	public ICommentDAO getCommentDAO() {
		return commentDAO;
	}

	public void setCommentDAO(ICommentDAO commentDAO) {
		this.commentDAO = commentDAO;
	}
}
