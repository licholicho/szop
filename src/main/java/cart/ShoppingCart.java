package cart;

import java.util.ArrayList;
import java.util.List;

import payment.PaymentStrategy;
import decorators.ZlotyDekorator;

public class ShoppingCart {

	List<Visitable> list = new ArrayList<Visitable>();
	TotalSumVisitor totalSumVisitor = new TotalSumVisitor();
	
	public ShoppingCart() {
	}

	public boolean addProduct(Visitable product) {
		product.acceptVisitor(totalSumVisitor, 1);
		return list.add(product);
	}
	
	public boolean removeProduct(Visitable product) {
		product.acceptVisitor(totalSumVisitor, -1);
		return list.remove(product);
	}
	
	public List<Visitable> getList() {
		return list;
	}
	
	public List<String> getPriceList() {
		ZlotyDekorator d = new ZlotyDekorator();
		List<String> l = new ArrayList<String>();
		for (int i=0; i< list.size(); i++)
			l.add(d.write(String.valueOf(list.get(i))));
		return l;
	}

	public void setList(List<Visitable> list) {
		this.list = list;
	}

	public double calcTotalCost() {

		return 	totalSumVisitor.overallSum();

	}

	public void pay(PaymentStrategy ps) {

		double totalCost = calcTotalCost();
		ps.pay(totalCost);
	}

}
