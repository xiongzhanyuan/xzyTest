package com.xzy.service;


import com.xzy.dao.UserDao;

public class UserServiceImpl implements UserService {

    UserDao dao;

    @Override
    public void find() {
        System.out.println("service");
        dao.query();
    }
}
