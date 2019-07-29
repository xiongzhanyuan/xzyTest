package com.proxy.test;

import com.proxy.dao.JdkDao;
import com.proxy.dao.JdkDaoImpl;
import com.proxy.proxy.JdkInvocationHandler;

public class JdkTest {

    public static void main(String[] args) {
        JdkInvocationHandler jdkInvocationHandler = new JdkInvocationHandler();
        JdkDao jdkDao = (JdkDao) jdkInvocationHandler.newProxy(new JdkDaoImpl());
        jdkDao.test();
    }

}
