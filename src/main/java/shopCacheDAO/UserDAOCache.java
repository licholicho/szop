package shopCacheDAO;

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
	
	public UserDAOCache(UserDAO dao) {
		this.dao = dao;
		try {
			if(dev)
				c = new MemcachedClient(new InetSocketAddress(devDonnection,
						portNum));
			else
				c = new MemcachedClient(new InetSocketAddress(prodConnection,
						portNum));
		} catch (Exception e) {
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
		User stud = (User) c.get(Integer.toString(id));
		if (stud == null) {
			stud = dao.getUser(id);
			if (stud == null)
				return null;
			c.set(Integer.toString(id), 3600, stud);
		}
		return stud;
	}

	@Override
	public List<User> getAllUsers() {
		@SuppressWarnings("unchecked")
		List<User> listStud = (List<User>) c.get("lista");
		if (listStud == null) {
			listStud = dao.getAllUsers();
			c.set("lista", 3600, listStud);
		}
		return listStud;
	}

	@Override
	public boolean createUser(User user) {
		boolean added = dao.createUser(user);
		if (added)
			c.delete("lista");
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
		return true;
	}

	@Override
	public boolean isUser(User user) {
		return dao.isUser(user);
	}

}