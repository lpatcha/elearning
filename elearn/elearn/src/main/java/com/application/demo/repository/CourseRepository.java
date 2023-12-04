package com.application.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.demo.entity.CourseEntity;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity, Long>{
	List<CourseEntity> findByProfessorName(String professorName);
	CourseEntity findByCourseNameAndProfessorName(String courseName, String professorName);
<<<<<<< Updated upstream
	CourseEntity findByCourseNameAndProfessorNameAndCategory(String courseName, String professorName, String Category);
<<<<<<< Updated upstream
<<<<<<< Updated upstream

=======
=======
>>>>>>> Stashed changes
//	Optional<CourseEntity> findById(Long id);
>>>>>>> Stashed changes
=======
	CourseEntity findByCourseNameAndProfessorNameAndCategoryId(String courseName, String professorName, Long Category);
	Optional<CourseEntity> findById(Long id);
>>>>>>> Stashed changes
}
