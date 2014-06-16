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

@WebServlet("/delete")
public class DeleteProductServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		IProductDAO productdao = (IProductDAO) getServletContext().getAttribute("productDAO");
		String prodId = request.getParameter("prodIdA");
		productdao.deleteProduct(Integer.valueOf(prodId));
		RequestDispatcher view = request.getRequestDispatcher("/browse");
		view.forward(request, response);

	}

}
