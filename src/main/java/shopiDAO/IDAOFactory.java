package shopiDAO;

import shopDAO.ICategoryDAO;
import shopDAO.IOrderDAO;
import shopDAO.IProductDAO;
import shopDAO.ISupplierDAO;

public interface IDAOFactory {
	public IUserDAO getCustomerDAO();
	public IOrderDAO getOrderDAO();
	public IProductDAO getProductDAO();
	public ICategoryDAO getCategoryDAO();
	public ISupplierDAO getSupplierDAO();
}
