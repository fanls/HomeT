package com.homet.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.homet.dao.NoteDAO;
import com.homet.entity.Note;

public class NoteDAOImpl extends HibernateDaoSupport implements NoteDAO{

	@Override
	public void addNote(Note note) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(note);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Note> findAllNote() {
		String hql = "from Note";
		List<Note> notes = this.getHibernateTemplate().find(hql);
		return notes;
	}
	@Override
	public void updateNote(Note note) {
		this.getHibernateTemplate().update(note);
	}
	@Override
	public void deleteNote(int nid) {
		this.getHibernateTemplate().delete(nid);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Note> findByNid(int nid) {
		String hql ="FROM Note n WHERE n.nid='"+nid+"'ORDER BY n.createDate DESC";
		List<Note> note = (List<Note>) this.getHibernateTemplate().find(hql);
		return note;
	}
	@SuppressWarnings("unchecked")
	public List findLabel(int uid){
		String hql = "SELECT n.label ,count(n.label) FROM Note n WHERE n.uid ='"+uid+"'GROUP BY n.label";
		List labels =this.getHibernateTemplate().find(hql);
		return labels;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List findDate(int uid){
		String hql = "SELECT  DATE_FORMAT(n.createDate,'%Y%m') ,count(n.nid) FROM Note n WHERE n.uid ='"+uid+"'GROUP BY DATE_FORMAT(n.createDate,'%Y%m')";
		List date =this.getHibernateTemplate().find(hql);
		return date;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Note> findByUid(String uid,int page) {
		Session session = this.getSession();
		String hql ="SELECT n FROM Note n WHERE UID='"+uid+"'ORDER BY n.createDate DESC";
		Query query = session.createQuery(hql);
		query.setFirstResult((page-1)*3);
		query.setMaxResults(3);
		List<Note> notes = query.list();;
		return notes;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Note> findByLabel(String label,String uid,int page){
		Session session = this.getSession();
		String hql = "SELECT n FROM Note n WHERE n.label ='"+label+"'AND n.uid='"+uid+"'ORDER BY n.createDate DESC";
		Query query = session.createQuery(hql);
		query.setFirstResult((page-1)*3);
		query.setMaxResults(3);
		List<Note> notes = query.list();;
		return notes;
	}
	@Override
	public List<Note> findByDate(String createDate,String uid,int page) {
		Session session = this.getSession();
		String hql ="SELECT n FROM Note n WHERE n.uid ='"+uid+"'AND n.createDate LIKE'%"+createDate+"%'ORDER BY n.createDate DESC";
		Query query = session.createQuery(hql);
		query.setFirstResult((page-1)*3);
		query.setMaxResults(3);
		List<Note> notes = query.list();;
		return notes;
	}
	@Override
	public List<Note> findByGroup(List<Integer> uids, int page) {
		Session session = this.getSession();
		String str = uids.toString();
		String hql ="SELECT n FROM Note n WHERE uid in ("+str.replace("[", "").replace("]", "")+") ORDER BY n.createDate DESC";
		Query query = session.createQuery(hql);
		query.setFirstResult((page-1)*3);
		query.setMaxResults(3);
		List<Note> notes = query.list();;
		return notes;
	}
	public List<Note> findByGroup(List<String> uids){
		Session session = this.getSession();
		String str = uids.toString();
		String hql ="SELECT n FROM Note n WHERE uid in ("+str.replace("[", "").replace("]", "")+") ORDER BY n.createDate DESC";
		Query query = session.createQuery(hql);
		List<Note> notes = query.list();;
		return notes;
	}
}
