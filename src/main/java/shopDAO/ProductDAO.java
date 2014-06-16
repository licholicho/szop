package shopDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import shop.Product;

public class ProductDAO extends AbstractDAO {
	
	public ProductDAO(DataSource ds) {
		super(ds);
	}

	public List<Product> viewProductsByCategory(String productName, String category) {
		Connection con = null;
		PreparedStatement pst = null;
		List<Product> list = new ArrayList<Product>();
		try {
			con = getConnection();
			
			String sql = "select p.Product_Id, p.Product_Name, p.Product_Description from Product p left join Category c "
					+"on p.Category_Id = c.Category_Id where c.Category_Name = ?";
			if (productName != "") {
					sql +=" and p.Product_Name REGEXP ?";
			}
			
			pst = con.prepareStatement(sql);
			pst.setString(1, category);
			
			if (productName != "") {
				pst.setString(2, productName);
		}
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Product product = new Product.ProductBuilder()
						.id(rs.getInt("Product_Id"))
						.productName(rs.getString("Product_Name"))
						.productDescription(rs.getString("Product_Description"))
						.build();
				list.add(product);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return list;
		} finally {
		closeQuietly(pst, con);
		}

	}
	
	public List<Product> viewProductsByCategory(String productName, String category, int offset, int noOfRecords) {
		Connection con = null;
		PreparedStatement pst = null;
		List<Product> list = new ArrayList<Product>();
		try {
			con = getConnection();
			
			String sql = "select p.Product_Id, p.Product_Name, p.Product_Description from Product p left join Category c "
					+"on p.Category_Id = c.Category_Id where c.Category_Name = ?";
			if (productName != "") {
					sql +=" and p.Product_Name REGEXP ?";
			}
			sql += " limit ?, ?";
			pst = con.prepareStatement(sql);
			int k = 1;
			pst.setString(k, category);
			k++;		
			if ((productName != null) && (productName != "")) {
				pst.setString(k, productName);
				k++;
		}
			pst.setInt(k, offset);
			k++;
			pst.setInt(k, noOfRecords);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Product product = new Product.ProductBuilder()
						.id(rs.getInt("Product_Id"))
						.productName(rs.getString("Product_Name"))
						.productDescription(rs.getString("Product_Description"))
						.build();
				list.add(product);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return list;
		} finally {
		closeQuietly(pst, con);
		}

	}
	
	
	public List<Product> viewAllProducts(int offset, int noOfRecords) {
		Connection con = null;
		PreparedStatement pst = null;
		List<Product> list = new ArrayList<Product>();
		try {
			con = getConnection();
			String sql = "select p.Product_Id, p.Product_Name, s.Supplier_Name, p.Unit_Price from Product p left join Supplier s on p.Supplier_Id = s.Supplier_Id limit ?, ?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, offset);
			pst.setInt(2, noOfRecords);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Product product = new Product.ProductBuilder()
				.id(rs.getInt("Product_Id"))
				.productName(rs.getString("Product_Name"))
				.supplierName(rs.getString("Supplier_Name"))
				.price(rs.getDouble("Unit_Price")).build();
				list.add(product);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return list;
		} finally {
			closeQuietly(pst, con);
		}

	}

	public int getNoOfRecords() {
		Connection con = null;
		PreparedStatement pst = null;
		int productsNumber = 0;
		try {
			con = getConnection();
			String sql = "select count(*) from Product";
			pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				productsNumber = rs.getInt(1);
			}
			return productsNumber;
		} catch (Exception e) {
			e.printStackTrace();
			return productsNumber;
		} finally {
			closeQuietly(pst, con);
		}

	}
	
	
	public Product getProduct(int id) {
		Connection c = null;
		PreparedStatement s = null;
		String sql = "SELECT Product_Name, Unit_Price FROM Product WHERE Product_Id = ?";
		try {
			c = getConnection();
			s = c.prepareStatement(sql);
			s.setInt(1, id);
			ResultSet rs = s.executeQuery();
			while (rs.next()) {
				Product product = new Product.ProductBuilder()
				.id(id)
				.productName(rs.getString("Product_Name"))
				.price(rs.getDouble("Unit_Price")).build();
				return product;
			}
			return null;
		} catch (Exception e) {
			return null;
		} finally {
			closeQuietly(s, c);
		}

	}

	public boolean addProduct(String name, String desc, String cat, String supplier, String price) {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = getConnection();
			con.setAutoCommit(false); 
			String sql = "INSERT INTO Product (Product_Name, Product_Description, Category_Id, "
					+ "Supplier_Id, Unit_Price, Date_From) values (?, ?, ?, ?, ?, curdate())";
			pst = con.prepareStatement(sql);
			pst.setString(1, name);
			pst.setString(2, desc);
			pst.setInt(3, Integer.parseInt(cat));
			pst.setInt(4, Integer.parseInt(supplier));
			pst.setDouble(5, Double.parseDouble(price));
			boolean ret = pst.execute();
			con.commit();
			return ret;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			closeQuietly(pst, con);
		}
	}
	
	public boolean deleteProduct(int id) {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = getConnection();
			con.setAutoCommit(false); 
			String sql = "DELETE FROM Product WHERE Product_Id = ?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			return pst.execute();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			closeQuietly(pst, con);
		}
	}
	
	public boolean updateProduct(Product product) {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = getConnection();
			con.setAutoCommit(false); 
			String sql = "UPDATE Product SET Product_Name = ?, Product_Descpription = ?, Unit_Price = ?, "
					+"Category_Id = ?, Supplier_Id = ? WHERE Product_Id = ?";
			pst = con.prepareStatement(sql);
			pst.setString(1, product.getProductName());
			pst.setString(2, product.getProductDescription());
			pst.setDouble(3, product.getPrice());
			pst.setInt(4, product.getCategoryId());
			pst.setInt(5, product.getSupplierId());
			pst.setInt(6, product.getId());
			return pst.execute();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			closeQuietly(pst, con);
		}
	}
}

