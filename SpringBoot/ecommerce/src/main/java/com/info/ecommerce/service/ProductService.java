package com.info.ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.info.ecommerce.dto.ProductDto;
import com.info.ecommerce.entity.Category;
import com.info.ecommerce.entity.Product;
import com.info.ecommerce.exception.ResourceNotFound;
import com.info.ecommerce.repo.CategoryRepository;
import com.info.ecommerce.repo.ProductRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductService {
	private ProductRepository productRepo;
	private CategoryRepository categoryRepo;

	public ProductService(ProductRepository productRepo, CategoryRepository categoryRepo) {
		this.productRepo = productRepo;
		this.categoryRepo = categoryRepo;
	}

	@Transactional
	public ProductDto saveProduct(int categoryId, Product p) {
		Category dbCategory = categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFound("category not found"));
		ProductDto dto = new ProductDto();

		p.setCategory(dbCategory);
		productRepo.save(p);

		dto.setId(p.getId());
		dto.setBrand(p.getBrand());
		dto.setPrice(p.getPrice());
		dto.setTitle(p.getTitle());
		dto.setCategoryId(dbCategory.getId());
		dto.setCategoryName(dbCategory.getCategoryName());

		return dto;
	}

	@Transactional
	public List<ProductDto> saveProductInBulk(int categoryId, List<Product> list) {
		Category dbCategory = categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFound("category not found"));
		List<ProductDto> dtoList = new ArrayList<ProductDto>();
		for (Product product : list) {
			product.setCategory(dbCategory);
		}

		productRepo.saveAll(list);

		for (Product p : list) {
			ProductDto dto = new ProductDto();
			dto.setId(p.getId());
			dto.setBrand(p.getBrand());
			dto.setPrice(p.getPrice());
			dto.setTitle(p.getTitle());
			dto.setCategoryId(dbCategory.getId());
			dto.setCategoryName(dbCategory.getCategoryName());
			dtoList.add(dto);
		}
		return dtoList;
	}
	
	
	public List<ProductDto> getProductList(){
		List<Product> productList = productRepo.findAll();
		List<ProductDto> dtoList = new ArrayList<ProductDto>();

		for (Product p : productList) {
			ProductDto dto = new ProductDto();
			dto.setId(p.getId());
			dto.setBrand(p.getBrand());
			dto.setPrice(p.getPrice());
			dto.setTitle(p.getTitle());
			dto.setCategoryId(p.getCategory().getId());
			dto.setCategoryName(p.getCategory().getCategoryName());
			dtoList.add(dto);
		}
		return dtoList;
	}
	
	
	public List<ProductDto> getProductPages(int page, int size){
		Pageable pageable = PageRequest.of(page, size);
		Page<Product> pageItem =  productRepo.findAll(pageable);
		List<Product> productList = pageItem.getContent();
		
		List<ProductDto> dtoList = new ArrayList<ProductDto>();
		for(Product p: productList) {
			ProductDto dto = new ProductDto();
			dto.setId(p.getId());
			dto.setTitle(p.getTitle());
			dto.setBrand(p.getBrand());
			dto.setPrice(p.getPrice());
			dto.setCategoryId(p.getCategory().getId());
			dto.setCategoryName(p.getCategory().getCategoryName());
			dtoList.add(dto);
		}
		return dtoList;
	}

}
