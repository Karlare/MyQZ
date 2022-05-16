package com.qz.dao;

import com.qz.po.Libration;

public interface LibrationDao {
    public Libration getLibrationByNameByPass(String librationName,String password);
}