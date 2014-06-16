package shopDAO;

import java.util.List;

import shop.User;

public interface IUserDAO {
	public User getUser(int id);
	public boolean createUser(User user);
	public boolean isUserWithLogin(String login);
	public boolean isUser(User User);
	public List<User> getAllUsers();
	public boolean isAdmin(User user);
	public User getUser(User user);
}
