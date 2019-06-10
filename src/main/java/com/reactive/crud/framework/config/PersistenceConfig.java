package com.reactive.crud.framework.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * @author <a href = "mailto: iarpitsrivastava06@gmail.com"> Arpit Srivastava</a>
 */
@Configuration
public class PersistenceConfig {

    @Autowired
    Environment env;

    @Bean
    public DbConfig dbConfig() {
        return DbConfig
                .builder()
                .databaseUrl(env.getProperty("spring.datasource.url"))
                .dbUserName(env.getProperty("spring.datasource.username"))
                .dbPassword(env.getProperty("spring.datasource.password"))
                .build();
    }
}
