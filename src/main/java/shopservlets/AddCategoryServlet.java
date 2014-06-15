package shopservlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shopDAO.CategoryDAO;

@WebServlet("/addcat")
public class AddCategoryServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 CategoryDAO categorydao = (CategoryDAO) getServletContext().getAttribute("categoryDAO");
		 String name = request.getParameter("newcat");
		 categorydao.addCategory(name);
		 RequestDispatcher view = request.getRequestDispatcher("/addproduct");
	     view.forward(request, response);
}
}
