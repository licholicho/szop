package shopservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.Category;
import shop.Product;
import shopiDAO.ICategoryDAO;
import shopiDAO.IProductDAO;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	 private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    response.setContentType("text/html;charset=UTF-8");
	        request.setCharacterEncoding("UTF-8");
	        String productToSearch = request.getParameter("product");
	        String category = request.getParameter("category");
	        PrintWriter p = response.getWriter();
	      
	        int page = 1;
	        if (request.getParameter("page") != null) {
	            page = Integer.parseInt(request.getParameter("page"));
	        }
	        
	        int recordsPerPage = 5;
	        
	        IProductDAO productdao = (IProductDAO) getServletContext().getAttribute("productDAO");
	        ICategoryDAO categorydao = (ICategoryDAO) getServletContext().getAttribute("categoryDAO");
	        List<Product> prodList = productdao.viewProductsByCategory(productToSearch, category, (page - 1) * recordsPerPage, recordsPerPage);
	        List<Product> all = productdao.viewAllProducts((page - 1) * recordsPerPage, recordsPerPage);
	        List<Category> catList = categorydao.viewAllCategories();
	        request.setAttribute("categoryList", catList);
	        request.setAttribute("productList", prodList);
	        request.setAttribute("allList", all);
	        request.setAttribute("liczba", prodList.size());
	        int noOfRecords = productdao.getNoOfRecords();
	        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
	        request.setAttribute("noOfPagesS", noOfPages);
	        request.setAttribute("currentPageS", page);
	        RequestDispatcher dis = request.getRequestDispatcher("search.jsp");
	        dis.forward(request, response);
	 }
}
