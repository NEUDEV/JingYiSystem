package com.JES.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.JES.json.JsonUtil;
import com.JES.model.Student;
import com.JES.model.Studentmasage;
import com.JES.service.AgentService;

@SuppressWarnings("serial")
public class AgentStudentsAction extends SuperAction{
	private String searchtype;
	private String searchvalue;
	private Integer chose;
	private AgentService agentservice;
	private String jsonResult;
	private String resultintime;
	
	
	public String getResultintime() {
		return resultintime;
	}
	public void setResultintime(String resultintime) {
		this.resultintime = resultintime;
	}
	public Integer getChose() {
		return chose;
	}
	public void setChose(Integer chose) {
		this.chose = chose;
	}
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
	
	public String Mystudents(){
		if (session.getAttribute("agentID") == null) {
			return "LoginNotYet";
		}
		try{
		List<Studentmasage> studentList = new ArrayList<Studentmasage>();
		
		String mid=session.getAttribute("agentID").toString();
		studentList=agentservice.searchStudents(searchtype,searchvalue,mid,chose);
		jsonResult = JsonUtil.listToJson(studentList);  
		System.out.println();
            ServletActionContext.getResponse().setContentType("text/xml");  
        }catch(Exception e){    
            e.fillInStackTrace();  
        }  
        return SUCCESS;
	}
	
	
	
}
