package com.application.demo.controller;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.application.demo.Dto.addcourserequest;
import com.application.demo.Dto.getcourseresponse;
import com.application.demo.entity.CourseEntity;
import com.application.demo.entity.UserTemp;
import com.application.demo.repository.CategoryRepository;
import com.application.demo.repository.CourseRepository;
import com.application.demo.service.CourseService;


@CrossOrigin(origins = "http://localhost:4200")


@RestController

public class CourseController {
	
	@Autowired
	private CourseService courseService;
	@Autowired
	private CourseRepository courseRepo;
	@Autowired
	private CategoryRepository categoryRepo;
	
	
	
	@PostMapping("/addCourse")
	public ResponseEntity<?> addNewCourse(@RequestBody addcourserequest course) {
	    // Check if a course with the same courseName and professorName already exists
	    CourseEntity existingCourse = courseService.findCourseByCourseNameAndProfessorNameAndCategoryName(course.getCourseName(), course.getProfessorName(), course.getCategory());

	    if (existingCourse != null) {
	        // A course with the same name and professor already exists, return an error response
	        return ResponseEntity.status(HttpStatus.CONFLICT).body("Course already exists.");
	    }

	    // Generate a new ID and save the course
	    String newID = getNewID();
	    course.setCourseId(newID);
	    LocalDate localEndDate = course.getEndDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate localStartDate = course.getStartDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        // Calculate the difference in days
        long daysDifference = localEndDate.toEpochDay() - localStartDate.toEpochDay();

        // Calculate the number of weeks
        long weeksDifference = daysDifference / 7;
	    course.setNumberOfWeeks((int)(weeksDifference));
	    CourseEntity courseObj = courseService.addNewCourse(course);

	    return ResponseEntity.ok(courseObj);
	}

	
	
	
	@GetMapping("/getcoursebyemail/{email}")
    public ResponseEntity<List<CourseEntity>> getCoursesByEmail(@PathVariable String email) {
        List<CourseEntity> courses = courseService.getCoursesByProfessorName(email);
        if (courses.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }
	@GetMapping("/getcoursebycousename/{email}/{coursename}")
    public ResponseEntity<CourseEntity> getCoursesByEmailandcoursename(@PathVariable String email,@PathVariable String coursename) {
        List<CourseEntity> courses = courseService.getCoursesByProfessorName(email);
        List<CourseEntity> filteredCourses = courses.stream()
                .filter(course -> course.getCourseName().equals(coursename))
                .toList();
        CourseEntity course=filteredCourses.get(0);
        if (courses.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(course, HttpStatus.OK);
    }
	public String getNewID()
	{
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"+"0123456789"+"abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 12; i++) 
        {
            int index = (int)(AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }
        return sb.toString();
	}
	
	@GetMapping("/getcourses")
	public List<getcourseresponse> getcourses(){
		return courseService.getAllCourses();
	}
	@GetMapping("/getcoursebyid/{id}")
	public CourseEntity getcoursebyid(@PathVariable String id){
		
		return courseRepo.findById(Long.parseLong(id)).get();
	}
	
	
	
	 @PutMapping("/enablecourse/{id}")
	    public ResponseEntity<CourseEntity> updateEntity(@PathVariable Long id) {
	    	
	        Optional<CourseEntity> entityOptional = courseRepo.findById(id);

	        if (entityOptional.isPresent()) {
	        	CourseEntity existingEntity = entityOptional.get();
	        	System.out.println(existingEntity.getCourseStatus());
	        	if(existingEntity.getCourseStatus().equals("inactive")) {
	        		 existingEntity.setCourseStatus("active");
	        	}
	        	else {
	        		System.out.println(existingEntity.getCourseStatus());
	        		 existingEntity.setCourseStatus("inactive");
	        	}
//	            existingEntity.setDescription(updatedEntity.getDescription());
	        	System.out.println(existingEntity.getCourseStatus());
	        	CourseEntity savedEntity = courseRepo.save(existingEntity);
	            return new ResponseEntity<>(savedEntity, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	 
	 @CrossOrigin(origins = "http://localhost:4200")
	 @PutMapping("updatecourse")
	 public ResponseEntity<CourseEntity> updateCourse(@RequestBody addcourserequest updatedCourse) {
	     Optional<CourseEntity> courseOptional = courseRepo.findById(updatedCourse.getId());

	     if (courseOptional.isPresent()) {
	         CourseEntity existingCourse = courseOptional.get();
	         existingCourse.setCourseName(updatedCourse.getCourseName());
	         existingCourse.setCourseDescription(updatedCourse.getCourseDescription());
	         existingCourse.setEndDate(updatedCourse.getEndDate());
	         existingCourse.setStartDate(updatedCourse.getStartDate());
	         existingCourse.setCategory(categoryRepo.findById(Long.parseLong(updatedCourse.getCategory())).get());
	         existingCourse.setDepartment(categoryRepo.findById(Long.parseLong(updatedCourse.getDepartment())).get());
	         LocalDate localEndDate = updatedCourse.getEndDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	         LocalDate localStartDate = updatedCourse.getStartDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

	         // Calculate the difference in days
	         long daysDifference = localEndDate.toEpochDay() - localStartDate.toEpochDay();

	         // Calculate the number of weeks
	         long weeksDifference = daysDifference / 7;
	         existingCourse.setNumberOfWeeks((int)(weeksDifference));
	         CourseEntity updatedEntity = courseRepo.save(existingCourse);
	         return new ResponseEntity<>(updatedEntity, HttpStatus.OK);
	     } else {
	         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	     }
	 }

	
	 
	
	

}
