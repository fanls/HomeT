package com.homet.entity;

import java.sql.Timestamp;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer uid;
	private String name;
	private String password;
	private Integer group;
	private Integer level;
	private Integer status;
	private Timestamp createDate;
	private Timestamp lastLogonDate;
	private Integer phone;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** full constructor */
	public User(String name, String password, Integer group, Integer level,
			Integer status, Timestamp createDate, Timestamp lastLogonDate,
			Integer phone) {
		this.name = name;
		this.password = password;
		this.group = group;
		this.level = level;
		this.status = status;
		this.createDate = createDate;
		this.lastLogonDate = lastLogonDate;
		this.phone = phone;
	}

	// Property accessors

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

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getGroup() {
		return this.group;
	}

	public void setGroup(Integer group) {
		this.group = group;
	}

	public Integer getLevel() {
		return this.level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Timestamp getLastLogonDate() {
		return this.lastLogonDate;
	}

	public void setLastLogonDate(Timestamp lastLogonDate) {
		this.lastLogonDate = lastLogonDate;
	}

	public Integer getPhone() {
		return this.phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

}