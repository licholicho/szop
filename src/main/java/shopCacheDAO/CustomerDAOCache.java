package shopCacheDAO;
import java.net.InetSocketAddress;
import java.util.List;

import net.spy.memcached.MemcachedClient;
import shop.User;
import shopDAO.IUserDAO;
import shopDAO.UserDAO;

public class UserDAOCache implements IUserDAO {
	private UserDAO dao;
	private int portNum = 11211;
	private MemcachedClient c = null;
	private final static String devDonnection = "localhost";
	
	public UserDAOCache(UserDAO dao) {
		this.dao = dao;
		try {
			c = new MemcachedClient(new InetSocketAddress(devDonnection, portNum));
		} catch (Exception e) {

		}
	}

	public User getUser(int id) {
		User stud = (User) c.get(Integer.toString(id));
		if (stud == null) {
			stud = dao.getUser(id);
			c.set(Integer.toString(id), 3600, stud);
		} 
		return stud;
	}

	public List<User> getAllUsers() {
		List<User> listStud = (List<User>) c.get("lista");
		if (listStud == null) {
			listStud = dao.getAllUsers();
			c.set("lista", 3600, listStud);
		} 
		return listStud;
	}

	public boolean addUser(User User) {
		boolean added = dao.createUser(user);
		if (added == true)
			c.delete("lista");
		return added;
		//uwaga: mozna przerobic dao tak zeby zwracalo dodany rekord razem z id
	}
}