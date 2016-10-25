package com.JES.action;

import java.util.ArrayList;
import java.util.UUID;

import com.JES.dao.AccountDAO;
import com.JES.model.Account;
import com.JES.model.Agent;
import com.JES.service.AgentService;
import com.opensymphony.xwork2.ModelDriven;

public class AgentLoginAndInfoAction extends SuperAction implements
		ModelDriven<Agent> {

	private Agent agent;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AgentService agentservice;

	public AgentService getAgentservice() {
		return agentservice;
	}

	public void setAgentservice(AgentService agentservice) {
		this.agentservice = agentservice;
	}

	/**
	 * ����Ա��½��
	 * 
	 * @return
	 */
	public String login() {
		if (agentservice.isLoginSuccess(agent)) {
			agent = (Agent) agentservice.getAgentDAO()
					.findByAname(agent.getAname()).get(0);
			session.setAttribute("agentID", agent.getUid());
			session.setAttribute("loginMessage", "���ã�" + agent.getAname()
					+ " [" + agent.getRole() + "]");
			session.setAttribute("logout", "ע��");
			return "agentLoginSuccess";
		}

		request.setAttribute("info", "�û������������");
		return "agentLoginFailed";
	}

	public String changePassword() {
		agent.setUid(session.getAttribute("agentID").toString());
		String chPassword = request.getParameter("chPassword");
		String confirmPassword = request.getParameter("confirmPassword");

		if (!agent.getPassword().equals(
				agentservice.getAgentDAO().findById(agent.getUid())
						.getPassword())) {
			request.setAttribute("info", "ԭ���벻��ȷ");
		} else if (!chPassword.equals(confirmPassword)) {
			request.setAttribute("info", "�������벻һ�£����������룡");

		} else {
			agent = agentservice.getAgentDAO().findById(agent.getUid());
			agent.setPassword(chPassword);
			agentservice.getAgentDAO().merge(agent);
			return "changePasswordSuccess";
		}

		return "changePasswordFailed";

	}

	/**
	 * ��ȡAgent��Ϣ��
	 * 
	 * @return
	 */
	public String getAgentInfo() {
		request.setAttribute("agent", session.getAttribute("agent"));
		return "returnAgentInfo";
	}

	/**
	 * ��ʾ��������Ϣ��
	 * 
	 * @return
	 */
	public String displayAgentInfo() {
		agent = agentservice.getAgentDAO().findById(
				session.getAttribute("agentID").toString());
		session.setAttribute("agent", agent);
		request.setAttribute("agent", agent);
		request.setAttribute("superAgent",
				agentservice.getAgentDAO().findById(agent.getMannager()));

		return "displayAgentInfo";
	}

	/**
	 * ���İ�������Ϣ��
	 * 
	 * @return
	 */
	public String changeAgentInfo() {
		Agent oldAgent = (Agent) session.getAttribute("agent");
		agent.setUid(session.getAttribute("agentID").toString());

		if (!"".equals(agent.getAname())) {
			if (agentservice.isExistAgent(agent)) {
				request.setAttribute("info", "�˻����Ѵ���");
				return "changeAgentInfoFailed";
			}
			oldAgent.setAname(agent.getAname());
		}

		if (!"".equals(agent.getName())) {
			oldAgent.setName(agent.getName());
		}

		if (!"".equals(agent.getQq())) {
			oldAgent.setQq(agent.getQq());
		}

		if (!"".equals(agent.getPhone())) {
			oldAgent.setPhone(agent.getPhone());
		}

		if (!"".equals(agent.getAccount())) {
			oldAgent.setAccount(agent.getAccount());
		}

		if (!"".equals(agent.getIdcard())) {
			oldAgent.setIdcard(agent.getIdcard());
		}

		if (!"".equals(agent.getBank())) {
			oldAgent.setBank(agent.getBank());
		}

		agentservice.getAgentDAO().merge(oldAgent);

		return "changeAgentInfoSuccess";
	}

	/**
	 * ������п���Ϣ��
	 * 
	 * @return
	 */
	public String getAccountInfo() {
		ArrayList<Account> accounts = (ArrayList<Account>) agentservice
				.getAccountDAO().findByAgent(
						session.getAttribute("agentID").toString());
		request.setAttribute("i", 0);
		request.setAttribute("accounts", accounts);
		return "displayAccountInfo";
	}

	/**
	 * ɾ���˻���
	 * 
	 * @return
	 */
	public String deleteAccount() {
		Account account = new Account();
		account.setBid(request.getParameter("bid"));
		agentservice.getAccountDAO().delete(account);

		getAccountInfo();
		return "deleteAccountSuccess";
	}

	/**
	 * ����˻���
	 * 
	 * @return
	 */
	public String addAccount() {
		Account account = new Account();
		if (agentservice.getAccountDAO()
				.findByAccount(request.getParameter("account")).size() > 0) {
			getAccountInfo();
			request.setAttribute("info", "�˺��Ѵ��ڣ�");
			return "addAccountFaild";
		}

		account.setBid(UUID.randomUUID().toString());
		account.setAccount(request.getParameter("account"));
		account.setBank(request.getParameter("selectBank"));
		account.setAgent(session.getAttribute("agentID").toString());
		agentservice.getAccountDAO().save(account);

		getAccountInfo();
		return "addAccountSuccess";
	}

	@Override
	public Agent getModel() {
		if (agent == null) {
			agent = new Agent();
		}

		return agent;
	}

}
