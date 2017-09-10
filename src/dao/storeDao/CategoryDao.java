package dao.storeDao;

import model.storeModel.Category;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by leo on 2017/6/29.
 */
public class CategoryDao {

    public ArrayList<Category> query(){
        ArrayList<Category> al=new ArrayList<Category>();
        Connection conn= DBUtil.getConnection();
        Statement stat=null;
        ResultSet rs=null;
        String sql="select * from category";
        try {
            stat=conn.createStatement();
            rs=stat.executeQuery(sql);//发送查询语句生成ResultSet对象
            while(rs.next()){
                int categoryId=rs.getInt("CategoryID");
                String name=rs.getString("Name");
                String remark=rs.getString("Remark");
                Category cate=new Category(categoryId,name,remark);
                al.add(cate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            DBUtil.close(rs, stat,conn);
        }
        return al;
    }

    public void addCategory(Category category){
        Connection conn= DBUtil.getConnection();
        PreparedStatement ps=null;
        String sql="insert into category values(?,?,?)";
        try {
            ps=conn.prepareStatement(sql);
            ps.setInt(1,category.getCategoryId());
            ps.setString(2,category.getName());
            ps.setString(3,category.getRemark());
            ps.executeUpdate();
            System.out.println("add succeed");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("add failed");
        }finally {
            DBUtil.close(null,ps,conn);
        }
    }



    public boolean deleteCategoryQuery(int categoryId){
        boolean flag=false;
        Connection conn= DBUtil.getConnection();
        Statement stat=null;
        ResultSet rs=null;
        //先根据categoryId查询一下product表里是否含有数据，含有数据则不可删除
        String sql="select * from product where CategoryID="+categoryId;
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
        return flag;
    }

    public void deleteCategory(int categoryId){
        Connection conn= DBUtil.getConnection();
        PreparedStatement ps=null;
        String sql="delete from category where CategoryID=?";
        try {
            ps=conn.prepareStatement(sql);
            ps.setInt(1,categoryId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(null,ps,conn);
        }
    }


    public void updateCategory(Category category){
        Connection conn= DBUtil.getConnection();
        PreparedStatement ps=null;
        String sql="update category set Name=?,Remark=? where CategoryID=?";
        try {
            ps=conn.prepareStatement(sql);
            ps.setString(1,category.getName());
            ps.setString(2,category.getRemark());
            ps.setInt(3,category.getCategoryId());
            ps.executeUpdate();
            System.out.println("update succeed");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("update failed");
        }finally {
            DBUtil.close(null,ps,conn);
        }
    }

}
