package com.application.demo.repository;

import java.util.List;
<<<<<<< Updated upstream
=======
import java.util.Optional;
>>>>>>> Stashed changes

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.demo.entity.Enrollment;
import com.application.demo.entity.ModuleEntity;

@Repository
public interface ModuleRepository extends JpaRepository<ModuleEntity, Long> {

<<<<<<< Updated upstream
	List<ModuleEntity> findByCoursenameAndInstructorname(String courseName, String instructorName);
	List<ModuleEntity> findByInstructornameAndCoursename(String value1, String value2);
<<<<<<< Updated upstream
=======
	 Optional<ModuleEntity> findByModulenameAndCoursenameAndInstructorname(String moduleName, String courseName, String instructorName);
>>>>>>> Stashed changes
=======
//	List<ModuleEntity> findByCoursenameAndInstructorname(String courseName, String instructorName);
//	List<ModuleEntity> findByInstructornameAndCoursename(String value1, String value2);
//	 Optional<ModuleEntity> findByModulenameAndCoursenameAndInstructorname(String moduleName, String courseName, String instructorName);
>>>>>>> Stashed changes
    // You can add custom query methods if needed
}