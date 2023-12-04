package com.application.demo.entity;

<<<<<<< Updated upstream
=======
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

>>>>>>> Stashed changes
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
<<<<<<< Updated upstream
=======
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
<<<<<<< Updated upstream

    @Transient 
    private MultipartFile pdfFile; 

    private String pdfFilePath;

	public AssignmentEntity(Long id, String title, String description, MultipartFile pdfFile, String pdfFilePath) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.pdfFile = pdfFile;
		this.pdfFilePath = pdfFilePath;
	}

	public AssignmentEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
=======
    
    private String fileUrl;
    
    private String fileName;
  private String totalmarks;
  private String weightage;
    private String deadlinedate;
    
    @ManyToOne
    @JoinColumn(name = "course_id")
    private CourseEntity course;
    
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

	public MultipartFile getPdfFile() {
		return pdfFile;
	}

	public void setPdfFile(MultipartFile pdfFile) {
		this.pdfFile = pdfFile;
	}

<<<<<<< Updated upstream
	public String getPdfFilePath() {
		return pdfFilePath;
	}

	public void setPdfFilePath(String pdfFilePath) {
		this.pdfFilePath = pdfFilePath;
	} 
    
=======
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
	}

	public CourseEntity getCourse() {
		return course;
	}

	public void setCourse(CourseEntity course) {
		this.course = course;
	}

	public List<assignmentsubmEntity> getAssignmentsubmissions() {
		return assignmentsubmissions;
	}

	public void setAssignmentsubmissions(List<assignmentsubmEntity> assignmentsubmissions) {
		this.assignmentsubmissions = assignmentsubmissions;
	}

	public AssignmentEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AssignmentEntity(Long id, String title, String description, String fileUrl, String fileName,
			String totalmarks, String weightage, String deadlinedate, CourseEntity course,
			List<assignmentsubmEntity> assignmentsubmissions) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.fileUrl = fileUrl;
		this.fileName = fileName;
		this.totalmarks = totalmarks;
		this.weightage = weightage;
		this.deadlinedate = deadlinedate;
		this.course = course;
		this.assignmentsubmissions = assignmentsubmissions;
	}

	

	
>>>>>>> Stashed changes
	
    
}
