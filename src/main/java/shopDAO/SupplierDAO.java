package shopDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import shop.Supplier;
import shopiDAO.ISupplierDAO;

public class SupplierDAO extends AbstractDAO implements ISupplierDAO {

	public SupplierDAO(DataSource ds) {	
		super(ds);
	}
	/* (non-Javadoc)
	 * @see shopDAO.ISupplierDAO#viewAllSuppliers()
	 */
	@Override
	public List<Supplier> viewAllSuppliers() {
		Connection con = null;
		PreparedStatement pst = null;
		List<Supplier> list = new ArrayList<Supplier>();
		try {
			con = getConnection();
			String sql = "select Supplier_Id, Supplier_Name from Supplier";
			pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Supplier supplier = new Supplier();
				supplier.setId(rs.getInt("Supplier_Id"));
				supplier.setName(rs.getString("Supplier_Name"));
				list.add(supplier);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return list;
		} finally {
			closeQuietly(pst, con);
		}

	}
	
	/* (non-Javadoc)
	 * @see shopDAO.ISupplierDAO#addSupplier(java.lang.String)
	 */
	@Override
	public boolean addSupplier(String name) {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = getConnection();
			String sql = "INSERT INTO Supplier (Supplier_Name) values (?) ";
			pst = con.prepareStatement(sql);
			pst.setString(1, name);	
			return pst.execute();
		} catch (Exception e) {
			System.out.println(e);
			return false;
		} finally {
			closeQuietly(pst, con);
		}
	}
}
