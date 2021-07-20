package com.example.demo.springfactories;

import org.junit.jupiter.api.Test;
import org.springframework.core.io.support.SpringFactoriesLoader;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @Author: WhaleFall541
 * @Date: 2021/7/5 22:28
 */
public class Test4SpringFactoryLoader {
    @Test
    void loadFactoriesInCorrectOrder() {
        List<DummyFactory> factories = SpringFactoriesLoader.loadFactories(DummyFactory.class, null);
        assertThat(factories.size()).isEqualTo(2);
        boolean condition1 = factories.get(0) instanceof MyDummyFactory1;
        assertThat(condition1).isTrue();
        boolean condition = factories.get(1) instanceof MyDummyFactory2;
        assertThat(condition).isTrue();
    }
}
