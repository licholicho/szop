package shopservlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shopDAO.ProductDAO;
import cart.ShoppingCart;
import cart.Visitable;

@WebServlet("/remove/*")
public class RemoveProductServlet  extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");
		 ProductDAO productdao = (ProductDAO) getServletContext().getAttribute("productDAO");
		 String ids = request.getPathInfo();
		 String regex = "[0-9]+"; 
		 ids = ids.substring(1);
		 if (ids.matches(regex)) {
		 int id = Integer.valueOf(ids);
		 Visitable product = cart.getList().get(id);
		 cart.removeProduct(product);
		 }
		 RequestDispatcher view = request.getRequestDispatcher("/cart");
	     view.forward(request, response);
		 
	}
	

		
		 
		 
	 }

