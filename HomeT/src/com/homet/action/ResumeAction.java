package com.homet.action;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.homet.entity.Resume;
import com.homet.service.ResumeService;
@SuppressWarnings("serial")
public class ResumeAction extends BaseAction{
	private ResumeService resumeService;
	private Resume resume;
	private int detilType;
	public String add(){
		Resume rs =new Resume();
		rs.setUid(resume.getUid());
		rs.setRid(resume.getRid());
		rs.setName(resume.getName());
		rs.setPhone(resume.getPhone());
		rs.setProgram(resume.getProgram());
		rs.setSumpro(resume.getSumpro());
		rs.setEmail(resume.getEmail());
		rs.setEdu(resume.getEdu());
		rs.setGeneral(resume.getGeneral());
		rs.setInschool(resume.getInschool());
		rs.setCreatedate(resume.getCreatedate());
		rs.setOthers(resume.getOthers());
		resumeService.addResume(rs);
		return SUCCESS;
	}
	public String delete(){
		return SUCCESS;
	}
	public String queryALL(){
		List<Resume> res=resumeService.findResumeALL();
		ServletActionContext.getRequest().setAttribute("resumelist", res);
		return "queryAll";
	}
	public String queryByUid(){
		List<Resume> res=resumeService.findResumeByUid(2012213534);
		ServletActionContext.getRequest().setAttribute("rs", res.get(0));
		return "queryByUid";
	}
	public String resumeDetail() throws Exception{
		List<Resume> res=resumeService.findResumeByUid(2012213534);
		String result=null;
		switch(detilType){
		case 0:result = res.get(0).getGeneral();break;
		case 1:result = res.get(0).getEdu();break;
		case 2:result = res.get(0).getProgram();break;
		case 3:result = res.get(0).getSumpro();break;
		case 4:result = res.get(0).getInschool();break;
		case 5:result = res.get(0).getOthers();break;
		default :result = "û�����";
		}
		String b;
		if(result.length()>280){
			b = result.substring(0, 280).concat("...");
		}else{
			b =result;
		}
		String a = b.replace("\r\n", "<br>");
		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		ServletActionContext.getResponse().getWriter().print(a);
		return null;
	}
	public ResumeService getResumeService() {
		return resumeService;
	}

	public void setResumeService(ResumeService resumeService) {
		this.resumeService = resumeService;
	}
	public Resume getResume() {
		return resume;
	}
	public void setResume(Resume resume) {
		this.resume = resume;
	}
	public int getDetilType() {
		return detilType;
	}
	public void setDetilType(int detilType) {
		this.detilType = detilType;
	}
}
