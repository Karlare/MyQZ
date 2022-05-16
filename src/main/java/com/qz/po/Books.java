package com.qz.po;

public class Books {
    private Integer bookId;
    private String bookName;
    private String bookExplain;
    private String authorName;

    @Override
    public String toString() {
        return "\n图书编号："+this.bookId+
                "\n图书名字："+this.bookName+
                "\n图书介绍："+this.bookExplain+
                "\n作者："+this.authorName;
    }

    public Integer getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public String getBookExplain() {
        return bookExplain;
    }

    public String getAuthorName(String authorName) {
        return this.authorName;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setBookExplain(String bookExplain) {
        this.bookExplain = bookExplain;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorName() {
        return this.authorName;
    }
}
