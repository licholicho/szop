package shopCacheDAO;

import javax.sql.DataSource;

import shopDAO.CategoryDAO;
import shopDAO.IDAOFactory;
import shopDAO.IUserDAO;
import shopDAO.OrderDAO;
import shopDAO.ProductDAO;
import shopDAO.SupplierDAO;
import shopDAO.UserDAO;

public class DAOCacheFactory implements IDAOFactory {
	
	private DataSource ds;
	private CacheConfig cacheConfig;
	
	public DAOCacheFactory(DataSource ds, CacheConfig cacheConfig) {
		this.ds = ds;
		this.cacheConfig = cacheConfig;
	}
	
	public IUserDAO getCustomerDAO() {
		return new UserDAOCache(new UserDAO(ds), cacheConfig);
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

	@Override
	public SupplierDAO getSupplierDAO() {
		return new SupplierDAO(ds);
	}
}
