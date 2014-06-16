package shopCacheDAO;

import java.io.IOException;
import java.net.InetSocketAddress;

import net.spy.memcached.MemcachedClient;
import shopiDAO.IUserDAO;

public class ADAOCache {

	protected MemcachedClient c = null;
	protected int defaultTime = 3600;

	public ADAOCache(CacheConfig cacheConfig) {
		super();
		try {
			c = new MemcachedClient(new InetSocketAddress(cacheConfig.getConnection(), cacheConfig.getPort()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}