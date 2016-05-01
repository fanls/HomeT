package com.homet.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.homet.dao.ICommentDAO;
import com.homet.dao.NoteDAO;
import com.homet.dao.UserDAO;
import com.homet.entity.Comment;
import com.homet.entity.Note;
import com.homet.entity.User;
import com.homet.service.ICommentService;

public class CommentServiceImpl implements ICommentService {
	private ICommentDAO commentDAO;
	private UserDAO userDAO;
	private NoteDAO noteDAO;

	@Override
	public void addComment(Comment comment) {
		commentDAO.addComment(comment);
	}
	@Override
	public void deleteByCid(int cid) {
		commentDAO.deleteByCid(cid);
	}
	@Override
	public List<Comment> findByNid(int nid,int page) {
		return commentDAO.findByNid(nid,page);
	}
	@Override
	public List<Comment> findByUid(int uid) {
		return commentDAO.findByUid(uid);
	}
	@Override
	public List<Comment> nearlyCommentInGroup(int uid) {
		List<User> users = new ArrayList<User>();
		List<Comment> comms = new ArrayList<Comment>();
		List<Note> notes = new ArrayList<Note>();
		Map<Integer,String> uidToName = new HashMap<Integer,String>();
		Map<Integer,String> nidToTitle = new HashMap<Integer,String>();
		User user = new User();
		List<String> uids = new ArrayList<String>();
		user = userDAO.findById(uid);
		users = userDAO.findByGroup(user.getGroupId());
		for(User u : users){
			uidToName.put(u.getUid(), u.getName());
			uids.add(u.getUid().toString());
		}
		notes = noteDAO.findByGroup(uids);
		for(Note n : notes){
			nidToTitle.put(n.getNid(), n.getTitle());
		}
		comms = commentDAO.nearlyComment(uids);
		for(Comment c:comms){
			c.setAuthor(uidToName.get(c.getUid()));
			c.setData(nidToTitle.get(c.getNid()));
		}
		return comms;
	}
//========================setter AND getter================================
	public ICommentDAO getCommentDAO() {
		return commentDAO;
	}
	public void setCommentDAO(ICommentDAO commentDAO) {
		this.commentDAO = commentDAO;
	}
	public UserDAO getUserDAO() {
		return userDAO;
	}
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	public NoteDAO getNoteDAO() {
		return noteDAO;
	}
	public void setNoteDAO(NoteDAO noteDAO) {
		this.noteDAO = noteDAO;
	}
}
