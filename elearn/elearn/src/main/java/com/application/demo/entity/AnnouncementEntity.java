package com.application.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
<<<<<<< Updated upstream
=======
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
>>>>>>> Stashed changes

@Entity
public class AnnouncementEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private LocalDateTime createdDate;
<<<<<<< Updated upstream
	public AnnouncementEntity(Long id, String title, String description, LocalDateTime createdDate) {
=======
    
	
    @ManyToOne
    @JoinColumn(name = "course_id")
    private CourseEntity course;
    
	public AnnouncementEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public AnnouncementEntity(Long id, String title, String description, LocalDateTime createdDate,
			String instructorName, String courseName, CourseEntity course) {
>>>>>>> Stashed changes
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.createdDate = createdDate;
<<<<<<< Updated upstream
	}
	public AnnouncementEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
=======
		
		this.course = course;
	}



>>>>>>> Stashed changes
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
<<<<<<< Updated upstream
=======


	public CourseEntity getCourse() {
		return course;
	}


	public void setCourse(CourseEntity course) {
		this.course = course;
	}
	
	
>>>>>>> Stashed changes
    

}
