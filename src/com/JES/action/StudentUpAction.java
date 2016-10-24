package com.JES.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts2.ServletActionContext;

import com.JES.model.Student;
import com.JES.service.AgentService;
import com.opensymphony.xwork2.ActionSupport;

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
			File uploadImage = upstudents[i]; 
			FileUtils.copyFile(uploadImage, new File(file, upstudentsFileName[i]));
			loadstudentsecxel(upstudentsFileName[i]);
			}
		return "success"; 
		}
		else {
    		return "fail";
		}
		}
	
	public void loadstudentsecxel(String uploadFileFileName){  
        String targetDirectory = ServletActionContext.getServletContext().getRealPath("/students");  
        File target = new File(targetDirectory,uploadFileFileName);
        String errstudentms="以下学员信息中QQ信息数据库已存在，导致信息录入失败：&#13;&#10;";
        Integer errmsnum=0;
        try{  
            FileInputStream fi = new FileInputStream(target);  
            Workbook wb =(Workbook) new HSSFWorkbook(fi);  
            Sheet sheet = wb.getSheetAt(0);    
            int rowNum = sheet.getLastRowNum()+1;  
            for(int i=1;i<rowNum;i++){  
                Student student = new Student();
                student.setUid(UUID.randomUUID().toString());
                Row row = sheet.getRow(i);
                int cellNum = row.getLastCellNum();
                boolean isenabel=true;
                for(int j=0;j<cellNum;j++){  
                    Cell cell = row.getCell(j);  
                    String cellValue = cell.getStringCellValue() ;      
                    switch(j){//通过列数来判断对应插如的字段   
                        case 0 : 
                        	if(agentservice.cheakQq(cellValue)){
                        		errmsnum++;
                        		errstudentms+=errmsnum.toString()+": "+cellValue;
                        		for(int k=1;k<4;k++){
                        			cell = row.getCell(k);
                        			errstudentms+=" , "+cell.getStringCellValue();
                        		}
                        		errstudentms+="&#13;&#10;";
                        		isenabel=false;
                        		j=Integer.MAX_VALUE;
                        	}
                        	else student.setQq(cellValue);
                        	break;  
                        case 1 : student.setName(cellValue);break;
                        case 2 : student.setWeixin(cellValue);break;
                        case 3 : student.setPhone(cellValue);break;
                        case 4 : student.setNote(cellValue);break;
                    }
                }   
                	if(isenabel)
                		agentservice.updateorsaveStudent(student);
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