package com.qz.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.qz.dao.LibrationDao;
import com.qz.po.Libration;
import com.qz.util.DBUtil;

public class LibrationDaoImpl implements LibrationDao{

    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;

    @Override
    public Libration getLibrationByNameByPass(String librationName,String password) {
        Libration libration = null;
        String sql = "select * from libration where librationName=? and password=?";
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, librationName);
            pst.setString(2, password);
            rs = pst.executeQuery();
            while(rs.next()) {
                libration = new Libration();
                libration.setLibrationId(rs.getInt("librationId"));
                libration.setLibrationName(rs.getString("librationName"));
                libration.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, pst, con);
        }
        return libration;
    }
}
