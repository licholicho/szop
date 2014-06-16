/**
 * 
 */
package shopCacheDAO;

import java.util.List;

import shop.Product;
import shopDAO.IProductDAO;

/**
 * @author Elwirka
 *
 */
public class ProductDAOCache extends ADAOCache implements IProductDAO {

	public ProductDAOCache(CacheConfig cacheConfig) {
		super(cacheConfig);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Product> viewProductsByCategory(String productName,
			String category) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see shopDAO.IProductDAO#viewProductsByCategory(java.lang.String, java.lang.String, int, int)
	 */
	@Override
	public List<Product> viewProductsByCategory(String productName,
			String category, int offset, int noOfRecords) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see shopDAO.IProductDAO#viewAllProducts(int, int)
	 */
	@Override
	public List<Product> viewAllProducts(int offset, int noOfRecords) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see shopDAO.IProductDAO#getNoOfRecords()
	 */
	@Override
	public int getNoOfRecords() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see shopDAO.IProductDAO#getProduct(int)
	 */
	@Override
	public Product getProduct(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see shopDAO.IProductDAO#addProduct(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public boolean addProduct(String name, String desc, String cat,
			String supplier, String price) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see shopDAO.IProductDAO#deleteProduct(int)
	 */
	@Override
	public boolean deleteProduct(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see shopDAO.IProductDAO#updateProduct(shop.Product)
	 */
	@Override
	public boolean updateProduct(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

}
