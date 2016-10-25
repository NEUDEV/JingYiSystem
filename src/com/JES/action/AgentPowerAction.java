package com.JES.action;

import com.JES.service.AgentService;

public class AgentPowerAction extends SuperAction{
	private AgentService agentservice;
	
	public AgentService getAgentservice() {
		return agentservice;
	}

	public void setAgentservice(AgentService agentservice) {
		this.agentservice = agentservice;
	}

	public String Power(){
		if (session.getAttribute("agentID") == null) {
			return "LoginNotYet";
		}
		if(agentservice.cheackPower(session.getAttribute("agentID").toString()))
		return "super";
		else return "nonsuper";
	}
}
