package com.JES.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFHeader;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;

import com.JES.dao.AccountDAO;
import com.JES.dao.AgentDAO;
import com.JES.dao.AgentupstudentDAO;
import com.JES.dao.CourseDAO;
import com.JES.dao.ReportDAO;
import com.JES.dao.SelectionDAO;
import com.JES.dao.StudentDAO;
import com.JES.model.Agent;
import com.JES.model.Agentupstudent;
import com.JES.model.Course;
import com.JES.model.Manager;
import com.JES.model.Report;
import com.JES.model.ReportShowItem;
import com.JES.model.Selection;
import com.JES.model.Student;

public class AgentService {
	private AgentDAO agentDAO;
	private AgentupstudentDAO agentupstudentDAO;
	private StudentDAO studentDAO;
	private AccountDAO accountDAO;
	private CourseDAO courseDAO;
	private SelectionDAO selectionDAO;
	private ReportDAO reportDAO;
	
	public ReportDAO getReportDAO() {
		return reportDAO;
	}

	public void setReportDAO(ReportDAO reportDAO) {
		this.reportDAO = reportDAO;
	}

	public SelectionDAO getSelectionDAO() {
		return selectionDAO;
	}

	public void setSelectionDAO(SelectionDAO selectionDAO) {
		this.selectionDAO = selectionDAO;
	}

	public CourseDAO getCourseDAO() {
		return courseDAO;
	}

	public void setCourseDAO(CourseDAO courseDAO) {
		this.courseDAO = courseDAO;
	}


	public AgentDAO getAgentDAO() {
		return agentDAO;
	}

	public void setAgentDAO(AgentDAO agentDAO) {
		this.agentDAO = agentDAO;
	}

	public AgentupstudentDAO getAgentupstudentDAO() {
		return agentupstudentDAO;
	}

	public void setAgentupstudentDAO(AgentupstudentDAO agentupstudentDAO) {
		this.agentupstudentDAO = agentupstudentDAO;
	}

	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	public AccountDAO getAccountDAO() {
		return accountDAO;
	}

	public void setAccountDAO(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}
	
	
	public void changemark(String uid,Integer mark){
		Student stu=new Student();
		stu=studentDAO.findById(uid);
		stu.setMark(mark);
		studentDAO.merge(stu);
	}

	/**
	 * ����ѧԱ
	 * @param type  
	 * @param value
	 * @param mid
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Student> searchStudents(String type, String value,String mid,Integer chose) {
		if(chose.equals(3)) return (List<Student>) studentDAO.findByMidMarkdesc(mid);
		if(value.equals("")||value==null){
			if(chose.equals(2)) return (List<Student>) studentDAO.findByMidMarkdesc(mid);
			return (List<Student>) studentDAO.findByMiddesc(mid);
		}
		switch (type) {
		case "��ʵ����":
			if(chose.equals(2)) return (List<Student>) studentDAO.findByNameWithMidMark(value,mid);
			return (List<Student>) studentDAO.findByNameWithMid(value,mid);
		case "�ֻ���":
			if(chose.equals(2)) return (List<Student>) studentDAO.findByPhoneWithMidMark(value,mid);
			return (List<Student>) studentDAO.findByPhoneWithMid(value,mid);
		case "QQ":
			if(chose.equals(2)) return (List<Student>) studentDAO.findByQqWithMidMark(value,mid);
			return (List<Student>) studentDAO.findByQqWithMid(value,mid);
		case "ѧ��":
			if(chose.equals(2)) return (List<Student>) studentDAO.findByStuidWithMidMark(value,mid);
			return (List<Student>) studentDAO.findByStuidWithMid(value,mid);
		case "΢��":
			if(chose.equals(2)) return (List<Student>) studentDAO.findByWeixinWithMidMark(value,mid);
			return (List<Student>) studentDAO.findByWeixinWithMid(value,mid);
		}
		return null;
	}
	
	
	/**
	 * ��ѯ�¼�������
	 * @param type
	 * @param value
	 * @param mannager����������ID
	 * @return
	 */
	public List<Agent> searchAgents(String type, String value,String mannager){
		if(value.equals("")||value==null) 
			return (List<Agent>) agentDAO.findByMannager(mannager);
		switch (type) {
		case "����������":
			return (List<Agent>) agentDAO.findByNameWithMannager(value,mannager);
		case "�������ֻ���":
			return (List<Agent>) agentDAO.findByPhoneWithMannager(value,mannager);
		case "������QQ":
			return (List<Agent>) agentDAO.findByQqWithMannager(value,mannager);
		}
		return null;
	}
	
	/*public List<Student> showAllStudents(){
		return (List<Student>) studentDAO.findAll();
	}
*/
	
	public boolean addStudent(Student student) {
		Student stu = studentDAO.findById(student.getUid());
		if (stu == null) {
			studentDAO.save(student);
			return true;
		} else
			return false;
	}
	
	
	/**
	 * ¼����ѧԱ
	 * @param input
	 * @param length
	 * @param upstudent
	 * @param student
	 * @param mid
	 * @return
	 */
	public boolean upNowStudent(FileInputStream input,Integer length,
			Agentupstudent upstudent,String mid){
		/*Report report=new Report();*/
		byte[] bFile = new byte[length];
		try {
			input.read(bFile);
			input.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date intime = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String sDate = sdf.format(intime);
		/*student.setIntime(sDate);
		student.setMark(1);   //����ת��ָ��
		student.setMid(mid); //���ô�����ID
		student.setMsign("");
		student.setSfrom("");
		student.setSign("����ʽѧԱ");*/
		upstudent.setPhoto(bFile);
		agentupstudentDAO.save(upstudent);
		/*studentDAO.save(student);*/
		/*report=reportDAO.findById(agentDAO.findById(mid).getReportId());
		report.setInformalstu(report.getInformalstu()+1);
		reportDAO.merge(report);*/
		/*updateReportAddNewOne(mid);*/
		return true;
	}
	
	
	public void savaupstudent(Agentupstudent upstudent){
		agentupstudentDAO.save(upstudent);
	}
	
	/**
	 * ���ѧԱ���±���
	 * @param mid
	 */
	public void updateReportAddNewOne(String mid){
		Report report=new Report(0);
		report=reportDAO.findById(agentDAO.findById(mid).getReportId());
		report.setInformalstu(report.getInformalstu()+1);
		report.setTransrate(Double.parseDouble(report.getAllinnum().toString())/(report.getInformalstu()+report.getAllinnum()));
		reportDAO.merge(report);
	}

	
	/**
	 * ��ȡѧԱ��Ϣ��ͼ
	 * @param qq
	 */
	public void shoeView(String qq) {
		HttpServletResponse response = null;
		ServletOutputStream out = null;
		Agentupstudent agentupstudent = new Agentupstudent();
		try {
			response = ServletActionContext.getResponse();
			response.setContentType("multipart/form-data");
			out = response.getOutputStream();
			agentupstudent = agentupstudentDAO.findById(qq);
			out.write(agentupstudent.getPhoto()); // �������Լ���ͼƬbyte[] ���ݾ���.
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	public boolean isLoginSuccess(Agent agent) {
		List resultList = agentDAO.findByAname(agent.getAname());

		if (resultList.size() != 0) {
			Agent result = (Agent) resultList.get(0);

			if (agent.getAname().equals(result.getAname())
					&& agent.getPassword().equals(result.getPassword())) {
				return true;
			}
		}

		return false;
	}

	public boolean isExistAgent(Agent agent) {
		List results = agentDAO.findByAname(agent.getAname());

		if (results.size() != 0) {

			Agent a = (Agent) results.get(0);
			if (agent.getUid().equals(a.getUid())) {
				return false;
			}

			return true;
		}

		return false;
	}
	
	/**
	 * ������ݿ��Ƿ���ڸ�QQ
	 * @param qq
	 * @return
	 */
	public boolean cheakQq(String qq){
		List<Student> student =studentDAO.findByQq(qq);
		Agentupstudent astu=agentupstudentDAO.findById(qq);
		if(student.size()!=0||astu!=null)
			return true;
		else return false;
	}
	
	public boolean cheakWeixin(String weixin){
		List<Student> student =studentDAO.findByWeixin(weixin);
		if(student.size()!=0)
			return true;
		else return false;
	}
	
	public boolean cheakUpWeixin(String weixin){
		List<Agentupstudent> astu=agentupstudentDAO.findByWeixin(weixin);
		if(astu.size()!=0)
			return true;
		else return false;
	}
	
	public boolean cheakUpQq(String qq){
		Agentupstudent student =agentupstudentDAO.findById(qq);
		if(student==null)
			return false;
		else return true;
	}
	
	/**
	 * �������μ���
	 * @param mid
	 * @return
	 */
	public boolean cheackPower(String mid){
		if(agentDAO.findById(mid).getRole().equals("����������"))
			return true;
		else return false;
	}
	
	/**
	 * ����ѧԱ��Ϣ
	 */
	public void updateorsaveStudent(Student student){
		studentDAO.merge(student);
	}
	
	/**
	 * ���пγ�
	 * @return
	 */
	public List<Course> allcourse(){
		return (List<Course>)courseDAO.findAll();
	}
	
	/**
	 * ���������λ�ȡ��ҵ��
	 * @param mid
	 * @return
	 */
	public List<Report> allreport(String mid){
		List<Report> reportList=new ArrayList<Report>();
		Report report=new Report(0);
		report=reportDAO.findById(agentDAO.findById(mid).getReportId());
		reportList.addAll(reportDAO.findreportbymid(mid));
		for(int i=0;i<reportList.size();i++){
			report.setInformalstu(report.getInformalstu()+reportList.get(i).getInformalstu());
			report.setPlatestu(report.getPlatestu()+reportList.get(i).getPlatestu());
			report.setTypefacestu(report.getTypefacestu()+reportList.get(i).getTypefacestu());
			report.setBrandstu(report.getBrandstu()+reportList.get(i).getBrandstu());
			report.setFullstu(report.getFullstu()+reportList.get(i).getFullstu());
			report.setIllustration(report.getIllustration()+reportList.get(i).getIllustration());
			report.setOnlinestu(report.getOnlinestu()+reportList.get(i).getOnlinestu());
			report.setLifetimestu(report.getLifetimestu()+reportList.get(i).getLifetimestu());
			report.setAllinnum(report.getAllinnum()+reportList.get(i).getAllinnum());
			report.setAllbills(report.getAllbills()+reportList.get(i).getAllbills());
		}
		report.setTransrate(Double.parseDouble(report.getAllinnum().toString())/(report.getInformalstu()+report.getAllinnum()));
		reportList.clear();
		reportList.add(report);
		return reportList;
	}
	
	/**
	 * �ᵥ
	 * @param uid
	 * @param phone
	 * @param weixin
	 * @param sign
	 * @param bill
	 * @param mark
	 * @param class_
	 * @param mid
	 * @return
	 */
	public boolean billUp(String uid,String phone,String weixin,String sign,Integer bill,Integer mark,String class_,String mid){
		Student student=(Student)studentDAO.findById(uid);
		Selection selection=new Selection();
		Date nDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sDate = sdf.format(nDate);
		String id=UUID.randomUUID().toString();
		student.setPhone(phone);
		student.setMark(mark);
		student.setSign(sign);
		student.setWeixin(weixin);
		studentDAO.merge(student);
		selection.setUid(student.getUid());
		selection.setBill(bill);
		selection.setSelecttime(sDate);
		selection.setCname(class_);
		selection.setId(id);
		selectionDAO.save(selection);
		
		Report report=new Report(0);
		report=reportDAO.findById(agentDAO.findById(mid).getReportId());
		switch (class_) {
		case "��ʽѧԱ":
			report.setPlatestu(report.getPlatestu()+1);
			break;
		case "����ѧԱ":
			report.setTypefacestu(report.getTypefacestu()+1);
			break;
		case "Ʒ��ѧԱ":
			report.setBrandstu(report.getBrandstu()+1);
			break;
		case "ȫ�ư�ѧԱ":
			report.setFullstu(report.getFullstu()+1);
			break;
		case "�廭ѧԱ":
			report.setIllustration(report.getIllustration()+1);
			break;
		case "����ѧԱ":
			report.setOnlinestu(report.getOnlinestu()+1);
			break;
		case "����ѧԱ":
			report.setLifetimestu(report.getLifetimestu()+1);
			break;
		default:
			break;
		}
		report.setAllbills(report.getAllbills()+bill);
		report.setInformalstu(report.getInformalstu()-1);
		report.setAllinnum(report.getAllinnum()+1);
		report.setTransrate(Double.parseDouble(report.getAllinnum().toString())/(report.getInformalstu()+report.getAllinnum()));
		reportDAO.merge(report);
		return true;
	}
	
	/**
	 * ��ȡ�����α���
	 * @param type
	 * @param value
	 * @param mid
	 * @return
	 */
	public List<ReportShowItem> MyCpReports(String type,String value,String mid){
		List<Agent> agentList=new ArrayList<Agent>();
		List<ReportShowItem> rItemList=new ArrayList<ReportShowItem>();
		Integer len;
		if(value.equals("")||value==null) {
			agentList.addAll((List<Agent>)agentDAO.findByMannager(mid));
			len=agentList.size();
			for(int i=0;i<len;i++){
				ReportShowItem rItem=new ReportShowItem();
				rItem.setReportShowITEM(reportDAO.findById(agentList.get(i).getReportId()),agentList.get(i));
				rItemList.add(rItem);
			}
			return rItemList;
		}
		else switch (type) {
		case "����������":
			agentList.addAll((List<Agent>)agentDAO.findReportByName(value, mid));
			len=agentList.size();
			for(int i=0;i<len;i++){
				ReportShowItem rItem=new ReportShowItem();
				rItem.setReportShowITEM(reportDAO.findById(agentList.get(i).getReportId()),agentList.get(i));
				rItemList.add(rItem);
			}
			return rItemList;
		case "������QQ":
			agentList.addAll((List<Agent>)agentDAO.findReportByQq(value, mid));
			len=agentList.size();
			for(int i=0;i<len;i++){
				ReportShowItem rItem=new ReportShowItem();
				rItem.setReportShowITEM(reportDAO.findById(agentList.get(i).getReportId()),agentList.get(i));
				rItemList.add(rItem);
			}
			return rItemList;
		case "�������ֻ���":
			agentList.addAll((List<Agent>)agentDAO.findReportByPhone(value, mid));
			len=agentList.size();
			for(int i=0;i<len;i++){
				ReportShowItem rItem=new ReportShowItem();
				rItem.setReportShowITEM(reportDAO.findById(agentList.get(i).getReportId()),agentList.get(i));
				rItemList.add(rItem);
			}
			return rItemList;
		}
		return null;
	}
	
	/**
	 * ����Ա�鿴�����α���
	 * @param type
	 * @param value
	 * @return
	 */
	public List<ReportShowItem> managerLookReports(String type,String value){
		List<Agent> agentList=new ArrayList<Agent>();
		List<ReportShowItem> rItemList=new ArrayList<ReportShowItem>();
		Integer len;
		if(value.equals("")||value==null){
			agentList.addAll((List<Agent>)agentDAO.findAll());
			len=agentList.size();
			for(int i=0;i<len;i++){
				ReportShowItem rItem=new ReportShowItem();
				rItem.setReportShowITEM(reportDAO.findById(agentList.get(i).getReportId()),agentList.get(i));
				rItemList.add(rItem);
			}
			return rItemList;
		}
		else switch (type) {
		case "����������":
			agentList.addAll((List<Agent>)agentDAO.findByName(value));
			len=agentList.size();
			for(int i=0;i<len;i++){
				ReportShowItem rItem=new ReportShowItem();
				rItem.setReportShowITEM(reportDAO.findById(agentList.get(i).getReportId()),agentList.get(i));
				rItemList.add(rItem);
			}
			return rItemList;
		case "������QQ":
			agentList.addAll((List<Agent>)agentDAO.findByQq(value));
			len=agentList.size();
			for(int i=0;i<len;i++){
				ReportShowItem rItem=new ReportShowItem();
				rItem.setReportShowITEM(reportDAO.findById(agentList.get(i).getReportId()),agentList.get(i));
				rItemList.add(rItem);
			}
			return rItemList;
		case "�������ֻ���":
			agentList.addAll((List<Agent>)agentDAO.findByPhone(value));
			len=agentList.size();
			for(int i=0;i<len;i++){
				ReportShowItem rItem=new ReportShowItem();
				rItem.setReportShowITEM(reportDAO.findById(agentList.get(i).getReportId()),agentList.get(i));
				rItemList.add(rItem);
			}
			return rItemList;
		}
		return null;
	}
	
	/**
	 * ��ʱ���ѯ�ҵ�ҵ��
	 * @param selecttype
	 * @param mid
	 * @return
	 */
	public List<Report> MyReports(String selecttype,String mid){
		List<Report> reportList=new ArrayList<Report>();
		switch (selecttype) {
		case "ȫ��":
			reportList.add(reportDAO.findById(agentDAO.findById(mid).getReportId()));
			return reportList;
		case "��ҵ��":
			return FindByTime(0,mid,"","");
		case "��ҵ��":
			return FindByTime(1,mid,"","");
		}
		return null;
	}
	
	/**
	 * ��ʱ���ѯ����
	 * @param subday
	 * @param mid
	 * @param sTime
	 * @param eTime
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Report> FindByTime(Integer subday,String mid,String sTime,String eTime){
		List<Report> reportList=new ArrayList<Report>();
		Report report=new Report(0);
		SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date beginDate = new Date();
		Calendar date = Calendar.getInstance();
		date.setTime(beginDate);
		String stime="",etime="";
		if(subday.equals(0)){
			date.set(Calendar.DATE, date.get(Calendar.DATE) - 7);
			stime=dft.format(date.getTime());
			etime=dft.format(beginDate);
		}
		else if(subday.equals(1)){
			date.add(Calendar.MONTH, -1);
			stime=dft.format(date.getTime());
			etime=dft.format(beginDate);
		}
		else if(subday.equals(2)){
			stime=sTime;
			etime=eTime;
		}
		List<Object> cList=new ArrayList<Object>();
		cList.addAll(selectionDAO.countclasstype(mid, stime,etime));
		report.setInformalstu(studentDAO.countunifStudentbyTime(mid, stime,etime));
		for(int i=0;i<cList.size();i++){
			Object[] obj=(Object[])cList.get(i);
			Integer num=Integer.parseInt(String.valueOf(obj[1]));
			switch (obj[0].toString()) {
			case "��ʽѧԱ":
				report.setPlatestu(report.getPlatestu()+num);
				report.setAllinnum(report.getAllinnum()+num);
				break;
			case "����ѧԱ":
				report.setTypefacestu(report.getTypefacestu()+num);
				report.setAllinnum(report.getAllinnum()+num);
				break;
			case "Ʒ��ѧԱ":
				report.setBrandstu(report.getBrandstu()+num);
				report.setAllinnum(report.getAllinnum()+num);
				break;
			case "ȫ�ư�ѧԱ":
				report.setFullstu(report.getFullstu()+num);
				report.setAllinnum(report.getAllinnum()+num);
				break;
			case "�廭ѧԱ":
				report.setIllustration(report.getIllustration()+num);
				report.setAllinnum(report.getAllinnum()+num);
				break;
			case "����ѧԱ":
				report.setOnlinestu(report.getOnlinestu()+num);
				report.setAllinnum(report.getAllinnum()+num);
				break;
			case "����ѧԱ":
				report.setLifetimestu(report.getLifetimestu()+num);
				report.setAllinnum(report.getAllinnum()+num);
				break;
			default:
				break;
			}
			//System.out.println(obj[0].toString()+Integer.parseInt(String.valueOf(obj[1])));
		}
		report.setAllbills(Double.parseDouble((selectionDAO.sumbills(mid, stime,etime).toString())));
		if((report.getInformalstu()+report.getAllinnum())!=0)
			report.setTransrate(Double.parseDouble(report.getAllinnum().toString())/(report.getInformalstu()+report.getAllinnum()));
		else report.setTransrate(0.0);
		reportList.add(report);
		return reportList;
	}
	
	/**
	 * ����ѧԱ
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public String studentmsout() throws Exception {
		List<Student> studentList = new ArrayList<Student>();
		studentList = studentDAO.findAll();

		/*
		 * ���ñ�ͷ����Excelÿ��ȡ��(���������ȡ�����ݱ�д)
		 */
		String[] tableHeader = { "UID", "ѧ��", "����", "�ֻ���", "QQ", "΢��", "��Դ",
				"״̬", "¼��ʱ��", "ѧԱת��ָ��" };
		/*
		 * ����Ķ����Կ������ñ�д
		 */
		short cellNumber = (short) tableHeader.length;// �������
		HSSFWorkbook workbook = new HSSFWorkbook(); // ����һ��excel
		HSSFCell cell = null; // Excel����
		HSSFRow row = null; // Excel����
		HSSFCellStyle style = workbook.createCellStyle(); // ���ñ�ͷ������
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		HSSFCellStyle style1 = workbook.createCellStyle(); // ������������
		style1.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		HSSFFont font = workbook.createFont(); // ��������
		HSSFSheet sheet = workbook.createSheet("sheet1"); // ����һ��sheet
		HSSFHeader header = sheet.getHeader();// ����sheet��ͷ
		try {
			/**
			 * �����Ƿ�ȡ�����ݣ�����header��Ϣ
			 *
			 */
			if (studentList.size() < 1) {
				header.setCenter("��ѧԱ��Ϣ");
			} else {
				header.setCenter("�ҵ�ѧԱ��Ϣ");
				row = sheet.createRow(0);
				row.setHeight((short) 400);
				for (int k = 0; k < cellNumber; k++) {
					cell = row.createCell((short) k);// ������0�е�k��
					cell.setCellValue(new HSSFRichTextString(tableHeader[k]));// ���õ�0�е�k�е�ֵ
					sheet.setColumnWidth((short) k, (short) 8000);// �����еĿ��
					font.setColor(HSSFFont.COLOR_NORMAL); // ���õ�Ԫ���������ɫ.
					font.setFontHeight((short) 350); // ���õ�Ԫ����߶�
					style1.setFont(font);// ����������
					cell.setCellStyle(style1);
				}
				/*
				 * // ��excel�������������Ҫ��д
				 */
				for (int i = 0; i < studentList.size(); i++) {
					Student student = (Student) studentList.get(i);// ��ȡstudent����
					row = sheet.createRow((short) (i + 1));// ������i+1��
					row.setHeight((short) 400);// �����и�

					if (student.getUid() != null) {
						cell = row.createCell((short) 0);// ������i+1�е�0��
						cell.setCellValue(new HSSFRichTextString(student
								.getUid()));// ���õ�i+1�е�0�е�ֵ
						cell.setCellStyle(style);// ���÷��
					}
					if (student.getStuid() != null) {
						cell = row.createCell((short) 1); // ������i+1�е�1��

						cell.setCellValue(new HSSFRichTextString(student
								.getStuid()));// ���õ�i+1�е�1�е�ֵ

						cell.setCellStyle(style); // ���÷��
					}
					// ��������ĺ�����Ļ�����ͬ���Ͳ���ע����
					if (student.getName() != null) {
						cell = row.createCell((short) 2);
						cell.setCellValue(new HSSFRichTextString(student
								.getName()));
						cell.setCellStyle(style);
					}
					if (student.getPhone() != null) {
						cell = row.createCell((short) 3);
						cell.setCellValue(new HSSFRichTextString(student
								.getPhone()));
						cell.setCellStyle(style);
					}
					if (student.getQq() != null) {
						cell = row.createCell((short) 4);
						cell.setCellValue(new HSSFRichTextString(student
								.getQq()));
						cell.setCellStyle(style);
					}
					if (student.getWeixin() != null) {
						cell = row.createCell((short) 5);
						cell.setCellValue(new HSSFRichTextString(student
								.getWeixin()));
						cell.setCellStyle(style);
					}
					if (student.getSfrom() != null) {
						cell = row.createCell((short) 6);
						cell.setCellValue(new HSSFRichTextString(student
								.getSfrom()));
						cell.setCellStyle(style);
					}
					if (student.getSign() != null) {
						cell = row.createCell((short) 7);
						cell.setCellValue(new HSSFRichTextString(student
								.getSign()));
						cell.setCellStyle(style);
					}
					if (student.getIntime() != null) {
						cell = row.createCell((short) 8);
						cell.setCellValue(new HSSFRichTextString(student
								.getIntime()));
						cell.setCellStyle(style);
					}
					if (student.getMark() != null) {
						cell = row.createCell((short) 9);
						cell.setCellValue(new HSSFRichTextString(student
								.getMark().toString()));
						cell.setCellStyle(style);
					}
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		/*
		 * ����Ŀ��Բ��ñ�д��ֱ�ӿ���
		 */
		HttpServletResponse response = null;// ����һ��HttpServletResponse����
		OutputStream out = null;// ����һ�����������
		try {
			response = ServletActionContext.getResponse();// ��ʼ��HttpServletResponse����
			out = response.getOutputStream();//
			response.setHeader("Content-disposition", "attachment; filename="
					+ "student" + ".xls");// filename�����ص�xls���������������Ӣ��
			response.setContentType("application/msexcel;charset=UTF-8");// ��������
			response.setHeader("Pragma", "No-cache");// ����ͷ
			response.setHeader("Cache-Control", "no-cache");// ����ͷ
			response.setDateHeader("Expires", 0);// ��������ͷ
			workbook.write(out);
			out.flush();
			workbook.write(out);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {

				if (out != null) {
					out.close();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		return null;
	}

}
