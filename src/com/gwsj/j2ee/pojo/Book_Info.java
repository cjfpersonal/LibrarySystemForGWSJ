package com.gwsj.j2ee.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="book_info",catalog="librarysystem")
public class Book_Info implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3053059156687790435L;

	private Integer book_id;
	
	private String book_name;
	
	private String book_content;
	
	private Integer book_count;
	
	private Date book_uptime;
	
	private String book_photo;
	
	private Integer book_lendcount;
	
	private String book_address;
	
	private Integer book_status;
	
	private Set<Student_Borrow> student_borrow;
	
	public Book_Info() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Book_Info(Integer book_id, String book_name, String book_content, Integer book_count, Date book_uptime,
			String book_photo, Integer book_lendcount, String book_address, Integer book_status,
			Set<Student_Borrow> student_borrow) {
		this.book_id = book_id;
		this.book_name = book_name;
		this.book_content = book_content;
		this.book_count = book_count;
		this.book_uptime = book_uptime;
		this.book_photo = book_photo;
		this.book_lendcount = book_lendcount;
		this.book_address = book_address;
		this.book_status = book_status;
		this.student_borrow = student_borrow;
	}



	@Column(name="book_count",nullable=false)
	public Integer getBook_count() {
		return book_count;
	}

	public void setBook_count(Integer book_count) {
		this.book_count = book_count;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="book_id",nullable=false,unique=true)
	public Integer getBook_id() {
		return book_id;
	}

	public void setBook_id(Integer book_id) {
		this.book_id = book_id;
	}

	@Column(name="book_name",nullable=false,length=255)
	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	@Column(name="book_content",nullable=false,length=255)
	public String getBook_content() {
		return book_content;
	}

	public void setBook_content(String book_content) {
		this.book_content = book_content;
	}

	@Column(name="book_uptime",nullable=false)
	public Date getBook_uptime() {
		return book_uptime;
	}

	public void setBook_uptime(Date book_uptime) {
		this.book_uptime = book_uptime;
	}

	@Column(name="book_photo",length=255)
	public String getBook_photo() {
		return book_photo;
	}

	public void setBook_photo(String book_photo) {
		this.book_photo = book_photo;
	}

	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.PERSIST,mappedBy="book_info")
	public Set<Student_Borrow> getStudent_borrow() {
		return student_borrow;
	}

	public void setStudent_borrow(Set<Student_Borrow> student_borrow) {
		this.student_borrow = student_borrow;
	}


	@Column(name="book_lendcount",length=11,nullable=false)
	public Integer getBook_lendcount() {
		return book_lendcount;
	}



	public void setBook_lendcount(Integer book_lendcount) {
		this.book_lendcount = book_lendcount;
	}


	@Column(name="book_address",length=255,nullable=false)
	public String getBook_address() {
		return book_address;
	}



	public void setBook_address(String book_address) {
		this.book_address = book_address;
	}


	@Column(name="book_status",length=1,nullable=false,columnDefinition="int(1) default 0")
	public Integer getBook_status() {
		return book_status;
	}



	public void setBook_status(Integer book_status) {
		this.book_status = book_status;
	}
	
	

}
