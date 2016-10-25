package com.JES.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.JES.json.JsonUtil;
import com.JES.model.Report;
import com.JES.service.AgentService;

public class ManagerLookAgentYejiAction extends SuperAction{
	String mid;
	private String selecttype;
	private AgentService agentservice;
	private String jsonResult;
	
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getSelecttype() {
		return selecttype;
	}
	public void setSelecttype(String selecttype) {
		this.selecttype = selecttype;
	}
	public String getJsonResult() {
		return jsonResult;
	}
	public void setJsonResult(String jsonResult) {
		this.jsonResult = jsonResult;
	}
	public AgentService getAgentservice() {
		return agentservice;
	}
	public void setAgentservice(AgentService agentservice) {
		this.agentservice = agentservice;
	}
	
	public String MyReport(){
		if (session.getAttribute("managerId") == null) {
			return "LoginNotYet";
		}
		try{
		List<Report> reportList = new ArrayList<Report>();
		reportList=agentservice.MyReports(selecttype,mid);
		jsonResult = JsonUtil.listToJson(reportList); 
        ServletActionContext.getResponse().setContentType("text/xml");  
        }catch(Exception e){    
            e.fillInStackTrace();  
        }  
        return SUCCESS;
	}
}
