package com.qz.dao;

import java.util.List;
import java.util.List;

import com.qz.po.Borrower;

public interface BorrowerDao {
    public List<Borrower> listBorrower(String borrowerName,String borrowerId);
    public int saveBorrower(String borrower);
    public int removeBorrower(int borrowerId);

    Borrower getBorrowerByIdByPass(int businessId, String password);
}
