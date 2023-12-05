package com.application.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.application.demo.Dto.enrollrequest;
import com.application.demo.Dto.enrollresponse;
import com.application.demo.entity.CourseEntity;
import com.application.demo.entity.Enrollment;
import com.application.demo.service.CourseService;
import com.application.demo.service.EnrollmentService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class EnrollmentController {
	@Autowired
	private EnrollmentService enrollService;
	
<<<<<<< Updated upstream
<<<<<<< Updated upstream
	@PostMapping("/addenrollment")
	public Enrollment addNewCourse(@RequestBody Enrollment enrollment) throws Exception
=======
=======
>>>>>>> Stashed changes
	@PostMapping("/addenrollment/{courseid}")
	public ResponseEntity<?> addNewCourse(@RequestBody enrollrequest enroll,@PathVariable String courseid) throws Exception
>>>>>>> Stashed changes
	{
		Enrollment courseObj = null;
<<<<<<< Updated upstream
//		String newID = getNewID();
//		enrollment.setEnrollid(newID);
<<<<<<< Updated upstream
		
		courseObj = enrollService.addNewCourse(enrollment);
		return courseObj;
=======
//		List<Enrollment> existenroll=enrollRepo.findByEnrolledusernameAndCoursenameAndInstructorname(enrollment.getEnrolledusername(),enrollment.getCoursename(),enrollment.getInstructorname());
//		List<Enrollment> existenroll= courseRepo.findById(Long.parseLong(courseid)).get().getEnrolllist().stream()
//                .filter(modu -> modu.getEnrolledusername().equals(enrollment.getEnrolledusername()))
//                .collect(Collectors.toList());
//		Optional<UserFullDetails> existingusers= userfull.findByEmail(enrollment.getEnrolledusername());
=======

>>>>>>> Stashed changes
		Optional<UserFullDetails> existingusers=userfull.findByEmail(enroll.getEnrolledusername());
		if(!(existingusers.isEmpty())) {
		List<Enrollment> existenroll= courseRepo.findById(Long.parseLong(courseid)).get().getEnrolllist().stream()
              .filter(modu -> modu.getUser().getId().equals(existingusers.get().getId()))
              .collect(Collectors.toList());
		if(existenroll.size()>0) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("User already exists");
		}
		};
		if(existingusers.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not exists");
		}
		
		courseObj = enrollService.addNewCourse(enroll.getEnrolledusername(),courseid);
		return ResponseEntity.ok(courseObj);
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
<<<<<<< Updated upstream
	@GetMapping("/getenrolledusers/{email}/{coursename}")
	public List<Enrollment> getusers(@PathVariable String email,@PathVariable String coursename){
		return enrollService.getAllEnrollUsers(email,coursename);
=======
//	@GetMapping("/getenrolledusers/{email}/{coursename}")
//	public List<Enrollment> getusers(@PathVariable String email,@PathVariable String coursename){
//		return enrollService.getAllEnrollUsers(email,coursename);
//	}
=======

>>>>>>> Stashed changes
	@GetMapping("/getenrolledusers/{id}")
	public List<enrollresponse> getusers(@PathVariable String id){
		try{
		return enrollService.getAllEnrollUsers(id);
		}
		catch(Exception e){
			return null;
		}
>>>>>>> Stashed changes
	}
}
