package com.example.demo.chapter1.Test4Scope;

import com.example.demo.chapter1.methodinject.SingleBean;
import com.example.demo.chapter1.methodinject.TempBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Nullable;
import javax.inject.Inject;
import java.util.Optional;

/**
 * @Author: WhaleFall541
 * @Date: 2021/7/4 14:50
 */
@RestController
public class Test4ScopeController {

    private Test4ScopeBO test4ScopeBO;

    @Value("123")
    private String str;

    // using constructor inject,do not need other annotation
    // if all the properties is base type ,using
    // @ConstrutorProperties({"xxx","xxx",...}) to inject the value

    // 1.if just one constructor here ,need not `@Autowired`
    // 2.only one multi-argument constructor can be set `@Autowired(required = true)`
    // 3. if one more constructor are annotationed with ` @Autowired(required = false)`
    // The constructor with the greatest number of dependencies that can be satisfied
    // by matching beans in the Spring container will be chose

    // 4.The @Autowired, @Inject, @Value, and @Resource annotations are handled by Spring
    //BeanPostProcessor implementations
    @Autowired(required = false)
    public Test4ScopeController(Optional<SingleBean> singleBean) {
        this.singleBean = singleBean;
    }

    //@Resource
    @Inject
    private TempBean tmp;

    @Autowired(required = false)
    public Test4ScopeController(@Nullable TempBean tmp) {
        this.tmp = tmp;
    }

    @Autowired(required = false)
    public Test4ScopeController(Test4ScopeBO test4ScopeBO) {
        this.test4ScopeBO = test4ScopeBO;
    }


    @Autowired(required = false)
    public Test4ScopeController(Test4ScopeBO test4ScopeBO, SingleBean singleBean) {
        this.test4ScopeBO = test4ScopeBO;
        this.singleBean = Optional.ofNullable(singleBean);
    }

    public Test4ScopeController() {
    }

    @Override
    public String toString() {
        return "Test4ScopeController{" +
                "test4ScopeBO=" + test4ScopeBO +
                ", str='" + str + '\'' +
                ", singleBean=" + singleBean +
                '}';
    }

    @Autowired
    private Optional<SingleBean> singleBean;

    @RequestMapping("test02")
    public String test02() {
        return this.singleBean.toString();
    }


}
