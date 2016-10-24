package com.JES.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import com.JES.dao.AgentDAO;
import com.JES.dao.CourseDAO;
import com.JES.dao.ManagerDAO;
import com.JES.dao.ReportDAO;
import com.JES.dao.StudentDAO;
import com.JES.model.Agent;
import com.JES.model.Course;
import com.JES.model.Manager;
import com.JES.model.Report;
import com.JES.model.Student;

/**
 * 管理员Service。
 * @author 刘鑫伟
 *
 */
public class ManagerService {
	private ManagerDAO managerDAO;
	private AgentDAO agentDAO;
	private StudentDAO studentDAO;
	private ReportDAO reportDAO;
	private CourseDAO courseDAO;

	/**
	 * @return the managerDAO
	 */
	public ManagerDAO getManagerDAO() {
		return managerDAO;
	}

	/**
	 * @param managerDAO the managerDAO to set
	 */
	public void setManagerDAO(ManagerDAO managerDAO) {
		this.managerDAO = managerDAO;
	}

	/**
	 * @return the agentDAO
	 */
	public AgentDAO getAgentDAO() {
		return agentDAO;
	}

	/**
	 * @param agentDAO the agentDAO to set
	 */
	public void setAgentDAO(AgentDAO agentDAO) {
		this.agentDAO = agentDAO;
	}

	/**
	 * @return the studentDAO
	 */
	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	/**
	 * @param studentDAO the studentDAO to set
	 */
	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	/**
	 * @return the reportDAO
	 */
	public ReportDAO getReportDAO() {
		return reportDAO;
	}

	/**
	 * @param reportDAO the reportDAO to set
	 */
	public void setReportDAO(ReportDAO reportDAO) {
		this.reportDAO = reportDAO;
	}

	/**
	 * @return the courseDAO
	 */
	public CourseDAO getCourseDAO() {
		return courseDAO;
	}

	/**
	 * @param courseDAO the courseDAO to set
	 */
	public void setCourseDAO(CourseDAO courseDAO) {
		this.courseDAO = courseDAO;
	}

	/**
	 * 是否登陆成功。
	 * 
	 * @param manager
	 *            管理员对象。
	 * @return 是否登陆成功。
	 */
	public boolean isLoginSuccess(Manager manager) {
		List resultList = managerDAO.findByMname(manager.getMname());

		if (resultList.size() != 0) {
			Manager result = (Manager) resultList.get(0);

			if (manager.getMname().equals(result.getMname())
					&& manager.getPassword().equals(result.getPassword())) {
				return true;
			}
		}

		return false;
	}

	/**
	 * 是否存在班主任。
	 * 
	 * @param agent
	 *            班主任对象。
	 * @return
	 */
	public boolean isExistAgent(Agent agent) {
		List results = agentDAO.findByAname(agent.getAname());

		if (results.size() != 0) {

			Agent a = (Agent) results.get(0);
			if (agent.getUid().equals(a.getUid())) {
				return false;
			}

			return true;
		}

		return false;
	}

	/**
	 * 班主任注册。
	 * 
	 * @param agent
	 */
	public String agentRegister(Agent agent, String confirmPassword) {
		Map<String, String> map = new HashMap<String, String>();
		agent.setUid("");

		if (isExistAgent(agent)) {
			map.put("info", "代理商账号已存在");
			return JSONObject.fromObject(map).toString();
		} else if (!agent.getPassword().equals(confirmPassword)) {
			map.put("info", "两次密码不一致");
			return JSONObject.fromObject(map).toString();
		} else if ("班主任".equals(agent.getRole())) {
			agent.setRole("班主任");
		} else if ("超级班主任".equals(agent.getRole())) {
			agent.setRole("超级班主任");
		}

		String reportId = UUID.randomUUID().toString();
		agent.setReportId(reportId);

		String uid = UUID.randomUUID().toString();
		agent.setUid(uid);
		agent.setMannager("");
		agentDAO.save(agent);

		Report report = new Report(0);
		report.setReportid(reportId);
		reportDAO.save(report);

		map.put("info", "OK");
		map.put("uid", agent.getUid());
		return JSONObject.fromObject(map).toString();

	}

	public ArrayList<Agent> getAgents() {
		return (ArrayList<Agent>) agentDAO.findAll();
	}

	/**
	 * 查找班主任。
	 * 
	 * @param searchType
	 * @param searchValue
	 * @return
	 */
	public ArrayList<Agent> searchAgent(String searchType, String searchValue) {

		if ("账户名".equals(searchType)) {
			return (ArrayList<Agent>) agentDAO.findByAname(searchValue);
		} else if ("姓名".equals(searchType)) {
			return (ArrayList<Agent>) agentDAO.findByName(searchValue);
		} else if ("手机号".equals(searchType)) {
			return (ArrayList<Agent>) agentDAO.findByPhone(searchValue);
		} else if ("QQ".equals(searchType)) {
			return (ArrayList<Agent>) agentDAO.findByQq(searchValue);
		} else if ("班主任类别".equals(searchType)) {
			return (ArrayList<Agent>) agentDAO.findByRole(searchValue);
		}

		return new ArrayList<Agent>();
	}

	/**
	 * 查找普通班主任。
	 * 
	 * @param searchType
	 * @param searchValue
	 * @return
	 */
	public ArrayList<Agent> searchCommonAgent(String searchType,
			String searchValue) {

		if ("账户名".equals(searchType)) {
			return (ArrayList<Agent>) agentDAO
					.findCommonAgentsByAname(searchValue);
		} else if ("姓名".equals(searchType)) {
			return (ArrayList<Agent>) agentDAO
					.findCommonAgentsByName(searchValue);
		} else if ("手机号".equals(searchType)) {
			return (ArrayList<Agent>) agentDAO
					.findCommonAgentsByPhone(searchValue);
		} else if ("QQ".equals(searchType)) {
			return (ArrayList<Agent>) agentDAO
					.findCommonAgentsByQq(searchValue);
		}

		return new ArrayList<Agent>();
	}

	/**
	 * 查找超级班主任。
	 * 
	 * @param searchType
	 * @param searchValue
	 * @return
	 */
	public ArrayList<Agent> searchSuperAgent(String searchType,
			String searchValue) {

		if ("账户名".equals(searchType)) {
			return (ArrayList<Agent>) agentDAO
					.findSuperAgentsByAname(searchValue);
		} else if ("姓名".equals(searchType)) {
			return (ArrayList<Agent>) agentDAO
					.findSuperAgentsByName(searchValue);
		} else if ("手机号".equals(searchType)) {
			return (ArrayList<Agent>) agentDAO
					.findSuperAgentsByPhone(searchValue);
		} else if ("QQ".equals(searchType)) {
			return (ArrayList<Agent>) agentDAO.findSuperAgentsByQq(searchValue);
		}

		return new ArrayList<Agent>();
	}

	/**
	 * 查找学生。
	 * 
	 * @param searchType
	 * @param searchValue
	 * @return 学生集合。
	 */
	public ArrayList<Student> searchStudent(String searchType,
			String searchValue) {
		if ("UID".equals(searchType)) {
			ArrayList<Student> students = new ArrayList<Student>();
			Student student = studentDAO.findById(searchValue);
			if (student != null) {
				students.add(student);
			}
			return students;
		} else if ("姓名".equals(searchType)) {
			return (ArrayList<Student>) studentDAO.findByName(searchValue);
		} else if ("手机号".equals(searchType)) {
			return (ArrayList<Student>) studentDAO.findByPhone(searchValue);
		} else if ("QQ".equals(searchType)) {
			return (ArrayList<Student>) studentDAO.findByQq(searchValue);
		} else if ("学号".equals(searchType)) {
			return (ArrayList<Student>) studentDAO.findByStuid(searchValue);
		}

		return new ArrayList<Student>();
	}

	/**
	 * 修改班主任。
	 * 
	 * @param agent
	 */
	public void changeAgent(Agent agent) {
		
		Agent otherAgent = agentDAO.findById(agent.getUid());

		if (!agent.getAname().equals(otherAgent.getAname())) {
			otherAgent.setAname(agent.getAname());
		}

		if (!agent.getName().equals(otherAgent.getName())) {
			otherAgent.setName(agent.getName());
		}

		if (!agent.getQq().equals(otherAgent.getQq())) {
			otherAgent.setQq(agent.getQq());
		}

		if (!agent.getPhone().equals(otherAgent.getPhone())) {
			otherAgent.setPhone(agent.getPhone());
		}

		if (!agent.getRole().equals(otherAgent.getRole())) {
			otherAgent.setRole(agent.getRole());
		}

		agentDAO.merge(otherAgent);
	}

	/**
	 * 返回报表。
	 * 
	 * @param managerId
	 * @return
	 */
	public ArrayList<Report> dealWithReport() {
		Report report = new Report(0);
		ArrayList<Report> reports = (ArrayList<Report>) reportDAO.findAll();
		Integer allOfStudent = 0;

		for (Report item : reports) {
			report.setBrandstu(report.getBrandstu() + item.getBrandstu());
			report.setFullstu(report.getFullstu() + item.getFullstu());
			report.setIllustration(report.getIllustration()
					+ item.getIllustration());
			report.setInformalstu(report.getInformalstu()
					+ item.getInformalstu());
			report.setLifetimestu(report.getLifetimestu()
					+ item.getLifetimestu());
			report.setOnlinestu(report.getOnlinestu() + item.getOnlinestu());
			report.setPlatestu(report.getPlatestu() + item.getPlatestu());
			report.setTypefacestu(report.getTypefacestu()
					+ item.getTypefacestu());
			report.setAllinnum(report.getAllinnum() + item.getAllinnum());
			report.setAllbills(report.getAllbills() + item.getAllbills());
			report.setTransrate((report.getAllinnum())
					/ (double) report.getAllinnum() + report.getInformalstu());
		}

		reports.add(report);

		return reports;
	}

	/**
	 * 删除班主任。
	 * 
	 * @return
	 */
	public void deleteAgent(Agent agent) {
		agentDAO.delete(agent);
		Report report = reportDAO.findById(agent.getReportId());
		reportDAO.delete(report);
		
		ArrayList<Student> students = (ArrayList<Student>) studentDAO.findByMid(agent.getUid());
		for (Student student : students) {
			student.setMid(null);
			student.setMsign(null);
			studentDAO.merge(student);
		}
	}
	
	/*********************************课程管理*****************************/
	
	/**
	 * 添加课程。
	 * @param course
	 */
	public Course addCourse(Course course) {
		String cid = UUID.randomUUID().toString();
		course.setCid(cid);
		courseDAO.save(course);
		return courseDAO.findById(cid);
	}

}
