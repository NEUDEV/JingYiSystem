package com.JES.action;

import com.JES.model.Student;
import com.JES.service.AgentService;

@SuppressWarnings("serial")
public class AgentBillAction extends SuperAction{
	private String sqq;
	private String phone;
	private String weixin;
	private String sign;
	private Integer bill;
	private Integer mark;
	private String class_;
	private String uid;
	
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	
	public String getSqq() {
		return sqq;
	}
	public void setSqq(String sqq) {
		this.sqq = sqq.replaceAll("\\s*", "");
	}
	public String getClass_() {
		return class_;
	}
	public void setClass_(String class_) {
		this.class_ = class_;
	}

	private AgentService agentservice;
	
	public AgentService getAgentservice() {
		return agentservice;
	}
	public void setAgentservice(AgentService agentservice) {
		this.agentservice = agentservice;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone.replaceAll("\\s*", "");
	}
	public String getWeixin() {
		return weixin;
	}
	public void setWeixin(String weixin) {
		this.weixin = weixin.replaceAll("\\s*", "");
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public Integer getBill() {
		return bill;
	}
	public void setBill(Integer bill) {
		this.bill = bill;
	}
	public Integer getMark() {
		return mark;
	}
	public void setMark(Integer mark) {
		this.mark = mark;
	}
	
	public String billup(){
		if (session.getAttribute("agentID") == null) {
			return "LoginNotYet";
		}
		agentservice.billUp(uid,phone,weixin,sign,bill,mark,class_,session.getAttribute("agentID").toString());
		request.setAttribute("studentupms", "提单成功！");
		return "SUCCESS";
	}
}
