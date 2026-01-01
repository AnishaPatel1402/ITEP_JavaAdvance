package com.info.ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.info.ecommerce.dto.CategoryDto;
import com.info.ecommerce.entity.Category;
import com.info.ecommerce.exception.ResourceNotFound;
import com.info.ecommerce.repo.CategoryRepository;

@Service
public class CategoryService {

		private CategoryRepository repo;
		public CategoryService(CategoryRepository repo) {
			this.repo = repo;
		}
		
		@Transactional
		public CategoryDto save(Category c) {
			Category dbCategory = repo.save(c);
			CategoryDto dto = new CategoryDto(dbCategory.getId(), dbCategory.getCategoryName());
			return dto;
		}
		
		@Transactional
		public List<CategoryDto> saveInBulk(List<Category> list){
			List<Category> dbList = repo.saveAll(list);
			List<CategoryDto> dtoList = new ArrayList<CategoryDto>();
			for(Category c : dbList) {
				CategoryDto dto = new CategoryDto(c.getId(),c.getCategoryName());
				dtoList.add(dto);
			}
			return dtoList;
		}
		
		
		public List<CategoryDto> fetchAllCategories(){
			List<Category> dbList = repo.findAll();
			List<CategoryDto> dtoList = new ArrayList<CategoryDto>();
			for(Category c : dbList) {
				CategoryDto dto = new CategoryDto(c.getId(),c.getCategoryName());
				dtoList.add(dto);
			}
			return dtoList;
		}
		
		
		public CategoryDto fetchCategory(int id) {
			Category dbCategory = repo.findById(id).orElseThrow(()->new ResourceNotFound("Category not exits"));
			CategoryDto dto = new CategoryDto(dbCategory.getId(),dbCategory.getCategoryName());
			return dto;
		}
}
