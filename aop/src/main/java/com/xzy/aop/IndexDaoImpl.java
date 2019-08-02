package com.xzy.aop;

import org.springframework.stereotype.Repository;

@Repository("dao1")
public class IndexDaoImpl  implements IndexDao {
    @Override
    public String test() {
        System.out.println("impl ");
        return "";
    }

//    @PostConstruct
//    public void init(){
//        System.out.println("init");
//    }
}
