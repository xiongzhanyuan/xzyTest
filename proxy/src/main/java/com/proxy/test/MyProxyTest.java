package com.proxy.test;

import com.proxy.dao.MyProxyDao;
import com.proxy.dao.MyProxyDaoImpl;
import com.proxy.proxy.MyImplInvocationHandler;
import com.proxy.proxy.ProxyUtil;

public class MyProxyTest {

    public static void main(String[] args) {
        MyProxyDao myProxyDao = (MyProxyDao) ProxyUtil.newInstance(MyProxyDao.class, new MyImplInvocationHandler(new MyProxyDaoImpl()));
        try {
            myProxyDao.test();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
