package shopDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AbstractDAO {
	private static boolean dev = false;

	protected static String URL = "jdbc:mysql://mysql-env-8290494.jelastic.dogado.eu/test"; 
	protected static String login = "root";
	protected static String pass = "PH3I8DThX2";
	
	protected static String URLdev = "jdbc:mysql://localhost/test";
	protected static String logindev = "root";
	protected static String passdev = "ciocia";

	public static Connection getConnection() throws SQLException,
			ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		if (dev) {
			System.out.println("jest_dev");
			return DriverManager.getConnection(URLdev, logindev, passdev);
		}
		else
			System.out.println("jest_srod");
			return DriverManager.getConnection(URL, login, pass);
	}

	public static void closeQuietly(Statement s, Connection c) {
		try {
			if (s != null) {
				s.close();
			}
			if (c != null) {
				c.close();
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}
