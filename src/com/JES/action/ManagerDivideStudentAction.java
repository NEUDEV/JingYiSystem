package com.JES.action;

import java.util.ArrayList;

import com.JES.model.Student;
import com.JES.service.ManagerService;
import com.opensymphony.xwork2.ModelDriven;

public class ManagerDivideStudentAction extends SuperAction implements
		ModelDriven<Student> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Student student;
	private ManagerService managerService;

	public void setManagerService(ManagerService managerService) {
		this.managerService = managerService;
	}
	
	public String searchStudent() {
		request.setAttribute("studentList", managerService.searchStudent(
				request.getParameter("searchType"),
				request.getParameter("searchValue")));
		return "studentsDisplay";
	}

	/**
	 * 获取鲸艺学员。
	 * @return
	 */
	public String selectJingyiStudent() {
		if (session.getAttribute("managerId") == null) {
			return "LoginNotYet";
		}
		
		session.setAttribute("checkStudents",
				request.getParameterValues("check"));
		request.setAttribute("firstLevelAgents", managerService.searchAgent("代理商类别", "1级代理商"));
		return "firstLevelAgentDisplay";
	}
	
	
	public String searchAgent() {
		if (session.getAttribute("managerId") == null) {
			return "LoginNotYet";
		}
		
		request.setAttribute("Agents", managerService.searchAgent(
				request.getParameter("searchType"),
				request.getParameter("searchValue")));
		
		return "firstLevelAgentDisplay";
	}
	
	public String divideJingyiToFirstLevelAgent() {
		if (session.getAttribute("managerId") == null) {
			return "LoginNotYet";
		}
		
		String agentID = request.getParameter("radio");
		String[] checkStudents = (String[])session.getAttribute("checkStudents");
		ArrayList<Student> studentList = new ArrayList<Student>();
		
		for (String uid : checkStudents) {
			student = managerService.getStudentDAO().findById(uid);
			student.setMid(agentID);
			student.setMsign(managerService.getAgentDAO().findById(agentID).getRole());
			managerService.getStudentDAO().merge(student);
			studentList.add(student);
		}
		
		request.setAttribute("studentList", studentList);
		return "divideStudentSuccess";
	}

	@Override
	public Student getModel() {

		if (student == null) {
			student = new Student();
		}

		return student;
	}
}
