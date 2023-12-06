package com.application.demo.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

<<<<<<< Updated upstream
=======
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
>>>>>>> Stashed changes
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;


@Entity
public class CourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String courseName;
    private String courseId;
    @Column(length = 10000)
    private String courseDescription;
    private Date startDate;
    private int numberOfWeeks;
    private Long userId;
    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn(name = "deptreference_id")
    @JsonIgnore
    private CategoryEntity department;
    private String courseStatus;

    private Date endDate;
    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn(name = "categoryreference_id")
    @JsonIgnore
    private CategoryEntity category;
	private String modules;
    
    private String professorName;
    @OneToMany(mappedBy = "course", fetch = FetchType.EAGER)
    @JsonIgnore
    public List<ModuleEntity> moduleslist= new ArrayList<>();
    
    @OneToMany(mappedBy = "course", fetch = FetchType.EAGER)
    @JsonIgnore
    public List<Enrollment> enrolllist= new ArrayList<>();
    
    
    @OneToMany(mappedBy = "course", fetch = FetchType.EAGER)
    @JsonIgnore
    public List<AnnouncementEntity> announcements= new ArrayList<>();
<<<<<<< Updated upstream
<<<<<<< Updated upstream
<<<<<<< Updated upstream
<<<<<<< Updated upstream

=======
=======
>>>>>>> Stashed changes
    
    
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AssignmentEntity> assignments;
<<<<<<< Updated upstream
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes
=======
=======
>>>>>>> Stashed changes
    
    
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<AssignmentEntity> assignments= new ArrayList<>();

<<<<<<< Updated upstream
>>>>>>> Stashed changes
=======
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<CourseAttachmentsEntity> courseAttachments= new ArrayList<>();
>>>>>>> Stashed changes

	public Long getId() {
		return id;
	}

<<<<<<< Updated upstream

	public void setId(Long id) {
		this.id = id;
	}


=======
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


>>>>>>> Stashed changes
	public String getCourseName() {
		return courseName;
	}


	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}


	public String getCourseId() {
		return courseId;
	}


	public void setCourseId(String courseId) {
		this.courseId = courseId;
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


<<<<<<< Updated upstream
	public String getDepartment() {
=======
	public CategoryEntity getDepartment() {
>>>>>>> Stashed changes
		return department;
	}


<<<<<<< Updated upstream
	public void setDepartment(String department) {
=======
	public void setDepartment(CategoryEntity department) {
>>>>>>> Stashed changes
		this.department = department;
	}


	public String getCourseStatus() {
		return courseStatus;
	}


	public void setCourseStatus(String courseStatus) {
		this.courseStatus = courseStatus;
	}


	public Date getEndDate() {
		return endDate;
	}


	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


<<<<<<< Updated upstream
	public String getCategory() {
=======
	public CategoryEntity getCategory() {
>>>>>>> Stashed changes
		return category;
	}


<<<<<<< Updated upstream
	public void setCategory(String category) {
=======
	public void setCategory(CategoryEntity category) {
>>>>>>> Stashed changes
		this.category = category;
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


	public List<ModuleEntity> getModuleslist() {
		return moduleslist;
	}


	public void setModuleslist(List<ModuleEntity> moduleslist) {
		this.moduleslist = moduleslist;
	}


	public List<Enrollment> getEnrolllist() {
		return enrolllist;
	}


	public void setEnrolllist(List<Enrollment> enrolllist) {
		this.enrolllist = enrolllist;
	}


	public List<AnnouncementEntity> getAnnouncements() {
		return announcements;
	}


	public void setAnnouncements(List<AnnouncementEntity> announcements) {
		this.announcements = announcements;
	}


<<<<<<< Updated upstream
	public CourseEntity(Long id, String courseName, String courseId, String courseDescription, Date startDate,
			int numberOfWeeks, Long userId, String department, String courseStatus, Date endDate, String category,
			String modules, String professorName, List<ModuleEntity> moduleslist, List<Enrollment> enrolllist,
			List<AnnouncementEntity> announcements) {
=======
	public List<AssignmentEntity> getAssignments() {
		return assignments;
	}


	public void setAssignments(List<AssignmentEntity> assignments) {
		this.assignments = assignments;
	}

<<<<<<< Updated upstream
=======

>>>>>>> Stashed changes

	public CourseEntity(Long id, String courseName, String courseId, String courseDescription, Date startDate,
			int numberOfWeeks, Long userId, CategoryEntity department, String courseStatus, Date endDate,
			CategoryEntity category, String modules, String professorName, List<ModuleEntity> moduleslist,
<<<<<<< Updated upstream
			List<Enrollment> enrolllist, List<AnnouncementEntity> announcements, List<AssignmentEntity> assignments) {
>>>>>>> Stashed changes
=======
			List<Enrollment> enrolllist, List<AnnouncementEntity> announcements, List<AssignmentEntity> assignments,
			List<CourseAttachmentsEntity> courseAttachments) {
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
		this.moduleslist = moduleslist;
		this.enrolllist = enrolllist;
		this.announcements = announcements;
		this.assignments = assignments;
<<<<<<< Updated upstream
>>>>>>> Stashed changes
=======
		this.courseAttachments = courseAttachments;
>>>>>>> Stashed changes
	}


	public CourseEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


<<<<<<< Updated upstream
	

<<<<<<< Updated upstream



=======
>>>>>>> Stashed changes
=======
	public List<CourseAttachmentsEntity> getCourseAttachments() {
		return courseAttachments;
	}


	public void setCourseAttachments(List<CourseAttachmentsEntity> courseAttachments) {
		this.courseAttachments = courseAttachments;
	}
	
	


	

>>>>>>> Stashed changes
    
    
}

