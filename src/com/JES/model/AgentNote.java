package com.JES.model;

import java.util.Date;

/**
 * AgentNote entity. @author MyEclipse Persistence Tools
 */

public class AgentNote implements java.io.Serializable {

	// Fields

	private String noteid;
	private String notetime;
	private String note;
	private String agentid;

	// Constructors

	/** default constructor */
	public AgentNote() {
	}

	/** minimal constructor */
	public AgentNote(String noteid) {
		this.noteid = noteid;
	}

	/** full constructor */
	public AgentNote(String noteid, String notetime, String note, String agentid) {
		this.noteid = noteid;
		this.notetime = notetime;
		this.note = note;
		this.agentid = agentid;
	}

	// Property accessors

	public String getNoteid() {
		return this.noteid;
	}

	public void setNoteid(String noteid) {
		this.noteid = noteid;
	}

	public String getNotetime() {
		return this.notetime;
	}

	public void setNotetime(String notetime) {
		this.notetime = notetime;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getAgentid() {
		return this.agentid;
	}

	public void setAgentid(String agentid) {
		this.agentid = agentid;
	}

}