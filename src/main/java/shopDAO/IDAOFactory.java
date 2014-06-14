package shopDAO;

public interface IDAOFactory {
	public IUserDAO getCustomerDAO();
	public OrderDAO getOrderDAO();
	public ProductDAO getProductDAO();
	public CategoryDAO getCategoryDAO();
}
