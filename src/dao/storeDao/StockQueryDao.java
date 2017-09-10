package dao.storeDao;
import model.storeModel.Stock;
import model.storeModel.StockQuery;
import model.storeModel.StockRecord;
import util.DBUtil;
import java.sql.*;
import java.util.ArrayList;

/**
 * Created by leo on 2017/7/13.
 */
public class StockQueryDao {
    //查询库存
    public ArrayList<StockQuery> query(){
        ArrayList<StockQuery> al=new ArrayList<StockQuery>();
        String sql = "select ProductCode,Name,PONum,SONum from product";
        String sql1="select Num from stock where ProductCode=?";
        Connection conn = DBUtil.getConnection();
        Statement stat = null;
        PreparedStatement ps=null;
        ResultSet rs = null;
        ResultSet rs1 = null;
        try {
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            while (rs.next()) {
                String productCode = rs.getString("ProductCode");
                String name = rs.getString("Name");
                int poNum=rs.getInt("PONum");
                int soNum=rs.getInt("SONum");
                StockQuery s=new StockQuery();
                s.setProductCode(productCode);
                s.setName(name);
                s.setPoNum(poNum);
                s.setSoNum(soNum);
                ps=conn.prepareStatement(sql1);
                ps.setString(1,productCode);
                rs1=ps.executeQuery();
                if(rs1.next()){
                    int num=rs1.getInt("Num");
                    s.setNum(num);
                }
                al.add(s);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(rs,stat,conn);
        }
        return al;
    }



    //根据产品编号查询库存变更记录
    public ArrayList<StockRecord> queryInRecord(String productCode){
        ArrayList<StockRecord> records = new ArrayList<StockRecord>();
        String sql = "select * from instockrecord where ProductCode='"+productCode+"'";
        Connection conn = DBUtil.getConnection();
        Statement stat = null;
        ResultSet rs = null;

        try {
            stat=conn.createStatement();
            rs=stat.executeQuery(sql);
            while (rs.next()){
                int stockID=rs.getInt("StockID");
                String orderCode=rs.getString("OrderCode");
                int stockNum=rs.getInt("StockNum");
                int stockType=rs.getInt("StockType");
                String stockTime=rs.getString("StockTime");
                String createUser=rs.getString("CreateUser");
                StockRecord record=new StockRecord(stockID,productCode,orderCode,stockNum,stockType,stockTime,createUser);
                records.add(record);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(rs,stat,conn);
        }

        return  records;
    }



    public ArrayList<StockRecord> queryOutRecord(String productCode,ArrayList<StockRecord> records){

        String sql = "select * from outstockrecord where ProductCode='"+productCode+"'";
        Connection conn = DBUtil.getConnection();
        Statement stat = null;
        ResultSet rs = null;

        try {
            stat=conn.createStatement();
            rs=stat.executeQuery(sql);
            while (rs.next()){
                int stockID=rs.getInt("StockID");
                String orderCode=rs.getString("OrderCode");
                int stockNum=rs.getInt("StockNum");
                int stockType=rs.getInt("StockType");
                String stockTime=rs.getString("StockTime");
                String createUser=rs.getString("CreateUser");
                StockRecord record=new StockRecord(stockID,productCode,orderCode,stockNum,stockType,stockTime,createUser);
                records.add(record);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(rs,stat,conn);
        }

        return  records;
    }



    //产品库存模糊查询
    public ArrayList<Stock> search(String sql){
        ArrayList<Stock> al=new ArrayList<Stock>();
        Connection conn=DBUtil.getConnection();
        Statement stat=null;
        ResultSet rs=null;

        try {
            stat=conn.createStatement();
            rs=stat.executeQuery(sql);
            while (rs.next()){
                String productCode=rs.getString("ProductCode");
                String name=rs.getString("Name");
                String unitName=rs.getString("UnitName");
                int num=rs.getInt("Num");
                Stock stock=new Stock(productCode,name,unitName,num);
                al.add(stock);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return al;
    }
}
