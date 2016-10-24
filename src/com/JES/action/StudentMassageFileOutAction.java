package com.JES.action;

import com.JES.service.AgentService;

public class StudentMassageFileOutAction extends SuperAction{
	private AgentService agentservice;

	public AgentService getAgentservice() {
		return agentservice;
	}

	public void setAgentservice(AgentService agentservice) {
		this.agentservice = agentservice;
	}
	public String massageout()
    {
		if (session.getAttribute("agentID") == null) {
			return "LoginNotYet";
		}
        try {
        	agentservice.studentmsout();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("导出数据有误");
        }
        return null;
    }
     
}
