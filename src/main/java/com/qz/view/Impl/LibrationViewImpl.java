package com.qz.view.Impl;

import java.util.Scanner;

import com.qz.dao.LibrationDao;
import com.qz.dao.impl.LibrationDaoImpl;
import com.qz.po.Libration;
import com.qz.view.LibrationView;

public class LibrationViewImpl implements LibrationView{

    private Scanner input = new Scanner(System.in);
    @Override
    public Libration login() {
        System.out.println("请输入管理员名称：");
        String librationName = input.next();
        System.out.println("请输入密码：");
        String password = input.next();

        LibrationDao dao = new LibrationDaoImpl();
        return dao.getLibrationByNameByPass(librationName, password);
    }
}