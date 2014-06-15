package shopDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.sql.DataSource;

import shop.Order;
import shop.Order_Detail;

public class OrderDAO extends AbstractDAO {
	
	public OrderDAO(DataSource ds) {
		super(ds);
	}

	public void addOrder(Order order, List<Order_Detail> orderDetails) {

		Connection con = null;
		PreparedStatement pst = null;
		PreparedStatement pst2 = null;
		try {
			con = getConnection();
			con.setAutoCommit(false); 
			String sql = "INSERT INTO Order (Customer_Id, Order_Date, Shipping) values(?, curdate(), ?)";
			pst = con.prepareStatement(sql);
			pst.setInt(1, order.getCustomerId());
			pst.setString(2, order.getShipping());
			pst.execute();
			ResultSet rs = pst.getResultSet();
			int i;
			while (rs.next()) {
				i = rs.getInt("Order_Id");
			}
			for (int k = 0; k < orderDetails.size(); k++) {
				String sql2 = "INSERT INTO Order_Details (Order_Id, Product_Id, Unit_Price, Quantity) values "
						+ "(?, ?, ?, 1)";
				pst2 = con.prepareStatement(sql2);
				pst2.setInt(1, orderDetails.get(k).getOrderId());
				pst2.setInt(2, orderDetails.get(k).getProductId());
				pst2.setDouble(3, orderDetails.get(k).getPrice());
				pst2.execute();
			}
			con.commit();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			closeQuietly(pst, con);
		}
	}
}
