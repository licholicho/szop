package shopDAO;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

import shopCacheDAO.CacheConfig;
import shopCacheDAO.DAOCacheFactory;
import shopiDAO.ICategoryDAO;
import shopiDAO.IDAOFactory;
import shopiDAO.IProductDAO;
import shopiDAO.ISupplierDAO;
import shopiDAO.IUserDAO;
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
		IProductDAO productdao = factory.getProductDAO();
		ICategoryDAO categorydao = factory.getCategoryDAO();
		ISupplierDAO supplierdao = factory.getSupplierDAO();
		sce.getServletContext().setAttribute("customerDAO", customerdao);
		sce.getServletContext().setAttribute("productDAO", productdao);
		sce.getServletContext().setAttribute("categoryDAO", categorydao);
		sce.getServletContext().setAttribute("supplierDAO", supplierdao);
		
		Shipping kurier = new Shipping("Kurier",15.0);
		Shipping poczta = new Shipping("Poczta Polska", 12.0);
		//List<Shipping> shippingPrices = new ArrayList<Shipping>();
		//shippingPrices.add(kurier);
		//shippingPrices.add(poczta);
		sce.getServletContext().setAttribute("kurier", kurier);
		sce.getServletContext().setAttribute("poczta", poczta);
		
	}

}
