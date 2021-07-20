package com.example.demo.chapter1.methodinject;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Priority;

/**
 * @Author: WhaleFall541
 * @Date: 2021/7/5 20:06
 */
@Component
@Order(1)
@Priority(1)
public class SingleBean implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    // because the protoBeanImpl is prototype @Autowired is false here
    // so we implements ApplicationContextAware

//    @Qualifier("protoBeanImpl")
//    @Autowired
//    private ProtoBean bean;

    @Autowired
    public SingleBean(@Qualifier("protoBeanImpl2") ProtoBean proto) {
        this.protoBeanImpl2 = (ProtoBeanImpl2) proto;
    }

    public ProtoBeanImpl protoBeanImpl;

    public ProtoBeanImpl2 protoBeanImpl2;

    public ProtoBeanImpl test(){
        return (ProtoBeanImpl) applicationContext.getBean("protoBeanImpl");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
       this.applicationContext = applicationContext;
        protoBeanImpl = (ProtoBeanImpl) applicationContext.getBean("protoBeanImpl");
    }
}
