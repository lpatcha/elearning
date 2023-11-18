package com.application.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.application.demo.entity.CategoryEntity;
import com.application.demo.repository.CategoryRepository;



@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    // Get all categories
    @GetMapping
    public List<CategoryEntity> getAllCategories() {
        return categoryRepository.getAllCategoriesWithSubcategories();
    }

    // Create a new category
<<<<<<< Updated upstream
    @PostMapping
    public CategoryEntity createCategory(@RequestBody CategoryEntity category) {
        return categoryRepository.save(category);
=======
//    @PostMapping
//    public CategoryEntity createCategory(@RequestBody CategoryEntity category) {
//        return categoryRepository.save(category);
//    }
    @GetMapping("/leaf")
    public List<CategoryEntity> getAllLeafCategories() {
        return categoryService.getAllLeafCategories();
    }
    
    @PostMapping("/addcategory")
    public CategoryEntity addCategory(@RequestBody CategoryEntity category) {
        return categoryService.addCategory(category);
    }
    @PutMapping("/updatecategory/{id}/{name}")
    public CategoryEntity updateCategory(@PathVariable String id,@PathVariable String name) {
    	CategoryEntity updatecontent=categoryRepository.findById(Long.parseLong(id)).get();
    	updatecontent.setName(name);
    	return categoryRepository.save(updatecontent);
    }

    @PostMapping("/{parentCategoryId}/subcategories")
    public  String addSubcategory(
            @PathVariable String parentCategoryId,
            @RequestBody CategoryEntity subcategory
    ) {
    	CategoryEntity a=categoryService.addSubcategory(parentCategoryId, subcategory);
//        return new ResponseEntity<>(a, HttpStatus.CREATED);
    	return "successfully added";
>>>>>>> Stashed changes
    }
    
    
    @GetMapping("/maincategories")
    public List<CategoryEntity> mainCategories() {
        return categoryRepository.findByParentCategoryIsNull();
    }
    @GetMapping("/categories/{id}")
    public List<CategoryEntity> subofmainCategories(@PathVariable String id) {
    	 List<CategoryEntity> cc = new ArrayList<CategoryEntity>();
    	 List<CategoryEntity> result = new ArrayList<CategoryEntity>();
    		cc.add(categoryRepository.findById(Long.parseLong(id)).get());
        	categoryService.collectLeafCategories(cc,result);
        		return result;
    }
}
