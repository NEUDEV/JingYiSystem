package com.JES.service;

import com.JES.dao.StudentDAO;
import com.JES.model.Student;

public class StudentService {
	private StudentDAO studentDAO;

	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}
	public boolean cheakId(String id){
		if(studentDAO.findById(id)==null)
			return false;
		else return true;
	}
}
