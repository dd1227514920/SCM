package dao.finance;

import model.finance.Instock;
import model.finance.Stock;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by JerryCheng on 2017.7.18.
 */
public class InStockDBOperator {
    public ArrayList<Instock> Detailquery(String begin, String end) {
        ArrayList<Instock> ss=new ArrayList<Instock>();
        Connection conn = DBConnection.getConn();
        String sql = "select * from instockrecord where 1=1";
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
                Instock is=new Instock(stockId,productCode,orderCode,stockNum,stockType,stockTime,createUser);
                ss.add(is);

            }
            System.out.println("按日期查询入库表成功");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("按日期查询入库表失败");
        }finally{
            DBConnection.close(null,stat, conn);
        }
        return ss;
    }


}
