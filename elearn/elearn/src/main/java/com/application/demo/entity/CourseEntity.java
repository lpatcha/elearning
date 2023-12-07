package com.application.demo.entity;

<<<<<<< Updated upstream
import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
=======
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
>>>>>>> Stashed changes
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class CourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String courseName;
    private String courseId;
    private String courseDescription;
    private Date startDate;
    private int numberOfWeeks;
    private Long userId;
    private String department;
    private String courseStatus;

    private Date endDate;
    private String category;
	private String modules;
    
    private String professorName;
    
    
<<<<<<< Updated upstream
=======
    @OneToMany(mappedBy = "course", fetch = FetchType.EAGER)
    @JsonIgnore
    public List<AnnouncementEntity> announcements= new ArrayList<>();
    
>>>>>>> Stashed changes

	


<<<<<<< Updated upstream
	public CourseEntity(Long id, String courseName, String courseId, String courseDescription, Date startDate,
			int numberOfWeeks, Long userId, String department, String courseStatus, Date endDate, String category,
			String modules, String professorName) {
=======

	




	public CourseEntity(Long id, String courseName, String courseId, String courseDescription, Date startDate,
			int numberOfWeeks, Long userId, String department, String courseStatus, Date endDate, String category,
			String modules, String professorName, List<AnnouncementEntity> announcements) {
>>>>>>> Stashed changes
		super();
		this.id = id;
		this.courseName = courseName;
		this.courseId = courseId;
		this.courseDescription = courseDescription;
		this.startDate = startDate;
		this.numberOfWeeks = numberOfWeeks;
		this.userId = userId;
		this.department = department;
		this.courseStatus = courseStatus;
		this.endDate = endDate;
		this.category = category;
		this.modules = modules;
		this.professorName = professorName;
<<<<<<< Updated upstream
	}

=======
		this.announcements = announcements;
	}




>>>>>>> Stashed changes
	public CourseEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseDescription() {
		return courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public int getNumberOfWeeks() {
		return numberOfWeeks;
	}

	public void setNumberOfWeeks(int numberOfWeeks) {
		this.numberOfWeeks = numberOfWeeks;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getCourseStatus() {
		return courseStatus;
	}

	public void setCourseStatus(String courseStatus) {
		this.courseStatus = courseStatus;
	}

	public String getModules() {
		return modules;
	}

	public void setModules(String modules) {
		this.modules = modules;
	}

	public String getProfessorName() {
		return professorName;
	}

	public void setProfessorName(String professorName) {
		this.professorName = professorName;
	}

<<<<<<< Updated upstream
    // getters and setters
=======



	public List<AnnouncementEntity> getAnnouncements() {
		return announcements;
	}




	public void setAnnouncements(List<AnnouncementEntity> announcements) {
		this.announcements = announcements;
	}




	
    
>>>>>>> Stashed changes
    
    
    
}

