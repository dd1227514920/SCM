package dao.storeDao;

import model.storeModel.StockRecord;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by leo on 2017/7/14.
 */
public class StockSheetDao {
    //查询入库记录
    public List<StockRecord> inStockSheet(String dateMin,String dateMax){
        List<StockRecord> al=new ArrayList<StockRecord>();
        Connection conn= DBUtil.getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        String sql="select * from instockrecord where StockTime>=? and StockTime<=?";
        try {
            ps=conn.prepareStatement(sql);
            ps.setString(1,dateMin);
            ps.setString(2,dateMax);
            rs=ps.executeQuery();
            while (rs.next()){
                int stockID=rs.getInt("StockID");
                String productCode=rs.getString("ProductCode");
                String orderCode=rs.getString("OrderCode");
                int stockNum=rs.getInt("StockNum");
                int stockType=rs.getInt("StockType");
                String stockTime=rs.getString("StockTime");
                String creatUser=rs.getString("CreateUser");
                StockRecord record=new StockRecord(stockID,productCode,orderCode,stockNum,stockType,stockTime,creatUser);
                al.add(record);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(rs,ps,conn);
        }


        return al;
    }



    public float getFee(List<StockRecord> al){
        int money=0;
        Connection conn=DBUtil.getConnection();
        Statement stat=null;
        ResultSet rs=null;
        try {
            stat=conn.createStatement();
            for(StockRecord record:al){
                String sql="select POTotal from pomain where POID='"+record.getOrderCode()+"'";
                rs=stat.executeQuery(sql);
                if(rs.next()){
                    Float total=rs.getFloat("POTotal");
                    money+=total;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  money;
    }


    public List<StockRecord> outStockSheet(String dateMin,String dateMax){
        List<StockRecord> al=new ArrayList<StockRecord>();
        Connection conn= DBUtil.getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        String sql="select * from outstockrecord where StockTime>=? and StockTime<=?";
        try {
            ps=conn.prepareStatement(sql);
            ps.setString(1,dateMin);
            ps.setString(2,dateMax);
            rs=ps.executeQuery();
            while (rs.next()){
                int stockID=rs.getInt("StockID");
                String productCode=rs.getString("ProductCode");
                String orderCode=rs.getString("OrderCode");
                int stockNum=rs.getInt("StockNum");
                int stockType=rs.getInt("StockType");
                String stockTime=rs.getString("StockTime");
                String creatUser=rs.getString("CreateUser");
                StockRecord record=new StockRecord(stockID,productCode,orderCode,stockNum,stockType,stockTime,creatUser);
                al.add(record);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(rs,ps,conn);
        }
        return al;
    }

    public float getMoney(List<StockRecord> al){
        int money=0;
        Connection conn=DBUtil.getConnection();
        Statement stat=null;
        ResultSet rs=null;
        try {
            stat=conn.createStatement();
            for(StockRecord record:al){
                String sql="select SOTotal from somain where SOID='"+record.getOrderCode()+"'";
                rs=stat.executeQuery(sql);
                if(rs.next()){
                    Float total=rs.getFloat("SOTotal");
                    money+=total;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  money;
    }


}
