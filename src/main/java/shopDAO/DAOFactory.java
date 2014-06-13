package shopDAO;

public class DAOFactory {
	private static DAOFactory factory;
	
	private DAOFactory() {}
	
	public static DAOFactory getInstance() {
		if (factory == null) 
			return new DAOFactory();
		else 
			return factory;
	}
	
	public UserDAO getCustomerDAO() {
		return new UserDAO();
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
}
