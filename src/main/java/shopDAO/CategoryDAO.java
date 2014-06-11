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
			String sql = "select Category_Name from Category";
			pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Category category = new Category();
				category.setCategoryName(rs.getString("Category_Name"));
				list.add(category);
			}
			return list;
		} catch (Exception e) {
			System.out.println(e);
			return list;
		} finally {
			closeQuietly(pst, con);
		}

	}
}
