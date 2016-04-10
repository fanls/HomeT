package com.homet.service;

import java.util.List;

import com.homet.entity.Resume;

public interface ResumeService {
	public void addResume(Resume resume);
	public void deleteResume(int rid);
	public List<Resume> findResumeALL();
	public List<Resume> findResumeByUid(int uid);	
}