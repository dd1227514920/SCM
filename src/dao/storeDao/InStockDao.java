package dao.storeDao;

import model.storeModel.POItem;
import model.storeModel.POMain;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by leo on 2017/7/10.
 */
public class InStockDao {
    //查询采购单主信息数据库中所有信息
    public ArrayList<POMain> queryPOMain(){
        ArrayList<POMain> al=new ArrayList<POMain>();
        String sql = "select * from pomain";
        Connection conn = DBUtil.getConnection();
        Statement stat = null;
        ResultSet rs = null;
        try {
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            while (rs.next()) {
                String poID=rs.getString("POID");
                String createTime=rs.getString("CreateTime");
                String venderCode=rs.getString("VenderCode");
                String account=rs.getString("Account");
                float tipFee=rs.getFloat("Tipfee");
                float productTotal=rs.getFloat("ProductTotal");
                float poTotal=rs.getFloat("POTotal");
                String payType=rs.getString("PayType");
                float prePayFee=rs.getFloat("PrePayFee");
                int status=rs.getInt("Status");

                POMain p=new POMain();
                p.setPoID(poID);
                p.setCreateTime(createTime);
                p.setVenderCode(venderCode);
                p.setAccount(account);
                p.setTipFee(tipFee);
                p.setProductTotal(productTotal);
                p.setPoTotal(poTotal);
                p.setPayType(payType);
                p.setPrePayFee(prePayFee);
                p.setStatus(status);

                al.add(p);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(rs,stat,conn);
        }

        return al;
    }


    //查询三种发货方式的采购单
    public ArrayList<POMain> queryPOM(int status,String type){
        ArrayList<POMain> al=new ArrayList<POMain>();
        String sql = "select * from pomain where Status="+status+" and PayType='"+type+"'";
        Connection conn = DBUtil.getConnection();
        Statement stat = null;
        ResultSet rs = null;
        try {
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            while (rs.next()) {
                String poID=rs.getString("POID");
                String createTime=rs.getString("CreateTime");
                String venderCode=rs.getString("VenderCode");
                String account=rs.getString("Account");
                float tipFee=rs.getFloat("Tipfee");
                float productTotal=rs.getFloat("ProductTotal");
                float poTotal=rs.getFloat("POTotal");
                String payType=rs.getString("PayType");
                float prePayFee=rs.getFloat("PrePayFee");

                POMain p=new POMain();
                p.setPoID(poID);
                p.setCreateTime(createTime);
                p.setVenderCode(venderCode);
                p.setAccount(account);
                p.setTipFee(tipFee);
                p.setProductTotal(productTotal);
                p.setPoTotal(poTotal);
                p.setPayType(payType);
                p.setPrePayFee(prePayFee);
                p.setStatus(status);

                al.add(p);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(rs,stat,conn);
        }

        return al;
    }




    //根据POID去采购明细表中查询
    public ArrayList<POItem> queryPOItem(String POID) {
        ArrayList<POItem> al = new ArrayList<POItem>();
        String sql = "select * from poitem where POID='"+POID+"'";
        Connection conn = DBUtil.getConnection();
        Statement stat = null;
        PreparedStatement ps=null;
        ResultSet rs= null;
        ResultSet rs1= null;
        ResultSet rs2= null;

        try {
            stat=conn.createStatement();
            rs=stat.executeQuery(sql);
            while (rs.next()){
                String poID=rs.getString("POID");
                String productCode=rs.getString("ProductCode");
                float unitPrice=rs.getFloat("UnitPrice");
                int num=rs.getInt("Num");
                String unitName=rs.getString("UnitName");
                float itemPrice=rs.getFloat("ItemPrice");
                String sql1="select Name from product where ProductCode=?";
                ps=conn.prepareStatement(sql1);
                ps.setString(1,productCode);
                rs1=ps.executeQuery();
                String sql2="select PayType from pomain where POID=?";
                ps=conn.prepareStatement(sql2);
                ps.setString(1,POID);
                rs2=ps.executeQuery();
                if(rs1.next()&&rs2.next()){
                    String name=rs1.getString("Name");
                    String payType=rs2.getString("PayType");
                    POItem poItem=new POItem(poID,productCode,unitPrice,num,unitName,itemPrice,name,payType);
                    al.add(poItem);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(rs,stat,conn);
        }
        return al;
    }





    //入库
    public boolean stock(ArrayList<POItem> al,String user, String date){
        boolean flag=false;
        Connection conn = DBUtil.getConnection();
        try {
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        PreparedStatement ps=null;
        try {
            for(POItem item:al){
                 //修改库存表
                String sql1="update stock set Num=Num+? where ProductCode=?";
                ps=conn.prepareStatement(sql1);
                ps.setInt(1,item.getNum());
                ps.setString(2,item.getProductCode());
                ps.addBatch();

                //修改采购主单
                String sql2="update pomain set Status=2,StockTime='"+date+"',StockUser='"+user+"' where POID='"+item.getPoID()+"'";
                ps.addBatch(sql2);

                //修改产品表
                String sql3="update product set PONum=PONum-"+item.getNum()+",SONum=SONum+"+item.getNum()+" where ProductCode='"+item.getProductCode()+"'";
                ps.addBatch(sql3);

                //修改入库记录
                String sql4="insert into instockrecord(ProductCode,OrderCode,StockNum,StockType,StockTime,CreateUser) values('"+item.getProductCode()+"','"+item.getPoID()+"',"+item.getNum()+",1,'"+date+"','"+user+"')";
                ps.addBatch(sql4);


                int[] value=ps.executeBatch();

                if(value[0]==1&&value[1]==1&&value[2]==1&&value[3]==1){
                    conn.commit();
                    flag=true;

                }else{
                    conn.rollback();
                }

            }
        } catch (SQLException e) {
                e.printStackTrace();
            }
        finally {
            DBUtil.close(null,ps,conn);
        }
        return flag;
    }



}
