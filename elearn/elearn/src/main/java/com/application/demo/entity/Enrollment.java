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
<<<<<<< Updated upstream
<<<<<<< Updated upstream
=======
=======
=======
>>>>>>> Stashed changes
	 @ManyToOne
	 @JoinColumn(name = "course_id")
	 private CourseEntity course;

<<<<<<< Updated upstream
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes
	 @ManyToOne
	 @JoinColumn(name = "course_id")
	 private CourseEntity course;

<<<<<<< Updated upstream
<<<<<<< Updated upstream
>>>>>>> Stashed changes
	 @ManyToOne
	 @JoinColumn(name = "course_id")
	 private CourseEntity course;

<<<<<<< Updated upstream
	private String enrolledusername;

=======
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes
=======
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
<<<<<<< Updated upstream
<<<<<<< Updated upstream

	public String getEnrolledusername() {
		return enrolledusername;
	}

	public void setEnrolledusername(String enrolledusername) {
		this.enrolledusername = enrolledusername;
	}
=======
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes

	public Enrollment(Long enrollid, CourseEntity course, String enrolledusername) {
		super();
		this.enrollid = enrollid;
		this.course = course;
<<<<<<< Updated upstream
		this.enrolledusername = enrolledusername;
=======
		this.user = user;
	}

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
	}

>>>>>>> Stashed changes
	public Enrollment() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
<<<<<<< Updated upstream
=======
	
}
