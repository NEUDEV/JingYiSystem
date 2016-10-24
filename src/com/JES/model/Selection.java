package com.JES.model;



/**
 * Selection entity. @author MyEclipse Persistence Tools
 */

public class Selection  implements java.io.Serializable {


    // Fields    

     private String id;
     private String uid;
     private String cname;
     private Integer bill;
     private String selecttime;


    // Constructors

    /** default constructor */
    public Selection() {
    }

	/** minimal constructor */
    public Selection(String id) {
        this.id = id;
    }
    
    /** full constructor */
    public Selection(String id, String uid, String cname, Integer bill, String selecttime) {
        this.id = id;
        this.uid = uid;
        this.cname = cname;
        this.bill = bill;
        this.selecttime = selecttime;
    }

   
    // Property accessors

    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    public String getUid() {
        return this.uid;
    }
    
    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getCname() {
        return this.cname;
    }
    
    public void setCname(String cname) {
        this.cname = cname;
    }

    public Integer getBill() {
        return this.bill;
    }
    
    public void setBill(Integer bill) {
        this.bill = bill;
    }

    public String getSelecttime() {
        return this.selecttime;
    }
    
    public void setSelecttime(String selecttime) {
        this.selecttime = selecttime;
    }
   








}