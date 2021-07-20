package com.example.demo.chapter1.methodinject;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @Author: WhaleFall541
 * @Date: 2021/7/5 20:06
 */
@Component
@Scope(value = "prototype")
public class ProtoBeanImpl2 implements ProtoBean{

}
