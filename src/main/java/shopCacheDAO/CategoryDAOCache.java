/**
 * 
 */
package shopCacheDAO;

import java.util.List;

import shop.Category;
import shop.Product;
import shopDAO.CategoryDAO;
import shopDAO.ProductDAO;
import shopDAO.UserDAO;
import shopiDAO.ICategoryDAO;

/**
 * @author sacherus
 *
 */
public class CategoryDAOCache extends ADAOCache implements ICategoryDAO {

	private ICategoryDAO dao;
	public CategoryDAOCache(ICategoryDAO dao, CacheConfig cc) {
		super(cc);
		this.dao = dao;
	}
	
	/* (non-Javadoc)
	 * @see shopiDAO.ICategoryDAO#viewAllCategories()
	 */
	@Override
	public List<Category> viewAllCategories() {
		List<Category> cats = (List<Category>) c.get(CategoryDAO.TABLE);
		if (cats == null) {
			cats = dao.viewAllCategories();
			c.set(CategoryDAO.TABLE, defaultTime, cats);
		}
		return cats;
	}

	/* (non-Javadoc)
	 * @see shopiDAO.ICategoryDAO#addCategory(java.lang.String)
	 */
	@Override
	public boolean addCategory(String name) {
		boolean added = dao.addCategory(name);
		if (added)
			c.delete(UserDAO.TABLE);
		return added;
	}

}
