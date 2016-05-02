package com.gwsj.j2ee.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="student_borrow",catalog="librarysystem")
public class Student_Borrow implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1115139600419131484L;

	private Integer id;
	
	private Book_Info book_info;
	
	private Student_Info student_info;
	
	private Date borrow_time;
	
	private Date deadline;
	
	private Date return_time;
	
	private Integer borrow_book_number;


	public Student_Borrow()
	{
		
	}




	public Student_Borrow(Integer id, Book_Info book_info, Student_Info student_info, Date borrow_time, Date deadline,
			Date return_time, Integer borrow_book_number) {
		this.id = id;
		this.book_info = book_info;
		this.student_info = student_info;
		this.borrow_time = borrow_time;
		this.deadline = deadline;
		this.return_time = return_time;
		this.borrow_book_number = borrow_book_number;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id",nullable=false,unique=true)
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}


	@Column(name="borrow_time",nullable=false)
	public Date getBorrow_time() {
		return borrow_time;
	}


	public void setBorrow_time(Date borrow_time) {
		this.borrow_time = borrow_time;
	}


	@Column(name="deadline",nullable=false)
	public Date getDeadline() {
		return deadline;
	}


	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	@Column(name="return_time",nullable=false)
	public Date getReturn_time() {
		return return_time;
	}


	public void setReturn_time(Date return_time) {
		this.return_time = return_time;
	}


    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="book_id",nullable=false)
	public Book_Info getBook_info() {
		return book_info;
	}


	public void setBook_info(Book_Info book_info) {
		this.book_info = book_info;
	}

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="student_id",nullable=false)
	public Student_Info getStudent_info() {
		return student_info;
	}


	public void setStudent_info(Student_Info student_info) {
		this.student_info = student_info;
	}
	@Column(name="borrow_book_number")
	public Integer getBorrow_book_number() {
		return borrow_book_number;
	}


	public void setBorrow_book_number(Integer borrow_book_number) {
		this.borrow_book_number = borrow_book_number;
	}

	
	
	
	
	
	
	

}
