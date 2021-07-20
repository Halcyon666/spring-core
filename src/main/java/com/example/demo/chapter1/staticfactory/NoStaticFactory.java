package com.example.demo.chapter1.staticfactory;

import com.example.demo.chapter1.bo.AAA;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Author: WhaleFall541
 * @Date: 2021/7/4 18:58
 */
@Component
public class NoStaticFactory {
    private AAA aaa = new AAA();

    @Bean("NoAAA")
    public AAA getAAA() {
        return aaa;
    }
}
