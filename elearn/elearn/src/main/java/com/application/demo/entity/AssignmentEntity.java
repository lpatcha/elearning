package com.application.demo.entity;

<<<<<<< Updated upstream
=======
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
>>>>>>> Stashed changes
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
<<<<<<< Updated upstream
=======
import jakarta.persistence.OneToMany;
>>>>>>> Stashed changes
import jakarta.persistence.Transient;

@Entity
public class AssignmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    
    private String fileUrl;
    
    private String fileName;
<<<<<<< Updated upstream
=======
    private String totalmarks;
    private String weightage;
    private String deadlinedate;
>>>>>>> Stashed changes
    
    @ManyToOne
    @JoinColumn(name = "course_id")
    private CourseEntity course;
<<<<<<< Updated upstream

    
    
	

	

	

	public AssignmentEntity(Long id, String title, String description, String fileUrl, String fileName,
			CourseEntity course) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.fileUrl = fileUrl;
		this.fileName = fileName;
		this.course = course;
	}

	public AssignmentEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
=======
    
    @OneToMany(mappedBy = "assignment",fetch = FetchType.EAGER)
    @JsonIgnore
    private List<assignmentsubmEntity> assignmentsubmissions= new ArrayList<>();
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

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
<<<<<<< Updated upstream
=======
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getTotalmarks() {
		return totalmarks;
	}

	public void setTotalmarks(String totalmarks) {
		this.totalmarks = totalmarks;
	}

	public String getWeightage() {
		return weightage;
	}

	public void setWeightage(String weightage) {
		this.weightage = weightage;
	}

	public String getDeadlinedate() {
		return deadlinedate;
	}

	public void setDeadlinedate(String deadlinedate) {
		this.deadlinedate = deadlinedate;
>>>>>>> Stashed changes
	}

	public CourseEntity getCourse() {
		return course;
	}

	public void setCourse(CourseEntity course) {
		this.course = course;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	

	
	
    
}
