package com.JES.action;

import com.JES.model.Manager;
import com.JES.service.ManagerService;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 管理员操作类。
 * 
 * @author 刘鑫伟
 *
 */
public class ManagerOperationAction extends SuperAction implements
		ModelDriven<Manager> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Manager manager;
	private ManagerService managerService;
	private String result;

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
	 * @return the result
	 */
	public String getResult() {
		return result;
	}

	/**
	 * @param result
	 *            the result to set
	 */
	public void setResult(String result) {
		this.result = result;
	}

	/**
	 * 管理员登陆。
	 * 
	 * @return
	 */
	public String login() {
		if (managerService.isLoginSuccess(manager)) {
			manager = (Manager) managerService.getManagerDAO()
					.findByMname(manager.getMname()).get(0);
			session.setAttribute("managerId", manager.getUid());
			session.setAttribute("loginMessage", "您好：" + manager.getMname()
					+ " [管理员]");
			session.setAttribute("logout", "注销");

			return "managerLoginSuccess";
		}

		request.setAttribute("info", "用户名或密码错误！");
		return "managerLoginFailed";
	}

	/**
	 * 管理员注销。
	 * 
	 * @return
	 */
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

	/**
	 * 显示所有管理员。
	 * 
	 * @return
	 */
	public String displayManager() {
		if (session.getAttribute("managerId") == null) {
			return "LoginNotYet";
		}

		request.setAttribute("i", 0);
		request.setAttribute("managerList", managerService.getManagerDAO()
				.findAll());

		return "displayManager";
	}

	/**
	 * 管理员注册。
	 * 
	 * @return
	 */
	public String managerRegister() {
		if (session.getAttribute("managerId") == null) {
			return "LoginNotYet";
		}

		result = managerService.managerRegister(manager,
				request.getParameter("confirmPassword"));
		System.out.println(result);

		return "managerRegister";
	}

	/**
	 * 管理员删除。
	 */
	public String deleteManager() {
		if (session.getAttribute("managerId") == null) {
			return "LoginNotYet";
		}

		manager = managerService.getManagerDAO().findById(
				request.getAttribute("uid").toString());
		managerService.getManagerDAO().delete(manager);
		request.setAttribute("manager", manager);

		return "deleteManager";
	}

	/**
	 * 查看单个管理员信息。
	 * 
	 * @return
	 */
	public String toDisplayManager() {
		if (session.getAttribute("managerId") == null) {
			return "LoginNotYet";
		}

		if (manager.getUid() == null) {
			manager.setUid(session.getAttribute("managerId").toString());
		}

		request.setAttribute("manager", managerService.getManagerDAO()
				.findById(manager.getUid()));
		return "toDisplayManager";
	}

	/**
	 * 修改密码。
	 * 
	 * @return
	 */
	public String changePassword() {
		if (session.getAttribute("managerId") == null) {
			return "LoginNotYet";
		}

		if (manager.getUid() == null || "".equals(manager.getUid())
				|| "null".equals(manager.getUid())) {
			manager.setUid(session.getAttribute("managerId").toString());
		}

		String chPassword = request.getParameter("chPassword");
		String confirmPassword = request.getParameter("confirmPassword");
		if (!chPassword.equals(confirmPassword)) {
			request.setAttribute("info", "两次密码不一致，请重新输入！");
		} else {
			manager = managerService.getManagerDAO().findById(manager.getUid());
			manager.setPassword(chPassword);
			managerService.getManagerDAO().merge(manager);
			return toDisplayManager();
		}

		return "ManagerchangePasswordFailed";
	}

	@Override
	public Manager getModel() {

		if (manager == null) {
			manager = new Manager();
		}

		return manager;
	}

}
