package shopDAO;

import javax.sql.DataSource;

import shopiDAO.ICategoryDAO;
import shopiDAO.IDAOFactory;
import shopiDAO.IOrderDAO;
import shopiDAO.IProductDAO;
import shopiDAO.ISupplierDAO;

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
	
	public IOrderDAO getOrderDAO() {
		return new OrderDAO(ds);
	}
	
	public IProductDAO getProductDAO() {
		return new ProductDAO(ds);
	}
	
	public ICategoryDAO getCategoryDAO() {
		return new CategoryDAO(ds);
	}
	
	public ISupplierDAO getSupplierDAO() {
		return new SupplierDAO(ds);
	}
}
