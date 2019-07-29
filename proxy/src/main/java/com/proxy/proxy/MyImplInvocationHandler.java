package com.proxy.proxy;

import com.proxy.dao.MyInvocationHandler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyImplInvocationHandler implements MyInvocationHandler {
    private Object target;
    public MyImplInvocationHandler(Object target) {
        this.target = target;
    }

    public Object invoke(Method method) {
        try {
            System.out.println("my proxy");
            return method.invoke(target);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
