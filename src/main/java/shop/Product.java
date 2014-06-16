package shop;

import java.util.Date;

import cart.AuxVisitor;
import cart.Visitable;
import decorators.ZlotyDekorator;


public class Product implements Visitable {

	private int id;
	private String productName;
	private double price;
	private int supplierId;
	private int categoryId;
	private Date dateFrom;
	private String supplierName;
	private String productDescription;
	
	public String getProductDescription() {
		return productDescription;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public int getId() {
		return id;
	}
	public String getProductName() {
		return productName;
	}
	public double getPrice() {
		return price;
	}
	public int getSupplierId() {
		return supplierId;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public Date getDateFrom() {
		return dateFrom;
	}
	
	public String getPriceZl() {
		String s = "";
		ZlotyDekorator d = new ZlotyDekorator();
		s = d.write(String.valueOf(price));
		return s;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public void acceptVisitor(AuxVisitor visitor, int sign) {
		visitor.visit(this, sign);
	}
	
	public static class ProductBuilder {
		
		private Product product;
		
		public ProductBuilder() {
			this.product = new Product();
		}
		
		public ProductBuilder productDescription(String productDescription) {
			this.product.productDescription = productDescription;
			return this;
		}
		public ProductBuilder supplierName(String supplierName) {
			this.product.supplierName = supplierName;
			return this;
		}
		public ProductBuilder id(int id) {
			this.product.id = id;
			return this;
		}
		public ProductBuilder productName(String productName) {
			this.product.productName = productName;
			return this;
		}
		public ProductBuilder price(double price) {
			this.product.price = price;
			return this;
		}
		public ProductBuilder supplierId(int supplierId) {
			this.product.supplierId = supplierId;
			return this;
		}
		public ProductBuilder categoryId(int categoryId) {
			this.product.categoryId = categoryId;
			return this;
		}
		public ProductBuilder dateFrom(Date dateFrom) {
			this.product.dateFrom = dateFrom;
			return this;
		}
		public Product build() {
			return this.product;
		}
	}
	
}
