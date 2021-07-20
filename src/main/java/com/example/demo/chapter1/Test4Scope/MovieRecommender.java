package com.example.demo.chapter1.Test4Scope;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author: WhaleFall541
 * @Date: 2021/7/8 21:12
 */
@Component
public class MovieRecommender {
    private final String catalog;
    public MovieRecommender(@Value("${catalog.name:defaultCatalog}") String catalog) {
        this.catalog = catalog;
    }
}