package dao.purchase;

import model.purchasemodel.Poitem;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PoitemDao {
	public List<Poitem> queryAllPoitems() throws SQLException{
		String sql = "select * from poitem";
		List<Poitem> lpi = new ArrayList<Poitem>();
		
		Connection conn = null;
		ResultSet rs = null;
		Statement stat = null;
		try{
		conn = DBUtil.getConnection();
		stat = conn.createStatement();
		rs = stat.executeQuery(sql);
		
		while(rs.next()){
			String poId = rs.getString("POID");
			String productCode = rs.getString("ProductCode");
			float unitPrice = rs.getFloat("UnitPrice");
			int num = rs.getInt("Num");
			String unitName = rs.getString("UnitName");
			float itemPrice = rs.getFloat("itemPrice");
			Poitem pi = new Poitem(poId, productCode, unitPrice, num, unitName, itemPrice);
			lpi.add(pi);
		}
		return lpi;
		}finally{
			DBUtil.close(rs, stat, conn);
		}
	}
	public List<Poitem> queryOnePoitems(String poId) throws SQLException{
		String sql = "select * from poitem where POID=?";
		List<Poitem> lpi = new ArrayList<Poitem>();
		
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		try{
		conn = DBUtil.getConnection();
		ps = conn.prepareStatement(sql);
		ps.setString(1, poId);
		rs = ps.executeQuery();
		
		while(rs.next()){
			String productCode = rs.getString("ProductCode");
			float unitPrice = rs.getFloat("UnitPrice");
			int num = rs.getInt("Num");
			String unitName = rs.getString("UnitName");
			float itemPrice = rs.getFloat("itemPrice");
			Poitem pi = new Poitem(poId, productCode, unitPrice, num, unitName, itemPrice);
			lpi.add(pi);
		}
		return lpi;
		}finally{
			DBUtil.close(rs, ps, conn);
		}
	}
	public void addPoitem(String poId,String productCode,String unitPrice,String num,
			String unitName,String itemPrice
			) throws SQLException{
		String sql="insert into poitem (POID,ProductCode,UnitPrice,Num,unitName,itemPrice) value (?,?,?,?,?,?)";
		Connection conn=null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		
		try{
		conn = DBUtil.getConnection();
		ps = conn.prepareStatement(sql);
		ps.setString(1, poId);
		ps.setString(2, productCode);
		ps.setString(3, unitPrice);
		ps.setString(4, num);
		ps.setString(5, unitName);
		ps.setString(6, itemPrice);
		ps.executeUpdate();
		}
		finally{
			DBUtil.close(rs, ps, conn);
		}
	}
}
