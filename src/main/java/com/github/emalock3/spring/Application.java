package com.github.emalock3.spring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
public class Application {
    
    @Bean
    public String helloString() {
        return "hello";
    }
    
    @Bean
    public String worldString() {
        return "world";
    }
    
    @Bean
    public String helloWorld(@Qualifier("helloString") String hello, @Qualifier("worldString") String world) {
        System.out.println(String.format("%s, %s!", hello, world));
        return String.format("%s, %s!", hello, world);
    }
    
    public static void main(String ... args) {
        new SpringApplicationBuilder(Application.class)
                .showBanner(false)
                .run(args);
    }
}
