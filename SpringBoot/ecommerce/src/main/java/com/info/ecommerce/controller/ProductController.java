package com.info.ecommerce.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.info.ecommerce.dto.ProductDto;
import com.info.ecommerce.entity.Product;
import com.info.ecommerce.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {
	private ProductService service;
	public ProductController(ProductService service) {
		this.service = service;
	}
	
	@PostMapping("/{categoryId}")
	public ResponseEntity<ProductDto> saveProduct(@PathVariable int categoryId, @RequestBody Product p){
		ProductDto dbProduct = service.saveProduct(categoryId,p);
		return ResponseEntity.status(HttpStatus.CREATED).body(dbProduct);
	}
	
	@PostMapping("/{categoryId}/bulk")
	public ResponseEntity<List<ProductDto>> saveProductBulk(@PathVariable int categoryId, @RequestBody List<Product> list){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.saveProductInBulk(categoryId, list));
	}
	
	@GetMapping
	public ResponseEntity<List<ProductDto>> getProductList(){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.getProductList());
	}
	
	
	//GET : http://localhost:8080/api/product/page?page=0&size=2
	@GetMapping("/page")
	public ResponseEntity<List<ProductDto>> getProductPages(@RequestParam int page, @RequestParam int size){
		return ResponseEntity.ok(service.getProductPages(page, size));
	}
}
