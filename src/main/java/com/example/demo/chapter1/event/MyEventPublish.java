package com.example.demo.chapter1.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

/**
 * @Author: WhaleFall541
 * @Date: 2021/7/12 21:41
 */
@Component
public class MyEventPublish implements ApplicationEventPublisherAware {
    private ApplicationEventPublisher publisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }

    public void publish(String address, String content) {
        if ("aaa".equals(address)) {
            publisher.publishEvent(new MyEvent(this, address, content));
            return;
        }
    }
}
