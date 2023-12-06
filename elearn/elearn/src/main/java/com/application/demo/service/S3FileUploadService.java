package com.application.demo.service;

import java.util.Map;
import org.springframework.web.multipart.MultipartFile;

public interface S3FileUploadService {

  Map<String, String> uploadFileToS3(MultipartFile multipartfile, String title, String description, Long courseId);

void deleteFile(Long fileId);

<<<<<<< Updated upstream
=======
List<String> getFileNamesByCourseId(String courseId);

void deleteassignment(long parseLong);

//Map<String, String> uploadSubmissionToS3(MultipartFile multipartfile,  String userid, String assignid);
//
//List<assignsubmissions> getsubmissions(String assignid);

>>>>>>> Stashed changes
}
