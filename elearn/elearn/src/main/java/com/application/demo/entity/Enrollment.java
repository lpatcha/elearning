package com.application.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Enrollment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long enrollid;
<<<<<<< Updated upstream
	private String coursename;

	private String enrolledusername;

	private String instructorname;
=======
	 @ManyToOne
	 @JoinColumn(name = "course_id")
	 private CourseEntity course;

	 @ManyToOne
	 @JoinColumn(name = "user_id")
	 private UserFullDetails user;
>>>>>>> Stashed changes

	public Long getEnrollid() {
		return enrollid;
	}

	public void setEnrollid(Long enrollid) {
		this.enrollid = enrollid;
	}

	public CourseEntity getCourse() {
		return course;
	}

	public void setCourse(CourseEntity course) {
		this.course = course;
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
