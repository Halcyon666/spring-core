package com.example.demo.chapter1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: WhaleFall541
 * @Date: 2021/7/11 16:11
 */
@Component //@Configuration
public class ConfigComponent {

    @Bean
    public RestTemplate restTemplate(BFO1 bfo) {
        return new RestTemplate();
    }
}
