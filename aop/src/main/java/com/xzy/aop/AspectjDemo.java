package com.xzy.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectjDemo {

    @Pointcut("execution(* com.example.demo.*.*(..))")
    public void pointCut(){}

    @Before("pointCut()")
    public void before() {
        System.out.println("before");
    }

}
