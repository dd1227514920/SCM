package dao.purchase;
import model.purchasemodel.ScmUser;
import util.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ScmUserDao {
	public ScmUser checkLog(String account, String password) throws SQLException{
		String sql = "select name,createdate,status from scmuser where account=? and password=?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, account);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if (rs.next()) {
				String name = rs.getString("name");
				String createdate = rs.getString("createdate");
				String status = rs.getString("status");
				ScmUser su = new ScmUser(account, password, name, createdate, status);
				return su;
			}
			return null;
		} finally {
			DBUtil.close(rs, ps, conn);
		}
	}
	public String queryAuth(String account) throws SQLException{
		String sql = "SELECT ModelName from systemmodel where ModelCode =(SELECT ModelCode FROM usermodel where Account =?)";
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		try{
		conn = DBUtil.getConnection();
		ps = conn.prepareStatement(sql);
		ps.setString(1, account);
		rs = ps.executeQuery();
		if(rs.next()){
			return rs.getString("ModelName");
			}
		return null;
		}finally{
			DBUtil.close(rs, null, conn);
		}
	}
	public String queryVali(String account) throws SQLException{
		String sql = "select * from scmuser where account=?";
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		try{
		conn = DBUtil.getConnection();
		ps = conn.prepareStatement(sql);
		ps.setString(1, account);
		rs = ps.executeQuery();
		if(rs.next()){
			return "用户名存在";
			}
		return "用户名不存在";
		}finally{
			DBUtil.close(rs, null, conn);
		}
	}
}
