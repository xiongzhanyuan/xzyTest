package com.xzy.aop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("dao1")
@MapperScan
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
