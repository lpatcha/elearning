package com.application.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.application.demo.Dto.VideoContentDto;
import com.application.demo.entity.VideoContent;
import com.application.demo.service.VideoContentService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/video-content")
public class VideoContentController {

    @Autowired
    private VideoContentService videoContentService;

    @PostMapping("/add")
<<<<<<< Updated upstream
    public VideoContent addVideoContent(@RequestBody VideoContentDto videoContentDto) {
        return videoContentService.addVideoContent(videoContentDto);
    }

    @PutMapping("/update/{id}")
<<<<<<< Updated upstream
    public VideoContent updateVideoContent(@PathVariable Long id, @RequestBody VideoContentDto videoContentDto) {
        return videoContentService.updateVideoContent(id, videoContentDto);
=======
=======
    public ResponseEntity<?> addVideoContent(@RequestBody VideoContentDto videoContentDto) {
//    	VideoContent exist =videoContentService.findByContentname(videoContentDto);
//    	if(exist!=null && exist.getModule().getModulename().equals(videoContentDto.getModuleName())&& exist.getModule().getCoursename().equals(videoContentDto.getCourseName())) {
//    		return ResponseEntity.status(HttpStatus.CONFLICT).body("Video content already exists");
//    	}
//         return ResponseEntity.ok(videoContentService.addVideoContent(videoContentDto));
    	try {
    	 Optional<ModuleEntity> module=modulerepo.findById(Long.parseLong(videoContentDto.getModuleName()));
    	 List<VideoContent> contentlist=module.get().getVideoContents();
		 List<VideoContent> singlecontent = contentlist.stream()
	                .filter(modu -> modu.getContentname().equals(videoContentDto.getContentName()))
	                .collect(Collectors.toList());
//			 ModuleEntity exist=moduleService.findModule(module.getModulename(),module.getCoursename(),module.getInstructorname());
		    	if(singlecontent.size()>0) {
		    		return ResponseEntity.status(HttpStatus.CONFLICT).body("video content already exists");
		    	}
		    	
		         return ResponseEntity.ok(videoContentService.addVideoContent(videoContentDto));
    	}
    	catch(Exception e) {
    		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("create a module first and then create a video");
    	}
    }

    
    @PutMapping("/update/{id}")
>>>>>>> Stashed changes
    public ResponseEntity<?> updateVideoContent(@PathVariable Long id, @RequestBody VideoContentDto videoContentDto) {
    	Optional<VideoContent> video=videoContentRepository.findById(id);
		 List<VideoContent> contentlist=video.get().getModule().getVideoContents();
		 List<VideoContent> singlecontent = contentlist.stream()
	                .filter(modu -> modu.getContentname().equals(videoContentDto.getContentName()))
	                .collect(Collectors.toList());
//			 ModuleEntity exist=moduleService.findModule(module.getModulename(),module.getCoursename(),module.getInstructorname());
		    	if(singlecontent.size()>0) {
		    		return ResponseEntity.status(HttpStatus.CONFLICT).body("video content already exists");
		    	}
		    	
		         return ResponseEntity.ok(videoContentService.updateVideoContent(id, videoContentDto));
		         
		         

>>>>>>> Stashed changes
    }

    @DeleteMapping("/delete/{id}")
    public void deleteVideoContent(@PathVariable Long id) {
        videoContentService.deleteVideoContent(id);
    }
<<<<<<< Updated upstream
<<<<<<< Updated upstream
<<<<<<< Updated upstream
    @GetMapping("/getcoursecontent")
=======
=======
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes

    @GetMapping("/getcoursecontentbyid/{moduleid}")
>>>>>>> Stashed changes
    public List<VideoContent> getVideoContentsByInstructorCourseModule(
            @RequestParam("instructorName") String instructorName,
            @RequestParam("courseName") String courseName,
            @RequestParam("moduleName") String moduleName) {
        return videoContentService.getVideoContentsByInstructorCourseModule(instructorName, courseName, moduleName);
    }
}
