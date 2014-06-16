package shopCacheDAO;

import java.util.List;

import shop.User;
import shopDAO.UserDAO;
import shopiDAO.IUserDAO;

public class UserDAOCache extends ADAOCache implements IUserDAO {

	private UserDAO dao;
	public UserDAOCache(UserDAO dao, CacheConfig cacheConfig) {
		super(cacheConfig);
		this.dao = dao;
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
	public User getUser(User user) {
		return dao.getUser(user);
	}
	

}