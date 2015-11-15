package com.integration.dao;

import java.util.List;

import com.integration.entity.Resume;

public interface ResumeDAO {
	public void insertResume(Resume resume);
	public void deleteResume(int rid);
	public void updateResume(Resume resume);
	public List<Resume> queryResumeALL();
	public List<Resume> queryResumeByUid(int uid);
}
