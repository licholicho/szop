package shopDAO;

import helpers.DbTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import shop.Product;

public class ProductDAO extends AbstractDAO {

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
			
			pst = con.prepareStatement(sql);
			int k = 1;
			pst.setString(k, category);
			k++;		
			if ((productName != null) && (productName != "")) {
				pst.setString(k, productName);
				k++;
		}
			sql += " limit ?, ?";
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
			System.out.println(e);
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
			System.out.println(e);
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
			System.out.println(e);
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
}
