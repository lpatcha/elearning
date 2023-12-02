package com.application.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.demo.entity.CourseEntity;
import com.application.demo.entity.Enrollment;
<<<<<<< Updated upstream
=======
import com.application.demo.entity.UserFullDetails;
import com.application.demo.repository.CourseRepository;
>>>>>>> Stashed changes
import com.application.demo.repository.EnrollmentRepository;
@Service
public class EnrollmentService {
   @Autowired
   EnrollmentRepository enrollRepo;
<<<<<<< Updated upstream
	public Enrollment addNewCourse(Enrollment enrollment) {
	  return  enrollRepo.save(enrollment);
	}
	public List<Enrollment> getAllEnrollUsers(String email,String coursename) {
		// TODO Auto-generated method stub
		List<Enrollment> enrollers=enrollRepo.findByInstructornameAndCoursename(email, coursename);
		
		return enrollers;
	}

=======
   @Autowired
	private CourseRepository courseRepo;
   @Autowired
   UserFullDetailsRepository userdetails;
	public Enrollment addNewCourse(String username,String courseid) {
	 CourseEntity course=courseRepo.findById(Long.parseLong(courseid)).get();
	 Enrollment enroll=new Enrollment();
	 UserFullDetails user=userdetails.findByEmail(username).get();
//	 enroll.setEnrolledusername(username);
	 enroll.setUser(user);
	 enroll.setCourse(course);
	 user.getEnrollcourseslist().add(enroll);
	 course.getEnrolllist().add(enroll);
	  return  enrollRepo.save(enroll);
	}
	public List<enrollresponse> getAllEnrollUsers(String id) {
		List<UserFullDetails> enrollers= courseRepo.findById(Long.parseLong(id)).get().getEnrolllist().stream().map(enroll->enroll.getUser()).toList();
		List<Enrollment> enrollment=courseRepo.findById(Long.parseLong(id)).get().getEnrolllist();
		 List<enrollresponse> enrollerresponse= new ArrayList<>();
		 for(UserFullDetails i:enrollers) {
			 enrollresponse enroll=new enrollresponse();
			 enroll.setId(i.getId());
			 enroll.setDept(i.getDept());
			 enroll.setEmail(i.getEmail());
			 enroll.setName(i.getName());
			 for(Enrollment j:enrollment) {
				 if(j.getUser().getId().equals(i.getId()))
				  enroll.setEnrollid(j.getEnrollid());
			 }
			 enrollerresponse.add(enroll);
		 }
		return enrollerresponse;
	}
	public void deleteenroll(Long id) {
		
		enrollRepo.deleteById(id);
	}
   public List<String>findAllEmails(Long courseid) {
	   List<String> allmails= courseRepo.findById(courseid).get().getEnrolllist().stream()
	              .map(modu -> modu.getUser().getEmail())
	              .collect(Collectors.toList());
	   return allmails;
   }
>>>>>>> Stashed changes
}
