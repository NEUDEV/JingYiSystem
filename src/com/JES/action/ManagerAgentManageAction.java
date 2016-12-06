package com.JES.action;

import java.util.ArrayList;
import java.util.UUID;

import com.JES.model.Agent;
import com.JES.model.Report;
import com.JES.model.Student;
import com.JES.service.ManagerService;
import com.opensymphony.xwork2.ModelDriven;

import freemarker.core.ReturnInstruction.Return;

/**
 * ����Ա����������ࡣ
 * 
 * @author ����ΰ
 *
 */
public class ManagerAgentManageAction extends SuperAction implements
		ModelDriven<Agent> {

	private static final long serialVersionUID = 1L;
	private Agent agent;
	private ManagerService managerService;
	private String result;

	public ManagerService getManagerService() {
		return managerService;
	}

	public void setManagerService(ManagerService managerService) {
		this.managerService = managerService;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	/**
	 * ������ע�ᡣ
	 * 
	 * @return
	 */
	public String register() {
		if (session.getAttribute("managerId") == null) {
			return "LoginNotYet";
		}

		result = managerService.agentRegister(agent,
				request.getParameter("confirmPassword"));
		return "agentReigster";
	}

	/**
	 * ��ѯ�����Ρ�
	 * 
	 * @return
	 */
	public String searchAgent() {
		if (session.getAttribute("managerId") == null) {
			return "LoginNotYet";
		}

		request.setAttribute("agentList", managerService.searchAgent(
				request.getParameter("searchType"),
				request.getParameter("searchValue")));
		return "agentsDisplay";
	}

	/**
	 * �޸İ�����Ԥ����
	 * 
	 * @return
	 */
	public String toChange() {
		if (session.getAttribute("managerId") == null) {
			return "LoginNotYet";
		}

		String uid = request.getParameter("uid");
		session.setAttribute("uid", uid);

		return "toChange";
	}

	/**
	 * �鿴�����Ρ�
	 * 
	 * @return
	 */
	public String toDisplay() {
		if (session.getAttribute("managerId") == null) {
			return "LoginNotYet";
		}

		String uid = request.getParameter("uid");
		request.setAttribute("agent", managerService.getAgentDAO()
				.findById(uid));
		return "toDisplay";
	}

	/**
	 * ɾ��������Ԥ����
	 * 
	 * @return
	 */
	public String toDelete() {
		if (session.getAttribute("managerId") == null) {
			return "LoginNotYet";
		}

		String uid = request.getParameter("uid");
		session.setAttribute("uid", uid);
		session.setAttribute("agent", managerService.getAgentDAO()
				.findById(uid));
		request.setAttribute("agent", managerService.getAgentDAO()
				.findById(uid));
		return "toDelete";
	}

	/**
	 * ��ʾ���а����Ρ�
	 * 
	 * @return
	 */
	public String display() {
		if (session.getAttribute("managerId") == null) {
			return "LoginNotYet";
		}

		request.setAttribute("agentList", managerService.getAgents());
		return "agentsDisplay";
	}

	/**
	 * ������ɾ����
	 * 
	 * @return
	 */
	public String delete() {
		if (session.getAttribute("managerId") == null) {
			return "LoginNotYet";
		}

		managerService.deleteAgent((Agent) session.getAttribute("agent"));
		return "agentDeleteSuccess";
	}

	/**
	 * �������޸���Ϣ��
	 * 
	 * @return
	 */
	public String change() {
		if (session.getAttribute("managerId") == null) {
			return "LoginNotYet";
		}

		agent.setUid(request.getParameter("uid"));

		if (managerService.isExistAgent(agent) && !"".equals(agent.getAname())) {
			request.setAttribute("info", "�˺��Ѵ��ڡ�");
			return "agentChangeFaild";
		}

		request.setAttribute("agent", managerService.changeAgent(agent));
		return "agentChangeSuccess";
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

		String chPassword = request.getParameter("chPassword");
		String confirmPassword = request.getParameter("confirmPassword");
		if (!chPassword.equals(confirmPassword)) {
			request.setAttribute("info", "�������벻һ�£����������룡");

		} else {
			agent = managerService.getAgentDAO().findById(agent.getUid());
			agent.setPassword(chPassword);
			managerService.getAgentDAO().merge(agent);
			return toDisplay();
		}

		return "changePasswordFailed";
	}

	/**
	 * ���Ұ����Ρ�
	 * 
	 * @return
	 */
	public String searchCommonAgents() {
		if (session.getAttribute("managerId") == null) {
			return "LoginNotYet";
		}

		request.setAttribute(
				"agentList",
				managerService.searchCommonAgent(
						request.getParameter("searchType"),
						request.getParameter("searchValue")));
		request.setAttribute("i", 0);
		return "returnCommonAgent";
	}

	/**
	 * ��ʾ���а����Ρ�
	 * 
	 * @return
	 */
	public String displayCommonAgents() {
		if (session.getAttribute("managerId") == null) {
			return "LoginNotYet";
		}

		request.setAttribute("agentList", managerService.getAgentDAO()
				.findByRole("������"));
		request.setAttribute("i", 0);
		return "returnCommonAgent";
	}

	/**
	 * ���Ұ����Ρ�
	 * 
	 * @return
	 */
	public String searchSuperAgents() {
		if (session.getAttribute("managerId") == null) {
			return "LoginNotYet";
		}

		request.setAttribute(
				"agentList",
				managerService.searchSuperAgent(
						request.getParameter("searchType"),
						request.getParameter("searchValue")));
		request.setAttribute("i", 0);
		return "returnSuperAgent";
	}

	/**
	 * ��ʾ���г��������Ρ�
	 * 
	 * @return
	 */
	public String displaySuperAgents() {
		if (session.getAttribute("managerId") == null) {
			return "LoginNotYet";
		}

		if (request.getParameterValues("check") == null) {
			request.setAttribute("agentList", managerService.getAgentDAO()
					.findByRole("������"));
			request.setAttribute("info", "������ѡ����Ϊ��");
			return "selectCommonAgentsFailed";
		}

		session.setAttribute("checkCommonAgents",
				request.getParameterValues("check"));

		request.setAttribute("agentList", managerService.getAgentDAO()
				.findByRole("����������"));
		request.setAttribute("i", 0);
		return "returnSuperAgent";
	}

	/**
	 * ���ְ����Ρ�
	 * 
	 * @return
	 */
	public String divideAgent() {
		if (session.getAttribute("managerId") == null) {
			return "LoginNotYet";
		}

		if (request.getParameterValues("radio") == null) {
			request.setAttribute("agentList", managerService.getAgentDAO()
					.findByRole("����������"));
			request.setAttribute("info", "����������ѡ����Ϊ��");
			return "selectSuperAgentsFailed";
		}

		String superAgentID = request.getParameter("radio");
		String[] checkStudents = (String[]) session
				.getAttribute("checkCommonAgents");
		ArrayList<Agent> agentList = new ArrayList<Agent>();

		for (String uid : checkStudents) {
			agent = managerService.getAgentDAO().findById(uid);
			agent.setMannager(superAgentID);
			managerService.getAgentDAO().merge(agent);
			agentList.add(agent);
		}

		request.setAttribute("superAgent", managerService.getAgentDAO()
				.findById(superAgentID));
		request.setAttribute("agentList", agentList);
		request.setAttribute("i", 0);
		return "divideAgentSuccess";
	}

	/**
	 * ��ʾ����������ѧԱ��
	 * 
	 * @return
	 */
	public String displayStudentByAgent() {
		if (session.getAttribute("managerId") == null) {
			return "LoginNotYet";
		}

		request.setAttribute("studentList", (ArrayList<Student>) managerService
				.getStudentDAO().findByMid(agent.getUid()));
		return "displayStudentByAgentSuccess";
	}

	@Override
	public Agent getModel() {

		if (agent == null) {
			agent = new Agent();
		}
		
//		agent.setAname(agent.getAname().replaceAll("\\s*", ""));
//		agent.setName(agent.getName().replaceAll("\\s*", ""));
//		agent.setPhone(agent.getPhone().replaceAll("\\s*", ""));
//		agent.setIdcard(agent.getIdcard().replaceAll("\\s*", ""));
//		agent.setQq(agent.getQq().replaceAll("\\s*", ""));
//		agent.setPassword(agent.getPassword().replaceAll("\\s*", ""));
		

		return agent;
	}

}
