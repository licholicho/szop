package shopDAO;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

import shopCacheDAO.CacheConfig;
import shopCacheDAO.DAOCacheFactory;
import cart.Shipping;

@WebListener
public class DAOListener implements ServletContextListener {
	private static final boolean cache = true;
	
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

	
	public void contextInitialized(ServletContextEvent sce) {
		InitialContext initContext;
		DataSource ds = null;
		CacheConfig cacheConfig = null;
		try {
			initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
	        ds = (DataSource)envContext.lookup("jdbc/mysql");	        
			cacheConfig = (CacheConfig) envContext.lookup("bean/CacheConfigFactory");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		IDAOFactory factory = cache ? new DAOCacheFactory(ds, cacheConfig) : new DAOFactory(ds);
		IUserDAO customerdao = factory.getCustomerDAO();
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
