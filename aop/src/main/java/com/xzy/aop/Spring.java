package com.xzy.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.xzy")
@EnableAspectJAutoProxy()
//@ImportResource("classpath:spring.xml")
public class Spring {
}
