package shopDAO;

import java.util.List;

import shop.Supplier;

public interface ISupplierDAO {

	public abstract List<Supplier> viewAllSuppliers();

	public abstract boolean addSupplier(String name);

}