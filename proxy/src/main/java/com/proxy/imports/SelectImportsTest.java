package com.proxy.imports;

import com.proxy.dao.JdkDao;
import com.proxy.dao.JdkDaoImpl;
import com.proxy.proxy.JdkInvocationHandler;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Proxy;

public class SelectImportsTest implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        if (beanName.equals("jdkDaoImpl")) {
            JdkInvocationHandler jdkInvocationHandler = new JdkInvocationHandler();
            bean =  jdkInvocationHandler.newProxy(new JdkDaoImpl());
        }

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }

//    public void query() {
//        System.out.println("selectImportsTest");
//    }

}
