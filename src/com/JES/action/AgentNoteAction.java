package com.JES.action;

import java.util.Date;

import com.JES.service.AgentService;

public class AgentNoteAction {
	private String note;
	AgentService agentservice;
	
	public AgentService getAgentservice() {
		return agentservice;
	}
	public void setAgentservice(AgentService agentservice) {
		this.agentservice = agentservice;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String agentnote(){
		agentservice.agentNote(note);
		return "success";
	}
}
