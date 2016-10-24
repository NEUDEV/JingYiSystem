package com.JES.action;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.JES.json.JsonUtil;
import com.JES.model.Course;
import com.JES.service.AgentService;


@SuppressWarnings("serial")
public class GetCourseAction extends SuperAction{
	private AgentService agentservice;
	private String jsonResult;
	
	public AgentService getAgentservice() {
		return agentservice;
	}

	public void setAgentservice(AgentService agentservice) {
		this.agentservice = agentservice;
	}

	public String getJsonResult() {
		return jsonResult;
	}

	public void setJsonResult(String jsonResult) {
		this.jsonResult = jsonResult;
	}

	public String courses(){
		if (session.getAttribute("agentID") == null) {
			return "LoginNotYet";
		}
		try{
		List<Course> courseList = new ArrayList<Course>();
		courseList=agentservice.allcourse();
		jsonResult = JsonUtil.listToJson(courseList);  
            ServletActionContext.getResponse().setContentType("text/xml");  
        }catch(Exception e){    
            e.fillInStackTrace();  
        }  
        return SUCCESS;
	}
}
