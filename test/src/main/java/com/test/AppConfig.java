package com.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan("com.test")
@Primary
public class AppConfig {

    @Bean
    public TestService testService() {
        return new TestService();
    }

}
