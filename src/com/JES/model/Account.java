package com.JES.model;

/**
 * Account entity. @author MyEclipse Persistence Tools
 */

public class Account implements java.io.Serializable {

	// Fields

	private String bid;
	private String bank;
	private String account;
	private String agent;

	// Constructors

	/** default constructor */
	public Account() {
	}

	/** full constructor */
	public Account(String bid, String bank, String account) {
		this.bid = bid;
		this.bank = bank;
		this.account = account;
	}

	// Property accessors

	public String getBid() {
		return this.bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	public String getBank() {
		return this.bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getAccount() {
		return this.account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getAgent() {
		return agent;
	}

	public void setAgent(String agent) {
		this.agent = agent;
	}
	
	

}