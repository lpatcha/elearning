package com.application.demo.service;

import java.util.List;
<<<<<<< Updated upstream
=======
import java.util.Optional;
>>>>>>> Stashed changes

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.demo.entity.ModuleEntity;
import com.application.demo.repository.ModuleRepository;
@Service
public class ModuleService {
	@Autowired
	ModuleRepository modulerepo;
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
        return moduleOptional.get();
    }
>>>>>>> Stashed changes
}
