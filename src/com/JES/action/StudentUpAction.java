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
        String errstudentms="以下学员信息中QQ信息数据库已存在，导致信息录入失败：&#13;&#10;";
        Integer errmsnum=0;
        try{
            FileInputStream fi = new FileInputStream(target); 
            HSSFWorkbook wb = new HSSFWorkbook(fi); 
            HSSFSheet sheet = wb.getSheetAt(0);   
            int rowNum = sheet.getLastRowNum()+1;  
            for(int i=1;i<rowNum;i++){  
                Student student = new Student();
                student.setUid(UUID.randomUUID().toString());
                HSSFRow row = sheet.getRow(i);
                int cellNum = row.getLastCellNum();
                boolean isenabel=true;
                for(int len=0;len<cellNum;len++){  
                	HSSFCell cell = row.getCell((short)len);  
                    String cellValue = cell.getRichStringCellValue().toString() ;      
                    switch(len){//通过列数来判断对应插如的字段   
                        case 0 :
                        	if(agentservice.cheakQq(cellValue)){
                        		errmsnum++;
                        		errstudentms+="<"+errmsnum.toString()+">"+": "+cellValue;
                        		for(int k=1;k<6;k++){
                        			cell = row.getCell((short)k);
                        			errstudentms+=" , "+cell.getRichStringCellValue().toString();
                        		}
                        		errstudentms+="&#13;&#10;";
                        		isenabel=false;
                        		len=cellNum;
                        	}
                        	else student.setQq(cellValue);
                        	break;
                        case 1 : student.setStuid(cellValue);break;
                        case 2 : student.setName(cellValue);break;
                        case 3 : student.setWeixin(cellValue);break;
                        case 4 : student.setPhone(cellValue);break;
                        case 5 : student.setNote(cellValue);break;
                    }
                }   
                	if(isenabel){
                		Date nDate = new Date();
                		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                		String sDate = sdf.format(nDate);
                		student.setMid(mid);
                		student.setIntime(sDate);
                		student.setMark(1);
                		student.setSign("非正式学员");
                		agentservice.updateorsaveStudent(student);
                		agentservice.updateReportAddNewOne(mid);;
                	}
            }  
              
        }catch(IOException e){  
            e.printStackTrace();  
        }
        if(errmsnum!=0)
        	request.setAttribute("studentupms", errstudentms);
        else request.setAttribute("studentupms", "信息录入成功！");
    }
	
	public String download(){
		return "success";
	}
}