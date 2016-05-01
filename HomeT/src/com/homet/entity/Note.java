package com.homet.entity;

/**
 * Note entity. @author MyEclipse Persistence Tools
 */

public class Note implements java.io.Serializable {

	// Fields

	private Integer nid;
	private Integer uid;
	private String title;
	private String createDate;
	private String article;
	private String label;
	
	//不匹配数据库字段
	private String next;
	private String last;

	// Constructors

	/** default constructor */
	public Note() {
	}

	/** minimal constructor */
	public Note(String createDate, String label) {
		this.createDate = createDate;
		this.label = label;
	}

	/** full constructor */
	public Note(Integer uid, String title, String createDate, String article,
			String label) {
		this.uid = uid;
		this.title = title;
		this.createDate = createDate;
		this.article = article;
		this.label = label;
	}

	// Property accessors

	public Integer getNid() {
		return this.nid;
	}

	public void setNid(Integer nid) {
		this.nid = nid;
	}

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getArticle() {
		return this.article;
	}

	public void setArticle(String article) {
		this.article = article;
	}

	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Object getNote() {
		// TODO Auto-generated method stub
		return null;
	}
//不匹配数据库字段
	public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

}