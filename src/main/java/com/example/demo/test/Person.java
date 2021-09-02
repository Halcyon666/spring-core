package com.example.demo.test;

/**
 * @Author: WhaleFall541
 * @Date: 2021/9/2 20:17
 */
public class Person {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
