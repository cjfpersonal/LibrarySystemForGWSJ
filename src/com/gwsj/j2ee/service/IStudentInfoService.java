package com.gwsj.j2ee.service;

import com.gwsj.j2ee.pojo.Student_Info;

public interface IStudentInfoService {

	/*
	 * 增加学生信息的方法
	 * @param Student_Info
	 * @return boolean
	 * 
	 */
	
	boolean addStudentInfo(Student_Info student_Info);
	
	/*
	 * 
	 * 删除学生信息的方法
	 * @param student_id
	 * @return boolean
	 * 
	 */
	
	boolean deleteStudentInfo(int id);
}
