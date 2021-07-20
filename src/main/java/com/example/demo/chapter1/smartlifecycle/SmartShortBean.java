package com.example.demo.chapter1.smartlifecycle;

import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

/**
 * @Author: WhaleFall541
 * @Date: 2021/7/6 20:46
 */
@Component
public class SmartShortBean implements SmartLifecycle {

    @Override
    public boolean isAutoStartup() {
        return true;
    }

    @Override
    public void stop(Runnable callback) {

    }

    @Override
    public int getPhase() {
        // a phase value of Integer.MAX_VALUE would indicate that the object should be started
        // last and stopped first, that is the shortest life span.
        return Integer.MAX_VALUE;
    }

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

//    @PostConstruct
//    public void init(){
//        System.err.println(this+" init");
//    }
//
//    @PreDestroy
//    public void myDestroy(){
//        System.err.println(this + " destroy");
//    }

}
