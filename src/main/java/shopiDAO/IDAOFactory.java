package shopiDAO;


public interface IDAOFactory {
	public IUserDAO getCustomerDAO();
	public IOrderDAO getOrderDAO();
	public IProductDAO getProductDAO();
	public ICategoryDAO getCategoryDAO();
	public ISupplierDAO getSupplierDAO();
}
