package com.example.demo.chapter1.initseq;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Author: WhaleFall541
 * @Date: 2021/7/6 20:49
 */
public class InitSequence implements InitializingBean, DisposableBean {

    /*
    Multiple lifecycle mechanisms configured for the same bean, with different initialization methods,
    are called as follows:
    1. Methods annotated with @PostConstruct
    2. afterPropertiesSet() as defined by the InitializingBean callback interface
    3. A custom configured init() method

    Destroy methods are called in the same order:
    1. Methods annotated with @PreDestroy
    2. destroy() as defined by the DisposableBean callback interface
    3. A custom configured destroy() method
     */

    private Log log = LogFactory.getLog(getClass());

    @PostConstruct
    public void postInit(){
//        System.err.println(this+" has been initialized on @PostConstruct" );
    }

    @PreDestroy
    public void myDestroy(){
//        System.err.println(this+" has been initialized on @PreDestroy" );
    }

    @Override
    public void afterPropertiesSet() throws Exception {
//        System.out.println(this+" has been initialized on InitializingBean" );
    }

    @Override
    public void destroy() throws Exception {
//        System.out.println(this+" has been initialized on DisposableBean" );
    }

    public void customInit(){
//        System.err.println(this+" has been initialized on customInit" );
    }

    public void customDestroy(){
//        System.err.println(this+" has been destroyed on customDestroy" );
    }


}
