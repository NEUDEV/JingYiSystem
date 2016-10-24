package com.JES.action;

import com.JES.model.Manager;
import com.JES.service.ManagerService;
import com.opensymphony.xwork2.ModelDriven;

/**
 * ����Ա�����ࡣ
 * 
 * @author ����ΰ
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
	 * ����Ա��½��
	 * 
	 * @return
	 */
	public String login() {
		if (managerService.isLoginSuccess(manager)) {
			manager = (Manager) managerService.getManagerDAO()
					.findByMname(manager.getMname()).get(0);
			session.setAttribute("managerId", manager.getUid());
			session.setAttribute("loginMessage", "���ã�" + manager.getMname()
					+ " [����Ա]");
			session.setAttribute("logout", "ע��");

			return "managerLoginSuccess";
		}

		request.setAttribute("info", "�û������������");
		return "managerLoginFailed";
	}

	/**
	 * ����Աע����
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
	 * ��ʾ���й���Ա��
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
	 * ����Աע�ᡣ
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
	 * ����Աɾ����
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
	 * �鿴��������Ա��Ϣ��
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
	 * �޸����롣
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
			request.setAttribute("info", "�������벻һ�£����������룡");
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
