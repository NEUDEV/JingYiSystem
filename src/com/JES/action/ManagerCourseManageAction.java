package com.JES.action;

import com.JES.model.Course;
import com.JES.service.ManagerService;
import com.opensymphony.xwork2.ModelDriven;

/**
 * ����Ա-�γ̹����ࡣ
 * 
 * @author ����ΰ
 *
 */
public class ManagerCourseManageAction extends SuperAction implements
		ModelDriven<Course> {

	private static final long serialVersionUID = 1L;
	private Course course;
	private ManagerService managerService;

	/**
	 * @return the managerService
	 */
	public ManagerService getManagerService() {
		return managerService;
	}

	/**
	 * @param managerService
	 *            the managerService to set
	 */
	public void setManagerService(ManagerService managerService) {
		this.managerService = managerService;
	}

	/**
	 * ��ʾ���пγ̡�
	 * 
	 * @return
	 */
	public String displayCourse() {
		if (session.getAttribute("managerId") == null) {
			return "LoginNotYet";
		}
		
		request.setAttribute("i", 0);
		request.setAttribute("courseList", managerService.getCourseDAO()
				.findAll());

		return "displayCourse";
	}

	/**
	 * ���ӿγ̡�
	 * 
	 * @return
	 */
	public String addCourse() {
		if (session.getAttribute("managerId") == null) {
			return "LoginNotYet";
		}
		
		course = managerService.addCourse(course);
		request.setAttribute("course", course);

		return "addCourse";
	}

	/**
	 * ɾ���γ̡�
	 * 
	 * @return
	 */
	public String deleteCourse() {
		if (session.getAttribute("managerId") == null) {
			return "LoginNotYet";
		}
		
		course = managerService.getCourseDAO().findById(
				request.getAttribute("cid").toString());
		managerService.getCourseDAO().delete(course);
		request.setAttribute("course", course);

		return "deleteCourse";
	}

	@Override
	public Course getModel() {
		if (course == null) {
			course = new Course();
		}
		return course;
	}

}
