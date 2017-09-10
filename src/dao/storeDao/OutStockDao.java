package dao.storeDao;

import model.storeModel.SOItem;
import model.storeModel.SOMain;
import util.DBUtil;
import java.sql.*;
import java.util.ArrayList;

/**
 * Created by leo on 2017/7/10.
 */
public class OutStockDao {
    //查询销售单主信息数据库中所有信息
    public ArrayList<SOMain> querySOMain(){
        ArrayList<SOMain> al=new ArrayList<SOMain>();
        String sql = "select * from somain";
        Connection conn = DBUtil.getConnection();
        Statement stat = null;
        ResultSet rs = null;
        try {
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            while (rs.next()) {
                String soid=rs.getString("SOID");
                String createTime=rs.getString("CreateTime");
                String customerCode=rs.getString("CustomerCode");
                String account=rs.getString("Account");
                float tipFee=rs.getFloat("TipFee");
                float productTotal=rs.getFloat("ProductTotal");
                String payType=rs.getString("PayType");
                float prePayFee=rs.getFloat("PrePayFee");
                String remark=rs.getString("Remark");
                int status=rs.getInt("Status");

                SOMain s=new SOMain();
                s.setSoid(soid);
                s.setCreateTime(createTime);
                s.setCustomerCode(customerCode);
                s.setAccount(account);
                s.setTipFee(tipFee);
                s.setProductTotal(productTotal);
                s.setPayType(payType);
                s.setPrePayFee(prePayFee);
                s.setRemark(remark);
                s.setStatus(status);

                al.add(s);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(rs,stat,conn);
        }

        return al;
    }


    //查询三种发货方式的销售单
    public ArrayList<SOMain> querySOM(int status,String type){
        ArrayList<SOMain> al=new ArrayList<SOMain>();
        String sql = "select * from somain where Status="+status+" and PayType='"+type+"'";
        Connection conn = DBUtil.getConnection();
        Statement stat = null;
        ResultSet rs = null;
        try {
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            while (rs.next()) {
                String soid=rs.getString("SOID");
                String createTime=rs.getString("CreateTime");
                String customerCode=rs.getString("CustomerCode");
                String account=rs.getString("Account");
                float tipFee=rs.getFloat("TipFee");
                float productTotal=rs.getFloat("ProductTotal");
                String payType=rs.getString("PayType");
                float prePayFee=rs.getFloat("PrePayFee");
                String remark=rs.getString("Remark");

                SOMain s=new SOMain();
                s.setSoid(soid);
                s.setCreateTime(createTime);
                s.setCustomerCode(customerCode);
                s.setAccount(account);
                s.setTipFee(tipFee);
                s.setProductTotal(productTotal);
                s.setPayType(payType);
                s.setPrePayFee(prePayFee);
                s.setRemark(remark);
                s.setStatus(status);

                al.add(s);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(rs,stat,conn);
        }

        return al;
    }




    //根据SOID去销售明细表中查询
    public ArrayList<SOItem> querySOItem(String SOID) {
        ArrayList<SOItem> al = new ArrayList<SOItem>();
        String sql = "select * from soitem where SOID='"+SOID+"'";
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
                String productCode=rs.getString("ProductCode");
                float unitPrice=rs.getFloat("UnitPrice");
                int num=rs.getInt("Num");
                String unitName=rs.getString("UnitName");
                float itemPrice=rs.getFloat("ItemPrice");

                String sql1="select Name from product where ProductCode=?";
                ps=conn.prepareStatement(sql1);
                ps.setString(1,productCode);
                rs1=ps.executeQuery();
                if(rs1.next()){
                    String name=rs1.getString("Name");
                    SOItem soItem=new SOItem(SOID,productCode,name,unitPrice,num,unitName,itemPrice);
                    al.add(soItem);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(rs,stat,conn);
        }
        return al;
    }





    //出库
    public boolean sale(ArrayList<SOItem> al,String user, String date){
        boolean flag=false;
        Connection conn = DBUtil.getConnection();
        try {
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        PreparedStatement ps=null;
        for(SOItem item:al){

            //修改库存表
            try {
                String sql1="update stock set Num=Num-? where ProductCode=?";
                ps=conn.prepareStatement(sql1);
                ps.setInt(1,item.getNum());
                ps.setString(2,item.getProductCode());
                ps.addBatch();

                //修改销售主单
                String sql2="update somain set Status=6,StockTime='"+date+"',StockUser='"+user+"' where SOID='"+item.getSoid()+"'";
                ps.addBatch(sql2);
                //修改产品表
                String sql3="update product set SONum=SONum-"+item.getNum()+" where ProductCode='"+item.getProductCode()+"'";
                ps.addBatch(sql3);

                //修改出库记录
                String sql4="insert into outstockrecord(ProductCode,OrderCode,StockNum,StockType,StockTime,CreateUser) values('"+item.getProductCode()+"','"+item.getSoid()+"',"+item.getNum()+",0,'"+date+"','"+user+"')";
                ps.addBatch(sql4);


                int[] value=ps.executeBatch();
                if(value[0]==1&&value[1]==1&&value[2]==1&&value[3]==1){
                    conn.commit();
                    flag=true;
                }else{
                    conn.rollback();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                DBUtil.close(null,ps,conn);
            }
        }
        return  flag;

    }


}
