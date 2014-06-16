package shopDAO;

import java.util.List;

import shop.Category;

public interface ICategoryDAO {

	public abstract List<Category> viewAllCategories();

	public abstract boolean addCategory(String name);

}