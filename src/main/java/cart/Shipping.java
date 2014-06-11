package cart;

public class Shipping implements Visitable {

	private String name;
	private double price;
	
	public String getProductName() {
		return name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void acceptVisitor(AuxVisitor visitor, int sign) {
		visitor.visit(this, sign);
	}
	
	public Shipping(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	
	
}
