package dao.finance;

import model.finance.PoItem;
import model.finance.SoItem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by JerryCheng on 2017.7.12.
 */
public class PoItemDBOperator {
    public ArrayList<PoItem> query(){
        ArrayList<PoItem> al=new ArrayList<PoItem>();
        Connection conn = DBConnection.getConn();
        String sql = "select * from poitem";
        Statement stat = null;

        try {
            stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                String poID=rs.getString("poID");
                String productCode=rs.getString("productCode");
                float unitPrice=rs.getFloat("unitPrice");
                int num=rs.getInt("num");
                String unitName=rs.getString("unitName");
                float itemPrice=rs.getFloat("itemPrice");
                String name=rs.getString("name");
                PoItem s=new PoItem(poID,productCode,unitPrice,num,unitName,itemPrice,name);
                al.add(s);

            } System.out.println("查询主采购单明细成功");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("查询主采购单明细失败");
        }finally{
            DBConnection.close(null,stat, conn);
        }
        return al;
    }
    public ArrayList<PoItem> query(String poID){
        ArrayList<PoItem> al=new ArrayList<PoItem>();
        Connection conn = DBConnection.getConn();
        String sql = "select * from poitem where POID='"+poID+"'";
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
                PoItem s=new PoItem(poID,productCode,unitPrice,num,unitName,itemPrice,"");
                al.add(s);
            }
            System.out.println("查询主采购单明细成功");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("查询主采购单明细失败");
        }finally{
            DBConnection.close(null,stat, conn);
        }
        return al;
    }

}
