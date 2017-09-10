package dao.sales;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import model.sales.Soitem;
import model.sales.Somain;


public class TransactionDao {

	public void addSomain_Soitem_Product(Somain somain, ArrayList<Soitem> soitems) {// 添加主销售单时，同时添加明细单，并更新产品表
		String updateSomainSQL = "insert into somain(SOID,CreateTime,CustomerCode,Account,TipFee,ProductTotal,PayType,PrePayFee,Remark,Status) values(?,?,?,?,?,?,?,?,?,?)";
		Connection connection = DBConnection.getConnection();
		PreparedStatement preparedStatement = null;
		boolean flag = true;
		try {
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(updateSomainSQL);
			preparedStatement.setString(1, somain.getSoid());
			preparedStatement.setString(2, somain.getCreateTime());
			preparedStatement.setString(3, somain.getCustomerCode());
			preparedStatement.setString(4, somain.getAccount());
			preparedStatement.setFloat(5, somain.getTipFee());
			preparedStatement.setFloat(6, somain.getProductTotal());
			preparedStatement.setString(7, somain.getPayType());
			preparedStatement.setFloat(8, somain.getPrePayFee());
			preparedStatement.setString(9, somain.getRemark());
			preparedStatement.setInt(10, somain.getStatus());
			preparedStatement.addBatch();

			for (Soitem soitem : soitems) {
				String updateProductSQL = "update product set SONum=SONum+" + soitem.getNum()
						+ " where ProductCode='" + soitem.getProductCode() + "'";
				String updateSoitemSQL = "insert into soitem values('" + soitem.getSoid() + "','"
						+ soitem.getProductCode() + "'," + soitem.getUnitPrice() + ","
						+ soitem.getNum() + ",'" + soitem.getUnitName() + "',"
						+ soitem.getItemPrice() + ")";
				preparedStatement.addBatch(updateProductSQL);
				preparedStatement.addBatch(updateSoitemSQL);
			}

			int[] results = preparedStatement.executeBatch();
			for (int i : results) {
				if (i == 0) {
					flag = false;
					break;
				}
			}
			if (flag) {
				connection.commit();
			} else {
				connection.rollback();
			}
			connection.setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.DatabaseClose(null, null, preparedStatement, connection);
		}
	}

	public void deleteSomain_Soitem_Product(String soid) {// 删除主销售单时，同时删除明细单，并更新产品表
		String querySoitemSQL = "select * from soitem where SOID='" + soid + "'";
		String updateSoitemSQL = "delete from soitem where SOID=?";
		String updateSomainSQL = "delete from somain where SOID='" + soid + "'";
		Connection connection = DBConnection.getConnection();
		PreparedStatement preparedStatement = null;
		Statement statement = null;
		ResultSet resultSet = null;
		HashMap<String, Integer> soitems = new HashMap<String, Integer>();
		boolean flag = true;
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(querySoitemSQL);
			while (resultSet.next()) {
				String productCode_value = resultSet.getString("ProductCode");
				int num_value = resultSet.getInt("Num");
				soitems.put(productCode_value, num_value);
			}

			connection.setAutoCommit(false);

			preparedStatement = connection.prepareStatement(updateSoitemSQL);
			preparedStatement.setString(1, soid);
			preparedStatement.addBatch();
			for (String productCode_value : soitems.keySet()) {
				String updateProductSQL = "update product set SONum=SONum-"
						+ soitems.get(productCode_value) + " where ProductCode='"
						+ productCode_value + "'";
				preparedStatement.addBatch(updateProductSQL);
			}
			preparedStatement.addBatch(updateSomainSQL);
			int[] results = preparedStatement.executeBatch();
			for (int i : results) {
				if (i == 0) {
					flag = false;
					break;
				}
			}
			if (flag) {
				connection.commit();
			} else {
				connection.rollback();
			}
			connection.setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.DatabaseClose(resultSet, statement, preparedStatement, connection);
		}
	}

	public void deleteSoitem_Product(String soid, String productCode, int num, float productTotal) {// 删除明细单，并更新产品表
		String updateSoitemSQL = "delete from soitem where SOID=? and ProductCode=?";
		String updateSomainSQL = "update somain set ProductTotal=" + productTotal + " where SOID='"
				+ soid + "'";
		String updateProductSQL = "update product set SONum=SONum-" + num + " where ProductCode='"
				+ productCode + "'";
		Connection connection = DBConnection.getConnection();
		PreparedStatement preparedStatement = null;
		boolean flag = true;
		try {
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(updateSoitemSQL);
			preparedStatement.setString(1, soid);
			preparedStatement.setString(2, productCode);
			preparedStatement.addBatch();
			preparedStatement.addBatch(updateSomainSQL);
			preparedStatement.addBatch(updateProductSQL);
			int results[] = preparedStatement.executeBatch();
			for (int i : results) {
				if (i == 0) {
					flag = false;
				}
			}
			if (flag) {
				connection.commit();
			} else {
				connection.rollback();
			}
			connection.setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.DatabaseClose(null, null, preparedStatement, connection);
		}
	}

	public void updateSomain_Soitem_Product(Somain somain, ArrayList<Soitem> soitems,
			String[] num_beforeArray) {// 更新主销售单、明细单，并更新产品表
		String updateSomainSQL = "update somain set CustomerCode=?,TipFee=?,ProductTotal=?,PayType=?,PrePayFee=?,Remark=? where SOID=?";
		Connection connection = DBConnection.getConnection();
		PreparedStatement preparedStatement = null;
		Statement statement = null;
		boolean flag = true;
		try {
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(updateSomainSQL);
			preparedStatement.setString(1, somain.getCustomerCode());
			preparedStatement.setFloat(2, somain.getTipFee());
			preparedStatement.setFloat(3, somain.getProductTotal());
			preparedStatement.setString(4, somain.getPayType());
			preparedStatement.setFloat(5, somain.getPrePayFee());
			preparedStatement.setString(6, somain.getRemark());
			preparedStatement.setString(7, somain.getSoid());
			preparedStatement.addBatch();

			for (int i = 0; i < soitems.size(); i++) {
				String updateSoitemSQL = "update soitem set Num=" + soitems.get(i).getNum()
						+ ",Itemprice=" + soitems.get(i).getItemPrice() + " where ProductCode='"
						+ soitems.get(i).getProductCode() + "'";
				String updateProductSQL = "update product set SONum=SONum-" + num_beforeArray[i]
						+ "+" + soitems.get(i).getNum() + " where ProductCode='"
						+ soitems.get(i).getProductCode() + "'";
				preparedStatement.addBatch(updateSoitemSQL);
				preparedStatement.addBatch(updateProductSQL);
			}
			int[] results = preparedStatement.executeBatch();
			for (int i : results) {
				if (i == 0) {
					flag = false;
					break;
				}
			}
			if (flag) {
				connection.commit();
			} else {
				connection.rollback();
			}
			connection.setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.DatabaseClose(null, statement, preparedStatement, connection);
		}
	}
}
