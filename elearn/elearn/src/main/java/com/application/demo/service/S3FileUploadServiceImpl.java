package com.application.demo.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.application.demo.entity.AssignmentEntity;
import com.application.demo.entity.CourseEntity;
import com.application.demo.repository.AssignmentRepository;
import com.application.demo.repository.CourseRepository;


@Service
public class S3FileUploadServiceImpl implements S3FileUploadService {

  private String s3BaseUrl = "https://s3-us-east-1.s3.amazonaws.com/";

  private String bucketName = "elearningsystem";

  private String folderName = "/lms/";

  @Autowired
  private AmazonS3 s3Client;
  
  @Autowired
  private AssignmentRepository assignmentRepository;
  
  
  @Autowired
  private CourseRepository courseRepository;

  public Map<String, String> uploadFileToS3(MultipartFile multipartfile, String title, String description, Long courseId) {
	    Map<String, String> response = new HashMap<>();

	    if (multipartfile != null && !multipartfile.isEmpty()) {
	        // Generate a unique file name to avoid overwriting
	        String uniqueFileName = UUID.randomUUID().toString() + "_" + multipartfile.getOriginalFilename();

	        File file = new File(uniqueFileName);

	        try (FileOutputStream fos = new FileOutputStream(file)) {
	            if (!file.exists()) {
	                file.createNewFile();
	            }

	            fos.write(multipartfile.getBytes());
	            fos.flush();

	            /* uploading file to S3 */
	            s3Client.putObject(new PutObjectRequest(bucketName, folderName + "/" + uniqueFileName, file)
	                .withCannedAcl(CannedAccessControlList.PublicRead));

	            
	            String s3FileAccessUrl = s3BaseUrl.concat(bucketName).concat(folderName)
	                .concat(uniqueFileName).replaceAll("\\s", "+");

	            response.put("fileUrl", s3FileAccessUrl);

	            // Create an AssignmentEntity and set the title, description, and file URL
	            Optional<CourseEntity> course = courseRepository.findById(courseId);
	            AssignmentEntity assignment = new AssignmentEntity();
	            assignment.setTitle(title);
	            assignment.setDescription(description);
	            assignment.setFileUrl(s3FileAccessUrl);
	            assignment.setFileName(uniqueFileName);
	            
//	            course.ifPresent(courseOp -> {
//	            	CourseEntity courseOp = course.get();
//	                assignment.setCourse(courseOp);
//	            });

	            if (course.isPresent()) {
	                CourseEntity courseOp = course.get();
	                assignment.setCourse(courseOp);
	            }
	            //assignment.setCourse(course);
	            // Save the AssignmentEntity to the database
	            assignmentRepository.save(assignment);
	            response.put("fileName", uniqueFileName);
	            //courseRepository.save(course);
<<<<<<< Updated upstream

=======
	            course.get().getAssignments().add(savedassign);
	            courseRepository.save(course.get());
>>>>>>> Stashed changes
	            file.delete();
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    return response;
	}
  
  public void deleteFile(Long fileId) {
	    // get filename by id from your database
	  AssignmentEntity a = new AssignmentEntity();
	  a=assignmentRepository.findById(fileId)
		      .orElse(null);
	    String filename = a.getFileName();
	    String keyName = filename;
	    s3Client.deleteObject(bucketName, keyName);
	    assignmentRepository.delete(a);
	  }
  
  
<<<<<<< Updated upstream
=======
  public List<String> getFileNamesByCourseId(String courseId) {
      return assignmentRepository.findFileNamesByCourseId(courseId);
      
  }
 //  public Map<String, String> uploadSubmissionToS3(MultipartFile multipartfile,  String userid, String assignid) {
//	    Map<String, String> response = new HashMap<>();
//
//	    if (multipartfile != null && !multipartfile.isEmpty()) {
//	        // Generate a unique file name to avoid overwriting
//	        String uniqueFileName = UUID.randomUUID().toString() + "_" + multipartfile.getOriginalFilename();
//
//	        File file = new File(uniqueFileName);
//
//	        try (FileOutputStream fos = new FileOutputStream(file)) {
//	            if (!file.exists()) {
//	                file.createNewFile();
//	            }
//
//	            fos.write(multipartfile.getBytes());
//	            fos.flush();
//
//	            /* uploading file to S3 */
//	            s3Client.putObject(new PutObjectRequest(bucketName, folderName + "/" + uniqueFileName, file)
//	                .withCannedAcl(CannedAccessControlList.PublicRead));
//
//	            
//	            String s3FileAccessUrl = s3BaseUrl.concat(bucketName).concat(folderName)
//	                .concat(uniqueFileName).replaceAll("\\s", "+");
//
//	            response.put("fileUrl", s3FileAccessUrl);
//	            Optional<UserFullDetails> user = userFullDetailsRepository.findByEmail(userid);
//	            Optional<AssignmentEntity> assignment = assignmentRepository.findById((long) Integer.parseInt(assignid));
//	            assignmentsubmEntity submission=new assignmentsubmEntity();
//	            submission.setAssignment(assignment.get());
//	            submission.setSubuser(user.get());
//	            Date currentDate = new Date();
//	            submission.setSubmitteddate(currentDate);
//	            submission.setFileUrl(s3FileAccessUrl);
//	            submission.setFileName(uniqueFileName);
//	            user.get().getSubmissionlist().add(submission);
//	            assignment.get().getAssignmentsubmissions().add(submission);
//	            assignmentSubmission.save(submission);
//	            // Create an AssignmentEntity and set the title, description, and file URL
////	            Optional<CourseEntity> course = courseRepository.findById((long) Integer.parseInt(courseId));
////	            AssignmentEntity assignment = new AssignmentEntity();
////	            assignment.setTitle(title);
////	            assignment.setDescription(description);
////	            assignment.setFileUrl(s3FileAccessUrl);
////	            assignment.setFileName(uniqueFileName);
////	            
//////	            course.ifPresent(courseOp -> {
//////	            	CourseEntity courseOp = course.get();
//////	                assignment.setCourse(courseOp);
//////	            });
////
////	            if (course.isPresent()) {
////	                CourseEntity courseOp = course.get();
////	                assignment.setCourse(courseOp);
////	            }
////	            //assignment.setCourse(course);
////	            // Save the AssignmentEntity to the database
////	            assignmentRepository.save(assignment);
//	            
//	            response.put("fileName", uniqueFileName);
//	            //courseRepository.save(course);
//
//	            file.delete();
//	        } catch (FileNotFoundException e) {
//	            e.printStackTrace();
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	        }
//	    }
//	    return response;
//	}
//  public List<assignsubmissions> getsubmissions(String assignid){
//	  
//	    AssignmentEntity assignment=assignmentRepository.findById(Long.parseLong(assignid)).get();
//		List<UserFullDetails> allusers=assignment.getCourse().getEnrolllist().stream().map(enroll->enroll.getUser()).toList();
//		List<assignmentsubmEntity>assignmentsubmissions=assignment.getAssignmentsubmissions();
//		List<assignsubmissions> result=new ArrayList<>();
//		for(UserFullDetails i:allusers) {
//			assignsubmissions res=new assignsubmissions();
//			res.setStatus("not submitted");
//			for(assignmentsubmEntity j:assignmentsubmissions) {
//				if(j.getSubuser().getId().equals(i.getId())) {
//					res.setFilename(j.getFileName());
//					res.setSubmissionid(j.getId());
//					res.setSubmitteddate(j.getSubmitteddate());
//					res.setTotalmarks(j.getAssignment().getTotalmarks());
//					res.setStatus("submitted");
//				}
//				
//			}
//			res.setDept(i.getDept());
//			res.setEmail(i.getEmail());
//			res.setName(i.getName());
//			result.add(res);
//		}
//		return result;
//		
//  }
  public void deleteassignment(long assignmentId) {
	  Optional<AssignmentEntity> assignmentOptional = assignmentRepository.findById(assignmentId);

      assignmentOptional.ifPresent(assignment -> {
          // Remove associated submissions
          List<assignmentsubmEntity> submissions = assignment.getAssignmentsubmissions();
//          for (assignmentsubmEntity submission : submissions) {
//              submission.setAssignment(null); // Break the relationship to avoid deletion constraints
//          }
//          submissions.clear(); // Remove submissions from assignment

          // Delete the assignment
          assignment.setDeleted(true);
          assignmentRepository.save(assignment);
      });
  }
  
>>>>>>> Stashed changes

}