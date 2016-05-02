package com.gwsj.j2ee.vo;

public class StudentInfoVo {
	
	private String student_id;
	private String student_name;
	private String student_password;
	private String student_college;
	private String student_sex;
	
	public StudentInfoVo() {
	}
	
	public StudentInfoVo(String student_id, String student_name, String student_password, String student_college,
			String student_sex) {
		this.student_id = student_id;
		this.student_name = student_name;
		this.student_password = student_password;
		this.student_college = student_college;
		this.student_sex = student_sex;
	}

	public String getStudent_id() {
		return student_id;
	}

	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public String getStudent_password() {
		return student_password;
	}

	public void setStudent_password(String student_password) {
		this.student_password = student_password;
	}

	public String getStudent_college() {
		return student_college;
	}

	public void setStudent_college(String student_college) {
		this.student_college = student_college;
	}

	public String getStudent_sex() {
		return student_sex;
	}

	public void setStudent_sex(String student_sex) {
		this.student_sex = student_sex;
	}
	
	
	

}
