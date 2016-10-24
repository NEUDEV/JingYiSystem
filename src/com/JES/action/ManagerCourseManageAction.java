package com.JES.action;

import com.JES.model.Course;
import com.JES.service.ManagerService;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 管理员-课程管理类。
 * 
 * @author 刘鑫伟
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
	 * 显示所有课程。
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
	 * 增加课程。
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
	 * 删除课程。
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
