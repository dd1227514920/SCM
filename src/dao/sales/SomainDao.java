package dao.sales;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.sales.Somain;


public class SomainDao {
	// 向数据库somain表增加销售单
	public void addSomain(Somain somain) {
		String updateSQL = "insert into somain(SOID,CreateTime,CustomerCode,Account,TipFee,ProductTotal,PayType,PrePayFee,Remark) values(?,?,?,?,?,?,?,?,?)";
		Connection connection = DBConnection.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(updateSQL);
			preparedStatement.setString(1, somain.getSoid());
			preparedStatement.setString(2, somain.getCreateTime());
			preparedStatement.setString(3, somain.getCustomerCode());
			preparedStatement.setString(4, somain.getAccount());
			preparedStatement.setFloat(5, somain.getTipFee());
			preparedStatement.setFloat(6, somain.getProductTotal());
			preparedStatement.setString(7, somain.getPayType());
			preparedStatement.setFloat(8, somain.getPrePayFee());
			preparedStatement.setString(9, somain.getRemark());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.DatabaseClose(null, null, preparedStatement, connection);
		}
	}

	// 从数据库somain表查询所有的销售单
	public ArrayList<Somain> querySomain() {
		ArrayList<Somain> somainAll = new ArrayList<Somain>();
		String querySQL = "select * from somain";
		Connection connection = DBConnection.getConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(querySQL);
			while (resultSet.next()) {
				String soid = resultSet.getString("SOID");
				String createTime = resultSet.getString("CreateTime");
				String customerCode = resultSet.getString("CustomerCode");
				String account = resultSet.getString("Account");
				float tipFee = resultSet.getFloat("TipFee");
				float productTotal = resultSet.getFloat("ProductTotal");
				String payType = resultSet.getString("PayType");
				float prePayFee = resultSet.getFloat("prePayFee");
				int status = resultSet.getInt("Status");
				Somain somain = new Somain(soid, createTime, customerCode, account, tipFee,
						productTotal, payType, prePayFee, status);
				somainAll.add(somain);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return somainAll;
	}

	// 从数据库somain表根据soid查询单条销售单记录
	public Somain queryOneSomain(String soid_value) {
		Somain somain = null;
		String querySQL = "select * from somain where SOID='" + soid_value + "'";
		Connection connection = DBConnection.getConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(querySQL);
			while (resultSet.next()) {
				String soid = resultSet.getString("SOID");
				String createTime = resultSet.getString("CreateTime");
				String customerCode = resultSet.getString("CustomerCode");
				String account = resultSet.getString("Account");
				float tipFee = resultSet.getFloat("TipFee");
				float productTotal = resultSet.getFloat("ProductTotal");
				String payType = resultSet.getString("PayType");
				float prePayFee = resultSet.getFloat("prePayFee");
				String remark = resultSet.getString("Remark");
				int status = resultSet.getInt("Status");
				somain = new Somain(soid, createTime, customerCode, account, tipFee, productTotal,
						payType, prePayFee, remark, status);
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return somain;
	}

	// 从数据库somain表根据customerCode查询销售单记录
	public boolean querySomainByCustomerCode(String customerCode) {
		boolean ifExit = false;
		String querySQL = "select * from somain where CustomerCode='" + customerCode + "'";
		Connection connection = DBConnection.getConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(querySQL);
			while (resultSet.next()) {
				ifExit = true;
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ifExit;
	}

	// 从数据库somain表根据查询条件查询匹配的销售单记录
	public ArrayList<Somain> queryDetailedSomain(Somain somain, String startTime, String endTime) {
		ArrayList<Somain> somainMatched = new ArrayList<Somain>();
		Connection connection = DBConnection.getConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		int count = 0;
		String sql = "select * from somain where";
		if (!somain.getSoid().equals("")) {
			sql = sql + " SOID like'%" + somain.getSoid() + "%'";
			count++;
		}
		if (!somain.getCustomerCode().equals("")) {
			if (count == 0) {
				sql = sql + " CustomerCode='" + somain.getCustomerCode() + "'";
				count++;
			} else {
				sql = sql + " and CustomerCode='" + somain.getCustomerCode() + "'";
				count++;
			}
		}
		if (!somain.getPayType().equals("")) {
			if (count == 0) {
				sql = sql + " PayType='" + somain.getPayType() + "'";
				count++;
			} else {
				sql = sql + " and PayType='" + somain.getPayType() + "'";
				count++;
			}
		}
		if (somain.getStatus() != -1) {
			if (count == 0) {
				sql = sql + " Status=" + somain.getStatus();
				count++;
			} else {
				sql = sql + " and Status=" + somain.getStatus();
				count++;
			}
		}
		if (!startTime.equals("") && !endTime.equals("")) {
			if (count == 0) {
				sql = sql + " CreateTime>='" + startTime + "' and CreateTime<='" + endTime + "'";
			} else {
				sql = sql + " and CreateTime>='" + startTime + "' and CreateTime<='" + endTime
						+ "'";
			}
		}
		System.out.println(sql);
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				String soid = resultSet.getString("SOID");
				String createTime = resultSet.getString("CreateTime");
				String customerCode = resultSet.getString("CustomerCode");
				String account = resultSet.getString("Account");
				float tipFee = resultSet.getFloat("TipFee");
				float productTotal = resultSet.getFloat("ProductTotal");
				String payType = resultSet.getString("PayType");
				float prePayFee = resultSet.getFloat("prePayFee");
				int status = resultSet.getInt("Status");
				Somain somain1 = new Somain(soid, createTime, customerCode, account, tipFee,
						productTotal, payType, prePayFee, status);
				somainMatched.add(somain1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.DatabaseClose(resultSet, statement, null, connection);
		}
		return somainMatched;
	}

	// 从数据库somain表查询可了结的货到付款销售单记录
	public ArrayList<Somain> querySomainFinished_HDFK(String username) {
		String querySQL = "select * from somain where PayType='货到付款' and Status=3 and Account='"
				+ username + "'";
		Connection connection = DBConnection.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<Somain> somainFinished_HDFK = new ArrayList<Somain>();
		try {
			preparedStatement = connection.prepareStatement(querySQL);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String soid = resultSet.getString("SOID");
				String createTime = resultSet.getString("CreateTime");
				String customerCode = resultSet.getString("CustomerCode");
				String account = resultSet.getString("Account");
				float tipFee = resultSet.getFloat("TipFee");
				float productTotal = resultSet.getFloat("ProductTotal");
				String payType = resultSet.getString("PayType");
				float prePayFee = resultSet.getFloat("prePayFee");
				int status = resultSet.getInt("Status");
				Somain somain = new Somain(soid, createTime, customerCode, account, tipFee,
						productTotal, payType, prePayFee, status);
				somainFinished_HDFK.add(somain);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.DatabaseClose(resultSet, null, preparedStatement, connection);
		}
		return somainFinished_HDFK;
	}

	// 从数据库somain表查询可了结的款到发货销售单记录
	public ArrayList<Somain> querySomainFinished_KDFH(String username) {
		String querySQL = "select * from somain where PayType='款到发货' and Status=6 and Account='"
				+ username + "'";
		Connection connection = DBConnection.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<Somain> somainFinished_KDFH = new ArrayList<Somain>();
		try {
			preparedStatement = connection.prepareStatement(querySQL);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String soid = resultSet.getString("SOID");
				String createTime = resultSet.getString("CreateTime");
				String customerCode = resultSet.getString("CustomerCode");
				String account = resultSet.getString("Account");
				float tipFee = resultSet.getFloat("TipFee");
				float productTotal = resultSet.getFloat("ProductTotal");
				String payType = resultSet.getString("PayType");
				float prePayFee = resultSet.getFloat("prePayFee");
				int status = resultSet.getInt("Status");
				Somain somain = new Somain(soid, createTime, customerCode, account, tipFee,
						productTotal, payType, prePayFee, status);
				somainFinished_KDFH.add(somain);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.DatabaseClose(resultSet, null, preparedStatement, connection);
		}
		return somainFinished_KDFH;
	}

	// 从数据库somain表查询可了结的预付款发货销售单记录
	public ArrayList<Somain> querySomainFinished_YFKFH(String username) {
		String querySQL = "select * from somain where PayType='预付款到发货' and Status=3 and Account='"
				+ username + "'";
		Connection connection = DBConnection.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<Somain> somainFinished_YFKFH = new ArrayList<Somain>();
		try {
			preparedStatement = connection.prepareStatement(querySQL);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String soid = resultSet.getString("SOID");
				String createTime = resultSet.getString("CreateTime");
				String customerCode = resultSet.getString("CustomerCode");
				String account = resultSet.getString("Account");
				float tipFee = resultSet.getFloat("TipFee");
				float productTotal = resultSet.getFloat("ProductTotal");
				String payType = resultSet.getString("PayType");
				float prePayFee = resultSet.getFloat("prePayFee");
				int status = resultSet.getInt("Status");
				Somain somain = new Somain(soid, createTime, customerCode, account, tipFee,
						productTotal, payType, prePayFee, status);
				somainFinished_YFKFH.add(somain);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.DatabaseClose(resultSet, null, preparedStatement, connection);
		}
		return somainFinished_YFKFH;
	}

	// 从数据库somain表根据时间查询销售单
	public ArrayList<Somain> querySomainByTime(String startTime, String endTime) {
		String querySQL = "select * from somain where CreateTime>=? and CreateTime<=?";
		Connection connection = DBConnection.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<Somain> somainList = new ArrayList<Somain>();
		try {
			preparedStatement = connection.prepareStatement(querySQL);
			preparedStatement.setString(1, startTime);
			preparedStatement.setString(2, endTime);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String soid = resultSet.getString("SOID");
				String createTime = resultSet.getString("CreateTime");
				String customerCode = resultSet.getString("CustomerCode");
				String account = resultSet.getString("Account");
				float tipFee = resultSet.getFloat("TipFee");
				float productTotal = resultSet.getFloat("ProductTotal");
				String payType = resultSet.getString("PayType");
				float prePayFee = resultSet.getFloat("prePayFee");
				int status = resultSet.getInt("Status");
				Somain somain = new Somain(soid, createTime, customerCode, account, tipFee,
						productTotal, payType, prePayFee, status);
				somainList.add(somain);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.DatabaseClose(resultSet, null, preparedStatement, connection);
		}
		return somainList;
	}

	// 从数据库somain表根据soid删除销售单
	public void deleteSomain(String soid) {
		String updateSQL = "delete from somain where SOID=?";
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

	// 从数据库somain表根据soid了结销售单
	public boolean finishSomain(String soid) {
		String updateSQL = "update somain set Status=4 where SOID='" + soid + "'";
		Connection connection = DBConnection.getConnection();
		Statement statement = null;
		boolean flag = true;
		try {
			statement = connection.createStatement();
			int result = statement.executeUpdate(updateSQL);
			if (result == 0) {
				flag = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.DatabaseClose(null, statement, null, connection);
		}
		return flag;
	}
}
