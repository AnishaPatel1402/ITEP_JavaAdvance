package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Product;

import java.io.IOException;
import java.io.PrintWriter;

import dao.ProductDao;

/**
 * Servlet implementation class EditProductSevlet
 */
@WebServlet("/EditProductSevlet")
public class EditProductSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EditProductSevlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		int price = Integer.parseInt(request.getParameter("price"));
		String brand = request.getParameter("brand");
		
		PrintWriter out = response.getWriter();
		Product p = new Product();
		p.setId(id);
		p.setTitle(title);
		p.setPrice(price);
		p.setBrand(brand);
		
		if(ProductDao.editProduct(p)) {
			response.sendRedirect("./ViewProductServlet");
		}else {
			out.print("Error");
		}
	}

}
