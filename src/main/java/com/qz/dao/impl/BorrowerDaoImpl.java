package com.qz.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.qz.dao.BorrowerDao;
import com.qz.po.Libration;
import com.qz.po.Borrower;
import com.qz.util.DBUtil;

public class BorrowerDaoImpl implements BorrowerDao{

    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;

    @Override
    public List<Borrower> listBorrower(String borrowerName, String borrowerId) {
        List<Borrower> list = new ArrayList<>();
        StringBuffer sql = new StringBuffer("select * from borrower where 1=1 ");
        if(borrowerName!=null&&!borrowerName.equals("")) {
            sql.append(" and businessName like '%"+borrowerName+"%' ");
        }
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql.toString());
            rs = pst.executeQuery();
            while(rs.next()) {
                Borrower borrower = new Borrower();
                borrower.setBorrowerId(rs.getInt("borrowerId"));
                borrower.setPassword(rs.getString("password"));
                borrower.setBorrowerName(rs.getString("borrowerName"));
                borrower.setBorrowTime(rs.getDate("borrowTime"));
                borrower.setReturnTime(rs.getDate("ReturnTime"));
                list.add(borrower);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, pst, con);
        }
        return list;
    }

    @Override
    public int saveBorrower(String borrowerName) {
        int businessId = 0;
        String sql = "insert into borrower(borrowerId,password) values(?,'123')";
        try {
            con = DBUtil.getConnection();
            //设置返回自增长列值
            pst = con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setString(1, borrowerName);
            pst.executeUpdate();
            //获取自增长列值（一行一列）
            rs = pst.getGeneratedKeys();
            if(rs.next()) {
                businessId = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, pst, con);
        }
        return businessId;
    }

    @Override
    public int removeBorrower(int borrowerId) {
        int result = 0;
        String delFootSql = "delete from Borrower where businessId=?";
        String delBusinessSql = "delete from Borrower where businessId=?";
        try {
            con = DBUtil.getConnection();
            //开启一个事务
            con.setAutoCommit(false);

            pst = con.prepareStatement(delFootSql);
            pst.setInt(1, borrowerId);
            pst.executeUpdate();

            pst = con.prepareStatement(delBusinessSql);
            pst.setInt(1, borrowerId);
            result = pst.executeUpdate();

            con.commit();
        } catch (SQLException e) {
            result = 0;
            try {
                con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            DBUtil.close(null, pst, con);
        }
        return result;
    }

    @Override
    public Borrower getBorrowerByIdByPass(int businessId, String password) {
        return null;
    }
}
