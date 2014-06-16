package shopCacheDAO;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import shop.Product;
import shopDAO.ProductDAO;
import shopiDAO.IProductDAO;

public class ProductDAOCache extends ADAOCache implements IProductDAO {

	private Set<String> keysToBeDeletedWithUpdate = new HashSet<String>();
	private ProductDAO dao;

	public ProductDAOCache(ProductDAO dao, CacheConfig cacheConfig) {
		super(cacheConfig);
		this.dao = dao;
	}

	@Override
	public List<Product> viewProductsByCategory(String productName,
			String category, int offset, int noOfRecords) {
		// @SuppressWarnings("unchecked")
		//
		// List<Product> listProd = (List<Product>) c.get(ProductDAO.TABLE);
		// if (listProd == null) {
		// listProd = dao.viewProductsByCategory(productName, category, offset,
		// noOfRecords);
		// c.set(UserDAO.TABLE, defaultTime, listProd);
		// }
		// return listProd;
		return dao.viewProductsByCategory(productName, category, offset,
				noOfRecords);
	}

	@Override
	public List<Product> viewAllProducts(int offset, int noOfRecords) {
		@SuppressWarnings("unchecked")
		final String key = ProductDAO.TABLE;
		List<Product> listProd = (List<Product>) c.get(key);
		if (listProd == null) {
			listProd = dao.viewAllProducts(0, getNoOfRecords());
			c.set(ProductDAO.TABLE, defaultTime, listProd);
			keysToBeDeletedWithUpdate.add(key);
		}
		return listProd;
	}

	@Override
	public int getNoOfRecords() {
		return dao.getNoOfRecords();
	}

	@Override
	public Product getProduct(int id) {
		Product prod = (Product) c.get(ProductDAO.TABLE + ProductDAO.ID
				+ Integer.toString(id));
		if (prod == null) {
			prod = dao.getProduct(id);
			if (prod == null)
				return null;
			c.set(ProductDAO.TABLE + ProductDAO.ID + Integer.toString(id),
					defaultTime, prod);
		}
		return prod;
	}

	@Override
	public boolean addProduct(String name, String desc, String cat,
			String supplier, String price) {
		boolean added = dao.addProduct(name, desc, cat, supplier, price);
		deleteAllFromCache(added);
		return added;
	}

	private void deleteAllFromCache(boolean status) {
		if (status) {
			Iterator<String> i = keysToBeDeletedWithUpdate.iterator();
			while (i.hasNext()) {
				String key = i.next();
				c.delete(key);
				i.remove();
			}
		}

	}

	@Override
	public boolean deleteProduct(int id) {
		boolean deleted = dao.deleteProduct(id);
		deleteAllFromCache(deleted);
		return deleted;
	}

	@Override
	public boolean updateProduct(Product product) {
		boolean updated = dao.updateProduct(product);
		deleteAllFromCache(updated);
		return updated;
	}

	@Override
	public List<Product> viewProductsByCategory(String productName,
			String category) {
		@SuppressWarnings("unchecked")
		final String key = ProductDAO.TABLE + productName + category;
		List<Product> listProd = (List<Product>) c.get(key);
		if (listProd == null) {
			listProd = dao.viewProductsByCategory(productName, category);
			c.set(key, defaultTime, listProd);
			keysToBeDeletedWithUpdate.add(key);
		}
		return listProd;
	}

}
