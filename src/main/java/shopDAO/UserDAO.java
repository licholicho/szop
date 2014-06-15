package shopDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import shop.User;

public class UserDAO extends AbstractDAO implements IUserDAO {
	public static final String ID = "User_Id";
	public static final String TABLE = "User";
	public static final String NICK = "User_Nick";
	public static final String PASS = "User_Pass";
	
	public UserDAO(DataSource ds) {
		super(ds);
	}
	
	private User resultSetToUser(ResultSet r) throws SQLException {
		if (r.next()) {
			String firstName = r.getString(NICK);
			String lastName = r.getString(PASS);
			int id = r.getInt(ID);
			User u = new User(firstName, lastName, id);
			return u;
		}
		return null;
	}
	
	@Override
	public User getUser(int id) {
		Connection c = null;
		PreparedStatement s = null;
		String sql = "SELECT * FROM User WHERE User_Id = ?";
		try {
			c = getConnection();
			s = c.prepareStatement(sql);
			s.setInt(1, id);
			ResultSet r = s.executeQuery();
			return resultSetToUser(r);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} finally {
			closeQuietly(s, c);
		}

	}
	
	@Override
	public boolean createUser(User user) {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = getConnection();
			String sql = "INSERT INTO User (User_Nick, User_Pass) values(?,?)";
			pst = con.prepareStatement(sql);
			pst.setString(1, user.getLogin());
			pst.setString(2, user.getPassword());
			return pst.execute();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			closeQuietly(pst, con);
		}
	}
	
	public User getUser(String login) {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = getConnection();
			String sql = "SELECT * FROM User WHERE User_Nick=?";
			pst = con.prepareStatement(sql);
			pst.setString(1, login);
			ResultSet rs = pst.executeQuery();
			return resultSetToUser(rs);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			closeQuietly(pst, con);
		}
	}
	
	public User getUser(User user) {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = getConnection();
			String sql = "SELECT * FROM User WHERE User_Nick=? AND User_Pass=?";
			pst = con.prepareStatement(sql);
			pst.setString(1, user.getLogin());
			pst.setString(2, user.getPassword());
			ResultSet rs = pst.executeQuery();
			return resultSetToUser(rs);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			closeQuietly(pst, con);
		}
	}

	public boolean isUserWithLogin(String login) {
		return getUser(login) == null ? false : true;
	}

	/**
	 * @param user User with login and password
	 * @return false if user not in database
	 * 			true if user is in database
	 */
	@Override
	public boolean isUser(User user) {
		return getUser(user) == null ? false : true;
	}
	
	@Override
	public List<User> getAllUsers() {
		Logger logger = Logger.getLogger(this.getClass().getName());
		logger.warn("Hello my message");
		Connection c = null;
		PreparedStatement s = null;
		String sql = "SELECT * FROM " + TABLE;
		List<User> list = new ArrayList<User>();
		try {
			c = getConnection();
			s = c.prepareStatement(sql);
			ResultSet r = s.executeQuery();
			while (r.next()) {
				String firstName = r.getString("User_Nick");
				String lastName = r.getString("User_Pass");
				int id = r.getInt(ID);
				User u = new User(firstName, lastName, id);
				list.add(u);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return list;
		} finally {
			closeQuietly(s, c);
		}
	}

	
}
