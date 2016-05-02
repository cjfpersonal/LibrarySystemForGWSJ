package com.gwsj.j2ee.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gwsj.j2ee.Dao.StudentInfoDao;
import com.gwsj.j2ee.pojo.Student_Info;
import com.gwsj.j2ee.service.IStudentInfoService;

@Service
public class StudentInfoServiceImpl implements IStudentInfoService{

	@Autowired
	private StudentInfoDao studentInfoDao;
	
	public boolean addStudentInfo(Student_Info student_Info) {
		// TODO Auto-generated method stub
		return studentInfoDao.save(student_Info);
	}

	public boolean deleteStudentInfo(int id) {
		// TODO Auto-generated method stub
		Student_Info student_Info;
		return false;
	}
	
	

}
