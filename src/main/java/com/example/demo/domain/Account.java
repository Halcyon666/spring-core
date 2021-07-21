package com.example.demo.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

/**
 * @Author: WhaleFall541
 * @Date: 2021/7/20 20:48
 */

@Configurable(preConstruction = true)
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
