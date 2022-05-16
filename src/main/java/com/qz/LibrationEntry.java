package com.qz;

import java.util.Scanner;

import com.qz.dao.BorrowerDao;
import com.qz.dao.impl.BorrowerDaoImpl;
import com.qz.po.Libration;
import com.qz.view.BooksView;
import com.qz.view.Impl.BooksViewImpl;
import com.qz.view.LibrationView;
import com.qz.view.BorrowerView;
import com.qz.view.Impl.LibrationViewImpl;
import com.qz.view.Impl.BorrowerViewImpl;

public class LibrationEntry {

    public void work() {
        Scanner input = new Scanner(System.in);

        System.out.println("---------------------------------------------------------");
        System.out.println("|\t\t\t 图书后台管理系统  \t\t\t|");
        System.out.println("---------------------------------------------------------");
        LibrationView librationView = new LibrationViewImpl();
        BorrowerView borrowerView = new BorrowerViewImpl();
        BooksView booksView = new BooksViewImpl();
        Libration x=librationView.login();
        //登录
        if(x!=null) {
            int booksId = 0;
            int menu = 0;
            int borrowerId = 0;
            while(menu!=7) {
                //输出主菜单
                System.out.println("\n========= 1.所有借阅者列表=2.搜索借阅者=3.搜索图书=4.添加借阅者=5.删除借阅者=6.退出系统 =========");
                System.out.println("请输入你的选择：");
                menu = input.nextInt();
                switch(menu) {
                    case 1:
                        borrowerView.listBorrowerAll();
                        break;
                    case 2:
                        System.out.println("请输入你想添加的借阅者编号：");

                        borrowerView.listBorrower();
                        break;
                    case 3:
                        System.out.println("请输入你想删除的借阅者编号：");
                        booksId = input.nextInt();
                        booksView.showBooksList(booksId);
                        break;
                    case 4:
                        borrowerView.saveBorrower();
                        break;
                    case 5:
                        borrowerView.removeBorrower();
                        break;
                    case 6:
                        System.out.println("<<<<<<<<--------------欢迎下次光临图书后台管理系统---------------->>>>>>>");
                        break;
                    default:
                        System.out.println("没有这个选项！\n");
                        break;
                }
            }

        }else {
            System.out.println("\n管理员名称或密码输入错误!\n");
        }
    }

    public static void main(String[] args) {
        new LibrationEntry().work();
    }

}
