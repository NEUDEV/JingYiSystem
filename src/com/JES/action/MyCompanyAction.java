package com.JES.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.JES.json.JsonUtil;
import com.JES.model.Agent;
import com.JES.model.Student;
import com.JES.service.AgentService;

public class MyCompanyAction extends SuperAction{
	private String searchtype;
	private String searchvalue;
	private AgentService agentservice;
	private String jsonResult;
	
	public String getJsonResult() {
		return jsonResult;
	}
	public void setJsonResult(String jsonResult) {
		this.jsonResult = jsonResult;
	}
	public String getSearchtype() {
		return searchtype;
	}
	public void setSearchtype(String searchtype) {
		this.searchtype = searchtype;
	}
	public String getSearchvalue() {
		return searchvalue;
	}
	public void setSearchvalue(String searchvalue) {
		this.searchvalue = searchvalue;
	}
	public AgentService getAgentservice() {
		return agentservice;
	}
	public void setAgentservice(AgentService agentservice) {
		this.agentservice = agentservice;
	}
	
	public String Myagents(){
		if (session.getAttribute("agentID") == null) {
			return "LoginNotYet";
		}
		try{
		List<Agent> agenttList = new ArrayList<Agent>();
		String mannager=session.getAttribute("agentID").toString();
		agenttList=agentservice.searchAgents(searchtype,searchvalue,mannager);
		jsonResult = JsonUtil.listToJson(agenttList);  
		System.out.println();
            ServletActionContext.getResponse().setContentType("text/xml");  
        }catch(Exception e){    
            e.fillInStackTrace();  
        }  
        return SUCCESS;
	}
	
}
