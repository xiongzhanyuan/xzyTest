package com.proxy.test;

import com.proxy.app.Appconfig;
import com.proxy.dao.JdkDao;
import com.proxy.dao.MyProxyDao;
import com.proxy.imports.SelectImportsTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SelectorTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();

        annotationConfigApplicationContext.register(Appconfig.class);

        annotationConfigApplicationContext.refresh();

        JdkDao dao = (JdkDao) annotationConfigApplicationContext.getBean("jdkDaoImpl");
        try {
            dao.test();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
