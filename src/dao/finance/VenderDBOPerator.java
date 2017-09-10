package dao.finance;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static dao.finance.DBConnection.close;

/**
 * Created by JerryCheng on 2017.7.12.
 */
public class VenderDBOPerator {
    public String queryname(String vendercode) {
        Connection conn = DBConnection.getConn();
        String sql = "select * from vender where vendercode= '"+vendercode+"'";
        Statement stat = null;
        String name="";
        try {
            stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                name=rs.getString("name");
            }   System.out.println("查询采购商名字成功");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("查询采购商名字失败");
        }finally{
            close(null,stat, conn);
        }
        return name;
    }

}
