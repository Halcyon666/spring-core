package com.example.demo.chapter1.config;

import com.example.demo.chapter1.bo.AAA;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @Author: WhaleFall541
 * @Date: 2021/7/11 18:28
 */
@Configuration
// 可以Import @Configuration @Component标记的类
@Import({ConfigA.class, AAA.class,AAA.class})

public class ConfigB {
    @Bean
    public B b() {
        return new B();
    }
}