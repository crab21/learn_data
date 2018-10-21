package com.example.algorithm.learnlist;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by k on 2018/9/9.
 */
@RestController
public class learnArrayList {
    public static void main(String[] args) {
        List list = new ArrayList<>();
        list.add(1);
    }

    @RequestMapping("/hello")
    public String hello(@RequestParam("id") String id) throws ParseException {
        System.out.println(id);
        return "ok";
    }
}
