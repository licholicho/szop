package shop;

import java.util.Date;

import cart.AuxVisitor;
import cart.Visitable;
import decorators.ZlotyDekorator;


public class Product implements Visitable {

	private long id;
	private String productName;
	private double price;
	private long supplierId;
	private long categoryId;
	private Date dateFrom;
	private String supplierName;
	private String productDescription;
	
	public String getProductDescription() {
		return productDescription;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public long getId() {
		return id;
	}
	public String getProductName() {
		return productName;
	}
	public double getPrice() {
		return price;
	}
	public long getSupplierId() {
		return supplierId;
	}
	public long getCategoryId() {
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
		public ProductBuilder id(long id) {
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
		public ProductBuilder supplierId(long supplierId) {
			this.product.supplierId = supplierId;
			return this;
		}
		public ProductBuilder categoryId(long categoryId) {
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
