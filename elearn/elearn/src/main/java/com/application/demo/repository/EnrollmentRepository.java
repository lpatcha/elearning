package com.application.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< Updated upstream
=======
import org.springframework.data.jpa.repository.Query;
>>>>>>> Stashed changes
import org.springframework.stereotype.Repository;

import com.application.demo.entity.CourseEntity;
import com.application.demo.entity.Enrollment;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long>{
//	List<CourseEntity> findByProfessorName(String professorName);
<<<<<<< Updated upstream
	List<Enrollment> findByInstructornameAndCoursename(String value1, String value2);
<<<<<<< Updated upstream
}
=======
	
	@Query("SELECT e.enrolledusername FROM Enrollment e")
    List<String> findAllEmails();
=======
//	List<Enrollment> findByInstructornameAndCoursename(String value1, String value2);
//	
//	@Query("SELECT e.enrolledusername FROM Enrollment e")
//    List<String> findAllEmails();

//	List<Enrollment> findByEnrolledusernameAndCoursenameAndInstructorname(String enrolledusername, String coursename,
//			String instructorname);
>>>>>>> Stashed changes
}


>>>>>>> Stashed changes
