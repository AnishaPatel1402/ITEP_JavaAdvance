package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Product;

import java.io.IOException;

import dao.AdminDao;
import dao.ProductDao;


//@WebServlet("/AddProductServlet")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public AddProductServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		int price = Integer.parseInt(request.getParameter("price"));
		String brand = request.getParameter("brand");
		
		
		Product product = new Product();
		product.setTitle(title);
		product.setPrice(price);
		product.setBrand(brand);
		
		if(ProductDao.saveProduct(product)) {
			System.out.println("Product added successfull");
			response.sendRedirect("addProduct.jsp");
		}else {
			System.out.println("Error!");
		}
		
	}

}
