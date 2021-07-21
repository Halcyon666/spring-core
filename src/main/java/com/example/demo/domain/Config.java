package com.example.demo.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;

/**
 * @Author: WhaleFall541
 * @Date: 2021/7/20 20:48
 */
// 配置类，使用注解的方式创建Bean
@Configuration
@EnableSpringConfigured
//@EnableLoadTimeWeaving
public class Config {

    @Bean
    public Dog dog(){
        return new Dog();
    }

}
