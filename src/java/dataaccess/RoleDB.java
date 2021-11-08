package dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Role;

public class RoleDB {
    
    public List<Role> getAll() throws Exception {
        List<Role> roleList = new ArrayList<>();
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = "SELECT * FROM role";
    try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                Role roles = new Role(id, name);
                roleList.add(roles);
            }
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }

        return roleList;
    }
    
    public Role get(int index) throws Exception
    {
        List<Role> roleList = new ArrayList<>();
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = "SELECT * FROM role WHERE role_id=" + index;
        
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                Role role = new Role(id, name);
                return role;
            }
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
        
        return null;
    }
}
