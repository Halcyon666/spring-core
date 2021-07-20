package com.example.demo.chapter1.event;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: WhaleFall541
 * @Date: 2021/7/12 22:42
 */
@Component
public class TestMethod {
    public List<String> test() {

        List<String> al = new ArrayList();
        al.add("foo");
        al.add("fool");

        return al;
    }
}
