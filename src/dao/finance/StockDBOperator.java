
package dao.finance;
import model.finance.*;
import org.apache.taglibs.standard.tag.common.core.ForEachSupport;

import java.sql.*;
import java.util.ArrayList;

import static dao.finance.DBConnection.close;

/**
 * Created by JerryCheng on 2017.7.11.
 */
public class StockDBOperator {
    public ArrayList<Stock> query() {
        ArrayList<Stock> al=new ArrayList<Stock>();
        Connection conn = DBConnection.getConn();
        String sql = "select * from stock";
        Statement stat = null;
        try {

            stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                String productcode=rs.getString("productcode");
                String name=rs.getString("name");
                String unitname=rs.getString("unitname");
                int num=rs.getInt("num");

                Stock s=new Stock(productcode, name, unitname,num);
                al.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            close(null,stat, conn);
        }
        return al;
    }
    public ArrayList<Stock> recovery(ArrayList<Instock> iss,ArrayList<Outstock> oss) {
        ArrayList<Stock> al=new ArrayList<Stock>();
        Connection conn = DBConnection.getConn();
        String sql = "select * from stock";
        Statement stat = null;
        try {

            stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                String productcode=rs.getString("productcode");
                String name=rs.getString("name");
                String unitname=rs.getString("unitname");
                int num=rs.getInt("num");

                Stock s=new Stock(productcode, name, unitname,num);
                al.add(s);
            }

            for (Instock is:iss) {
                for (Stock alp:al) {
                    if(alp.getProductcode().equals(is.getProductCode()))
                        alp.setNum(alp.getNum()-is.getStockNum());
                }
            }

            for (Outstock os:oss) {
                for (Stock alp:al) {
                    if(alp.getProductcode().equals(os.getProductCode()))
                        alp.setNum(alp.getNum()+os.getStockNum());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            close(null,stat, conn);
        }
        return al;
    }

    public void update(int realnum, String productcode){
        Connection conn=DBConnection.getConn();
        String sql="update stock set num="+realnum+" where productcode='"+productcode+"'";
        System.out.println(sql);
        Statement stat=null;
        System.out.println(sql);
        try {
            stat=conn.createStatement();
            stat.executeUpdate(sql);
            System.out.println("修改库存成功");
        } catch (SQLException e) {
            System.out.println("修改库存失败");
            e.printStackTrace();
        }
    }

    public int querynum(String productcode) {
        ArrayList<Stock> al=new ArrayList<Stock>();
        Connection conn = DBConnection.getConn();
        String sql = "select * from stock where productcode= '"+productcode+"'";
        Statement stat = null;
        int num=0;
        try {

            stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                num=rs.getInt("num");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            close(null,stat, conn);
        }
        return num;
    }
    public Stock query(String productcode) {
        Connection conn = DBConnection.getConn();
        String sql = "select * from stock where productcode= '"+productcode+"'";
        Statement stat = null;
        Stock sk=new Stock();
        try {
            stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                String name=rs.getString("name");
                String unitname=rs.getString("unitname");
                int num=rs.getInt("num");
              sk=new Stock(productcode, name, unitname,num);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            close(null,stat, conn);
        }
        return sk;
    }


}
