package dao.finance;
import java.sql.*;


public class DBConnection {
	private static String url="jdbc:mysql://localhost:3306/scm?Unicode=true&characterEncoding=UTF-8";
	private static String user="root";
	private static String password="lh";
	//静态代码块,用来封装驱动程序
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("驱动成功");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("驱动失败");
		}
	}
	//静态方法:用来获取数据库的连接
	public static Connection getConn(){
		Connection conn=null;
		try {
			conn=DriverManager.getConnection(url, user, password);
			//System.out.println("数据库连接成功");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("数据库连接失败");
		}
		return conn;
	}

	public static void close(ResultSet rs, Statement stat, Connection conn){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(stat!=null){
			try {
				stat.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
