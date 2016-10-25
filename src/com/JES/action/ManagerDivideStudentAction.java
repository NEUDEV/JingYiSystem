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
	
	/**
	 * 查询学生。
	 * @return
	 */
	public String searchStudent() {
		request.setAttribute("studentList", managerService.searchStudent(
				request.getParameter("searchType"),
				request.getParameter("searchValue")));
		return "studentsDisplay";
	}

	/**
	 * 获取班主任学员。
	 * @return
	 */
	public String selectJingyiStudent() {
		if (session.getAttribute("managerId") == null) {
			return "LoginNotYet";
		}
		
		if (request.getParameterValues("check") == null) {
			request.setAttribute("info", "学员选择不能为空");
			return "selectJingyiStudent";
		}
		
		session.setAttribute("checkStudents",
				request.getParameterValues("check"));
		request.setAttribute("Agents", managerService.getAgentDAO().findAll());
		return "firstLevelAgentDisplay";
	}
	
	/**
	 * 搜索班主任。
	 * @return
	 */
	public String searchAgent() {
		if (session.getAttribute("managerId") == null) {
			return "LoginNotYet";
		}
		
		request.setAttribute("Agents", managerService.searchAgent(
				request.getParameter("searchType"),
				request.getParameter("searchValue")));
		
		return "firstLevelAgentDisplay";
	}
	
	/**
	 * 将学员划分到班主任。
	 * @return
	 */
	public String divideJingyiToFirstLevelAgent() {
		if (session.getAttribute("managerId") == null) {
			return "LoginNotYet";
		}
		
		if (request.getParameterValues("radio") == null) {
			request.setAttribute("info", "班主任选择不能为空");
			return "selectStudentFaild";
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
