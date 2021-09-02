package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.metrics.buffering.BufferingApplicationStartup;
import org.springframework.context.ConfigurableApplicationContext;

//@ComponentScan(excludeFilters = {
//		@ComponentScan.Filter(type = FilterType.CUSTOM,classes = MyFilter.class),
//		@ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Service.class),
//})
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(DemoApplication.class, args);
		run.setApplicationStartup(new BufferingApplicationStartup(2048));


//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigComponent.class);
//		ConfigComponent configComponent = (ConfigComponent) context.getBean("configComponent");


	}
}
