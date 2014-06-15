package shopDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

public class AbstractDAO {

	private DataSource ds;

	AbstractDAO(DataSource ds) {
		this.ds = ds;
	}


	public Connection getConnection() throws SQLException,
			ClassNotFoundException {
		return ds.getConnection();
	}

	void setDataSource(DataSource ds) {
		this.ds = ds;
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
