package dao.storeDao;

import model.storeModel.Stock;
import model.storeModel.StockRecord;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by leo on 2017/7/14.
 */
public class ProductSheetDao {

    //得到当前库存表里所有产品的数量和
    public int getSum(){
        int sum=0;
        Connection conn=DBUtil.getConnection();
        Statement stat=null;
        ResultSet rs=null;
        String sql="select Num from stock";
        try {
            stat=conn.createStatement();
            rs=stat.executeQuery(sql);
            while (rs.next()){
                int num=rs.getInt("Num");
                sum+=num;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(rs,stat,conn);
        }
        return sum;
    }


//得到期间的出库入库差值
    public int getRecord(String dateMin,String dateMax){
        int sum=0;
        Connection conn= DBUtil.getConnection();
        Statement stat=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        String sql1="select * from instockrecord where StockTime>=? and StockTime<=?";

        try {
            ps=conn.prepareStatement(sql1);
            ps.setString(1,dateMin);
            ps.setString(2,dateMax);
            rs=ps.executeQuery();
            while (rs.next()){
                int stockNumOut=rs.getInt("StockNum");
                sum+=stockNumOut;
            }
            stat=conn.createStatement();
            String sql2="select * from instockrecord where StockTime>='"+dateMin+"' and StockTime<='"+dateMax+"'";
            rs=stat.executeQuery(sql2);
            while (rs.next()){
                int stockNumIn=rs.getInt("StockNum");
                sum-=stockNumIn;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(rs,ps,conn);
        }


        return sum;
    }


//库存表里各项产品的细目
    public ArrayList<Stock> queryStock(){
        ArrayList<Stock> al=new ArrayList<Stock>();
        Connection conn=DBUtil.getConnection();
        Statement stat=null;
        ResultSet rs=null;
        String sql="select * from stock";
        try {
            stat=conn.createStatement();
            rs=stat.executeQuery(sql);
            while (rs.next()){
               String productCode=rs.getString("ProductCode");
               String name=rs.getString("Name");
               String unitName=rs.getString("UnitName");
               int num=rs.getInt("Num");
               Stock s=new Stock(productCode,name,unitName,num);
               al.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  al;
    }



//根据产品的编号去查询期间出库的数量
    public ArrayList<Stock> getDetailSum(ArrayList<Stock> al){
        ArrayList<Stock> array=new ArrayList<Stock>();
        Connection conn=DBUtil.getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        String sql="select StockNum from outstockrecord where ProductCode=?";
        try {
            ps=conn.prepareStatement(sql);
            for(Stock s:al){
                int sum=0;
                ps.setString(1,s.getProductCode());
                rs=ps.executeQuery();
                while (rs.next()){
                    int stockNum=rs.getInt("StockNum");
                    sum+=stockNum;
                }
                Stock stock=new Stock(s.getProductCode(),s.getName(),s.getUnitName(),sum);
                array.add(stock);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return array;
    }

}
