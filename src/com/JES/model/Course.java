package com.JES.model;

import java.util.Date;

/**
 * Course entity. @author MyEclipse Persistence Tools
 */

public class Course implements java.io.Serializable {

	// Fields

	private String cid;
	private String cname;
	private Date starttime;
	private Date endtime;
	private Integer referencebill;

	// Constructors

	/** default constructor */
	public Course() {
	}

	/** minimal constructor */
	public Course(String cid) {
		this.cid = cid;
	}

	/** full constructor */
	public Course(String cid, String cname, Date starttime, Date endtime,
			Integer referencebill) {
		this.cid = cid;
		this.cname = cname;
		this.starttime = starttime;
		this.endtime = endtime;
		this.referencebill = referencebill;
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
		this.cname = cname;
	}

	public Date getStarttime() {
		return this.starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	public Date getEndtime() {
		return this.endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public Integer getReferencebill() {
		return this.referencebill;
	}

	public void setReferencebill(Integer referencebill) {
		this.referencebill = referencebill;
	}

}