package com.JES.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.JES.json.JsonUtil;
import com.JES.model.Report;
import com.JES.model.ReportShowItem;
import com.JES.service.AgentService;

public class MyReportAction extends SuperAction{
	private String selecttype;
	private AgentService agentservice;
	private String jsonResult;
	
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
		if (session.getAttribute("agentID") == null) {
			return "LoginNotYet";
		}
		try{
		List<Report> reportList = new ArrayList<Report>();
		String mid = session.getAttribute("agentID").toString();
		reportList=agentservice.MyReports(selecttype,mid);
		jsonResult = JsonUtil.listToJson(reportList); 
        ServletActionContext.getResponse().setContentType("text/xml");  
        }catch(Exception e){    
            e.fillInStackTrace();  
        }  
        return SUCCESS;
	}
}
