package shopservlets;

import helpers.Message;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.Category;
import shop.Product;
import shopDAO.CategoryDAO;
import shopDAO.ProductDAO;

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
	        
	        Message m = new Message();
	        
	        ProductDAO productdao = (ProductDAO) getServletContext().getAttribute("productDAO");
	        CategoryDAO categorydao = (CategoryDAO) getServletContext().getAttribute("categoryDAO");
	        
	        List<Product> prodList = productdao.viewProductsByCategory(productToSearch, category);
	        List<Category> catList = categorydao.viewAllCategories();
	        request.setAttribute("categoryList", catList);
	        request.setAttribute("productList", prodList);
	        m.setLoginMessage(productToSearch);
	        request.setAttribute("message", m);
	        RequestDispatcher dis = request.getRequestDispatcher("search.jsp");
	        dis.forward(request, response);
	 }
}
