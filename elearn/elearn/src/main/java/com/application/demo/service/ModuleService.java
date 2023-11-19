package com.application.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.demo.entity.ModuleEntity;
<<<<<<< Updated upstream
=======
import com.application.demo.entity.VideoContent;
>>>>>>> Stashed changes
import com.application.demo.repository.ModuleRepository;
@Service
public class ModuleService {
	@Autowired
	ModuleRepository modulerepo;
<<<<<<< Updated upstream
=======
	 @Autowired
	    private VideoContentRepository videoContentRepository;
	 
>>>>>>> Stashed changes
	 public List<ModuleEntity> getModulesByCourseAndInstructor(String courseName, String instructorName) {
		 System.out.println(modulerepo.findByCoursenameAndInstructorname(courseName, instructorName));
	        return modulerepo.findByInstructornameAndCoursename(instructorName,courseName);
	    }
	public ModuleEntity savemodule(ModuleEntity module) {
		return modulerepo.save(module);
	}
	public List<ModuleEntity> getAllModules() {
		// TODO Auto-generated method stub
		return modulerepo.findAll();
	}
<<<<<<< Updated upstream
=======
	public ModuleEntity findModule(String moduleName, String courseName, String instructorName) {
        Optional<ModuleEntity> moduleOptional = modulerepo.findByModulenameAndCoursenameAndInstructorname(moduleName, courseName, instructorName);
        if(moduleOptional.isPresent())
        	return moduleOptional.get();
        else
        	return null;
    }
	 public void deleteModuleAndContents(Long moduleId) {
	        ModuleEntity module = modulerepo.findById(moduleId)
	                .orElseThrow(() -> new EntityNotFoundException("Module not found with id: " + moduleId));

	        // Delete associated video contents
	        List<VideoContent> videoContents = module.getVideoContents();
	        for (VideoContent videoContent : videoContents) {
	            videoContentRepository.delete(videoContent);
	        }
	        

	        // Now delete the module itself
	        module.setVideoContents(null);
	        modulerepo.delete(module);
	    }
	 public ModuleEntity updateModule(Long moduleId, String updatedModule) {
	        ModuleEntity existingModule = modulerepo.findById(moduleId)
	                .orElseThrow(() -> new EntityNotFoundException("Module not found with id: " + moduleId));

	        // Update module properties
	        existingModule.setModulename(updatedModule);
//	        existingModule.setCoursename(updatedModule.getCoursename());
//	        existingModule.setInstructorname(updatedModule.getInstructorname());

	        // If you need to update associated video content, you can do so here

	        // Save the updated module
	        return modulerepo.save(existingModule);
	    }
>>>>>>> Stashed changes
}
