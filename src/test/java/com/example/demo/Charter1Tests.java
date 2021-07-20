package com.example.demo;

import com.example.demo.chapter1.Test4Scope.MovieRecommender;
import com.example.demo.chapter1.bo.AAA;
import com.example.demo.chapter1.config.A;
import com.example.demo.chapter1.config.B;
import com.example.demo.chapter1.config.ConfigB;
import com.example.demo.chapter1.event.MyEventPublish;
import com.example.demo.chapter1.lookup.AbstractAA;
import com.example.demo.chapter1.lookup.CommandManager;
import com.example.demo.chapter1.methodinject.ProtoBeanImpl2;
import com.example.demo.chapter1.methodinject.SingleBean;
import com.example.demo.chapter1.qulifierannotation.PersonService;
import com.example.demo.domain.Account;
import com.example.demo.domain.Config;
import com.example.demo.domain.Dog;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Field;

@SpringBootTest
class Charter1Tests implements ApplicationContextAware {
    public static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    @Test
    public void testSingletonDependsOnPrototype() {

        SingleBean singleBean = (SingleBean) context.getBean("singleBean");
        // prove that each time to use a new ProtoBeanImpl which held by SingleBean
        Assertions.assertThat(singleBean.test() != singleBean.test()).isEqualTo(true);

        // to prove that if set the field once, I get the bean one more time
        // and the prototype bean is not changed
        // because I call the setProtoBeanImpl2 ont the method setApplicationContext of the protoBeanImpl2
        // which just call one time when the context startup
        SingleBean singleBean2 = (SingleBean) context.getBean("singleBean");
        Assertions.assertThat(singleBean.protoBeanImpl == singleBean2.protoBeanImpl).isEqualTo(true);
    }

    @Test
    public void testBeanProtoBeanImpl2() {
        // ProtoBeanImpl2 injected with a singleton-scoped by @Bean method
        // but `return new ProtoBeanImpl2()` in TempBean, and we get the same bean
        ProtoBeanImpl2 protoBeanImpl2 = (ProtoBeanImpl2) context.getBean("protoBeanImpl2");
        ProtoBeanImpl2 protoBeanImpl22 = (ProtoBeanImpl2) context.getBean("protoBeanImpl2");
        Assertions.assertThat(protoBeanImpl2 != protoBeanImpl22).isEqualTo(true);
    }

    @Test
    void testInitSequence() {

        // first @PostConstruct second InitializingBean third custom init-method
        // look the print,sometime 1 is first and others 2 is first
        // official give the sequence 1,2,3 and the same as destroy method

        // 1.com.example.demo.chapter1.initseq.InitSequence@54db056b has been initialized on @PostConstruct
        // 2.com.example.demo.chapter1.initseq.InitSequence@54db056b has been initialized on afterPropertiesSet
        // 3.com.example.demo.chapter1.initseq.InitSequence@54db056b has been initialized on customInit
        context.getBean("initSequence");

    }

    @Test
    void testRegisterHook() {
        //Shutting Down the Spring IoC Container Gracefully in Non-Web Applications
        ((ConfigurableApplicationContext) context).registerShutdownHook();

    }

    @Test
    void testQualifierAnnotation() {
        AbstractApplicationContext context1 = new ClassPathXmlApplicationContext("qulifierannotation1.xml");
        PersonService service = context1.getBean(PersonService.class);
        Assertions.assertThat(service.getPerson().getPersonName().equals("Teacher Sudama")).isEqualTo(true);
        context1.close();
    }

    @Test
    void testMovieRecommender() throws NoSuchFieldException, IllegalAccessException {
        MovieRecommender movieRecommender = (MovieRecommender) context.getBean("movieRecommender");
        // reflect get field
        Field catalog = movieRecommender.getClass().getDeclaredField("catalog");
        catalog.setAccessible(true);
        String str = (String) catalog.get(movieRecommender);
        Assertions.assertThat("defaultCatalog".equals(str)).isEqualTo(true);
    }

    @Test
    void testOverrideLookup() {
        // 因为指定了SynCommand 为@Primary 所以lookup查找的这个
        CommandManager commandManager = (CommandManager) context.getBean("commandManager");
        CommandManager commandManagerImpl = (CommandManager) context.getBean("commandManagerImpl");
        Assertions.assertThat(commandManager.process()).isEqualTo("SynCommand");
        Assertions.assertThat(commandManagerImpl.process()).isEqualTo("AsyncCommand");
        Assertions.assertThat(commandManager).as("two instance is the same one").isNotEqualTo(commandManagerImpl);
    }

    @Test
    void testConfigAB() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigB.class);
        A a = ctx.getBean(A.class);
        B b = ctx.getBean(B.class);
        AAA aaa = (AAA) ctx.getBean("AAA");
        Assertions.assertThat(a != null && b != null && aaa != null).isEqualTo(true);
    }

    @Test
    void testApplicationEvent() {
        MyEventPublish bean = context.getBean(MyEventPublish.class);
        bean.publish("aaa", "foo");
    }

    @Test
    void test4Actions() throws NoSuchFieldException, IllegalAccessException {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
        Account account = new Account();
        Field dog = account.getClass().getDeclaredField("dog");
        dog.setAccessible(true);
        Dog d = (Dog) dog.get(account);
        //Assertions.assertThat(d).as("NullPointException Dog is null").isNotEqualTo(null);

    }

    @Test
    void testAbstract() {
        AbstractAA bean = context.getBean(AbstractAA.class);
        Assertions.assertThat(bean).isNotEqualTo(null);

    }
}