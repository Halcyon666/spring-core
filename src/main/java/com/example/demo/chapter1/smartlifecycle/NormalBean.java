package com.example.demo.chapter1.smartlifecycle;

import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

/**
 * @Author: WhaleFall541
 * @Date: 2021/7/6 20:46
 */
@Component
public class NormalBean implements SmartLifecycle {
    /*
    NormalBean getPhase -1
    SmartLongBean Integer.MIN_VALUE
    SmartShortBean Integer.MAX_VALUE

    com.example.demo.chapter1.smartlifecycle.NormalBean@2e1ddc90 init
    com.example.demo.chapter1.smartlifecycle.SmartLongBean@5b7c8930 init
    com.example.demo.chapter1.smartlifecycle.SmartShortBean@58867cd5 init

    com.example.demo.chapter1.smartlifecycle.SmartShortBean@58867cd5 destroy
    com.example.demo.chapter1.smartlifecycle.SmartLongBean@5b7c8930 destroy
    com.example.demo.chapter1.smartlifecycle.NormalBean@2e1ddc90 destroy
     */
//    @PostConstruct
//    public void init(){
//        System.err.println(this+" init");
//    }
//
//    @PreDestroy
//    public void myDestroy(){
//        System.err.println(this + " destroy");
//    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public boolean isRunning() {
        return false;
    }

    @Override
    public int getPhase() {
        return -1;
    }
}
