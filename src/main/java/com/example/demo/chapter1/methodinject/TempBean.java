package com.example.demo.chapter1.methodinject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
/**
 * @Author: WhaleFall541
 * @Date: 2021/7/5 20:28
 */
@Component
public abstract class TempBean {
    protected final Log logger = LogFactory.getLog(getClass());

    @Order(1)
    @Primary
    @Scope("prototype")
    @Bean(autowireCandidate = false, name="protoBeanImpl")
    public ProtoBeanImpl protoBeanImpl() {
//        logger.error("ProtoBeanImpl2 created in "+ this.getClass() + createProtoBeanImpl2());
        return new ProtoBeanImpl();
    }

    @Lookup
    public abstract ProtoBeanImpl2 createProtoBeanImpl2();

}
