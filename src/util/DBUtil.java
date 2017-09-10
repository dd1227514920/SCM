package util;
import java.sql.*;

/**
 * Created by leo on 2017/6/29.
 */
public class DBUtil {
    private static String url="jdbc:mysql://localhost:3306/scm?Unicode=true&characterEncoding=UTF-8";
    private static String user="root";
    private static String password="lh";
    //静态代码块,用来封装驱动程序
    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");
//            System.out.println("Driver Succeed");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Driver Failed");
        }
    }
    //静态方法:用来获取数据库的连接
    public static Connection getConnection(){
        Connection conn=null;
        try {
            conn= DriverManager.getConnection(url, user, password);
//            System.out.println("DB Connection Succeed");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("DB Connection Failed");
        }
        return conn;
    }



    public static void close(ResultSet rs, Statement stat,Connection conn){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if(stat!=null){
            try {
                stat.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }


}
