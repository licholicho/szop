package shopCacheDAO;

import javax.sql.DataSource;

import shopDAO.CategoryDAO;
import shopDAO.OrderDAO;
import shopDAO.ProductDAO;
import shopDAO.SupplierDAO;
import shopDAO.UserDAO;
import shopiDAO.ICategoryDAO;
import shopiDAO.IDAOFactory;
import shopiDAO.IOrderDAO;
import shopiDAO.IProductDAO;
import shopiDAO.ISupplierDAO;
import shopiDAO.IUserDAO;

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
	
	public IOrderDAO getOrderDAO() {
		return new OrderDAO(ds);
	}
	
	public IProductDAO getProductDAO() {
		return new ProductDAOCache(new ProductDAO(ds), cacheConfig);
	}
	
	public ICategoryDAO getCategoryDAO() {
		return new CategoryDAOCache(new CategoryDAO(ds), cacheConfig);
	}

	@Override
	public ISupplierDAO getSupplierDAO() {
		return new SupplierDAO(ds);
	}
}
