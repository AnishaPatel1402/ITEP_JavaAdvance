package com.info.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.info.entity.Product;
import com.info.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@PostMapping
	@ResponseBody
	public Product save(@RequestBody Product p) {
		
		System.out.println("Product saved successfully");
		return service.saveProduct(p);
	}
	
	@GetMapping
	@ResponseBody
	public List<Product> getProducts(){
		return service.getAllProducts();
	}
	
	@GetMapping("/id")
	@ResponseBody
	public Product getProductById(@RequestParam int id){
		return service.getProductById(id);
	}
	
	@PutMapping
	@ResponseBody
	public Product update(@RequestBody Product p) {
		return service.updateProduct(p);
	}
	
	@DeleteMapping
	@ResponseBody
	public Product delete(@RequestBody Product p) {
		return service.deleteProduct(p.getId());
	}
}
