package shopservlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shopiDAO.ISupplierDAO;

@WebServlet("/addsupplier")
public class AddSupplierServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 ISupplierDAO supplierdao = (ISupplierDAO) getServletContext().getAttribute("SupplierDAO");
		 String name = request.getParameter("newsup");
		 supplierdao.addSupplier(name);
		 RequestDispatcher view = request.getRequestDispatcher("/addproduct");
	     view.forward(request, response);
}
}
