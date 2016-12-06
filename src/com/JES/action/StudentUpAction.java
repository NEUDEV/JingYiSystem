package com.JES.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;

import com.JES.model.Agentupstudent;
import com.JES.model.Student;
import com.JES.service.AgentService;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class StudentUpAction extends SuperAction{
	private File[] upstudents;
	private String[] upstudentsContentType;
	private String[] upstudentsFileName;
	private String inputPath;
	private AgentService agentservice;
	//private InputStream inputStream;
	
	
	public AgentService getAgentservice() {
		return agentservice;
	}

	public void setAgentservice(AgentService agentservice) {
		this.agentservice = agentservice;
	}

	public InputStream getInputStream() {
		try {
			return ServletActionContext.getServletContext().getResourceAsStream(inputPath);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public File[] getUpstudents() {
		return upstudents;
	}

	public void setUpstudents(File[] upstudents) {
		this.upstudents = upstudents;
	}

	public String[] getUpstudentsContentType() {
		return upstudentsContentType;
	}

	public void setUpstudentsContentType(String[] upstudentsContentType) {
		this.upstudentsContentType = upstudentsContentType;
	}

	public String[] getUpstudentsFileName() {
		return upstudentsFileName;
	}

	public void setUpstudentsFileName(String[] upstudentsFileName) {
		this.upstudentsFileName = upstudentsFileName;
	}

	public String getInputPath() {
		return inputPath;
	}

	public void setInputPath(String inputPath) {
		this.inputPath = inputPath;
	}
	
	public String upload() throws Exception{ 
		String realpath = ServletActionContext.getServletContext().getRealPath("/students"); 
		File file = new File(realpath); 
		if(!file.exists()) file.mkdirs();
		if(upstudents!=null){
		for(int i=0 ;i<upstudents.length; i++){
			String mid=session.getAttribute("agentID").toString();
			File uploadImage = upstudents[i]; 
			FileUtils.copyFile(uploadImage, new File(file, upstudentsFileName[i]));
			loadstudentsecxel(upstudentsFileName[i],mid);
			}
		return "success"; 
		}
		else {
			request.setAttribute("studentupms", "err:信息录入失败！");
    		return "fail";
		}
		}
	
	@SuppressWarnings("resource")
	public void loadstudentsecxel(String uploadFileFileName,String mid){  
        String targetDirectory = ServletActionContext.getServletContext().getRealPath("/students");  
        File target = new File(targetDirectory,uploadFileFileName);
        String errstudentms="以下学员信息中QQ信息已存在数据库或未审核列表，导致信息录入失败：&#13;&#10;";
        String blockms="以下学员信息中QQ为空，导致信息录入失败：&#13;&#10;";
        String errupstudentms="以下学员信息中QQ信息已存在数据库或未审核列表，导致信息录入失败：&#13;&#10;";
        String errweixinms="以下学员信息中微信号信息数据库已存在，导致信息录入失败：&#13;&#10;";
        String errnamems="以下学员信息中姓名为空，导致信息录入失败：&#13;&#10;";
        Integer errmsnum=0;
        Integer errblocknum=0;
        Integer errupstudentnum=0;
        Integer errweixinnum=0;
        Integer errnamenum=0;
        try{
            FileInputStream fi = new FileInputStream(target); 
            HSSFWorkbook wb = new HSSFWorkbook(fi); 
            HSSFSheet sheet = wb.getSheetAt(0);   
            int rowNum = sheet.getLastRowNum()+1;  
            for(int i=1;i<rowNum;i++){  
            	Agentupstudent student = new Agentupstudent();
                /*student.setUid(UUID.randomUUID().toString());*/
                HSSFRow row = sheet.getRow(i);
                int cellNum = row.getLastCellNum();
                boolean isenabel=true;
                for(int len=0;len<cellNum;len++){  
                	HSSFCell cell = row.getCell((short)len);
                    String cellValue = cheakCellBlock(cell).toString().replaceAll("\\s*", "");     
                    switch(len){//通过列数来判断对应插如的字段   
                        case 0 :
                        	if(cellValue.equals("")){
                        		errblocknum++;
                        		blockms+="<"+errblocknum.toString()+">"+": "+cellValue;
                        		for(int k=1;k<6;k++){
                        			cell = row.getCell((short)k);
                        			blockms+=" , "+cheakCellBlock(cell);
                        		}
                        		blockms+="&#13;&#10;";
                        		isenabel=false;
                        		len=cellNum;
                        	}
                        	else if(agentservice.cheakUpQq(cellValue)){
                        		errupstudentnum++;
                        		errupstudentms+="<"+errupstudentnum.toString()+">"+": "+cellValue;
                        		for(int k=1;k<6;k++){
                        			cell = row.getCell((short)k);
                        			errupstudentms+=" , "+cheakCellBlock(cell);
                        		}
                        		errupstudentms+="&#13;&#10;";
                        		isenabel=false;
                        		len=cellNum;
                        	}
                        	else if(agentservice.cheakQq(cellValue)){
                        		errmsnum++;
                        		errstudentms+="<"+errmsnum.toString()+">"+": "+cellValue;
                        		for(int k=1;k<6;k++){
                        			cell = row.getCell((short)k);
                        			errstudentms+=" , "+cheakCellBlock(cell);
                        		}
                        		errstudentms+="&#13;&#10;";
                        		isenabel=false;
                        		len=cellNum;
                        	}
                        	else student.setQq(cellValue);
                        	break;
                       /* case 1 : student.setStuid(cellValue);break;
                        case 2 : student.setName(cellValue);break;
                        case 3 : student.setWeixin(cellValue);break;
                        case 4 : student.setPhone(cellValue);break;
                        case 5 : student.setNote(cellValue);break;*/
                        case 1 : student.setStuid(cellValue);break;
                        case 2 : 
                        	if(cellValue.equals("")){
                        		errnamenum++;
                        		errnamems+="<"+errnamenum.toString()+">"+": "+cellValue;
                        		for(int k=1;k<6;k++){
                        			cell = row.getCell((short)k);
                        			errnamems+=" , "+cheakCellBlock(cell);
                        		}
                        		errnamems+="&#13;&#10;";
                        		isenabel=false;
                        		len=cellNum;
                        	}
                        	else student.setName(cellValue);
                        	break;
                        case 3 : 
                        	if(!cellValue.equals("")&&agentservice.cheakWeixin(cellValue)){
                    		errweixinnum++;
                    		errweixinms+="<"+errweixinnum.toString()+">"+": "+cellValue;
                    		for(int k=1;k<6;k++){
                    			cell = row.getCell((short)k);
                    			errweixinms+=" , "+cheakCellBlock(cell);
                    		}
                    		/*errweixinms+="&#13;&#10;";*/
                    		isenabel=false;
                    		len=cellNum;
                        	}
                        	else student.setWeixin(cellValue);
                        	break;
                        case 4 : student.setPhone(cellValue);break;
                        case 5 : student.setNote(cellValue);break;
                    }
                }   
                	if(isenabel){
                		/*Date nDate = new Date();
                		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                		String sDate = sdf.format(nDate);*/
                		student.setMid(mid);
                		agentservice.savaupstudent(student);
                		/*student.setIntime(sDate);
                		student.setMark(1);
                		student.setSign("非正式学员");
                		agentservice.updateorsaveStudent(student);
                		agentservice.updateReportAddNewOne(mid);;*/
                	}
            }  
              
        }catch(IOException e){  
            e.printStackTrace();  
        }
        if((errmsnum+errblocknum+errweixinnum)>0){
        	String errms="";
        	if(errblocknum!=0) errms+=blockms+"&#13;&#10;";
        	if(errmsnum!=0) errms+=errstudentms+"&#13;&#10;";
        	if(errupstudentnum!=0) errms+=errupstudentms+"&#13;&#10;";
        	if(errnamenum!=0) errms+=errnamems+"&#13;&#10;";
        	if(errweixinnum!=0) errms+=errweixinms+"&#13;&#10;";
        	request.setAttribute("studentupms", errms);
        }
        else request.setAttribute("studentupms", "信息录入成功！");
    }
	
	public String download(){
		return "success";
	}
	
	public String cheakCellBlock(HSSFCell cell){
		if(cell==null) return "";
		switch (cell.getCellType()) {
	    case HSSFCell.CELL_TYPE_STRING:
	        return cell.getRichStringCellValue().getString();
	    case HSSFCell.CELL_TYPE_NUMERIC:
	    	java.text.NumberFormat nf = java.text.NumberFormat.getInstance();   
	    	nf.setGroupingUsed(false);
	        return nf.format(cell.getNumericCellValue()).toString();
	    default:
	        return "";
	    }
		/*else return cell.getRichStringCellValue().toString();*/
	}
}