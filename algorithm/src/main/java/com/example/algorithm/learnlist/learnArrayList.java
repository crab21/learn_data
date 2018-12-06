package com.example.algorithm.learnlist;

import io.netty.buffer.ByteBuf;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
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
