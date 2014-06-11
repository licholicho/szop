package sorting;

import java.util.List;

import shop.Product;

public interface SortingStrategy {

	public List<Product> sort(List<Product> list);
}
