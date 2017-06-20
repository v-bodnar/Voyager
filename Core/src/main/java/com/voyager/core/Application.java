package com.voyager.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * Created by volodymyr.bodnar on 6/19/2017.
 */
@SpringBootApplication(scanBasePackages = {"com.voyager"})
@PropertySources({
        @PropertySource(value = "classpath:application.properties")
})
@EnableMongoRepositories(basePackages = "com.voyager.core.repository")
@EnableMongoAuditing
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public AbstractSecurityWebApplicationInitializer securityWebApplicationInitializer(){
        return new AbstractSecurityWebApplicationInitializer(){};
    }
}