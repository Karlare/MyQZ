package com.qz.po;

import java.util.Date;

public class Borrower {
    private Integer borrowerId;
    private String password;
    private String borrowerName;
    private Date borrowTime;
    private Date returnTime;

    @Override
    public String toString(){
        return "\n借阅者编号："+this.borrowerId+
                "\n借阅者名字："+this.borrowerName+
                "\n借阅时间："+this.borrowTime+
                "\n归还时间："+this.returnTime;
    }

    public Integer getBorrowerId() {
        return borrowerId;
    }

    public String getPassword(){
        return password;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public Date getBorrowTime() {
        return borrowTime;
    }

    public Date getReturnTime() {
        return returnTime;
    }

    public void setBorrowerId(Integer borrowerId) {
        this.borrowerId = borrowerId;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    public void setBorrowTime(Date borrowTime) {
        this.borrowTime = borrowTime;
    }

    public void setReturnTime(Date returnTime) {
        this.returnTime = returnTime;
    }
}
