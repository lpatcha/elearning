package com.application.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.demo.entity.ModuleEntity;
import com.application.demo.service.ModuleService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/modules")
public class Modulescontroller {
	@Autowired
	ModuleService moduleService;
<<<<<<< Updated upstream
=======
	@Autowired
	ModuleRepository modulerepo;
	@Autowired
	private CourseRepository courseRepo;
	

>>>>>>> Stashed changes
	 @PostMapping("/add")
    public ModuleEntity addModule(@RequestBody ModuleEntity module) {
        return moduleService.savemodule(module);
    }

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
        return moduleService.getModulesByCourseAndInstructor(course, instructor);
    }
    @DeleteMapping("/{moduleId}")
    public ResponseEntity<String> deleteModule(@PathVariable Long moduleId) {
        moduleService.deleteModuleAndContents(moduleId);
        return new ResponseEntity<>("Module and associated video contents deleted successfully", HttpStatus.OK);
    }
    @PutMapping("/{moduleId}/{updatedModule}")
<<<<<<< Updated upstream
    public ResponseEntity<ModuleEntity> updateModule(@PathVariable Long moduleId, @PathVariable String  updatedModule) {
        ModuleEntity updated = moduleService.updateModule(moduleId, updatedModule);
        return new ResponseEntity<>(updated, HttpStatus.OK);
=======
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
>>>>>>> Stashed changes
    }
}
