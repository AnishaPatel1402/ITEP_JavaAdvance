package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import dao.ProductDao;

/**
 * Servlet implementation class ViewProductServlet
 */
//@WebServlet("/ViewProductServlet")
public class ViewProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewProductServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Product> productList = ProductDao.getAllProduct();
		

		if (productList != null) {
			PrintWriter out = response.getWriter();
			out.print("<html>");
			out.print("<body>");
			out.print("<table border='1'>");
			out.print("<tr>");
			out.print("<td>Id</td>");
			out.print("<td>Title</td>");
			out.print("<td>Brand</td>");
			out.print("<td>Price</td>");
			out.print("<td>Edit</td>");
			out.print("<td>Delete</td>");
			out.print("</tr>");
			for (Product p : productList) {
				out.print("<tr>");
				out.print("<td>" + p.getId() + "</td>");
				out.print("<td>" + p.getTitle() + "</td>");
				out.print("<td>" + p.getBrand() + "</td>");
				out.print("<td>" + p.getPrice() + "</td>");
				out.print("<td><a href='editProduct.jsp?id=" + p.getId() + "'><button>Edit</button></a></td>");
				out.print("<td><a href='./DeleteProductServlet?id=" + p.getId() + "'><button>Delete</button></a></td>");
				out.print("</tr>");

			}
			out.print("</table>");
			out.print("</body>");
			out.print("</html>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
