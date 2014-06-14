package shopDAO;

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
