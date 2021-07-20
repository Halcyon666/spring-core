package com.example.demo.chapter1.staticfactory;

import com.example.demo.chapter1.bo.AAA;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Author: WhaleFall541
 * @Date: 2021/7/4 18:58
 */
@Component
public class StaticFactory {
    private static AAA aaa = new AAA();

    @Bean(name = "staticAAA",autowireCandidate = false) // 不会被自动注入
    public static AAA getAAA() {
        return aaa;
    }
}
