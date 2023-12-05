package com.application.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.demo.entity.CourseEntity;
import com.application.demo.repository.CourseRepository;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepo;
	
	public CourseEntity saveCourse(CourseEntity course)
	{
		return courseRepo.save(course);
	}
	
	public CourseEntity addNewCourse(CourseEntity course)
	{
		return courseRepo.save(course);
	}
	
	public List<CourseEntity> getAllCourses()
	{
		return (List<CourseEntity>)courseRepo.findAll();
	}
<<<<<<< Updated upstream
	
=======
	public CourseEntity findCourseByCourseNameAndProfessorNameAndCategoryName(String courseName, String professorName, String categoryName) {
		CategoryEntity category=categoryRepo.findById(Long.parseLong(categoryName)).get();
	    return courseRepo.findByCourseNameAndProfessorNameAndCategoryId(courseName, professorName, Long.parseLong(categoryName));
	}

>>>>>>> Stashed changes
	
	

    public List<CourseEntity> getCoursesByProfessorName(String professorName) {
        return courseRepo.findByProfessorName(professorName);
    }

}
