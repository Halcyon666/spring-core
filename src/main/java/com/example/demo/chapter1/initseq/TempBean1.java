package com.example.demo.chapter1.initseq;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Author: WhaleFall541
 * @Date: 2021/7/6 20:57
 */
@Component
public class TempBean1 implements ApplicationContextAware {

    @Bean(initMethod = "customInit",destroyMethod = "customDestroy")
    public InitSequence initSequence(){
        return new InitSequence();
    }

    private ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }


}
