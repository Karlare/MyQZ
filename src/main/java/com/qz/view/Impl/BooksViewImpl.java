package com.qz.view.Impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.qz.dao.BooksDao;
import com.qz.dao.impl.BooksDaoImpl;
import com.qz.po.Books;
import com.qz.view.BooksView;

public class BooksViewImpl implements BooksView {

    private Scanner input = new Scanner(System.in);

    @Override
    public List<Books> showBooksList(Integer booksId) {
        BooksDao dao = new BooksDaoImpl();
        List<Books> list = dao.listBooksByBooksId(booksId);
        System.out.println("图书编号\t图书名称\t图书介绍\t图书作者");
        for (Books books : list) {
            System.out.println(books.getBookId() + "\t" + books.getBookName() + "\t" + books.getBookExplain() + "\t" + books.getAuthorName());
        }
        return list;
    }
}