package com.integration.dao.impl;
import java.util.List;

import com.integration.dao.ResumeDAO;
import com.integration.entity.Resume;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
public class ResumeDAOImpl extends HibernateDaoSupport implements ResumeDAO{
	@Override
	public void insertResume(Resume resume) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(resume);	
	}
	@Override
	public void deleteResume(int rid) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(rid);
	}
	@Override
	public void updateResume(Resume resume) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(resume);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Resume> queryResumeALL() {
		// TODO Auto-generated method stub
		String hsql = "form resume";
		List<Resume> list = this.getHibernateTemplate().find(hsql);
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Resume> queryResumeByUid(int uid) {
		// TODO Auto-generated method stub
		String hql ="FROM Resume WHERE UID='"+uid+"'";
		List<Resume> list = this.getHibernateTemplate().find(hql);
		return list;
	}
}