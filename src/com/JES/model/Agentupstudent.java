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
	private String stuid;
	private byte[] photo;
	private String note;
	private String mid;
	private String sfrom;

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
			String stuid, byte[] photo, String note, String mid,String sfrom) {
		this.qq = qq;
		this.name = name;
		this.weixin = weixin;
		this.phone = phone;
		this.stuid = stuid;
		this.photo = photo;
		this.note = note;
		this.mid = mid;
		this.sfrom=sfrom;
	}

	// Property accessors
	
	public String getQq() {
		return this.qq;
	}

	public String getSfrom() {
		return sfrom;
	}

	public void setSfrom(String sfrom) {
		this.sfrom = sfrom;
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

	public String getStuid() {
		return this.stuid;
	}

	public void setStuid(String stuid) {
		this.stuid = stuid;
	}

	public byte[] getPhoto() {
		return this.photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getMid() {
		return this.mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

}