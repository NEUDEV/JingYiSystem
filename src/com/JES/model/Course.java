package com.JES.model;

import java.sql.Timestamp;

/**
 * Course entity. @author MyEclipse Persistence Tools
 */

public class Course implements java.io.Serializable {

	// Fields

	private String cid;
	private String cname;
	private Timestamp starttime;
	private Timestamp endtime;
	private Integer referencebill;
	private String classname;

	// Constructors

	/** default constructor */
	public Course() {
	}

	/** minimal constructor */
	public Course(String cid) {
		this.cid = cid;
	}

	/** full constructor */
	public Course(String cid, String cname, Timestamp starttime,
			Timestamp endtime, Integer referencebill, String classname) {
		this.cid = cid;
		this.cname = cname.trim();
		this.starttime = starttime;
		this.endtime = endtime;
		this.referencebill = referencebill;
		this.classname = classname.trim();
	}

	// Property accessors

	public String getCid() {
		return this.cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getCname() {
		return this.cname;
	}

	public void setCname(String cname) {
		this.cname = cname.trim();
	}

	public Timestamp getStarttime() {
		return this.starttime;
	}

	public void setStarttime(Timestamp starttime) {
		this.starttime = starttime;
	}

	public Timestamp getEndtime() {
		return this.endtime;
	}

	public void setEndtime(Timestamp endtime) {
		this.endtime = endtime;
	}

	public Integer getReferencebill() {
		return this.referencebill;
	}

	public void setReferencebill(Integer referencebill) {
		this.referencebill = referencebill;
	}

	public String getClassname() {
		return this.classname;
	}

	public void setClassname(String classname) {
		this.classname = classname.trim();
	}

}