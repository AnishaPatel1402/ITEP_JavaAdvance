package com.info.crudapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.info.crudapi.entitty.Admin;
import com.info.crudapi.entitty.Product;
import com.info.crudapi.service.AdminService;
import com.info.crudapi.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService pService;
	
	@Autowired
	private AdminService aService;
	
	//POST: http://localhost:8080/product
	@PostMapping
	public ResponseEntity<Product> save(@RequestBody Product p){
		try {
			Product dbProduct = pService.saveProduct(p);
			return ResponseEntity.status(201).body(dbProduct);
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build();
		}
	}
	
	//GET: http://localhost:8080/product
	@GetMapping()
	public ResponseEntity<List<Product>> getAll(){
		try {
			List<Product> list = pService.getAllProducts();
			return ResponseEntity.ok(list);
			
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build();
		}
	}
	
	
	//GET: http://localhost:8080/product/3
	@GetMapping("/{id}")
	public ResponseEntity<Product> get(@PathVariable int id){
		try {
			Product dbProduct = pService.getProduct(id);
			if(dbProduct!=null) ResponseEntity.ok(dbProduct);
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build();
		}
	}

	//PUT: http://localhost:8080/product/4
	@PutMapping("/{id}")
	public ResponseEntity<Product> update(@PathVariable int id, @RequestBody Product p){
		try {
			Product dbProduct = pService.updateProduct(id,p);
			if(dbProduct != null) {
				return ResponseEntity.ok(dbProduct);
			}
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build();
		}
	}
	
	//DELETE: http://localhost:8080/product/5
	@DeleteMapping("/{id}")
	public ResponseEntity<Product> delete(@PathVariable int id){
		try {
			Product dbProduct = pService.deleteProduct(id);
			if(dbProduct != null) {
				return ResponseEntity.ok(dbProduct);
			}
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build();
		}
	}
	
	
	//it should be in admin controller
	@GetMapping("/admin")
	public ResponseEntity<Admin> login(@RequestBody Admin admin){
		Admin dbAdmin = aService.validate(admin);
		if(dbAdmin != null) return ResponseEntity.ok(dbAdmin);
		return ResponseEntity.notFound().build();
	}
}
