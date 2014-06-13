package shopservlets;

import helpers.Message;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	

          	
     	Message m = new Message();

     	request.setAttribute("msg", m);
     	RequestDispatcher view = request.getRequestDispatcher("payment.jsp");
	    view.forward(request, response);
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		RequestDispatcher view = request.getRequestDispatcher("payment.jsp");
	    view.forward(request, response);
	}
}