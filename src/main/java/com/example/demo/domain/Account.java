package com.example.demo.domain;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

/**
 * @Author: WhaleFall541
 * @Date: 2021/7/20 20:48
 */

@Configurable(autowire = Autowire.BY_TYPE, preConstruction = true)
public class Account {

    @Autowired
    private Dog dog;

    @Override
    public String toString() {
        return "Account{" +
                "dog=" + dog +
                '}';
    }
}
