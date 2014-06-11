package shop;

public class Category {

	private long id;
	private String categoryName;
	
	public Category () {}
	
	public Category(String categoryName) {
		super();
		this.categoryName = categoryName;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	
}
