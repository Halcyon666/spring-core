package com.example.demo.chapter1.bo;

import com.example.demo.chapter1.config.A;
import com.example.demo.chapter1.config.B;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @Author: WhaleFall541
 * @Date: 2021/7/3 19:16
 */
@Component("AAA")
@Scope(value = "prototype")
public class AAA {

    @Bean
    public AAA createAAA(A a,B b) {
        return this;
    }

}
