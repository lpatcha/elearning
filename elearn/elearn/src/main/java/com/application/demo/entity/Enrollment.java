package com.application.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Enrollment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long enrollid;
	private String coursename;

	 @ManyToOne
	 @JoinColumn(name = "user_id")
	 private UserFullDetails user;

	private String instructorname;

	public Long getEnrollid() {
		return enrollid;
	}
	public void setEnrollid(Long enrollid) {
		this.enrollid = enrollid;
	}
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
<<<<<<< Updated upstream
	public String getEnrolledusername() {
		return enrolledusername;
	}
	public void setEnrolledusername(String enrolledusername) {
		this.enrolledusername = enrolledusername;
	}
	public String getInstructorname() {
		return instructorname;
	}
	public void setInstructorname(String instructorname) {
		this.instructorname = instructorname;
	}
	public Enrollment(Long enrollid, String coursename, String enrolledusername, String instructorname) {
		super();
		this.enrollid = enrollid;
		this.coursename = coursename;
		this.enrolledusername = enrolledusername;
		this.instructorname = instructorname;
=======

	public UserFullDetails getUser() {
		return user;
	}

	public void setUser(UserFullDetails user) {
		this.user = user;
	}

	public Enrollment(Long enrollid, CourseEntity course, UserFullDetails user) {
		super();
		this.enrollid = enrollid;
		this.course = course;
		this.user = user;
>>>>>>> Stashed changes
	}
	public Enrollment() {
		super();
		// TODO Auto-generated constructor stub
	}
<<<<<<< Updated upstream
=======

	
	
	
>>>>>>> Stashed changes
}
