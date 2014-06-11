package sorting;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import shop.Product;

public class SortByDateStrategy implements SortingStrategy {
	
	class DateComparator implements Comparator<Product> {
		
		public int compare(Product p, Product q) {
	        if (p.getDateFrom().before(q.getDateFrom())) {
	            return -1;
	        } else if (p.getDateFrom().after(q.getDateFrom())) {
	            return 1;
	        } else {
	            return 0;
	        }        
	    }
	}

	public List<Product> sort(List<Product> list) {
		Collections.sort(list, new DateComparator());
		return list;
	}
}
