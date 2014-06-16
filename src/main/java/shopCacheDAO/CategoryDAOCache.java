/**
 * 
 */
package shopCacheDAO;

import java.util.List;

import javax.sql.DataSource;

import shop.Category;
import shopDAO.AbstractDAO;
import shopiDAO.ICategoryDAO;

/**
 * @author sacherus
 *
 */
public class CategoryDAOCache extends ADAOCache implements ICategoryDAO {

	private CategoryDAOCache dao;
	public CategoryDAOCache(CategoryDAOCache dao, CacheConfig cc) {
		super(cc);
		this.dao = dao;
	}
	
	/* (non-Javadoc)
	 * @see shopiDAO.ICategoryDAO#viewAllCategories()
	 */
	@Override
	public List<Category> viewAllCategories() {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see shopiDAO.ICategoryDAO#addCategory(java.lang.String)
	 */
	@Override
	public boolean addCategory(String name) {
		// TODO Auto-generated method stub
		return false;
	}

}
