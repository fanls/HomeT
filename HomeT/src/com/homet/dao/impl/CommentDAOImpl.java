package com.homet.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.homet.dao.ICommentDAO;
import com.homet.entity.Comment;
public class CommentDAOImpl extends HibernateDaoSupport implements ICommentDAO{


	@SuppressWarnings("unchecked")
	@Override
	public List<Comment> findByNid(int nid,int page) {
		Session session = this.getSession();
		String hql ="FROM Comment c WHERE c.nid='"+nid+"'ORDER BY c.createDate DESC";
		Query query = session.createQuery(hql);
		query.setFirstResult((page-1)*3);
		query.setMaxResults(3);
		List<Comment> comments = query.list();
		return comments;
	}

	@Override
	public void addComment(Comment comment) {
		this.getHibernateTemplate().save(comment);
	}

	@Override
	public void deleteByCid(int cid) {
		Comment comm = new Comment();
		comm.setCid(cid);
		this.getHibernateTemplate().delete(comm);
	}

	@Override
	public List<Comment> findByUid(int uid) {
		String hql ="FROM Comment c WHERE c.uid='"+uid+"'ORDER BY c.createDate DESC";
		List<Comment> comments = (List<Comment>) this.getHibernateTemplate().find(hql);
		return comments;
	}

	@Override
	public List<Comment> nearlyComment(List<String> group) {
		String str = group.toString();
		String hql ="FROM Comment c WHERE c.uid in("+str.replace("[", "").replace("]", "")+") ORDER BY c.createDate DESC";
		Session session = this.getSession();
		Query query = session.createQuery(hql);
		query.setFirstResult(0);
		query.setMaxResults(4);
		List<Comment> comments = query.list();
		return comments;
	}

}
