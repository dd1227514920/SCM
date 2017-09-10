package dao.sales;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBClose {
	public static void DatabaseClose(ResultSet resultSet, Statement statement, PreparedStatement preparedStatement,
			Connection connection) {// 方法：关闭数据库操作部件
		if (resultSet != null) {
			try {
				resultSet.close();// 关闭ResultSet对象
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (statement != null) {
			try {
				statement.close();// 关闭Statement对象
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (preparedStatement != null) {
			try {
				preparedStatement.close();// 关闭Statement对象
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (connection != null) {
			try {
				connection.close();// 关闭Connection对象
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}