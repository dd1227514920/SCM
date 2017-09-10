package dao.finance;

import model.finance.CheckStock;
import java.sql.*;
import java.util.ArrayList;

import static dao.finance.DBConnection.close;

/**
 * Created by JerryCheng on 2017.7.11.
 */
public class CheckStockDBOperator {
    public ArrayList<CheckStock> query() {
        ArrayList<CheckStock> al=new ArrayList<CheckStock>();
        Connection conn = DBConnection.getConn();
        String sql = "select * from CheckStock";
        Statement stat = null;
        try {
            stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                String productcode=rs.getString("ProductCode");
                String StockTime=rs.getString("StockTime");
                String CreateUser=rs.getString("CreateUser");
                String Description=rs.getString("Description");
                String Type=rs.getString("Type");
                int OriginNum=rs.getInt("SOriginNum");
                int RealNum=rs.getInt("RealNum");

                CheckStock s=new CheckStock(productcode,OriginNum,RealNum,StockTime,CreateUser,Description,Type);
                al.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            DBConnection.close(null,stat, conn);
        }
        return al;
    }

    public void add(CheckStock cs){
        Connection conn=DBConnection.getConn();
        String sql="insert into checkstock(productcode,OriginNum,RealNum,StockTime,CreateUser,Description,Type)values(?,?,?,?,?,?,?)";
        PreparedStatement ps=null;
        try{
            ps=conn.prepareStatement(sql);
                ps.setString(1,cs.getProductcode());
                ps.setString(2, String.valueOf(cs.getOriginnum()));
                ps.setString(3, String.valueOf(cs.getRealnum()));
                ps.setString(4, cs.getStocktime());
                ps.setString(5,cs.getCreateUser());
                ps.setString(6,cs.getDescription());
                ps.setString(7,cs.getType());
                ps.addBatch();
            ps.executeBatch();
            System.out.println("添加成功");
        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("添加失败");
        }finally{
            DBConnection.close(null, ps, conn);
        }
    }





}
