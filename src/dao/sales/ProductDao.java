package dao.sales;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.sales.Product;


public class ProductDao {

	// 从数据库product表中查询所有产品信息
	public ArrayList<Product> queryProductAll() {
		String queryProductSQL = "select * from product";
		Connection connection = DBConnection.getConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<Product> productList = new ArrayList<Product>();
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(queryProductSQL);
			while (resultSet.next()) {
				String productCode = resultSet.getString("ProductCode");
				String name = resultSet.getString("Name");
				String unitName = resultSet.getString("UnitName");
				float price = resultSet.getFloat("Price");
				Product product = new Product(productCode, name, unitName, price);
				productList.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.DatabaseClose(resultSet, statement, null, connection);
		}
		return productList;
	}
}