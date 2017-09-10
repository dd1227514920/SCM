package dao.purchase;

import model.purchasemodel.Poitem;
import model.purchasemodel.Pomain;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;


public class PomainDao {
	public List<Pomain> queryAllPomains(String accountt) throws SQLException {
		String sql = "select * from pomain where account='"+accountt+"'";
		List<Pomain> lp = new ArrayList<Pomain>();
		
		Connection conn = null;
		ResultSet rs = null;
		Statement stat = null;
		try {
			conn = DBUtil.getConnection();
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);

			while (rs.next()) {
				String poId = rs.getString("POID");
				String venderCode = rs.getString("VenderCode");
				String account = rs.getString("Account");
				String createTime = rs.getString("CreateTime");
				float tipFee = rs.getFloat("TipFee");
				float productTotal = rs.getFloat("ProductTotal");
				float poTotal = rs.getFloat("POTotal");
				String payType = rs.getString("PayType");
				float prePayFee = rs.getFloat("PrePayFee");
				int status = rs.getInt("Status");
				String remark = rs.getString("Remark");
				String stockTime = rs.getString("StockTime");
				String stockUser = rs.getString("StockUser");
				String payTime = rs.getString("PayTime");
				String payUser = rs.getString("PayUser");
				String prePayTime = rs.getString("PrePayTime");
				String prePayUser = rs.getString("PrePayUser");
				String endTime = rs.getString("EndTime");
				String endUser = rs.getString("EndUser");
				Pomain pm = new Pomain(poId, venderCode, account, createTime,
						tipFee, productTotal, poTotal, payType, prePayFee,
						status, remark, stockTime, stockUser, payTime, payUser,
						prePayUser, prePayTime, endTime, endUser);
				lp.add(pm);
			}
			return lp;
		} finally {
			DBUtil.close(rs, stat, conn);
		}
	}

	public void addPomain(Pomain pm,List<Poitem> lpi){
		String sql = "insert into pomain (POID,VenderCode,Account,CreateTime,TipFee,ProductTotal,PoTotal,PayType,PrePayFee,Status,Remark) value (?,?,?,?,?,?,?,?,?,?,?)";
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;

		try {
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);
			ps.setString(1, pm.getPoId());
			ps.setString(2, pm.getVenderCode());
			ps.setString(3, pm.getAccount());
			ps.setString(4, pm.getCreateTime());
			ps.setFloat(5, pm.getTipFee());
			ps.setFloat(6, pm.getProductTotal());
			ps.setFloat(7, pm.getPoTotal());
			ps.setString(8, pm.getPayType());
			ps.setFloat(9, pm.getPrePayFee());
			ps.setInt(10, pm.getStatus());
			ps.setString(11, pm.getRemark());
			ps.addBatch();
			for(int i=0;i<lpi.size();i++){
			String itemSql = "insert into poitem (POID,ProductCode,UnitPrice,Num,unitName,itemPrice) value ('"+lpi.get(i).getPoId()+"','"+lpi.get(i).getProductCode()+"','"+lpi.get(i).getUnitPrice()+"','"+lpi.get(i).getNum()+"','"+lpi.get(i).getUnitName()+"','"+lpi.get(i).getItemPrice()+"')";
			ps.addBatch(itemSql);
			String productSql = "update product set ponum=ponum+"+lpi.get(i).getNum()+" where productCode='"+lpi.get(i).getProductCode()+"'";
			ps.addBatch(productSql);
			}
			ps.executeBatch();
			conn.commit();
			//ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			DBUtil.close(rs, ps, conn);
		}
	}
	public void deletePomain(String poId, HttpServletRequest request){
		String sql="select ProductCode,Num from poitem where POID='"+poId+"'";
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		List<Poitem> lpi =new ArrayList<Poitem>();
		try {
			conn= DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				String pc = rs.getString("ProductCode");
				int num = rs.getInt("Num");
				Poitem pi = new Poitem();
				pi.setProductCode(pc);
				pi.setNum(num);
				lpi.add(pi);
			}
			conn.setAutoCommit(false);
			for(int i=0;i<lpi.size();i++){
				String productSql = "update product set ponum=(ponum-"+lpi.get(i).getNum()+") where ProductCode="+lpi.get(i).getProductCode();
				ps.addBatch(productSql);
			}
			String poitemSql = "delete from poitem where POID='"+poId+"'";
			ps.addBatch(poitemSql);
			String pomainSql = "delete from pomain where POID='"+poId+"'";
			ps.addBatch(pomainSql);
		//	throw new SQLException();
			ps.executeBatch();
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				request.setAttribute("message", "删除失败");
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, ps, conn);
		}
	}
	public Pomain queryOnePomains(String poId) throws SQLException {
		String sql = "select * from pomain where POID='"+poId+"'";

		Connection conn = null;
		ResultSet rs = null;
		Statement stat = null;
		try {
			conn = DBUtil.getConnection();
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);

			if(rs.next()) {
				//String poId = rs.getString("POID");
				String venderCode = rs.getString("VenderCode");
				String account = rs.getString("Account");
				String createTime = rs.getString("CreateTime");
				float tipFee = rs.getFloat("TipFee");
				float productTotal = rs.getFloat("ProductTotal");
				float poTotal = rs.getFloat("POTotal");
				String payType = rs.getString("PayType");
				float prePayFee = rs.getFloat("PrePayFee");
				int status = rs.getInt("Status");
				String remark = rs.getString("Remark");
				String stockTime = rs.getString("StockTime");
				String stockUser = rs.getString("StockUser");
				String payTime = rs.getString("PayTime");
				String payUser = rs.getString("PayUser");
				String prePayTime = rs.getString("PrePayTime");
				String prePayUser = rs.getString("PrePayUser");
				String endTime = rs.getString("EndTime");
				String endUser = rs.getString("EndUser");
				Pomain pm = new Pomain(poId, venderCode, account, createTime,
						tipFee, productTotal, poTotal, payType, prePayFee,
						status, remark, stockTime, stockUser, payTime, payUser,
						prePayUser, prePayTime, endTime, endUser);
			return pm;
			}
			return null;
		} finally {
			DBUtil.close(rs, stat, conn);
		}
	}

	public void updatePomain(Pomain pm, List<Poitem> lpi, HttpServletRequest request) {
		// TODO Auto-generated method stub
		String sql="select ProductCode,Num from poitem where POID="+pm.getPoId();
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		List<Poitem> lpi2 =new ArrayList<Poitem>();
		try{
			conn= DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				String pc = rs.getString("ProductCode");
				int num = rs.getInt("Num");
				Poitem pi = new Poitem();
				pi.setProductCode(pc);
				pi.setNum(num);
				lpi2.add(pi);
			}
			conn.setAutoCommit(false);
			for(int i=0;i<lpi2.size();i++){
				String productSql = "update product set ponum=(ponum-"+lpi2.get(i).getNum()+") where ProductCode="+lpi2.get(i).getProductCode();
				ps.addBatch(productSql);
			}
			String poitemSql = "delete from poitem where POID='"+pm.getPoId()+"'";
			ps.addBatch(poitemSql);
			String pomainSql = "delete from pomain where POID='"+pm.getPoId()+"'";
			ps.addBatch(pomainSql);	
			String sql2 = "insert into pomain (POID,VenderCode,Account,CreateTime,TipFee,ProductTotal,PoTotal,PayType,PrePayFee,Status,Remark) value ("+pm.getPoId()+",'"+pm.getVenderCode()+"','"+pm.getAccount()+"','"+pm.getCreateTime()+"',"+pm.getTipFee()+","+pm.getProductTotal()+","+pm.getPoTotal()+",'"+pm.getPayType()+"',"+pm.getPrePayFee()+","+pm.getStatus()+",'"+pm.getRemark()+"')";
			ps.addBatch(sql2);
			for(int i=0;i<lpi.size();i++){
				String itemSql = "insert into poitem (POID,ProductCode,UnitPrice,Num,unitName,itemPrice) value ('"+lpi.get(i).getPoId()+"','"+lpi.get(i).getProductCode()+"','"+lpi.get(i).getUnitPrice()+"','"+lpi.get(i).getNum()+"','"+lpi.get(i).getUnitName()+"','"+lpi.get(i).getItemPrice()+"')";
				ps.addBatch(itemSql);
				String productSql = "update product set ponum=ponum+"+lpi.get(i).getNum()+" where productCode='"+lpi.get(i).getProductCode()+"'";
				ps.addBatch(productSql);
			}
			ps.executeBatch();
			conn.commit();
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			try {
				request.setAttribute("message", "修改失败");
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally{
			DBUtil.close(rs, ps, conn);
		}
	}
	public List<Pomain> querydate(String poId, String startTime,
										 String endTime, String venderCode, String payType) throws SQLException {
		String sql = "select * from pomain where ";

		if (!startTime.equals("")) {
			sql = sql + "and createTime > '" + startTime + "' ";
		}
		if (!endTime.equals("")) {
			sql = sql + "and createTime < '" + endTime + "' ";
		}

		sql = sql.split("and", 2)[0] + sql.split("and", 2)[1];
		System.out.println(sql);
		Connection conn = null;
		ResultSet rs = null;
		Statement stat = null;
		List<Pomain> lpm = new ArrayList<Pomain>();
		try {
			conn = DBUtil.getConnection();
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);

			while (rs.next()) {
				String poId2 = rs.getString("POID");
				String venderCode2 = rs.getString("VenderCode");
				String account = rs.getString("Account");
				String createTime = rs.getString("CreateTime");
				float tipFee = rs.getFloat("TipFee");
				float productTotal = rs.getFloat("ProductTotal");
				float poTotal = rs.getFloat("POTotal");
				String payType2 = rs.getString("PayType");
				float prePayFee = rs.getFloat("PrePayFee");
				int status = rs.getInt("Status");
				String remark = rs.getString("Remark");
				String stockTime = rs.getString("StockTime");
				String stockUser = rs.getString("StockUser");
				String payTime = rs.getString("PayTime");
				String payUser = rs.getString("PayUser");
				String prePayTime = rs.getString("PrePayTime");
				String prePayUser = rs.getString("PrePayUser");
				String endTime2 = rs.getString("EndTime");
				String endUser = rs.getString("EndUser");
				Pomain pm = new Pomain(poId2, venderCode2, account, createTime,
						tipFee, productTotal, poTotal, payType2, prePayFee,
						status, remark, stockTime, stockUser, payTime, payUser,
						prePayUser, prePayTime, endTime2, endUser);
				lpm.add(pm);
			}
			return lpm;
		} finally {
			DBUtil.close(rs, stat, conn);
		}
	}
	public List<Pomain> querySomePomains(String poId, String startTime,
			String endTime, String venderCode, String payType) throws SQLException {
		// TODO Auto-generated method stub
		if(poId==null&&startTime==null&&endTime==null&&venderCode==null&&payType==null){return null;}
		if(poId.equals("")&&startTime.equals("")&&endTime.equals("")&&venderCode.equals("请选择供应商")&&payType.equals("请选择")){return null;}
		String sql="select * from pomain where ";
		if(!"".equals(poId)){
			sql=sql+"and poId like'%"+poId+"%' ";}
		if(!startTime.equals("")){
			sql=sql+"and createTime > '"+startTime+"' ";}
		if(!endTime.equals("")){
			sql=sql+"and createTime < '"+endTime+"' ";}
		if(!"请选择供应商".equals(venderCode)){
			sql=sql+"and venderCode = '"+venderCode+"' ";}
		if(!"请选择".equals(payType)){
			sql=sql+"and payType = '"+payType+"' ";}
		sql=sql.split("and", 2)[0]+sql.split("and", 2)[1];
		System.out.println(sql);
		Connection conn = null;
		ResultSet rs = null;
		Statement stat = null;
		List<Pomain> lpm =new ArrayList<Pomain>();
		try {
			conn = DBUtil.getConnection();
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);

			while (rs.next()) {
				String poId2 = rs.getString("POID");
				String venderCode2 = rs.getString("VenderCode");
				String account = rs.getString("Account");
				String createTime = rs.getString("CreateTime");
				float tipFee = rs.getFloat("TipFee");
				float productTotal = rs.getFloat("ProductTotal");
				float poTotal = rs.getFloat("POTotal");
				String payType2 = rs.getString("PayType");
				float prePayFee = rs.getFloat("PrePayFee");
				int status = rs.getInt("Status");
				String remark = rs.getString("Remark");
				String stockTime = rs.getString("StockTime");
				String stockUser = rs.getString("StockUser");
				String payTime = rs.getString("PayTime");
				String payUser = rs.getString("PayUser");
				String prePayTime = rs.getString("PrePayTime");
				String prePayUser = rs.getString("PrePayUser");
				String endTime2 = rs.getString("EndTime");
				String endUser = rs.getString("EndUser");
				Pomain pm = new Pomain(poId2, venderCode2, account, createTime,
						tipFee, productTotal, poTotal, payType2, prePayFee,
						status, remark, stockTime, stockUser, payTime, payUser,
						prePayUser, prePayTime, endTime2, endUser);
				lpm.add(pm);
			}
			return lpm;
		} finally {
			DBUtil.close(rs, stat, conn);
		}
	}
	public List<Pomain> queryOverPomains(String account2) throws SQLException{
		String sql="select * from pomain where account=? and payType='货到付款' and status=3 or payType='预付款到发货' and status=3 or payType='款到发货' and status=2 order by payType";
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		List<Pomain> lpi =new ArrayList<Pomain>();
		try{
		conn=DBUtil.getConnection();
		ps=conn.prepareStatement(sql);
		ps.setString(1, account2);
		rs=ps.executeQuery();
		while(rs.next()){
			String poId = rs.getString("POID");
			String venderCode = rs.getString("VenderCode");
			String account = rs.getString("Account");
			String createTime = rs.getString("CreateTime");
			float tipFee = rs.getFloat("TipFee");
			float productTotal = rs.getFloat("ProductTotal");
			float poTotal = rs.getFloat("POTotal");
			String payType = rs.getString("PayType");
			float prePayFee = rs.getFloat("PrePayFee");
			int status = rs.getInt("Status");
			String remark = rs.getString("Remark");
			String stockTime = rs.getString("StockTime");
			String stockUser = rs.getString("StockUser");
			String payTime = rs.getString("PayTime");
			String payUser = rs.getString("PayUser");
			String prePayTime = rs.getString("PrePayTime");
			String prePayUser = rs.getString("PrePayUser");
			String endTime = rs.getString("EndTime");
			String endUser = rs.getString("EndUser");
			Pomain pm = new Pomain(poId, venderCode, account, createTime,
					tipFee, productTotal, poTotal, payType, prePayFee,
					status, remark, stockTime, stockUser, payTime, payUser,
					prePayUser, prePayTime, endTime, endUser);
			lpi.add(pm);
		}
		return lpi;}finally{
			DBUtil.close(rs, ps, conn);
		}
	}
	public void overOnePomain(String poId,String endTime,String endUser) throws SQLException{
		String sql = "update pomain set status=4,EndTime=?,EndUser=? where POID=?";
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		try{
		conn=DBUtil.getConnection();
		ps=conn.prepareStatement(sql);
		ps.setString(1, endTime);
		ps.setString(2, endUser);
		ps.setString(3, poId);
		ps.executeUpdate();
		}finally{
			DBUtil.close(rs, ps, conn);
		}
	}
	public List<Pomain> querySheetPomains(String startTime,
			String endTime) throws SQLException {
		// TODO Auto-generated method stub
		if(startTime==null&&endTime==null){return null;}
		if(startTime.equals("")&&endTime.equals("")){return null;}
		String sql="select * from pomain where ";
		if(!startTime.equals("")){
			sql=sql+"and createTime > '"+startTime+"' ";}
		if(!endTime.equals("")){
			sql=sql+"and createTime < '"+endTime+"' ";}
		sql=sql.split("and", 2)[0]+sql.split("and", 2)[1];
		Connection conn = null;
		ResultSet rs = null;
		Statement stat = null;
		List<Pomain> lpm =new ArrayList<Pomain>();
		try {
			conn = DBUtil.getConnection();
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);

			while (rs.next()) {
				String poId2 = rs.getString("POID");
				String venderCode2 = rs.getString("VenderCode");
				String account = rs.getString("Account");
				String createTime = rs.getString("CreateTime");
				float tipFee = rs.getFloat("TipFee");
				float productTotal = rs.getFloat("ProductTotal");
				float poTotal = rs.getFloat("POTotal");
				String payType2 = rs.getString("PayType");
				float prePayFee = rs.getFloat("PrePayFee");
				int status = rs.getInt("Status");
				String remark = rs.getString("Remark");
				String stockTime = rs.getString("StockTime");
				String stockUser = rs.getString("StockUser");
				String payTime = rs.getString("PayTime");
				String payUser = rs.getString("PayUser");
				String prePayTime = rs.getString("PrePayTime");
				String prePayUser = rs.getString("PrePayUser");
				String endTime2 = rs.getString("EndTime");
				String endUser = rs.getString("EndUser");
				Pomain pm = new Pomain(poId2, venderCode2, account, createTime,
						tipFee, productTotal, poTotal, payType2, prePayFee,
						status, remark, stockTime, stockUser, payTime, payUser,
						prePayUser, prePayTime, endTime2, endUser);
				lpm.add(pm);
			}
			return lpm;
		} finally {
			DBUtil.close(rs, stat, conn);
		}
	}
}