package shopCacheDAO;

import java.util.List;

import shop.Supplier;
import shopiDAO.ISupplierDAO;

public class SupplierDAOCache extends ADAOCache implements ISupplierDAO {

	public SupplierDAOCache(CacheConfig cacheConfig) {
		super(cacheConfig);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Supplier> viewAllSuppliers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addSupplier(String name) {
		// TODO Auto-generated method stub
		return false;
	}

}
