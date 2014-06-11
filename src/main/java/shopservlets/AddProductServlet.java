package shopservlets;

import helpers.Message;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.Product;
import shopDAO.ProductDAO;
import cart.ShoppingCart;

@WebServlet(urlPatterns = {"/add/*", "/add"})
public class AddProductServlet  extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");
		 ProductDAO productdao = (ProductDAO) getServletContext().getAttribute("productDAO");
		 String ids = request.getPathInfo();
		 ids = ids.substring(1);
		 String regex = "[0-9]+";  
		 if (ids.matches(regex)) {
		 int id = Integer.valueOf(ids);
		 Product product = productdao.getProduct(id);
		 cart.addProduct(product);
		 }
		// PrintWriter a = response.getWriter();
		 //a.println(request.getServletPath());
		 Message m = new Message();
		 m.setLoginMessage("Powrot do sklepu");
		 request.getSession().setAttribute("back", m);
		 RequestDispatcher view = request.getRequestDispatcher("/add");
	     view.forward(request, response);
		 
	}
	

		
		 
		 
	 }

