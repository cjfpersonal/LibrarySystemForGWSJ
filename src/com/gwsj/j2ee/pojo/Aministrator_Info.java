package com.gwsj.j2ee.pojo;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.sql.rowset.JdbcRowSet;

import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Table;


@javax.persistence.Entity
@javax.persistence.Table(name="aministrator_info",catalog="librarysystem")
public class Aministrator_Info implements java.io.Serializable{

	
	private Integer id;
	
	private String ausername;
	
	private String apassword;
	
	public Aministrator_Info() {
		// TODO Auto-generated constructor stub
	}
	
	public Aministrator_Info(String ausername,String apassword)
	{
		this.ausername=ausername;
		this.apassword=apassword;
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id",unique=true,nullable=false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="ausername",nullable=false,length=255)
	public String getAusername() {
		return ausername;
	}

	public void setAusername(String ausername) {
		this.ausername = ausername;
	}

	@Column(name="apassword",nullable=false,length=255)
	public String getApassword() {
		return apassword;
	}

	public void setApassword(String apassword) {
		this.apassword = apassword;
	}
	
	
}
