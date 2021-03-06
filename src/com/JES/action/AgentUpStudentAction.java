package com.JES.action;

import java.io.File;
import java.io.FileInputStream;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.JES.model.Agentupstudent;
import com.JES.model.Student;
import com.JES.service.AgentService;
import com.opensymphony.xwork2.ActionSupport;

public class AgentUpStudentAction extends SuperAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private File file;
	private String qq;
    private String name;
    private String weixin;
    private String phone;
    private String stuid;
    private String sfrom;
    private String note;
	private String fileFileName;
	private String fileContentType;
	
	private AgentService agentservice;
	
	
	public String getSfrom() {
		return sfrom;
	}
	public void setSfrom(String sfrom) {
		this.sfrom = sfrom;
	}
	public String getStuid() {
		return stuid;
	}
	public void setStuid(String stuid) {
		this.stuid = stuid;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWeixin() {
		return weixin;
	}
	public void setWeixin(String weixin) {
		this.weixin = weixin;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	public String getFileContentType() {
		return fileContentType;
	}
	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
	
	
	public AgentService getAgentservice() {
		return agentservice;
	}
	public void setAgentservice(AgentService agentservice) {
		this.agentservice = agentservice;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String execute() throws Exception{
	if (session.getAttribute("agentID") == null) {
			return "LoginNotYet";
		}
	File uploadFile=new File(ServletActionContext.getServletContext().getRealPath("uploadFile"));
	if(!uploadFile.exists()){  
        uploadFile.mkdir(); //创建该目录  
    	}
	FileInputStream input=new FileInputStream(file);
	Agentupstudent upstudent=new Agentupstudent();
	/*Student student =new Student();*/
	/*upstudent.setClass_(class_);*/
	upstudent.setName(name.replaceAll("\\s*", ""));
	upstudent.setPhone(phone.replaceAll("\\s*", ""));
	upstudent.setQq(qq.replaceAll("\\s*", ""));
	upstudent.setWeixin(weixin.replaceAll("\\s*", ""));
	upstudent.setNote(note.replaceAll("\\s*", ""));
	upstudent.setSfrom(sfrom.replaceAll("\\s*", ""));
	upstudent.setMid(session.getAttribute("agentID").toString());
	upstudent.setStuid(stuid.replaceAll("\\s*", ""));
	/*student.setUid(UUID.randomUUID().toString());
	student.setQq(qq);
	student.setName(name);
	student.setPhone(phone);
	student.setWeixin(weixin);
	student.setStuid(stuid);
	student.setNote(note);*/
	agentservice.upNowStudent(input, (int) file.length(), upstudent,session.getAttribute("agentID").toString());
	request.setAttribute("studentupms", "信息录入成功！");
	return "success";
	}
}
