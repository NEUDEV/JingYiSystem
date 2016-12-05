package com.JES.action;

import java.util.ArrayList;
import java.util.UUID;

import com.JES.model.Agentupstudent;
import com.JES.model.Report;
import com.JES.model.Student;
import com.JES.service.ManagerService;
import com.opensymphony.xwork2.ModelDriven;

/**
 * ����Ա-ѧԱ��ˡ�
 * @author ����ΰ
 *
 */
public class ManagerAuditStudentAction extends SuperAction implements
		ModelDriven<Agentupstudent> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Agentupstudent agentupstudent;
	private ManagerService managerService;
	private String stuqq;

	
	public String getStuqq() {
		return stuqq;
	}

	public void setStuqq(String stuqq) {
		this.stuqq = stuqq;
	}

	public void setManagerService(ManagerService managerService) {
		this.managerService = managerService;
	}
	
	public String displayUpStudent() {
		request.setAttribute("upStudentList", managerService.getAgentupstudentDAO().findAll());
		return "upStudentsDisplay";
	}
	
	/**
	 * ��ѯѧ����
	 * @return
	 */
	public String searchUpStudent() {
		if (session.getAttribute("managerId") == null) {
			return "LoginNotYet";
		}
		
		request.setAttribute("upStudentList", managerService.searchUpStudent(
				request.getParameter("searchType"),
				request.getParameter("searchValue")));
		return "upStudentsDisplay";
	}
	
	public String deletUpStudent(){
		Agentupstudent astu=managerService.getAgentupstudentDAO().findById(stuqq);
		if(astu!=null)
		managerService.getAgentupstudentDAO().delete(astu);
		return "deletUpStudent";
	}
	
	public String showUpStudent() {
		if (session.getAttribute("managerId") == null) {
			return "LoginNotYet";
		}
		
		session.setAttribute("upStudentQq", agentupstudent.getQq());
		request.setAttribute("upStudent", managerService.getAgentupstudentDAO().findById(agentupstudent.getQq()));
		return "showUpStudent";
	}
	
	/**
	 * ���ѧԱ��
	 * @return
	 */
	public String auditStudent() {
		agentupstudent = managerService.getAgentupstudentDAO().findById(session.getAttribute("upStudentQq").toString());
		
		Student student = new Student();
		student.setUid(UUID.randomUUID().toString());
		student.setQq(agentupstudent.getQq());
		student.setName(agentupstudent.getName());
		student.setPhone(agentupstudent.getPhone());
		student.setStuid(agentupstudent.getStuid());
		student.setNote(agentupstudent.getNote());
		student.setWeixin(agentupstudent.getWeixin());
		student.setMid(agentupstudent.getMid());
		student.setMark(1);
		student.setSign("����ʽѧԱ");
		managerService.auditReport(agentupstudent.getMid(),1);
		
		managerService.getAgentupstudentDAO().delete(agentupstudent);
		managerService.getStudentDAO().save(student);
		
		request.setAttribute("student", student);
		
		return "auditStudent";
	}

	@Override
	public Agentupstudent getModel() {

		if (agentupstudent == null) {
			agentupstudent = new Agentupstudent();
		}

		return agentupstudent;
	}
}
