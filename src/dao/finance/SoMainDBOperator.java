package dao.finance;
import model.finance.InOut;
import model.finance.SoMain;

import java.sql.*;
import java.util.ArrayList;

import static dao.finance.DBConnection.close;

/**
 * Created by JerryCheng on 2017.7.13.
 */
public class SoMainDBOperator {
    public ArrayList<SoMain> query() {
        ArrayList<SoMain> al=new ArrayList<SoMain>();
        Connection conn = DBConnection.getConn();
        String sql = "select * from somain where status=1 or status=6";
        Statement stat = null;
        try {
            stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                String soID=rs.getString("soID");
                String customerCode=rs.getString("customerCode");
                String account=rs.getString("account");
                String createTime=rs.getString("createTime");
                float tipFee=rs.getInt("tipFee");
                float productTotal=rs.getInt("productTotal");
                float soTotal=rs.getInt("soTotal");
                String payType=rs.getString("payType");
                float prePayFee=rs.getFloat("prePayFee");
                int status=rs.getInt("status");
                String remark=rs.getString("remark");
                String stockTime=rs.getString("stockTime");
                String stockUser=rs.getString("stockUser");
                String payTime=rs.getString("payTime");
                String payUser=rs.getString("payUser");
                String prePayTime=rs.getString("prePayTime");
                String prePayUser=rs.getString("prePayUser");
                String endTime=rs.getString("endTime");
                String endUser=rs.getString("endUser");
                SoMain s=new SoMain("",soID,customerCode,account,createTime,tipFee,productTotal,soTotal,payType,prePayFee,status,remark,stockTime,stockUser,payTime,payUser,prePayTime,prePayUser,endTime,endUser);
                al.add(s);

            }
            System.out.println("查询主销售单成功");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("查询主销售单失败");
        }finally{
            close(null,stat, conn);
        }
        return al;
    }

    public ArrayList<SoMain> query(String payType,int status) {
        ArrayList<SoMain> al=new ArrayList<SoMain>();
        Connection conn = DBConnection.getConn();
        String sql = "select * from somain where payType='"+payType+"' and status="+status;
        Statement stat = null;
        try {
            stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                String soID=rs.getString("soID");
                String customerCode=rs.getString("customerCode");
                String account=rs.getString("account");
                String createTime=rs.getString("createTime");
                float tipFee=rs.getInt("tipFee");
                float productTotal=rs.getInt("productTotal");
                float soTotal=rs.getInt("soTotal");
                float prePayFee=rs.getFloat("prePayFee");
                String remark=rs.getString("remark");
                String stockTime=rs.getString("stockTime");
                String stockUser=rs.getString("stockUser");
                String payTime=rs.getString("payTime");
                String payUser=rs.getString("payUser");
                String prePayTime=rs.getString("prePayTime");
                String prePayUser=rs.getString("prePayUser");
                String endTime=rs.getString("endTime");
                String endUser=rs.getString("endUser");
                SoMain s=new SoMain("",soID,customerCode,account,createTime,tipFee,productTotal,soTotal,payType,prePayFee,status,remark,stockTime,stockUser,payTime,payUser,prePayTime,prePayUser,endTime,endUser);
                al.add(s);

            }
            System.out.println("查询主销售单成功");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("查询主销售单失败");
        }finally{
            close(null,stat, conn);
        }
        return al;
    }

    public ArrayList<SoMain> query(String payType) {
        ArrayList<SoMain> al=new ArrayList<SoMain>();
        Connection conn = DBConnection.getConn();
        String sql = "select * from somain where payType='"+payType+"' and `status` =1 or `status`=6";
        System.out.println(sql);
        Statement stat = null;
        try {
            stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                String soID=rs.getString("soID");
                String customerCode=rs.getString("customerCode");
                String account=rs.getString("account");
                String createTime=rs.getString("createTime");
                float tipFee=rs.getInt("tipFee");
                float productTotal=rs.getInt("productTotal");
                float soTotal=rs.getInt("soTotal");
                float prePayFee=rs.getFloat("prePayFee");
                String remark=rs.getString("remark");
                int status=rs.getInt("status");
                String stockTime=rs.getString("stockTime");
                String stockUser=rs.getString("stockUser");
                String payTime=rs.getString("payTime");
                String payUser=rs.getString("payUser");
                String prePayTime=rs.getString("prePayTime");
                String prePayUser=rs.getString("prePayUser");
                String endTime=rs.getString("endTime");
                String endUser=rs.getString("endUser");
                SoMain s=new SoMain("",soID,customerCode,account,createTime,tipFee,productTotal,soTotal,payType,prePayFee,status,remark,stockTime,stockUser,payTime,payUser,prePayTime,prePayUser,endTime,endUser);
                al.add(s);
            }
            System.out.println("查询主销售单成功");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("查询主销售单失败");
        }finally{
            close(null,stat, conn);
        }
        return al;
    }

    public ArrayList<SoMain> Detailquery(InOut inout) {
        ArrayList<SoMain> al=new ArrayList<SoMain>();
        Connection conn = DBConnection.getConn();
        String sql = "select * from somain where 1=1";
        if(!(inout.getBegin().equals(""))||!(inout.getEnd().equals(""))||!(inout.getId().equals(""))||!(inout.getPaytype().equals("")))
        {

            if (!(inout.getBegin().equals("")) && !(inout.getEnd().equals(""))) {
                if("预付款到发货".equals(inout.getPaytype())){
                    sql = sql + " and paytime > '" + inout.getBegin() + "' and paytime < '" + inout.getEnd() + "'";
                    sql = sql + " or (prepaytime > '" + inout.getBegin() + "' and prepaytime < '" + inout.getEnd() + "')";
                }
                else{
                    sql = sql + " and paytime > '" + inout.getBegin() + "' and paytime < '" + inout.getEnd() + "'";
                }

            }
            if(!(inout.getId().equals("")))
                sql=sql+" and soid like '%"+inout.getId()+"%'";
            if(!(inout.getPaytype().equals("")))
                sql=sql+" and paytype='"+inout.getPaytype()+"'";
        }
        System.out.println(sql);
        Statement stat = null;
        try {
            stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                String soID=rs.getString("soID");
                String customerCode=rs.getString("customerCode");
                String account=rs.getString("account");
                String createTime=rs.getString("createTime");
                float tipFee=rs.getInt("tipFee");
                float productTotal=rs.getInt("productTotal");
                float soTotal=rs.getInt("soTotal");
                float prePayFee=rs.getFloat("prePayFee");
                String remark=rs.getString("remark");
                int status=rs.getInt("status");
                String payType=rs.getString("payType");
                String stockTime=rs.getString("stockTime");
                String stockUser=rs.getString("stockUser");
                String payTime=rs.getString("payTime");
                String payUser=rs.getString("payUser");
                String prePayTime=rs.getString("prePayTime");
                String prePayUser=rs.getString("prePayUser");
                String endTime=rs.getString("endTime");
                String endUser=rs.getString("endUser");
                SoMain s=new SoMain("",soID,customerCode,account,createTime,tipFee,productTotal,soTotal,payType,prePayFee,status,remark,stockTime,stockUser,payTime,payUser,prePayTime,prePayUser,endTime,endUser);
                al.add(s);

            }
            System.out.println("详细查询销售单成功");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("详细查询销售单成功");
        }finally{
            close(null,stat, conn);
        }
        return al;
    }



    public boolean earn(String SOID, int status, String payuser, String paytime) throws SQLException {
        Connection conn = DBConnection.getConn();
        String sql;
        if(status==7){
            sql = "update somain set PrePayUser=?,Status=?,PrePayTime=? where SOID=?";
        }
       else {
            sql = "update somain set PayUser=?,Status=?,PayTime=? where SOID=?";
        }

        PreparedStatement ps=null;
        conn.setAutoCommit(false);
        boolean flag=false;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, payuser);
            ps.setInt(2, status);
            ps.setString(3, paytime);
            ps.setString(4, SOID);
            System.out.println(sql);
            flag = ps.executeUpdate()== 0 ? false : true;
        }
        finally {
            if (flag)
                conn.commit();
            else
                conn.rollback();
            conn.setAutoCommit(true);
            close(null,ps,conn);
        }
        return flag;
    }

}
