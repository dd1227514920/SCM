package dao.sales;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.sales.User;


public class UserDao {

	public User loginVerify(String username, String password) {
		String queryUserSQL = "select * from scmuser where Account=? and Password=?";
		Connection connection = DBConnection.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		User user = null;
		try {
			preparedStatement = connection.prepareStatement(queryUserSQL);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String name = resultSet.getString("Name");
				String createDate = resultSet.getString("CreateDate");
				String status = resultSet.getString("Status");
				String auth = resultSet.getString("Auth");
				user = new User(username, password, name, createDate, status, auth);
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.DatabaseClose(resultSet, null, preparedStatement, connection);
		}
		return user;
	}
}