package com.JES.action;

import com.JES.service.AgentService;

public class ChangeMarkAction extends SuperAction{
	private String uid;
	private Integer mark;
	private String result;
	private AgentService agentservice;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public Integer getMark() {
		return mark;
	}
	public void setMark(Integer mark) {
		this.mark = mark;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public AgentService getAgentservice() {
		return agentservice;
	}
	public void setAgentservice(AgentService agentservice) {
		this.agentservice = agentservice;
	}
	public String execute() throws Exception {
		if (session.getAttribute("agentID") == null) {
			return "LoginNotYet";
		}
		agentservice.changemark(uid,mark);
		this.result = "true";
		return "success";
	}
}
