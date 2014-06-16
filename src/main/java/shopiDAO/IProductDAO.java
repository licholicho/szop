package shopiDAO;

import java.util.List;

import shop.Product;

public interface IProductDAO {

	public abstract List<Product> viewProductsByCategory(String productName,
			String category);

	public abstract List<Product> viewProductsByCategory(String productName,
			String category, int offset, int noOfRecords);

	public abstract List<Product> viewAllProducts(int offset, int noOfRecords);

	public abstract int getNoOfRecords();

	public abstract Product getProduct(int id);

	public abstract boolean addProduct(String name, String desc, String cat,
			String supplier, String price);

	public abstract boolean deleteProduct(int id);

	public abstract boolean updateProduct(Product product);

}