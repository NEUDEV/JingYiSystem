package com.JES.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.JES.service.AgentService;

public class CheakQqAction extends SuperAction{
	private String qq;
	private String result;
	private AgentService agentservice;
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
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
	    if(agentservice.cheakQq(qq)){
	      //返回给ajax的数据
	      this.result = "true";
	    }else{
	      this.result = "false";
	    }
	    return "success";
	  }
}
