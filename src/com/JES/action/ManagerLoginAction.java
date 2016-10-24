package com.JES.action;

import com.JES.model.Manager;
import com.JES.service.ManagerService;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.mail.util.LogOutputStream;

public class ManagerLoginAction extends SuperAction implements
		ModelDriven<Manager> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Manager manager;
	private ManagerService managerService;

	public ManagerService getManagerService() {
		return managerService;
	}

	public void setManagerService(ManagerService managerService) {
		this.managerService = managerService;
	}

	/**
	 * ����Ա��½��
	 * 
	 * @return
	 */
	public String login() {
		if (managerService.isLoginSuccess(manager)) {
			manager = (Manager) managerService.getManagerDAO()
			.findByMname(manager.getMname()).get(0);
			session.setAttribute("managerId",manager.getUid());
			session.setAttribute("loginMessage", "���ã�" + manager.getMname() + " [����Ա]");
			session.setAttribute("logout", "ע��");
			
			return "managerLoginSuccess";
		}

		request.setAttribute("info", "�û������������");
		return "managerLoginFailed";
	}
	
	public String logout() {
		
		if (session.getAttribute("managerId") != null) {
			session.setAttribute("managerId", null);
		} else {
			session.setAttribute("agentID", null);
		}
		
		session.setAttribute("loginMessage", null);
		session.setAttribute("logout", null);
		return "logout";
	}

	@Override
	public Manager getModel() {

		if (manager == null) {
			manager = new Manager();
		}

		return manager;
	}

}
