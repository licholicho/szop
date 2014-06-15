package shopDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import shop.Category;

public class CategoryDAO extends AbstractDAO {

	public List<Category> viewAllCategories() {
		Connection con = null;
		PreparedStatement pst = null;
		List<Category> list = new ArrayList<Category>();
		try {
			con = getConnection();
			String sql = "select Category_Id, Category_Name from Category";
			pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Category category = new Category();
				category.setId(rs.getInt("Category_Id"));
				category.setCategoryName(rs.getString("Category_Name"));
				list.add(category);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return list;
		} finally {
			closeQuietly(pst, con);
		}

	}
	
	public boolean addCategory(String name) {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = getConnection();
			String sql = "INSERT INTO Category (Category_Name) values (?) ";
			pst = con.prepareStatement(sql);
			pst.setString(1, name);	
			return pst.execute();
		} catch (Exception e) {
			System.out.println(e);
			return false;
		} finally {
			closeQuietly(pst, con);
		}
	}
}
