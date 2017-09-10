package dao.finance;

import model.finance.CheckStock;
import model.finance.Product;
import model.finance.Stock;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static dao.finance.DBConnection.close;

/**
 * Created by JerryCheng on 2017.7.11.
 */
public class ProductDBOperator {
    public ArrayList<Product> query() {
        ArrayList<Product> al=new ArrayList<Product>();
        Connection conn = DBConnection.getConn();
        String sql = "select * from Product";
        Statement stat = null;
        try {

            stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                String ProductCode=rs.getString("ProductCode");
                int CategoryID=rs.getInt("CategoryID");
                String name=rs.getString("name");
                String UnitName=rs.getString("UnitName");
                float Price=rs.getFloat("Price");
                String CreateDate=rs.getString("CreateDate");
                String Remark=rs.getString("Remark");
                int PONum=rs.getInt("PONum");
                int SONum=rs.getInt("SONum");

                Product s=new Product(ProductCode,CategoryID,name, UnitName,Price,CreateDate,Remark,PONum,SONum,0);
                al.add(s);

            }System.out.println("查询成功");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("查询失败");
        }finally{
            close(null,stat, conn);
        }
        return al;
    }

    public ArrayList<Product> datequery(String begin, String end) {
        ArrayList<Product> ss=new ArrayList<Product>();
        Connection conn = DBConnection.getConn();
        String sql = "select * from product where 1=1";
        if(!(begin.equals(""))&&!(end.equals(""))) {
            sql = sql + " and createdate > '" + begin + "' and createdate < '" + end + "'";
        }
        System.out.println(sql);
        Statement stat = null;
        try {
            stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                String ProductCode=rs.getString("ProductCode");
                int CategoryID=rs.getInt("CategoryID");
                String name=rs.getString("name");
                String UnitName=rs.getString("UnitName");
                float Price=rs.getFloat("Price");
                String CreateDate=rs.getString("CreateDate");
                String Remark=rs.getString("Remark");
                int PONum=rs.getInt("PONum");
                int SONum=rs.getInt("SONum");
                Product s=new Product(ProductCode,CategoryID,name, UnitName,Price,CreateDate,Remark,PONum,SONum,0);
                ss.add(s);

            }System.out.println("查询产品表成功");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("查询产品表失败");
        }finally{
            close(null,stat, conn);
        }
        return ss;
    }

    public String queryname(String productcode) {
        Connection conn = DBConnection.getConn();
        String sql = "select * from product where productcode= '"+productcode+"'";
        Statement stat = null;
        String name="";
        try {

            stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                name=rs.getString("name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            close(null,stat, conn);
        }
        return name;
    }



}
