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
import shop.Supplier;
import shopiDAO.ICategoryDAO;
import shopiDAO.IProductDAO;
import shopiDAO.ISupplierDAO;

@WebServlet("/update")
public class UpdateProductServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);

	}

	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		IProductDAO productdao = (IProductDAO) getServletContext().getAttribute("productDAO");
		ICategoryDAO categorydao = (ICategoryDAO) getServletContext().getAttribute("categoryDAO");
		ISupplierDAO supplierdao = (ISupplierDAO) getServletContext().getAttribute("supplierDAO");
		List<Category> catList = categorydao.viewAllCategories();
		List<Supplier> supList = supplierdao.viewAllSuppliers();
		request.setAttribute("catList", catList);
		request.setAttribute("supList", supList);
		String prodId = request.getParameter("prodIdA");
		request.setAttribute("prodIdA", prodId);
		Product prod = productdao.getProduct(Integer.valueOf(prodId));
        request.setAttribute("prod", prod);
		/*if (prodId != null) {
		
		String name = request.getParameter("prodname"); 
		String desc = request.getParameter("proddesc");
		String supplier = request.getParameter("prodsupplier");
		String cat = request.getParameter("prodcat");
		String price = request.getParameter("prodprice");
		prod.setPrice(Double.parseDouble(price));
		prod.setProductName(name);
		prod.setProductDescription(desc);
		prod.setCategoryId(Integer.parseInt(cat));
		prod.setSupplierId(Integer.parseInt(supplier));
		productdao.updateProduct(prod);
		Message m = new Message();
		m.setLoginMessage("");
		if (name != null) {
			m.setLoginMessage("Produkt uaktualniony");
		}
		request.setAttribute("mp", m);
		}*/
		System.out.println(prodId);
		
		RequestDispatcher view = request.getRequestDispatcher("/update.jsp");
		view.forward(request, response);
	}

}
