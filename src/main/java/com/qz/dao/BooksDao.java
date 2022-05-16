package com.qz.dao;

import com.qz.po.Books;

import java.util.List;

public interface BooksDao {
    public int saveBook(Books books);
    public int removeBook(Integer bookId);
    public Books getBookById(Integer bookId);
    public Books getBookByAuthor(String authorName);

    List<Books> listBooksByBooksId(Integer booksId);
}
