package com.application.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

//public class EmailService {
//
//}
@Service
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;
<<<<<<< Updated upstream
=======
    
    @Autowired
    private EnrollmentService enrollmentService;
>>>>>>> Stashed changes

    public void sendRegistrationEmail(String recipientEmail, String registrationToken) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(recipientEmail);
        message.setSubject("Student Registration");
        message.setText("Click the link below to complete your registration:\n" +
                "http://localhost:4200/registration?email=" + recipientEmail );

        javaMailSender.send(message);
    }
<<<<<<< Updated upstream
=======
    
    public void sendAnnouncementEmail(Long courseid,String title, String description) {
        List<String> userEmails = enrollmentService.findAllEmails(courseid); // Implement this method in your repository
        
        for (String email : userEmails) {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(email);
            message.setSubject("Announcement: " + title);
            message.setText("Dear User,\n\n" + description + "\n\nBest regards,\n Illinois state university");
            

            
            javaMailSender.send(message);
        }
    }
    
>>>>>>> Stashed changes
}

