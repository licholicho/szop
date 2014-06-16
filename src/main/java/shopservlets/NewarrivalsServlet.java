package shopservlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.Product;
import shopDAO.IProductDAO;

@WebServlet("/newarrivals")
public class NewarrivalsServlet extends HttpServlet  {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  processRequest(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	  private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        int page = 1;
	        if (req.getParameter("page") != null) {
	            System.out.println(req.getParameter("page"));
	            page = Integer.parseInt(req.getParameter("page"));
	        }
	        
	        int recordsPerPage = 5;
		    IProductDAO dao = (IProductDAO) getServletContext().getAttribute("productDAO");
			
	        List<Product> list = dao.viewAllProducts((page - 1) * recordsPerPage,
	                recordsPerPage);
	        req.setAttribute("liczba", list.size());
	        int noOfRecords = dao.getNoOfRecords();
	        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
	        req.setAttribute("productList", list);
	        req.setAttribute("noOfPages", noOfPages);
	        req.setAttribute("currentPage", page);
	        RequestDispatcher view = req.getRequestDispatcher("newarrivals.jsp");
	        view.forward(req, resp);
	    }
}
