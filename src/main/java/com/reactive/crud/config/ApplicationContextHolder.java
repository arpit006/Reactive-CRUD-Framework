package com.reactive.crud.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author <a href = "mailto: iarpitsrivastava06@gmail.com"> Arpit Srivastava</a>
 */
@Configuration
public class ApplicationContextHolder {

    @Autowired
    ApplicationContext applicationContext;

    private static ApplicationContextHolder _INSTANCE;

    @PostConstruct
    private void initialize() {
        _INSTANCE = this;
    }

    public static <T> T getBean(Class<T> clazz) {
        return _INSTANCE.applicationContext.getBean(clazz);
    }

    public static Object getBean(String beanName) {
        return _INSTANCE.applicationContext.getBean(beanName);
    }
}
