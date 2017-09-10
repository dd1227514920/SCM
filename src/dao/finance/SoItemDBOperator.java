package dao.finance;
import model.finance.SoItem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static dao.finance.DBConnection.close;

/**
 * Created by JerryCheng on 2017.7.13.
 */
public class SoItemDBOperator {
    public ArrayList<SoItem> query(){
        ArrayList<SoItem> al=new ArrayList<SoItem>();
        Connection conn = DBConnection.getConn();
        String sql = "select * from poitem";
        Statement stat = null;

        try {
            stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                String soID=rs.getString("soID");
                String productCode=rs.getString("productCode");
                float unitPrice=rs.getFloat("unitPrice");
                int num=rs.getInt("num");
                String unitName=rs.getString("unitName");
                float itemPrice=rs.getFloat("itemPrice");
                String name=rs.getString("name");
                SoItem s=new SoItem(soID,productCode,unitPrice,num,unitName,itemPrice,name);
                al.add(s);

            }
            System.out.println("查询主销售单单明细成功");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("查询主销售单明细失败");
        }finally{
            close(null,stat, conn);
        }
        return al;
    }
    public ArrayList<SoItem> query(String soID){
        ArrayList<SoItem> al=new ArrayList<SoItem>();
        Connection conn = DBConnection.getConn();
        String sql = "select * from soitem where SOID='"+soID+"'";
        Statement stat = null;
        try {
            stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                String productCode=rs.getString("productCode");
                float unitPrice=rs.getFloat("unitPrice");
                int num=rs.getInt("num");
                String unitName=rs.getString("unitName");
                float itemPrice=rs.getFloat("itemPrice");
                SoItem s=new SoItem(soID,productCode,unitPrice,num,unitName,itemPrice,"");
                al.add(s);

            }
            System.out.println("查询主销售单单明细成功");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("查询主销售单明细失败");
        }finally{
            close(null,stat, conn);
        }
        return al;
    }

}
