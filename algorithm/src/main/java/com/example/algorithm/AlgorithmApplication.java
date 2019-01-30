package com.example.algorithm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.support.AbstractRefreshableWebApplicationContext;
import org.springframework.web.servlet.HandlerInterceptor;
import reactor.core.publisher.Flux;


@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@SpringBootApplication
@RestController
public class AlgorithmApplication {
    public static void main(String[] args) {

        SpringApplication.run(AlgorithmApplication.class, args);
    }

    @GetMapping("/webflux")
    public Flux<String> hello() {
        return Flux.just("hello");


    }
}


