package com.JES.action;

import com.JES.model.Student;
import com.JES.service.ManagerService;
import com.opensymphony.xwork2.ModelDriven;

/**
 * ����Ա-ѧ�������ࡣ
 * @author ����ΰ
 *
 */
public class ManagerStudentManageAction extends SuperAction implements
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
	 * ��ѯѧ����
	 * @return
	 */
	public String searchStudent() {
		if (session.getAttribute("managerId") == null) {
			return "LoginNotYet";
		}
		
		request.setAttribute("studentList", managerService.searchStudent(
				request.getParameter("searchType"),
				request.getParameter("searchValue")));
		return "searchStudentSuccess";
	}

	/**
	 * ͨ��id��ѯѧ����
	 * @return
	 */
	public String searchStudentById() {
		if (session.getAttribute("managerId") == null) {
			return "LoginNotYet";
		}
		
		student = managerService.getStudentDAO().findById(student.getUid());
		request.setAttribute("student", student);
		request.setAttribute("i", 0);
		session.setAttribute("student", student);
		return "returnStudentInfo";
	}

	/**
	 * ����ѧ����Ϣ��
	 * @return
	 */
	public String changeStudentInfo() {
		if (session.getAttribute("managerId") == null) {
			return "LoginNotYet";
		}
		
		Student oldStudent = (Student) session.getAttribute("student");
		
		if (!"".equals(student.getQq())) {
			oldStudent.setQq(student.getQq());
		}
		
		if (!"".equals(student.getWeixin())) {
			oldStudent.setWeixin(student.getWeixin());
		}
		
		managerService.getStudentDAO().merge(oldStudent);
		
		return "changeStudentInfoSuccess";
	}

	@Override
	public Student getModel() {

		if (student == null) {
			student = new Student();
		}

		return student;
	}
}
