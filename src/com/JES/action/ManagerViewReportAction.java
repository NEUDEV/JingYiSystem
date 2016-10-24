package com.JES.action;

import java.util.ArrayList;

import com.JES.model.Agent;
import com.JES.model.Report;
import com.JES.service.ManagerService;

public class ManagerViewReportAction extends SuperAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ManagerService managerService;

	public ManagerService getManagerService() {
		return managerService;
	}

	public void setManagerService(ManagerService managerService) {
		this.managerService = managerService;
	}

	/**
	 * 查询班主任。
	 * 
	 * @return
	 */
	public String displayReportByAgent() {
		if (session.getAttribute("managerId") == null) {
			return "LoginNotYet";
		}
		
		ArrayList<Report> reports = new ArrayList<Report>();
		ArrayList<Agent> agents = (ArrayList<Agent>) managerService
				.searchAgent(request.getParameter("searchType"),
						request.getParameter("searchValue"));
		
		for (Agent agent : agents) {
			reports.add(managerService.getReportDAO().findById(agent.getReportId()));
		}
		
		request.setAttribute("i", 0);
		request.setAttribute("reports", reports);

		return "displayReport";
	}

	/**
	 * 显示报表。
	 * 
	 * @return
	 */
	public String displayReport() {
		if (session.getAttribute("managerId") == null) {
			return "LoginNotYet";
		}

		request.setAttribute("i", 0);
		request.setAttribute("reports", managerService.dealWithReport());

		return "displayReport";
	}
}
