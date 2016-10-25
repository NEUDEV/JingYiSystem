package com.JES.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.JES.json.JsonUtil;
import com.JES.model.Report;
import com.JES.service.AgentService;

public class MyReportFindByTimeAction extends SuperAction{
	private String firstY;
	private String firstM;
	private String lastY;
	private String lastM;
	private AgentService agentservice;
	private String jsonResult;
	
	public String getFirstY() {
		return firstY;
	}
	public void setFirstY(String firstY) {
		this.firstY = firstY;
	}
	public String getFirstM() {
		return firstM;
	}
	public void setFirstM(String firstM) {
		this.firstM = firstM;
	}
	public String getLastY() {
		return lastY;
	}
	public void setLastY(String lastY) {
		this.lastY = lastY;
	}
	public String getLastM() {
		return lastM;
	}
	public void setLastM(String lastM) {
		this.lastM = lastM;
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
		String[] runyear={"31", "29", "31", "30", "31", "30", "31", "31", "30", "31", "30", "31"};
		String[] nonrunyear={"31", "28", "31", "30", "31", "30", "31", "31", "30", "31", "30", "31"};
		String mid = session.getAttribute("agentID").toString();
		String firstYM=firstY;
		String lastYM=lastY;
		Integer lyear=Integer.valueOf(lastY);
		Integer fmonth=Integer.valueOf(firstM);
		Integer lmonth=Integer.valueOf(lastM);
		if(fmonth<10)
			firstYM+="-0"+firstM+"-01"+" 00:00:00";
		else firstYM+="-"+firstM+"-01"+" 00:00:00";
		if(lmonth<10)
			lastYM+="-0"+lastM;
		else lastYM+="-"+lastM;
		if(lyear % 4 == 0 && lyear % 100 != 0 || lyear % 400 == 0){
		    lastYM+="-"+runyear[lmonth-1]+" 23:59:59";
		}else{
			lastYM+="-"+nonrunyear[lmonth-1]+" 23:59:59";
		}
		reportList=agentservice.FindByTime(2,mid,firstYM,lastYM);
		jsonResult = JsonUtil.listToJson(reportList); 
        ServletActionContext.getResponse().setContentType("text/xml");  
        }catch(Exception e){    
            e.fillInStackTrace();  
        }  
        return SUCCESS;
	}
}
