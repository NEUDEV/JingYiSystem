package com.JES.model;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */

public class Studentmasage implements java.io.Serializable {

	// Fields

	private String uid;
	private String msign;
	private String name;
	private String phone;
	private String qq;
	private String weixin;
	private String mid;
	private String sign;
	private String stuid;
	private String sfrom;
	private Integer mark;
	private String intime;
	private String note;
	private String subtime;
	// Constructors

	/** default constructor */
	public Studentmasage() {
	}

	/** minimal constructor */
	public Studentmasage(String uid) {
		this.uid = uid;
	}

	/** full constructor */
	public Studentmasage(String uid, String msign, String name, String phone,
			String qq, String weixin, String mid, String sign, String stuid,
			String sfrom, Integer mark, String intime, String note) {
		this.uid = uid;
		this.msign = msign;
		this.name = name;
		this.phone = phone;
		this.qq = qq;
		this.weixin = weixin;
		this.mid = mid;
		this.sign = sign;
		this.stuid = stuid;
		this.sfrom = sfrom;
		this.mark = mark;
		this.intime = intime;
		this.note = note;
	}

	// Property accessors
	public Studentmasage(Student stu){
		this.intime=stu.getIntime();
		this.mark=stu.getMark();
		this.mid=stu.getMid();
		this.msign=stu.getMsign();
		this.name=stu.getName();
		this.note=stu.getNote();
		this.phone=stu.getPhone();
		this.qq=stu.getQq();
		this.sfrom=stu.getSfrom();
		this.sign=stu.getSign();
		this.stuid=stu.getStuid();
		this.uid=stu.getUid();
		this.weixin=stu.getWeixin();
	}
	public String getUid() {
		return this.uid;
	}

	public String getSubtime() {
		return subtime;
	}

	public void setSubtime(String subtime) {
		this.subtime = subtime;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getMsign() {
		return this.msign;
	}

	public void setMsign(String msign) {
		this.msign = msign;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getQq() {
		return this.qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getWeixin() {
		return this.weixin;
	}

	public void setWeixin(String weixin) {
		this.weixin = weixin;
	}

	public String getMid() {
		return this.mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getSign() {
		return this.sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getStuid() {
		return this.stuid;
	}

	public void setStuid(String stuid) {
		this.stuid = stuid;
	}

	public String getSfrom() {
		return this.sfrom;
	}

	public void setSfrom(String sfrom) {
		this.sfrom = sfrom;
	}

	public Integer getMark() {
		return this.mark;
	}

	public void setMark(Integer mark) {
		this.mark = mark;
	}

	public String getIntime() {
		return this.intime;
	}

	public void setIntime(String intime) {
		this.intime = intime;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}