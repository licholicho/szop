package shopDAO;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import cart.Shipping;

@WebListener
public class DAOListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent sce) {
		
	}

	public void contextInitialized(ServletContextEvent sce) {
		DAOFactory factory = DAOFactory.getInstance();
		CustomerDAO customerdao = factory.getCustomerDAO();
		ProductDAO productdao = factory.getProductDAO();
		CategoryDAO categorydao = factory.getCategoryDAO();
		sce.getServletContext().setAttribute("customerDAO", customerdao);
		sce.getServletContext().setAttribute("productDAO", productdao);
		sce.getServletContext().setAttribute("categoryDAO", categorydao);
		
		Shipping kurier = new Shipping("Kurier",15.0);
		Shipping poczta = new Shipping("Poczta Polska", 12.0);
		//List<Shipping> shippingPrices = new ArrayList<Shipping>();
		//shippingPrices.add(kurier);
		//shippingPrices.add(poczta);
		sce.getServletContext().setAttribute("kurier", kurier);
		sce.getServletContext().setAttribute("poczta", poczta);
		
	}

}
