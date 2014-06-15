package shopDAO;

import java.util.List;

import javax.sql.DataSource;

import shop.Order;
import shop.Order_Detail;

public class OrderDAO extends AbstractDAO {
	
	public OrderDAO(DataSource ds) {
		super(ds);
	}

	public void addOrder(Order order, List<Order_Detail> orderDetails) {
		
	}
}
