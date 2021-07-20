package com.example.demo.chapter1.event;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @Author: WhaleFall541
 * @Date: 2021/7/12 21:38
 */
@Component
public class MyListener implements ApplicationEventPublisherAware {
    private Log log = LogFactory.getLog(MyListener.class);

    //@EventListener(condition = "#a0.content == 'foo'")//SpEL #a0 代表第一个入参
    //@EventListener(condition = "#event.content == 'foo'")//SpEL #event  代表名称相同的参数
    //@EventListener(condition = "@testMethod.test().equals(#a0.content)")// 如果要表示一个对象要使用@XXX
    //@EventListener({ContextStartedEvent.class, ContextRefreshedEvent.class})
    public void process(MyEvent event) {
        System.err.println("event test is ok " + event);
    }

    private boolean flag = true;

    // 在address:aaa content:foo发布之后再发布一个 bbb bar
    @EventListener(condition = "@testMethod.test().contains(#a0.content)")
    public MyEvent process1(MyEvent event) {

        //System.err.println("event test is ok " + event);
        return new MyEvent(this, "bbb", "bar");
    }

    @EventListener(condition = "#a0.content == 'bar'")
    public void process2(MyEvent event) {
        System.err.println("event test is ok " + event);
    }


    private ApplicationEventPublisher publisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }
}
