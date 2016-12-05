package com.JES.action;

import com.JES.service.AgentService;

public class CheakWeixinAction extends SuperAction{
	private String weixin;
	private String result;
	private AgentService agentservice;
	public String getWeixin() {
		return weixin;
	}
	public void setWeixin(String weixin) {
		this.weixin = weixin;
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
	    if(agentservice.cheakWeixin(weixin)||agentservice.cheakUpWeixin(weixin)){
	      //返回给ajax的数据
	      this.result = "true";
	    }else{
	      this.result = "false";
	    }
	    return "success";
	  }
}
