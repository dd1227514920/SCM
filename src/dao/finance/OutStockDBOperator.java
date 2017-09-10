package dao.finance;

import model.finance.Instock;
import model.finance.Outstock;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by JerryCheng on 2017.7.18.
 */
public class OutStockDBOperator {
    public ArrayList<Outstock> Detailquery(String begin, String end) {
        ArrayList<Outstock> ss=new ArrayList<Outstock>();
        Connection conn = DBConnection.getConn();
        String sql = "select * from Outstockrecord where 1=1";
        if(!(begin.equals(""))&&!(end.equals(""))) {
            sql = sql + " and stocktime > '" + begin + "' and stocktime < '" + end + "'";
        }
        System.out.println(sql);
        Statement stat = null;
        try {

            stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                int stockId=rs.getInt("stockId");
                String productCode=rs.getString("productCode");
                String orderCode=rs.getString("orderCode");
                int stockNum=rs.getInt("stockNum");
                int stockType=rs.getInt("stockType");
                String stockTime=rs.getString("stockTime");
                String createUser=rs.getString("createUser");
                Outstock is=new Outstock(stockId,productCode,orderCode,stockNum,stockType,stockTime,createUser);
                ss.add(is);

            }
            System.out.println("按日期查询出库表成功");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("按日期查询出库表失败");
        }finally{
            DBConnection.close(null,stat, conn);
        }
        return ss;
    }
}
