package shopservlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.Product;
import shopiDAO.IProductDAO;
import cart.ShoppingCart;

@WebServlet("/add")
public class AddProductServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute(
				"cart");
		IProductDAO productdao = (IProductDAO) getServletContext()
				.getAttribute("productDAO");
		String ids = request.getParameter("prodId");
		int id = Integer.valueOf(ids);
		Product product = productdao.getProduct(id);
		cart.addProduct(product);
		RequestDispatcher view = request.getRequestDispatcher("/search");
		view.forward(request, response);

	}

}
