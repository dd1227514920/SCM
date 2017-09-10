package dao.finance;

import model.finance.Page;
import model.finance.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDBOperator {
    //查询全部用户
    public ArrayList<User> query() {
        ArrayList<User> al = new ArrayList<User>();
        Connection conn = DBConnection.getConn();
        String sql = "select * from scmuser";
        Statement stat = null;
        try {
            stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                String account = rs.getString("account");
                String password = rs.getString("password");
                String name = rs.getString("name");
                String createDate = rs.getString("createDate");
                String status = rs.getString("status");
                String limits = rs.getString("auth");
                User s = new User(account, password, name, createDate, status, limits);
                al.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(null, stat, conn);
        }
        return al;
    }

    public String querylimits(String account) {
        ArrayList<User> al = new ArrayList<User>();
        Connection conn = DBConnection.getConn();
        String sql = "select * from scmuser where Account='"+account+"'";
        Statement stat = null;
        String limits="";
        try {
            stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                limits = rs.getString("auth");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(null, stat, conn);
        }
        return limits;
    }

    public boolean isDuplicat(String username) {
        String sql = "select * from scmuser where account=?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DBConnection.getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if (rs.next())
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs, ps, conn);
        }
        return false;
    }

    //批量增加
    public boolean add(User user) throws SQLException {
        Connection conn = DBConnection.getConn();
        conn.setAutoCommit(false);
        String sql = "insert into scmuser values(?,?,?,?,?,?)";
        PreparedStatement ps = null;
        boolean flag = false;
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getAccount());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getName());
            ps.setString(4, user.getCreateDate());
            ps.setString(5, user.getStatus());
            ps.setString(6, user.getLimits());
            ps.addBatch();
            flag = ps.executeBatch()[0] == 0 ? false : true;
        } finally {
            if (flag)
                conn.commit();
            else
                conn.rollback();
            conn.setAutoCommit(true);
            close(null, ps, conn);
        }
        return flag;
    }


    public boolean update(User p, String account) throws SQLException {
        Connection conn = DBConnection.getConn();
        conn.setAutoCommit(false);
        String sql = "update scmuser set password='" + p.getPassword() + "',name='" + p.getName() + "',createdate='" + p.getCreateDate() + "',status='" + p.getStatus() + "',auth='" + p.getLimits() + "' where account='" + account + "'";
        System.out.println(sql);
        Statement stat = null;
        System.out.println(sql);
        boolean flag = false;
        try {
            stat = conn.createStatement();
            flag = stat.executeUpdate(sql)== 0 ? false : true;
        } finally {
            if (flag)
                conn.commit();
            else
                conn.rollback();
            conn.setAutoCommit(true);
            close(null,stat, conn);
        }
        return flag;
    }

    public boolean delete(String account) throws SQLException {
        Connection conn = DBConnection.getConn();
        String sql = "delete from scmuser where account= '" + account + "'";
        conn.setAutoCommit(false);
        Statement stat = null;
        boolean flag = false;
        try {
            stat = conn.createStatement();
            flag = stat.executeUpdate(sql) == 0 ? false : true;
            System.out.println("删除成功");
        } catch (SQLException e) {
            System.out.println("删除失败");
            e.printStackTrace();
        } finally {
            if (flag)
                conn.commit();
            else
                conn.rollback();
            conn.setAutoCommit(true);
            close(null, stat, conn);
        }
        return flag;
    }


    public int queryTotalCount() {
        String sql = "select count(*) n from scmuser";
        int n = 0;
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;

        try {
            conn = DBConnection.getConn();
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            if (rs.next()) {
                n = rs.getInt("n");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs, stat, conn);
        }
        return n;
    }

    public void queryData(Page page) {
        String sql = "select * from scmuser auth limit ?,?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<User> sl = new ArrayList<User>();

        try {
            conn = DBConnection.getConn();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (page.getCurrentPage() - 1) * page.getPageSize());
            ps.setInt(2, page.getPageSize());
            rs = ps.executeQuery();
            while (rs.next()) {
                String account = rs.getString("account");
                String password = rs.getString("password");
                String name = rs.getString("name");
                String createDate = rs.getString("createDate");
                String status = rs.getString("status");
                String limits = rs.getString("auth");
                User s = new User(account, password, name, createDate, status, limits);
                sl.add(s);
            }
            page.setData(sl);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs, ps, conn);
        }
    }


    private void close(ResultSet rs, Statement stat, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stat != null) {
            try {
                stat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean queryexist(String username, String password) {
        Connection conn = DBConnection.getConn();
        String sql = "select * from scmuser where account='" + username + "'and password='" + password + "'";
        Statement stat = null;
        try {
            stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            if (rs.next())
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}