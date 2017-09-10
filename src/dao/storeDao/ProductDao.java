package dao.storeDao;

import model.storeModel.Page;
import model.storeModel.Product;
import util.DBUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by leo on 2017/7/10.
 */
public class ProductDao {


    //从category表中得到所有的分类
    public ArrayList<Integer> getCategorys(){
        ArrayList<Integer> al=new ArrayList<Integer>();
        String sql = "select CategoryID from category";
        Connection conn = DBUtil.getConnection();
        Statement stat = null;
        ResultSet rs = null;
        try {
            stat=conn.createStatement();
            rs=stat.executeQuery(sql);
            while (rs.next()){
                Integer category=rs.getInt("CategoryID");
                al.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(rs,stat,conn);
        }

        return al;
    }

    //增加前需要先检验一下是否productCode重复
    public boolean queryCode(String productCode){
        boolean flag=false;
        String sql="select * from product where ProductCode='"+productCode+"'";
        Connection conn = DBUtil.getConnection();
        Statement stat=null;
        ResultSet rs=null;
        try {
            stat=conn.createStatement();
            rs=stat.executeQuery(sql);
            if(rs.next()){
                flag=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(rs,stat,conn);
        }

        return  flag;
    }

    //增加前查询productName是否重复
    public boolean queryName(String productName){
        boolean flag=false;
        String sql="select * from product where Name='"+productName+"'";
        Connection conn = DBUtil.getConnection();
        Statement stat=null;
        ResultSet rs=null;
        try {
            stat=conn.createStatement();
            rs=stat.executeQuery(sql);
            if(rs.next()){
                flag=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(rs,stat,conn);
        }
        return  flag;
    }
    // 向数据库product表增加产品信息
    public void addProduct(Product product) {
        String sql = "insert into product values(?,?,?,?,?,?,?,?,?)";
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, product.getProductCode());
            ps.setInt(2, product.getCategoryID());
            ps.setString(3, product.getName());
            ps.setString(4, product.getUnitName());
            ps.setFloat(5, product.getPrice());
            ps.setString(6, product.getCreateDate());
            ps.setString(7, product.getRemark());
            ps.setInt(8,product.getPoNum());
            ps.setInt(9,product.getSoNum());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(null,ps,conn);
        }
    }

    // 从数据库中product表删除产品分类信息
    public boolean deleteProduct(String productCode) {
        boolean flag=false;
        String sql = "delete from product where ProductCode=?";
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, productCode);
            int result=ps.executeUpdate();
            if(result==1){
                flag=true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(null,ps,conn);
        }
        return  flag;
    }

    // 从数据库中product表修改产品信息
    public boolean updateProduct(Product product) {
        boolean flag=false;
        String sql = "update product set CategoryID=?,Name=?,UnitName=?,Price=?,CreateDate=?,Remark=? where ProductCode=?";
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,product.getCategoryID());
            ps.setString(2, product.getName());
            ps.setString(3,product.getUnitName());
            ps.setFloat(4,product.getPrice());
            ps.setString(5,product.getCreateDate());
            ps.setString(6,product.getRemark());
            ps.setString(7,product.getProductCode());
            int result=ps.executeUpdate();
            if(result==1){
                flag=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(null,ps,conn);
        }
        return flag;
    }


    //分页时查询产品表中记录条数
    public void getTotalPage(Page page){
        Connection conn=DBUtil.getConnection();
        Statement stat=null;
        ResultSet rs=null;
        String sql="select count(*) total from product";
        try {
            stat=conn.createStatement();
            rs = stat.executeQuery(sql);
            if (rs.next()) {
                int total = rs.getInt("total");
                int totalPage = total % page.getPageSize() == 0 ? total
                        / page.getPageSize() : total / page.getPageSize() + 1;
                page.setTotalPage(totalPage);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(rs,stat,conn);
        }

    }



    public void queryData(Page page) {
        String sql = "select * from product limit ?,?";

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Product> data = new ArrayList<Product>();


        conn = DBUtil.getConnection();
        try {
            ps=conn.prepareStatement(sql);
            ps.setInt(1, (page.getCurrentPage() - 1) * page.getPageSize());
            ps.setInt(2, page.getPageSize());
            rs = ps.executeQuery();
            while (rs.next()) {
                String productCode = rs.getString("ProductCode");
                int categoryID = rs.getInt("CategoryID");
                String name = rs.getString("Name");
                String unitName = rs.getString("UnitName");
                float price = rs.getFloat("Price");
                String createDate = rs.getString("CreateDate");
                String productRemark = rs.getString("Remark");
                int poNum=rs.getInt("PONum");
                int soNum=rs.getInt("SONum");
                Product  product=new Product(productCode,categoryID,name,unitName,price,createDate,productRemark,poNum,soNum);
                data.add(product);
            }
            page.setData(data);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }



    }
