package com.example.demo.typefilter;

import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * @Author: WhaleFall541
 * @Date: 2021/7/3 19:39
 */
public class MyFilter implements TypeFilter {

    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        AnnotationMetadata metadata = metadataReader.getAnnotationMetadata();
        if (metadata.getClassName().contains("A"))
            return false;

        return true;
    }

}
