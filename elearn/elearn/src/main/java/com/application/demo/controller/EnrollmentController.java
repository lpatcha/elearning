package com.application.demo.controller;

import java.util.List;
<<<<<<< Updated upstream
=======
import java.util.Optional;
import java.util.stream.Collectors;
>>>>>>> Stashed changes

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.application.demo.entity.CourseEntity;
import com.application.demo.entity.Enrollment;
<<<<<<< Updated upstream
=======
import com.application.demo.entity.ModuleEntity;
import com.application.demo.entity.UserFullDetails;
import com.application.demo.repository.CourseRepository;
import com.application.demo.repository.EnrollmentRepository;
import com.application.demo.repository.UserFullDetailsRepository;
>>>>>>> Stashed changes
import com.application.demo.service.CourseService;
import com.application.demo.service.EnrollmentService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class EnrollmentController {
	@Autowired
	private EnrollmentService enrollService;
<<<<<<< Updated upstream
	
	@PostMapping("/addenrollment")
	public Enrollment addNewCourse(@RequestBody Enrollment enrollment) throws Exception
=======
	@Autowired
	private UserFullDetailsRepository userfull;
	 @Autowired
	 private EnrollmentRepository enrollRepo;
	 @Autowired
		private CourseRepository courseRepo;
	
	@PostMapping("/addenrollment/{courseid}")
	public ResponseEntity<?> addNewCourse(@RequestBody enrollrequest enroll,@PathVariable String courseid) throws Exception
>>>>>>> Stashed changes
	{
		Enrollment courseObj = null;
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
	@GetMapping("/getenrolledusers/{email}/{coursename}")
	public List<Enrollment> getusers(@PathVariable String email,@PathVariable String coursename){
		return enrollService.getAllEnrollUsers(email,coursename);
=======
//	@GetMapping("/getenrolledusers/{email}/{coursename}")
//	public List<Enrollment> getusers(@PathVariable String email,@PathVariable String coursename){
//		return enrollService.getAllEnrollUsers(email,coursename);
//	}
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
