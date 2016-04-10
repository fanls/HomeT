package com.homet.service.impl;

import java.util.List;

import com.homet.dao.ResumeDAO;
import com.homet.entity.Resume;
import com.homet.service.ResumeService;

public class ResumeServiceImpl implements ResumeService{
	private ResumeDAO resumeDAO;
	@Override
	public void addResume(Resume resume) {
		// TODO Auto-generated method stub
		resumeDAO.insertResume(resume);
	}

	@Override
	public void deleteResume(int rid) {
		// TODO Auto-generated method stub
		resumeDAO.deleteResume(rid);
	}

	@Override
	public List<Resume> findResumeALL() {
		// TODO Auto-generated method stub
		return resumeDAO.queryResumeALL();
	}

	@Override
	public List<Resume> findResumeByUid(int uid) {
		// TODO Auto-generated method stub
		return resumeDAO.queryResumeByUid(uid);
	}

	public ResumeDAO getResumeDAO() {
		return resumeDAO;
	}

	public void setResumeDAO(ResumeDAO resumeDAO) {
		this.resumeDAO = resumeDAO;
	}

}
