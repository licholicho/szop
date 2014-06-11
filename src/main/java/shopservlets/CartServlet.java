package shopservlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cart.Shipping;
import cart.ShoppingCart;
import cart.Visitable;
import decorators.ZlotyDekorator;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");
		
     	String shipping = request.getParameter("shipping");
     	if (shipping != null) {
     		 PrintWriter out = response.getWriter();
     		 out.println(shipping);
     	if(shipping.equals("Kurier")) {
     		cart.addProduct(new Shipping(shipping, 15.0));
     		 out.println(cart.getList().size());
     	}     	else if (shipping.equals("Poczta Polska")) {
     		cart.addProduct(new Shipping(shipping, 12.0));
     	}
	}
 
     	request.getSession().setAttribute("cart", cart);
     	RequestDispatcher view = request.getRequestDispatcher("cart.jsp");
	    view.forward(request, response);
	 
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	 private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	    
			RequestDispatcher view = request.getRequestDispatcher("cart.jsp");
		    view.forward(request, response);
		 
	 }
}
