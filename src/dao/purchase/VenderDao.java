package dao.purchase;

import model.purchasemodel.Page;
import model.purchasemodel.Vender;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VenderDao {
	public List<Vender> queryAllVenders() throws SQLException{
		String sql="select * from vender";
		List<Vender> lv = new ArrayList<Vender>();
		Connection conn=null;
		ResultSet rs = null;
		Statement stat = null;
		
		try{
		conn = DBUtil.getConnection();
		stat = conn.createStatement();
		rs = stat.executeQuery(sql);
		while(rs.next()){
			String venderCode = rs.getString("venderCode");
			String name = rs.getString("name");
			String password = rs.getString("password");
			String contactor = rs.getString("contactor");
			String address = rs.getString("address");
			String postCode = rs.getString("postCode");
			String tel = rs.getString("tel");
			String fax = rs.getString("fax");
			String createDate = rs.getString("createDate");
			Vender vd = new Vender(venderCode, name, password, contactor, address, postCode, tel, fax, createDate);
			lv.add(vd);
		}
		return lv;
		}
		finally{
			DBUtil.close(rs, stat, conn);
		}
	}
	public boolean isVender(String vendercode) throws SQLException{
		String sql="select * from vender where vendercode=?";
		Connection conn=null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		
		try{
		conn = DBUtil.getConnection();
		ps = conn.prepareStatement(sql);
		ps.setString(1, vendercode);
		rs = ps.executeQuery();
		return rs.next();
		}
		finally{
			DBUtil.close(rs, ps, conn);
		}
	}
	public void addVender(String vendercode,String name,String password,String contactor,
			String address,String postcode,String tel,String fax,String createdate) throws SQLException{
		String sql="insert into vender (VenderCode,Name,Password,Contactor,Address,Postcode,Tel,Fax,CreateDate) value (?,?,?,?,?,?,?,?,?)";
		Connection conn=null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		
		try{
		conn = DBUtil.getConnection();
		ps = conn.prepareStatement(sql);
		ps.setString(1, vendercode);
		ps.setString(2, name);
		ps.setString(3, password);
		ps.setString(4, contactor);
		ps.setString(5, address);
		ps.setString(6, postcode);
		ps.setString(7, tel);
		ps.setString(8, fax);
		ps.setString(9, createdate);
		ps.executeUpdate();
		}
		finally{
			DBUtil.close(rs, ps, conn);
		}
	}
	public void updateVender(String vendercode,String name,String password,String contactor,
			String address,String postcode,String tel,String fax,String createdate) throws SQLException{
		String sql="update vender set name=?,password=?,contactor=?,address=?,postcode=?,tel=?,fax=?,createdate=? where vendercode=?";
		Connection conn=null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		
		try{
		conn = DBUtil.getConnection();
		ps = conn.prepareStatement(sql);
		ps.setString(1, name);
		ps.setString(2, password);
		ps.setString(3, contactor);
		ps.setString(4, address);
		ps.setString(5, postcode);
		ps.setString(6, tel);
		ps.setString(7, fax);
		ps.setString(8, createdate);
		ps.setString(9, vendercode);
		ps.executeUpdate();
		}
		finally{
			DBUtil.close(rs, ps, conn);
		}
	}
	public void deletedVender(String vendercode) throws SQLException{
		String sql="delete from vender where vendercode=?";
		Connection conn=null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		try{
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, vendercode);
			ps.executeUpdate();
			}
			finally{
				DBUtil.close(rs, ps, conn);
			}
	}
	public int queryTotalCount() throws SQLException{
		String sql="select count(*) n from vender";
		
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.getConnection();
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			if (rs.next()) {
				int n = rs.getInt("n");
				return n;
			}
			return 0;
		} finally {
			DBUtil.close(rs, stat, conn);
		}
	}
	public void queryDate(Page page) throws SQLException{
		String sql="select * from vender limit ?,?";
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Vender> lv = new ArrayList<Vender>();
		
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, (page.getCurrentPage() - 1) * page.getPageSize());
			ps.setInt(2, page.getPageSize());
			rs = ps.executeQuery();
			while (rs.next()) {
				String venderCode = rs.getString("venderCode");
				String name = rs.getString("name");
				String password = rs.getString("password");
				String contactor = rs.getString("contactor");
				String address = rs.getString("address");
				String postCode = rs.getString("postCode");
				String tel = rs.getString("tel");
				String fax = rs.getString("fax");
				String createDate = rs.getString("createDate");
				Vender vd = new Vender(venderCode, name, password, contactor, address, postCode, tel, fax, createDate);
				lv.add(vd);
			}
			page.setData(lv);
		} finally {
			DBUtil.close(rs, ps, conn);
		}
	}
}
