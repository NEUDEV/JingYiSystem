package com.JES.model;

public class ReportShowItem {
	private String Aname;
	private String Aqq;
	private String Aphone;
	private String Mid;
	private Integer informalstu;
	private Integer platestu;
	private Integer typefacestu;
	private Integer brandstu;
	private Integer fullstu;
	private Integer illustration;
	private Integer onlinestu;
	private Integer lifetimestu;
	private Double transrate;
	private String role;
	private Integer allinnum;
	private Double allbills;
	
	public void setReportShowITEM(Report report,Agent agent){
		this.allbills=report.getAllbills();
		this.allinnum=report.getAllinnum();
		this.brandstu=report.getBrandstu();
		this.fullstu=report.getFullstu();
		this.illustration=report.getIllustration();
		this.informalstu=report.getInformalstu();
		this.lifetimestu=report.getLifetimestu();
		this.onlinestu=report.getOnlinestu();
		this.platestu=report.getPlatestu();
		this.transrate=report.getTransrate();
		this.typefacestu=report.getTypefacestu();
		this.Aname=agent.getName();
		this.Aphone=agent.getPhone();
		this.Aqq=agent.getQq();
		this.Mid=agent.getUid();
	}
	
	public String getMid() {
		return Mid;
	}

	public void setMid(String mid) {
		Mid = mid;
	}

	public String getAname() {
		return Aname;
	}
	public void setAname(String aname) {
		Aname = aname;
	}
	public String getAqq() {
		return Aqq;
	}
	public void setAqq(String aqq) {
		Aqq = aqq;
	}
	public String getAphone() {
		return Aphone;
	}
	public void setAphone(String aphone) {
		Aphone = aphone;
	}
	public Integer getInformalstu() {
		return informalstu;
	}
	public void setInformalstu(Integer informalstu) {
		this.informalstu = informalstu;
	}
	public Integer getPlatestu() {
		return platestu;
	}
	public void setPlatestu(Integer platestu) {
		this.platestu = platestu;
	}
	public Integer getTypefacestu() {
		return typefacestu;
	}
	public void setTypefacestu(Integer typefacestu) {
		this.typefacestu = typefacestu;
	}
	public Integer getBrandstu() {
		return brandstu;
	}
	public void setBrandstu(Integer brandstu) {
		this.brandstu = brandstu;
	}
	public Integer getFullstu() {
		return fullstu;
	}
	public void setFullstu(Integer fullstu) {
		this.fullstu = fullstu;
	}
	public Integer getIllustration() {
		return illustration;
	}
	public void setIllustration(Integer illustration) {
		this.illustration = illustration;
	}
	public Integer getOnlinestu() {
		return onlinestu;
	}
	public void setOnlinestu(Integer onlinestu) {
		this.onlinestu = onlinestu;
	}
	public Integer getLifetimestu() {
		return lifetimestu;
	}
	public void setLifetimestu(Integer lifetimestu) {
		this.lifetimestu = lifetimestu;
	}
	public Double getTransrate() {
		return transrate;
	}
	public void setTransrate(Double transrate) {
		this.transrate = transrate;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Integer getAllinnum() {
		return allinnum;
	}
	public void setAllinnum(Integer allinnum) {
		this.allinnum = allinnum;
	}
	public Double getAllbills() {
		return allbills;
	}
	public void setAllbills(Double allbills) {
		this.allbills = allbills;
	}
	
}
