package com.application.demo.entity;

//public class UserFullDetails {
//
//}
//import javax.persistence.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
<<<<<<< Updated upstream
=======
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
>>>>>>> Stashed changes
import jakarta.persistence.Table;

@Entity
@Table(name = "user_full_details")
public class UserFullDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String dept;
    
    private String password;
    
    
    @Column(nullable = false)
    private String phoneno;

    @Column(nullable = false)
    private String dob;
<<<<<<< Updated upstream
=======
    
    @OneToOne(mappedBy = "userfulldetails")
    @JsonIgnore
    private UserTemp usertemp;
    
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    @JsonIgnore
    public List<Enrollment> enrollcourseslist= new ArrayList<>();
    
    @OneToMany(mappedBy = "subuser", fetch = FetchType.EAGER)
    @JsonIgnore
    public List<assignmentsubmEntity> submissionlist= new ArrayList<>();

	public UserFullDetails(Long id, String email, String name, String dept, String password, String phoneno, String dob,
			UserTemp usertemp, List<Enrollment> enrollcourseslist, List<assignmentsubmEntity> submissionlist) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.dept = dept;
		this.password = password;
		this.phoneno = phoneno;
		this.dob = dob;
		this.usertemp = usertemp;
		this.enrollcourseslist = enrollcourseslist;
		this.submissionlist = submissionlist;
	}

	public UserFullDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
>>>>>>> Stashed changes

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

<<<<<<< Updated upstream
	
   
=======
	public UserTemp getUsertemp() {
		return usertemp;
	}

	public void setUsertemp(UserTemp usertemp) {
		this.usertemp = usertemp;
	}

	public List<Enrollment> getEnrollcourseslist() {
		return enrollcourseslist;
	}

	public void setEnrollcourseslist(List<Enrollment> enrollcourseslist) {
		this.enrollcourseslist = enrollcourseslist;
	}

	public List<assignmentsubmEntity> getSubmissionlist() {
		return submissionlist;
	}

	public void setSubmissionlist(List<assignmentsubmEntity> submissionlist) {
		this.submissionlist = submissionlist;
	}

	
	

>>>>>>> Stashed changes
}

