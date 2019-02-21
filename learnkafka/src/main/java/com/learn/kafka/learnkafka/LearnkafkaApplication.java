package com.learn.kafka.learnkafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class LearnkafkaApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnkafkaApplication.class, args);
    }

    @Autowired
    IndicatorService indicatorService;

    @GetMapping("/sendMsg")
    public String sendMsg() {
        indicatorService.sendMessage("test", "wang............");
        return "ok";
    }

}
