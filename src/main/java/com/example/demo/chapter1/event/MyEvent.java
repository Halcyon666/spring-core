package com.example.demo.chapter1.event;

import org.springframework.context.ApplicationEvent;

import java.time.Clock;

/**
 * @Author: WhaleFall541
 * @Date: 2021/7/12 21:38
 */
public class MyEvent extends ApplicationEvent {
    private final String address;
    private final String content;

    public MyEvent(Object source, String address, String content) {
        super(source);
        this.address = address;
        this.content = content;
    }

    public MyEvent(Object source, Clock clock, String address, String content) {
        super(source, clock);
        this.address = address;
        this.content = content;
    }

    public String getAddress() {
        return address;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "MyEvent{" +
                "address='" + address + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
