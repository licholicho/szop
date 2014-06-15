package shopCacheDAO;

import shopDAO.CategoryDAO;
import shopDAO.IDAOFactory;
import shopDAO.IUserDAO;
import shopDAO.OrderDAO;
import shopDAO.ProductDAO;
import shopDAO.SupplierDAO;
import shopDAO.UserDAO;

public class DAOCacheFactory implements IDAOFactory {
	public IUserDAO getCustomerDAO() {
		return new UserDAOCache(new UserDAO());
	}
	
	public OrderDAO getOrderDAO() {
		return new OrderDAO();
	}
	
	public ProductDAO getProductDAO() {
		return new ProductDAO();
	}
	
	public CategoryDAO getCategoryDAO() {
		return new CategoryDAO();
	}

	@Override
	public SupplierDAO getSupplierDAO() {
		return new SupplierDAO();
	}
}
