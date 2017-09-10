package dao.storeDao;

import javafx.scene.media.SubtitleTrack;
import util.DBUtil;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by leo on 2017/7/19.
 */
public class UserDao {

    //检测是否用户登录
    public boolean login(String username,String password){
        boolean flag=false;
        Connection conn=DBUtil.getConnection();
        Statement stat=null;
        ResultSet rs=null;
        String sql="select * from scmuser where Account='"+username+"' and Password='"+password+"'";
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

    public String queryAuth(String username){
        String auth=null;
        Connection conn=DBUtil.getConnection();
        Statement stat=null;
        ResultSet rs=null;
        String sql="select Auth from scmuser where Account='"+username+"'";
        try {
            stat=conn.createStatement();
            rs=stat.executeQuery(sql);
            if(rs.next()){
                auth=rs.getString("Auth");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(rs,stat,conn);
        }
        return auth;
    }
}
