package cart;

public interface Visitable {

	public void acceptVisitor(AuxVisitor visitor, int sign);
	public double getPrice();
}
