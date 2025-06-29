package com.ea.SpringBootSeleniumUIFramework.libraries;

import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.support.SimpleThreadScope;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ThreadScopeConfig {

    @Bean
    public static CustomScopeConfigurer customScopeConfigurer() {
        CustomScopeConfigurer configurer = new CustomScopeConfigurer();
        Map<String, Object> scopes = new HashMap<>();
        scopes.put("thread", new SimpleThreadScope());
        configurer.setScopes(scopes);
        return configurer;
    }
}