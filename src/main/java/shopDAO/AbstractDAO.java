package shopDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AbstractDAO {

	protected static String URL = "jdbc:mysql://mysql-env-8780654.jelastic.dogado.eu/test"; 
	protected static String login = "root";
	protected static String pass = "Dmxg4FT1R4";

		public static Connection getConnection() throws SQLException, ClassNotFoundException {
			Class.forName("com.mysql.jdbc.Driver");
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
        }
    }
}
