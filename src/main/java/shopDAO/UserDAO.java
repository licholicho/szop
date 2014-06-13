package shopDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import shop.User;


public class UserDAO extends AbstractDAO implements ICustomerDAO {


		public User getUser(int id) {
			Connection c = null;
			PreparedStatement s = null;
			String sql = "SELECT * FROM User WHERE User_Id = ?";
			try {
				c = getConnection();
				s = c.prepareStatement(sql);
				s.setInt(1, id);
				ResultSet r = s.executeQuery();
				while (r.next()) {
					String firstName = r.getString("User_Nick");
					String lastName = r.getString("User_Pass");
					User u = new User(firstName, lastName, id);
					return u;
				}
				return null;
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
				return null;
			} finally {
				closeQuietly(s, c);
			}

		}
				
    
    public boolean createUser(User user){
        Connection con = null;
        PreparedStatement pst = null;
        try {
             con = getConnection();
             String sql = "INSERT INTO User (User_Nick, User_Pass) values(?,?)";
             pst = con.prepareStatement(sql);
             pst.setString(1,user.getLogin());
             pst.setString(2, user.getPassword());
             return pst.execute();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        } finally {
            closeQuietly(pst, con);
        }
    }

		   
    public boolean isUserWithLogin(String login){
        Connection con = null;
        PreparedStatement pst = null;
        try {
             con = getConnection();
             String sql = "SELECT * FROM User WHERE User_Nick=?";
             pst = con.prepareStatement(sql);
             pst.setString(1, login);
             ResultSet rs = pst.executeQuery();
             if (rs.next()) {
                return true;
            }
             else {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e);
            return false;
        } finally {
            closeQuietly(pst, con);
        }
    }
    
     public boolean isUser(User User){
        Connection con = null;
        PreparedStatement pst = null;
        try {
             con = getConnection();
             String sql = "SELECT * FROM User WHERE User_Nick=? AND User_Pass=?";
             pst = con.prepareStatement(sql);
             pst.setString(1, User.getLogin());
             pst.setString(2, User.getPassword());
             ResultSet rs = pst.executeQuery();
             if (rs.next()) {
                return true;
            }
             else {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e);
            return false;
        } finally {
            closeQuietly(pst, con);
        }
    }
}
