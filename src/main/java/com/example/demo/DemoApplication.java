package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@ComponentScan(excludeFilters = {
//		@ComponentScan.Filter(type = FilterType.CUSTOM,classes = MyFilter.class),
//		@ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Service.class),
//})
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigComponent.class);
//		ConfigComponent configComponent = (ConfigComponent) context.getBean("configComponent");


	}
}
