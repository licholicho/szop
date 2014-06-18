package shopservlets;

import java.io.IOException;
import java.io.PrintWriter;

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
		PrintWriter w = response.getWriter();
		w.print(Integer.parseInt(prodId));
		productdao.deleteProduct(Integer.parseInt(prodId));
		RequestDispatcher view = request.getRequestDispatcher("/browse");
		view.forward(request, response);

	}

}
