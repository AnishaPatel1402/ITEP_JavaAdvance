package com.info.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.info.entity.Product;
import com.info.repo.ProductRepo;

@Service
public class ProductService {
	
	private ProductRepo repo;
	
	public ProductService(ProductRepo repo) {
		this.repo = repo;
	}
	
	public Product saveProduct(Product p) {
		return repo.save(p);
	}
	
	public List<Product> getAllProducts(){
		return repo.findAll();
	}
	
	public Product getProductById(int id) {
		return repo.findById(id).orElse(null);
	}
	
	public Product updateProduct(Product p) {
		Product dbProduct = repo.findById(p.getId()).orElse(null);
		if(dbProduct!=null) {
			dbProduct.setTitle(p.getTitle());
			dbProduct.setPrice(p.getPrice());
			return repo.save(dbProduct);
		}
		return null;
	}
	
	public Product deleteProduct(int id) {
		Product dbProduct = repo.findById(id).orElse(null);
		if(dbProduct!=null) {
			repo.delete(dbProduct);
			return dbProduct;
		}
		return null;
	}
}
