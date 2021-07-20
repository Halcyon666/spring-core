package com.example.demo.chapter1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: WhaleFall541
 * @Date: 2021/7/11 18:20
 */
@Configuration
public class ConfigA {
    @Bean
    public A a() {
        return new A();
    }

    // Constructor injection in @Configuration classes is only supported as of Spring
    //Framework 4.3
    public ConfigA(B b) {
    }
}

