package shopiDAO;

import java.util.List;

import shop.Order;
import shop.Order_Detail;

public interface IOrderDAO {

	public abstract void addOrder(Order order, List<Order_Detail> orderDetails);

}