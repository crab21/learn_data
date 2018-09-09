package com.example.algorithm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class AlgorithmApplication {

    static String i;

    public static void main(String[] args) {
        SpringApplication.run(AlgorithmApplication.class, args);
    }

    public void show() {
        int i = 0;
        System.out.println(i);
    }
}
