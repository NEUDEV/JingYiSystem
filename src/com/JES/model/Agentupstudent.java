package com.JES.model;

/**
 * Agentupstudent entity. @author MyEclipse Persistence Tools
 */

public class Agentupstudent implements java.io.Serializable {

	// Fields

	private String qq;
	private String name;
	private String weixin;
	private String phone;
	private String class_;
	private byte[] photo;

	// Constructors

	/** default constructor */
	public Agentupstudent() {
	}

	/** minimal constructor */
	public Agentupstudent(String qq) {
		this.qq = qq;
	}

	/** full constructor */
	public Agentupstudent(String qq, String name, String weixin, String phone,
			String class_, byte[] photo) {
		this.qq = qq;
		this.name = name;
		this.weixin = weixin;
		this.phone = phone;
		this.class_ = class_;
		this.photo = photo;
	}

	// Property accessors

	public String getQq() {
		return this.qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWeixin() {
		return this.weixin;
	}

	public void setWeixin(String weixin) {
		this.weixin = weixin;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getClass_() {
		return this.class_;
	}

	public void setClass_(String class_) {
		this.class_ = class_;
	}

	public byte[] getPhoto() {
		return this.photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

}