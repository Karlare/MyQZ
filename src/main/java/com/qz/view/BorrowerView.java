package com.qz.view;

import com.qz.po.Borrower;

public interface BorrowerView {

    public void listBorrowerAll();

    Borrower login();

    public void listBorrower();

    void saveBorrower();

    void removeBorrower();
}
