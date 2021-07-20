package com.example.demo.chapter1.lookup;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @Author: WhaleFall541
 * @Date: 2021/7/11 17:19
 */
@Primary
@Component
public class SynCommand implements Command{

    @Override
    public String execute() {
        return "SynCommand";
    }
}
