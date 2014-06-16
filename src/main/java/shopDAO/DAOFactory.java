package shopDAO;

import javax.sql.DataSource;

import shopCacheDAO.DAOCache;

public class DAOFactory implements IDAOFactory{
//	private static DAOFactory factory;
//	
//	private DAOFactory() {}
//	
//	public static DAOFactory getInstance() {
//		if (factory == null)
//			factory = new DAOFactory();
//		return factory;
//	}
	
	private DataSource ds;
//	private UserDAO ud;
//	private OrderDAO od;
//	private CategoryDAO cd;
//	private ProductDAO pd;
//	
	public DAOFactory(DataSource ds) {
		this.ds = ds;
	}
	
	public UserDAO getCustomerDAO() {
		return new UserDAO(ds);
	}
	
	public OrderDAO getOrderDAO() {
		return new OrderDAO(ds);
	}
	
	public ProductDAO getProductDAO() {
		return new ProductDAO(ds);
	}
	
	public CategoryDAO getCategoryDAO() {
		return new CategoryDAO(ds);
	}
	
	public SupplierDAO getSupplierDAO() {
		return new SupplierDAO(ds);
	}
}
