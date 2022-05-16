package com.qz.view.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Scanner;

import com.qz.dao.BorrowerDao;
import com.qz.dao.impl.BorrowerDaoImpl;
import com.qz.po.Borrower;
import com.qz.view.BorrowerView;

public class BorrowerViewImpl implements BorrowerView{

    private Scanner input = new Scanner(System.in);
    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;

    @Override
    public void listBorrowerAll() {
        BorrowerDao dao = new BorrowerDaoImpl();
        List<Borrower> list = dao.listBorrower(null,null);
        System.out.println("借阅者编号\t借阅者名字\t借阅时间\t归还时间");
        for(Borrower b : list) {
            System.out.println(b.getBorrowerId()+"\t"+b.getBorrowerName()+"\t"+b.getBorrowTime()+"\t"+b.getReturnTime());
        }
    }

    @Override
    public Borrower login() {
        System.out.println("请输入借阅者编号：");
        int businessId = input.nextInt();
        System.out.println("请输入密码：");
        String password = input.next();

        BorrowerDao dao = new BorrowerDaoImpl();
        return dao.getBorrowerByIdByPass(businessId, password);
    }

    @Override
    public void listBorrower() {
        String BorrowerName = "";
        String BorrowerAddress = "";

        String inputStr = "";
        System.out.println("是否需要输入借阅者名称关键词(y/n)：");
        inputStr = input.next();
        if(inputStr.equals("y")) {
            System.out.println("请输入借阅者名称关键词：");
            BorrowerName = input.next();
        }

        BorrowerDao dao = new BorrowerDaoImpl();
        List<Borrower> list = dao.listBorrower(null,null);
        System.out.println("借阅者编号\t借阅图书名字\t借阅时间\t归还时间");
        for(Borrower b : list) {
            System.out.println("  "+b.getBorrowerId()+"   "+b.getBorrowerName()+"   "+b.getBorrowTime()+"   "+b.getReturnTime());
        }
    }

    @Override
    public void saveBorrower() {
        System.out.println("请输入借阅者名称：");
        String BorrowerName = input.next();
        BorrowerDao dao = new BorrowerDaoImpl();
        int BorrowerId = dao.saveBorrower(BorrowerName);
        if(BorrowerId>0) {
            System.out.println("新建借阅者成功！借阅者编号为："+BorrowerId);
        }else {
            System.out.println("新建借阅者失败！");
        }
    }

    @Override
    public void removeBorrower() {
        System.out.println("请输入借阅者编号：");
        int BorrowerId = input.nextInt();

        BorrowerDao dao = new BorrowerDaoImpl();
        System.out.println("确认要删除吗(y/n)：");
        if(input.next().equals("y")) {
            int result = dao.removeBorrower(BorrowerId);
            if(result==1) {
                System.out.println("删除借阅者成功！");
            }else {
                System.out.println("删除借阅者失败！");
            }
        }
    }
}
