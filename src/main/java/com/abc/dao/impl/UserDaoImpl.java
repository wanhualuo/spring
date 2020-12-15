package com.abc.dao.impl;

import com.abc.dao.entity.User;
import com.abc.dao.idao.IUserDao;
import com.abc.dao.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//对应的数据库sql语句的执行 返回查询结果给service service在进行对结果的分析处理
public class UserDaoImpl implements IUserDao {
    @Override
    public int exist(String username) throws Exception {
        Connection con = DBUtil.getConnection();
        String sql = "select count(1) from user where username=? ";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setObject(1,username);
        ResultSet rs = ps.executeQuery();
        int flag = 0;
        if (rs.next()){
            flag = rs.getInt(1);
        }
        DBUtil.close(rs,ps,con);
        return flag;
    }

    @Override
    public User login(User user) throws Exception {
        Connection con = DBUtil.getConnection();
        String sql = "select id,username,password,pri from user where username=? and password=? ";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setObject(1,user.getUsername());
        ps.setObject(2,user.getPassword());
        ResultSet rs = ps.executeQuery();
        User result = null;
        if (rs.next()){
            result = new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4));
        }
        DBUtil.close(rs,ps,con);
        return result;
    }
}
