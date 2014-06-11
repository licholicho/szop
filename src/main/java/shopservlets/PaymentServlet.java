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

import payment.CreditCardStrategy;
import payment.PayPalStrategy;
import payment.PaymentStrategy;
import cart.ShoppingCart;

@WebServlet("/payment")
public class PaymentServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");
		PaymentStrategy ps = null;
     	String shipping = request.getParameter("pay");
     	if (shipping != null) {
     		 PrintWriter out = response.getWriter();
     		 out.println(shipping);
     	if(shipping.equals("PayPalStrategy")) {
     		ps = new PayPalStrategy();
     	}     	else if (shipping.equals("CreditCardStrategy")) {
     		ps = new CreditCardStrategy();
     	}
	}
          	
     	Message m = new Message();
     	m.setLoginMessage(ps.pay(cart.calcTotalCost()));
     	request.setAttribute("msg", m);
     	RequestDispatcher view = request.getRequestDispatcher("payment.jsp");
	    view.forward(request, response);
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		RequestDispatcher view = request.getRequestDispatcher("payment.jsp");
	    view.forward(request, response);
	}
}