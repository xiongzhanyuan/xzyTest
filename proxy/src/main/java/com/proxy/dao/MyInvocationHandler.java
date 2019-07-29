package com.proxy.dao;

import java.lang.reflect.Method;

public interface MyInvocationHandler {

    public Object invoke(Method method);

}
