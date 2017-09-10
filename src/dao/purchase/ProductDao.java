package dao.purchase;

import model.purchasemodel.Product;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
	public List<Product> queryAllProduct() throws SQLException{
		String sql = "select * from product";
		List<Product> lpd = new ArrayList<Product>();
		
		Connection conn = null;
		ResultSet rs = null;
		Statement stat = null;
		try{
		conn = DBUtil.getConnection();
		stat = conn.createStatement();
		rs = stat.executeQuery(sql);
		
		while(rs.next()){
			String productCode = rs.getString("ProductCode");
			int categoryId = rs.getInt("CategoryId");
			String name = rs.getString("Name");
			String unitName = rs.getString("UnitName");
			float price = rs.getFloat("Price");
			String createDate = rs.getString("CreateDate");
			String remark = rs.getString("Remark");
			int poNum = rs.getInt("PONum");
			int soNum = rs.getInt("SONum");
			Product pd = new Product(productCode, categoryId, name, unitName, price, remark, poNum, soNum);
			lpd.add(pd);
		}
		return lpd;
		}finally{
			DBUtil.close(rs, stat, conn);
		}
	}
	public void poAddProduct(String productCode,String num) throws SQLException{
	
		String sql = "select ponum from product where productCode = ?";
		String sql2 = "update product set ponum=? where productCode = ?";
		int ponum=0;
		
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		try{
		conn = DBUtil.getConnection();
		ps = conn.prepareStatement(sql);
		ps.setString(1, productCode);
		rs = ps.executeQuery();
		if(rs.next()){
			ponum=rs.getInt("ponum");
		}
		ponum=ponum+Integer.parseInt(num);
		ps.close();
		ps = conn.prepareStatement(sql2);
		ps.setInt(1, ponum);
		ps.setString(2, productCode);
		ps.executeUpdate();
		}finally{
			DBUtil.close(rs, ps, conn);
		}
	}
	
}
