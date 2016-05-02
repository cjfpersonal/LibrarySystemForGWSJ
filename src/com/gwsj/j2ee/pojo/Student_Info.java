package com.gwsj.j2ee.pojo;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="student_info",catalog="librarysystem")
public class Student_Info implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -735187094673926777L;

	private Integer student_id;
	
	private String student_name;
	
	private String student_password;
	
	private String student_college;
	
	private Integer student_sex;
	
	private String student_photo;
	
	private Integer student_money;
	
	@JsonIgnore
	private Set<Student_Borrow> student_borrow;
	
	
	public Student_Info()
	{
	
	}

	public Student_Info(Integer student_id, String student_name, String student_password, String student_college,
			Integer student_sex, String student_photo) {
		this.student_id = student_id;
		this.student_name = student_name;
		this.student_password = student_password;
		this.student_college = student_college;
		this.student_sex = student_sex;
		this.student_photo = student_photo;
	}
	

	@Id
	@Column(name="student_id",nullable=false,unique=true)
	public Integer getStudent_id() {
		return student_id;
	}

	public void setStudent_id(Integer student_id) {
		this.student_id = student_id;
	}

	@Column(name="student_name",nullable=false,length=255)
	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	@Column(name="student_password",nullable=false,length=255)
	public String getStudent_password() {
		return student_password;
	}

	public void setStudent_password(String student_password) {
		this.student_password = student_password;
	}

	@Column(name="student_college",nullable=false,length=255)
	public String getStudent_college() {
		return student_college;
	}

	public void setStudent_college(String student_college) {
		this.student_college = student_college;
	}

	@Column(name="student_sex",nullable=false)
	public Integer getStudent_sex() {
		return student_sex;
	}

	public void setStudent_sex(Integer student_sex) {
		this.student_sex = student_sex;
	}

	@Column(name="student_photo",length=255)
	public String getStudent_photo() {
		return student_photo;
	}

	public void setStudent_photo(String student_photo) {
		this.student_photo = student_photo;
	}

	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL,mappedBy="student_info")
	public Set<Student_Borrow> getStudent_borrow() {
		return student_borrow;
	}

	public void setStudent_borrow(Set<Student_Borrow> student_borrow) {
		this.student_borrow = student_borrow;
	}
	@Column(name="student_money",length=11,columnDefinition="int(11) default 0")
	public Integer getStudent_money() {
		return student_money;
	}

	public void setStudent_money(Integer student_money) {
		this.student_money = student_money;
	}
	
	
	
	
	
	
	

}
