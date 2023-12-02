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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.demo.entity.CourseEntity;
import com.application.demo.entity.ModuleEntity;
<<<<<<< Updated upstream
=======
import com.application.demo.entity.VideoContent;
import com.application.demo.repository.CourseRepository;
import com.application.demo.repository.ModuleRepository;
>>>>>>> Stashed changes
import com.application.demo.service.ModuleService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/modules")
public class Modulescontroller {
	@Autowired
	ModuleService moduleService;
<<<<<<< Updated upstream
	 @PostMapping("/add")
    public ModuleEntity addModule(@RequestBody ModuleEntity module) {
        return moduleService.savemodule(module);
    }
=======
	@Autowired
	ModuleRepository modulerepo;
	@Autowired
	private CourseRepository courseRepo;
	

	 @PostMapping("/add")
	    public ResponseEntity<?> addModule(@RequestBody ModuleEntity module) {
		 Optional<CourseEntity> course=courseRepo.findById(module.getId());
		 List<ModuleEntity> moduleslist=course.get().getModuleslist();
		 List<ModuleEntity> singlemodule = moduleslist.stream()
	                .filter(modu -> modu.getModulename().equals(module.getModulename()))
	                .collect(Collectors.toList());
//			 ModuleEntity exist=moduleService.findModule(module.getModulename(),module.getCoursename(),module.getInstructorname());
		    	if(singlemodule.size()>0) {
		    		return ResponseEntity.status(HttpStatus.CONFLICT).body("module already exists");
		    	}
		    	
		         return ResponseEntity.ok(moduleService.savemodule(module));
	    }
>>>>>>> Stashed changes

    @GetMapping("/list")
    public List<ModuleEntity> listModules() {
        return moduleService.getAllModules();
    }

<<<<<<< Updated upstream
    @GetMapping("/getmodules/{instructor}/{course}")
    public List<ModuleEntity> getModulesByCourseAndInstructor(
            @PathVariable String course,
            @PathVariable String instructor
=======

    @GetMapping("/getmodulesbyid/{id}")
    public List<ModuleEntity> getModulesById(
            @PathVariable Long id
>>>>>>> Stashed changes
    ) {
    	 Optional<CourseEntity> course=courseRepo.findById(id);
    	return course.get().getModuleslist();
    }
<<<<<<< Updated upstream
=======
    @DeleteMapping("/{moduleId}")
    public void deleteModule(@PathVariable Long moduleId) {
        moduleService.deleteModuleAndContents(moduleId);
    }
    @PutMapping("/{moduleId}/{updatedModule}")
    public ResponseEntity<?> updateModule(@PathVariable Long moduleId, @PathVariable String  updatedModule) {

    	CourseEntity modi=modulerepo.findById(moduleId).get().getCourse();
//         Optional<CourseEntity> course=courseRepo.findById(moduleId);
		 List<ModuleEntity> moduleslist=modi.getModuleslist();
		 List<ModuleEntity> singlemodule = moduleslist.stream()
	                .filter(modu -> modu.getModulename().equals(updatedModule))
	                .collect(Collectors.toList());
//			 ModuleEntity exist=moduleService.findModule(module.getModulename(),module.getCoursename(),module.getInstructorname());
		    	if(singlemodule.size()>0) {
		    		return ResponseEntity.status(HttpStatus.CONFLICT).body("module already exists");
		    	}
		    	
		         return ResponseEntity.ok(moduleService.updateModule(moduleId, updatedModule));
    }
>>>>>>> Stashed changes
}
