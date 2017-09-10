package dao.sales;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.sales.Soitem;


public class SoitemDao {
	// 向数据库soitem表增加销售单
	public void addSoitem(Soitem soitem) {
		String updateSQL = "insert into soitem values(?,?,?,?,?,?)";
		Connection connection = DBConnection.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(updateSQL);
			preparedStatement.setString(1, soitem.getSoid());
			preparedStatement.setString(2, soitem.getProductCode());
			preparedStatement.setFloat(3, soitem.getUnitPrice());
			preparedStatement.setInt(4, soitem.getNum());
			preparedStatement.setString(5, soitem.getUnitName());
			preparedStatement.setFloat(6, soitem.getItemPrice());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.DatabaseClose(null, null, preparedStatement, connection);
		}
	}

	// 从数据库soitem表查询的销售单
	public ArrayList<Soitem> querySoitem(String soid_value) {
		ArrayList<Soitem> soitems = new ArrayList<Soitem>();
		String querySQL = "select * from soitem where SOID='" + soid_value + "'";
		Connection connection = DBConnection.getConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		Statement statement2 = null;
		ResultSet resultSet2 = null;
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(querySQL);
			while (resultSet.next()) {
				String soid = resultSet.getString("SOID");
				String productCode = resultSet.getString("ProductCode");
				String name = null;
				float unitPrice = resultSet.getFloat("UnitPrice");
				int num = resultSet.getInt("Num");
				String unitName = resultSet.getString("UnitName");
				float itemPrice = resultSet.getFloat("ItemPrice");
				String queryProductNameSQL = "select * from product where ProductCode='"
						+ productCode + "'";
				statement2 = connection.createStatement();
				resultSet2 = statement2.executeQuery(queryProductNameSQL);
				while (resultSet2.next()) {
					name = resultSet2.getString("Name");
					break;
				}
				Soitem soitem = new Soitem(soid, productCode, name, unitPrice, num, unitName,
						itemPrice);
				soitems.add(soitem);
				DBClose.DatabaseClose(resultSet2, statement2, null, null);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.DatabaseClose(resultSet, statement, null, connection);
		}
		return soitems;
	}

	// 从数据库soitem表根据soid删除销售单
	public void deleteSoitem(String soid) {
		String updateSQL = "delete from soitem where SOID=?";
		Connection connection = DBConnection.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(updateSQL);
			preparedStatement.setString(1, soid);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.DatabaseClose(null, null, preparedStatement, connection);
		}
	}
}
