package com.info.crudapi.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.info.crudapi.CrudapiApplication;
import com.info.crudapi.entitty.Admin;
import com.info.crudapi.entitty.Product;
import com.info.crudapi.repo.ProductRepository;

@Service
public class ProductService {

	private ProductRepository repo;
	
	public ProductService(ProductRepository repo) {
		this.repo = repo;
	}
	
	public Product saveProduct(Product p) {
		Product dbProduct = repo.save(p);
		return dbProduct;
	}
	
	public Product getProduct(int id) {
		Product dbProduct = repo.findById(id).orElse(null);
		return dbProduct;
	}
	
	public List<Product> getAllProducts(){
		return repo.findAll();
	}
	
	public Product updateProduct(int id, Product p) {
		Product dbProduct = repo.findById(id).orElse(null);
		if(dbProduct != null) {
			dbProduct.setTitle(p.getTitle());
			dbProduct.setBrand(p.getBrand());
			dbProduct.setPrice(p.getPrice());
			
			return repo.save(dbProduct);
		}
		return dbProduct;
	}
	
	public Product deleteProduct(int id) {
		Product dbProduct = repo.findById(id).orElse(null);
		if(dbProduct != null) repo.delete(dbProduct);
		return dbProduct;
	}
}
