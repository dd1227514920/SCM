package dao.finance;
import model.finance.InOut;
import model.finance.PoMain;
import model.finance.User;

import java.sql.*;
import java.util.ArrayList;

import static dao.finance.DBConnection.close;

/**
 * Created by JerryCheng on 2017.7.12.
 */
public class PoMainDBOperator {
    public ArrayList<PoMain> query() {
        ArrayList<PoMain> al=new ArrayList<PoMain>();
        Connection conn = DBConnection.getConn();
        String sql = "select * from pomain where status <3";
        Statement stat = null;
        try {
            stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                String poID=rs.getString("poID");
                String venderCode=rs.getString("venderCode");
                String account=rs.getString("account");
                String createTime=rs.getString("createTime");
                float tipFee=rs.getInt("tipFee");
                float productTotal=rs.getInt("productTotal");
                float poTotal=rs.getInt("poTotal");
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
                PoMain s=new PoMain("",poID,venderCode,account,createTime,tipFee,productTotal,poTotal,payType,prePayFee,status,remark,stockTime,stockUser,payTime,payUser,prePayTime,prePayUser,endTime,endUser);
                al.add(s);

            }
            System.out.println("查询主采购单成功");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("查询主采购单失败");
        }finally{
            close(null,stat, conn);
        }
        return al;
    }

    public ArrayList<PoMain> query(String payType,int status) {
        ArrayList<PoMain> al=new ArrayList<PoMain>();
        Connection conn = DBConnection.getConn();
        String sql = "select * from pomain where payType='"+payType+"' and status="+status;
        Statement stat = null;
        try {
            stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                String poID=rs.getString("poID");
                String venderCode=rs.getString("venderCode");
                String account=rs.getString("account");
                String createTime=rs.getString("createTime");
                float tipFee=rs.getInt("tipFee");
                float productTotal=rs.getInt("productTotal");
                float poTotal=rs.getInt("poTotal");
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
                PoMain s=new PoMain("",poID,venderCode,account,createTime,tipFee,productTotal,poTotal,payType,prePayFee,status,remark,stockTime,stockUser,payTime,payUser,prePayTime,prePayUser,endTime,endUser);
                al.add(s);

            }
            System.out.println("查询主采购单成功");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("查询主采购单失败");
        }finally{
            close(null,stat, conn);
        }
        return al;
    }

    public ArrayList<PoMain> query(String payType) {
        ArrayList<PoMain> al=new ArrayList<PoMain>();
        Connection conn = DBConnection.getConn();
        String sql = "select * from pomain where payType='"+payType+"' and `status` <=2";
        System.out.println(sql);
        Statement stat = null;
        try {
            stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                String poID=rs.getString("poID");
                String venderCode=rs.getString("venderCode");
                String account=rs.getString("account");
                String createTime=rs.getString("createTime");
                float tipFee=rs.getInt("tipFee");
                float productTotal=rs.getInt("productTotal");
                float poTotal=rs.getInt("poTotal");
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
                PoMain s=new PoMain("",poID,venderCode,account,createTime,tipFee,productTotal,poTotal,payType,prePayFee,status,remark,stockTime,stockUser,payTime,payUser,prePayTime,prePayUser,endTime,endUser);
                al.add(s);

            }
            System.out.println("查询主采购单成功");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("查询主采购单失败");
        }finally{
            close(null,stat, conn);
        }
        return al;
    }

    public boolean pay(String POID,int status,String payuser,String paytime) throws SQLException {
        Connection conn = DBConnection.getConn();
        String sql;
        if(status==5) {
            sql = "update pomain set PrePayUser=?,Status=?,PrePayTime=? where POID=?";
        }
         else {
            sql = "update pomain set PayUser=?,Status=?,PayTime=? where POID=?";
        }
        PreparedStatement ps=null;
        conn.setAutoCommit(false);
        boolean flag=false;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, payuser);
            ps.setInt(2, status);
            ps.setString(3, paytime);
            ps.setString(4, POID);
            System.out.println(sql);
            flag = ps.executeUpdate()== 0 ? false : true;
        } finally {
            if (flag)
                conn.commit();
            else
                conn.rollback();
            conn.setAutoCommit(true);
            close(null,ps,conn);
        }
        return flag;
    }

    public ArrayList<PoMain> Detailquery(InOut inout) {
        ArrayList<PoMain> al=new ArrayList<PoMain>();
        Connection conn = DBConnection.getConn();
        String sql = "select * from pomain where 1=1";
        if(!(inout.getBegin().equals(""))||!(inout.getEnd().equals(""))||!(inout.getId().equals(""))||!(inout.getPaytype().equals("")))
        {

               if (!(inout.getBegin().equals("")) && !(inout.getEnd().equals(""))) {
                   if("预付款到发货".equals(inout.getPaytype())){
                       sql = sql + " and paytime > '" + inout.getBegin() + "' and paytime < '" + inout.getEnd() + "'";
                       sql = sql + " or (prepaytime > '" + inout.getBegin() + "' and prepaytime < '" + inout.getEnd() + "')";
                   }
                   else
                       sql = sql + " and paytime > '" + inout.getBegin() + "' and paytime < '" + inout.getEnd() + "'";
               }

            if(!(inout.getId().equals("")))
                sql=sql+" and poid like '%"+inout.getId()+"%'";
            if(!(inout.getPaytype().equals("")))
                sql=sql+" and paytype='"+inout.getPaytype()+"'";
        }
        System.out.println(sql);
        Statement stat = null;
        try {
            stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                String poID=rs.getString("poID");
                String venderCode=rs.getString("venderCode");
                String account=rs.getString("account");
                String createTime=rs.getString("createTime");
                float tipFee=rs.getInt("tipFee");
                float productTotal=rs.getInt("productTotal");
                float poTotal=rs.getInt("poTotal");
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
                PoMain s=new PoMain("",poID,venderCode,account,createTime,tipFee,productTotal,poTotal,payType,prePayFee,status,remark,stockTime,stockUser,payTime,payUser,prePayTime,prePayUser,endTime,endUser);
                al.add(s);

            }
            System.out.println("详细查询采购单成功");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("详细查询采购单成功");
        }finally{
            close(null,stat, conn);
        }
        return al;
    }

}
