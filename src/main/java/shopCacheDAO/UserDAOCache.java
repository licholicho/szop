package shopCacheDAO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.List;

import net.spy.memcached.MemcachedClient;
import shop.User;
import shopDAO.IUserDAO;
import shopDAO.UserDAO;

public class UserDAOCache extends DAOCache implements IUserDAO {
	private static final boolean dev = true;

	private UserDAO dao;
	private int portNum = 11211;
	private MemcachedClient c = null;
	private final static String devDonnection = "localhost";
	private final static String prodConnection = "memcached-env-8290494.jelastic.dogado.eu";
	private int defaultTime = 3600;

	public UserDAOCache(UserDAO dao, CacheConfig cacheConfig) {
		this.dao = dao;
		// try {
		// if(dev)
		// c = new MemcachedClient(new InetSocketAddress(devDonnection,
		// portNum));
		// else
		// c = new MemcachedClient(new InetSocketAddress(prodConnection,
		// portNum));
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		try {
			c = new MemcachedClient(new InetSocketAddress(cacheConfig.getConnection(), cacheConfig.getPort()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Memcached implemenation of UserDAO
	 * 
	 * @param id
	 *            User id
	 * @return null if user isn't in database
	 */
	@Override
	public User getUser(int id) {
		User stud = (User) c.get(UserDAO.TABLE + UserDAO.NICK + Integer.toString(id));
		if (stud == null) {
			stud = dao.getUser(id);
			if (stud == null)
				return null;
			c.set(UserDAO.TABLE + UserDAO.NICK + Integer.toString(id), defaultTime, stud);
		}
		return stud;
	}

	@Override
	public List<User> getAllUsers() {
		@SuppressWarnings("unchecked")
		List<User> listStud = (List<User>) c.get(UserDAO.TABLE);
		if (listStud == null) {
			listStud = dao.getAllUsers();
			c.set(UserDAO.TABLE, defaultTime, listStud);
		}
		return listStud;
	}

	@Override
	public boolean createUser(User user) {
		boolean added = dao.createUser(user);
		if (added)
			c.delete(UserDAO.TABLE);
		return added;
	}

	@Override
	public boolean isUserWithLogin(String login) {
		User dbuser = dao.getUser(login);
		if (dbuser == null) {
			return false;
		}
		dbuser = dao.getUser(login);
		c.set(UserDAO.TABLE + UserDAO.NICK + login, defaultTime, dbuser);
		System.out.println(UserDAO.TABLE + UserDAO.NICK + login);
		return true;
	}

	@Override
	public boolean isUser(User user) {
		return isUserWithLogin(user.getLogin());
	}

	@Override
	public boolean isAdmin(User user) {
		return false;
	}

}