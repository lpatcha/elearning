package com.application.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.demo.entity.CourseEntity;
import com.application.demo.entity.Enrollment;
<<<<<<< Updated upstream
=======
import com.application.demo.entity.UserFullDetails;
>>>>>>> Stashed changes
import com.application.demo.repository.CourseRepository;
import com.application.demo.repository.EnrollmentRepository;
@Service
public class EnrollmentService {
   @Autowired
   EnrollmentRepository enrollRepo;
   @Autowired
	private CourseRepository courseRepo;
	public Enrollment addNewCourse(Enrollment enrollment,String courseid) {
	 CourseEntity course=courseRepo.findById(Long.parseLong(courseid)).get();
	 Enrollment enroll=new Enrollment();
	 enroll.setEnrolledusername(enrollment.getEnrolledusername());
	 enroll.setCourse(course);
	 course.getEnrolllist().add(enroll);
	  return  enrollRepo.save(enroll);
	}
<<<<<<< Updated upstream
	public List<Enrollment> getAllEnrollUsers(String id) {
		List<Enrollment> enrollers= courseRepo.findById(Long.parseLong(id)).get().getEnrolllist();
		return enrollers;
=======
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
>>>>>>> Stashed changes
	}
	public void deleteenroll(Long id) {
		
		enrollRepo.deleteById(id);
	}

}
