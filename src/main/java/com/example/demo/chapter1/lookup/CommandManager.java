package com.example.demo.chapter1.lookup;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: WhaleFall541
 * @Date: 2021/7/11 17:12
 */
@Configuration
public abstract class CommandManager {
    public String process() {
        return createCommand().execute();
    }

    @Lookup
    protected abstract Command createCommand();

    @Bean
    //@Scope("singleton")
    public AsyncCommand asyncCommand() {
        return  new AsyncCommand();
    }

    @Bean
    public CommandManager commandManagerImpl() {
        // 定义一个匿名内部类 去覆盖原Lookup逻辑,
        // 返回调用process方法时持有AsyncCommand的CommandManager
        return new CommandManager() {
            protected Command createCommand() {
                return  asyncCommand();
            }
        };
    }
}