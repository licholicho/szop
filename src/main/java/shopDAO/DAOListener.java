package shopDAO;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import shopCacheDAO.DAOCacheFactory;
import cart.Shipping;

@WebListener
public class DAOListener implements ServletContextListener {
	private static final boolean cache = false;
	
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

	
	public void contextInitialized(ServletContextEvent sce) {
//		InitialContext initContext;
//		DataSource dataSource = null;
//		try {
//			initContext = new InitialContext();
//			Context envContext  = (Context)initContext.lookup("java:/comp/env");
//	        dataSource = (DataSource)envContext.lookup("jdbc/mkyongdb");
//		} catch (NamingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//        System.out.println(dataSource.toString());
        
		IDAOFactory factory = cache ? new DAOCacheFactory() : new DAOFactory();
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
