package dao.finance;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by JerryCheng on 2017.7.13.
 */
public class CustomerDBOperator {
    public String queryname(String customercode) {
        Connection conn = DBConnection.getConn();
        String sql = "select * from customer where customercode= '"+customercode+"'";
        Statement stat = null;
        String Name="";
        try {
            stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                Name=rs.getString("Name");
            }
            System.out.println("查询客户名字成功");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("查询客户名字失败");
        }finally{
            DBConnection.close(null,stat, conn);
        }
        return Name;
    }

}
