package com.example.demo.chapter2;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;

/**
 * @Author: WhaleFall541
 * @Date: 2021/7/13 20:09
 */
@Component
public class TestResource implements ResourceLoaderAware {
    private ResourceLoader resourceLoader;

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @PostConstruct
    public void getMySource() throws IOException {
//        you should avoid using absolute paths with
//        FileSystemResource or FileSystemXmlApplicationContext and force the use of a UrlResource by using
//        the file: URL prefix.
        Resource resource = resourceLoader.getResource("file://idea/navigate/reference?project=spring-core&path=qulifierannotation1.xml");
        //System.err.println(resource.getFile());
    }

}
