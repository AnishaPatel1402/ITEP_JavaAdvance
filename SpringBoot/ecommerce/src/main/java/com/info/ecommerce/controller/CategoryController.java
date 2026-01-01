package com.info.ecommerce.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.info.ecommerce.dto.CategoryDto;
import com.info.ecommerce.entity.Category;
import com.info.ecommerce.service.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
	
	private CategoryService service;
	public CategoryController(CategoryService service) {
		this.service = service;
	}
	
	@PostMapping
	public ResponseEntity<CategoryDto> save(@RequestBody Category c){
		CategoryDto dto = service.save(c);
		return ResponseEntity.ok(dto);
	}
	
	@PostMapping("/bulk")
	public ResponseEntity<List<CategoryDto>> saveInBulk(@RequestBody List<Category> c){
		return ResponseEntity.ok(service.saveInBulk(c));
	}
	
	@GetMapping
	public ResponseEntity<List<CategoryDto>> fetchAllCategories(){
		return ResponseEntity.ok(service.fetchAllCategories());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CategoryDto> fetchCategory(@PathVariable int id){
		return ResponseEntity.ok(service.fetchCategory(id));
	}
}


