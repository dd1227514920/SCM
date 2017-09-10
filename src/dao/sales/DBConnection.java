package dao.sales;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	static {// 数据库连接驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("驱动成功");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("驱动失败");
		}
	}

	public static Connection getConnection() {// 方法：连接数据库
		String url = "jdbc:mysql://localhost:3306/scm?Unicode=true&characterEncoding=UTF-8";
		String username = "root";
		String password = "lh";
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url, username, password);
			System.out.println("数据库连接成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("数据库连接失败");
			e.printStackTrace();
		}
		return connection;
	}
}