package com.demo;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.demo.entity.Product;
import com.demo.service.ProductService;


@SpringBootApplication
public class Springboot1Application {

	public static void main(String[] args) {
		ApplicationContext context =  SpringApplication.run(Springboot1Application.class, args);
		ProductService service = context.getBean(ProductService.class);
		
//		Product p = new Product();
//		p.setTitle("Samsung J2");
//		p.setPrice(15000f);
//		
//		Product dbProduct = service.saveProduct(p);
//		if(dbProduct!=null) System.out.println("product saved");
//		else System.out.println("product not saved");
		
		
//		Product p = new Product();
//		p.setId(3);
//		p.setTitle("My Marker");
//		p.setPrice(50f);
//		
//		
//		Product dbProduct = service.updateProduct(p);
//		if(dbProduct!=null) System.out.println("product updated");
//		else System.out.println("product not updated");
		
		
		
//		Product dbProduct = service.deleteProduct(3);
//		if(dbProduct!=null) System.out.println("product deleted");
//		else System.out.println("product not deleted");
		
		
		
//		List<Product> list = service.getAllProducts();
//		for(Product p : list) {
//			System.out.println(p.getId()+ "  "+ p.getTitle() + "  "+ p.getPrice());
//		}
	
	Product dbProduct = service.getProductById(4);
	System.out.println(dbProduct.getId()+ "  "+ dbProduct.getTitle() + "  "+ dbProduct.getPrice());
	
	
	}
	
}
