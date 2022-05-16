package com.qz.dao.impl;

import com.qz.dao.BooksDao;
import com.qz.po.Books;
import com.qz.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BooksDaoImpl implements BooksDao{
    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;

    @Override
    public int saveBook(Books books) {
        int result = 0;
        String sql = "insert into books values(null,?,?,?,?)";
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, books.getBookName());
            pst.setString(2, books.getAuthorName(rs.getString("authorName")));
            pst.setString(3, books.getBookExplain());
            pst.setInt(4, books.getBookId());
            result = pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(null, pst, con);
        }
        return result;
    }

    @Override
    public Books getBookById(Integer bookId) {
        Books books = null;
        String sql = "select * from food where foodId=?";
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1, bookId);
            rs = pst.executeQuery();
            while(rs.next()) {
                books = new Books();
                books.setBookId(rs.getInt("bookId"));
                books.setBookName(rs.getString("bookName"));
                books.setBookExplain(rs.getString("bookExplain"));
                books.setAuthorName(rs.getString("authorName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, pst, con);
        }
        return books;
    }

    @Override
    public int removeBook(Integer bookId) {
        int result = 0;
        String sql = "delete from book where bookId=?";
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1, bookId);
            result = pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(null, pst, con);
        }
        return result;
    }

    @Override
    public Books getBookByAuthor(String authorName){
        Books books = null;
        String sql = "select * from book where authorName=?";
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, authorName);
            rs = pst.executeQuery();
            while(rs.next()) {
                books = new Books();
                books.getAuthorName(rs.getString("authorName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, pst, con);
        }
        return books;
    }

    @Override
    public List<Books> listBooksByBooksId(Integer booksId) {
        List<Books> list = new ArrayList<>();
        String sql = "select * from book where bookId=?";
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1, booksId);
            rs = pst.executeQuery();
            while(rs.next()) {
                Books books = new Books();
                books.setBookId(rs.getInt("bookId"));
                books.setBookName(rs.getString("bookName"));
                books.setBookExplain(rs.getString("bookExplain"));
                books.setAuthorName(rs.getString("authorName"));
                list.add(books);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, pst, con);
        }
        return list;
    }
}