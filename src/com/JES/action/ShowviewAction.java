package com.JES.action;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.JES.dao.AgentupstudentDAO;
import com.JES.model.Agentupstudent;

public class ShowviewAction extends SuperAction{
	private String qq;
	AgentupstudentDAO agentupstudentDAO;

	
	public AgentupstudentDAO getAgentupstudentDAO() {
		return agentupstudentDAO;
	}


	public void setAgentupstudentDAO(AgentupstudentDAO agentupstudentDAO) {
		this.agentupstudentDAO = agentupstudentDAO;
	}
	
	public String getQq() {
		return qq;
	}


	public void setQq(String qq) {
		this.qq = qq;
	}


	public String viewImages() {
		if (session.getAttribute("agentID") == null) {
			return "LoginNotYet";
		}
        HttpServletResponse response = null;
        ServletOutputStream out = null;
        Agentupstudent agentupstudent=new Agentupstudent();
        try {
            response = ServletActionContext.getResponse();
            response.setContentType("multipart/form-data");
            out = response.getOutputStream();
            agentupstudent = agentupstudentDAO.findById(qq);
            out.write(agentupstudent.getPhoto()); //换成你自己的图片byte[] 数据就行.
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
