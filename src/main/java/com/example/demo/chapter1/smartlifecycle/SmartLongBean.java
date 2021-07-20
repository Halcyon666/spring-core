package com.example.demo.chapter1.smartlifecycle;

import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

/**
 * @Author: WhaleFall541
 * @Date: 2021/7/6 20:46
 */
@Component
public class SmartLongBean implements SmartLifecycle {
    @Override
    public boolean isAutoStartup() {
        return false;
    }

    @Override
    public void stop(Runnable callback) {

    }

    @Override
    public int getPhase() {
        // would be among the first to start and the last to stop.
        // the default phase for any “normal”
        // Lifecycle object that does not implement SmartLifecycle is 0.
        return Integer.MIN_VALUE;
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
}
