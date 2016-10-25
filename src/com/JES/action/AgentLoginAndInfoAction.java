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
	 * 管理员登陆。
	 * 
	 * @return
	 */
	public String login() {
		if (agentservice.isLoginSuccess(agent)) {
			agent = (Agent) agentservice.getAgentDAO()
					.findByAname(agent.getAname()).get(0);
			session.setAttribute("agentID", agent.getUid());
			session.setAttribute("loginMessage", "您好：" + agent.getAname()
					+ " [" + agent.getRole() + "]");
			session.setAttribute("logout", "注销");
			return "agentLoginSuccess";
		}

		request.setAttribute("info", "用户名或密码错误！");
		return "agentLoginFailed";
	}

	public String changePassword() {
		agent.setUid(session.getAttribute("agentID").toString());
		String chPassword = request.getParameter("chPassword");
		String confirmPassword = request.getParameter("confirmPassword");

		if (!agent.getPassword().equals(
				agentservice.getAgentDAO().findById(agent.getUid())
						.getPassword())) {
			request.setAttribute("info", "原密码不正确");
		} else if (!chPassword.equals(confirmPassword)) {
			request.setAttribute("info", "两次密码不一致，请重新输入！");

		} else {
			agent = agentservice.getAgentDAO().findById(agent.getUid());
			agent.setPassword(chPassword);
			agentservice.getAgentDAO().merge(agent);
			return "changePasswordSuccess";
		}

		return "changePasswordFailed";

	}

	/**
	 * 获取Agent信息。
	 * 
	 * @return
	 */
	public String getAgentInfo() {
		request.setAttribute("agent", session.getAttribute("agent"));
		return "returnAgentInfo";
	}

	/**
	 * 显示班主任信息。
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
	 * 更改班主任信息。
	 * 
	 * @return
	 */
	public String changeAgentInfo() {
		Agent oldAgent = (Agent) session.getAttribute("agent");
		agent.setUid(session.getAttribute("agentID").toString());

		if (!"".equals(agent.getAname())) {
			if (agentservice.isExistAgent(agent)) {
				request.setAttribute("info", "账户名已存在");
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
	 * 获得银行卡信息。
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
	 * 删除账户。
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
	 * 添加账户。
	 * 
	 * @return
	 */
	public String addAccount() {
		Account account = new Account();
		if (agentservice.getAccountDAO()
				.findByAccount(request.getParameter("account")).size() > 0) {
			getAccountInfo();
			request.setAttribute("info", "账号已存在！");
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
