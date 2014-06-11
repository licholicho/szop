package sorting;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import shop.Product;

public class SortByNameStrategy implements SortingStrategy {
	
	class ProductNameComparator implements Comparator<Product> {

		public int compare(Product o1, Product o2) {
			return o1.getProductName().compareTo(o2.getProductName());
		}
		
	}

	public List<Product> sort(List<Product> list) {
		Collections.sort(list, new ProductNameComparator());
		return list;
	}

}

