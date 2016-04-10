package com.homet.entity;

/**
 * Resume entity. @author MyEclipse Persistence Tools
 */

public class Resume implements java.io.Serializable {

	// Fields

	private Integer rid;
	private Integer uid;
	private String name;
	private String phone;
	private String email;
	private String general;
	private String program;
	private String sumpro;
	private String inschool;
	private String edu;
	private String others;
	private String createdate;

	// Constructors

	/** default constructor */
	public Resume() {
	}

	/** full constructor */
	public Resume(Integer uid, String name, String phone, String email,
			String general, String program, String sumpro, String inschool,
			String edu, String others, String createdate) {
		this.uid = uid;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.general = general;
		this.program = program;
		this.sumpro = sumpro;
		this.inschool = inschool;
		this.edu = edu;
		this.others = others;
		this.createdate = createdate;
	}

	// Property accessors

	public Integer getRid() {
		return this.rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGeneral() {
		return this.general;
	}

	public void setGeneral(String general) {
		this.general = general;
	}

	public String getProgram() {
		return this.program;
	}

	public void setProgram(String program) {
		this.program = program;
	}

	public String getSumpro() {
		return this.sumpro;
	}

	public void setSumpro(String sumpro) {
		this.sumpro = sumpro;
	}

	public String getInschool() {
		return this.inschool;
	}

	public void setInschool(String inschool) {
		this.inschool = inschool;
	}

	public String getEdu() {
		return this.edu;
	}

	public void setEdu(String edu) {
		this.edu = edu;
	}

	public String getOthers() {
		return this.others;
	}

	public void setOthers(String others) {
		this.others = others;
	}

	public String getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}

}