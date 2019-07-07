package com.example.algorithm.learnMongodb;

import com.mongodb.client.FindIterable;
import com.mongodb.client.model.Filters;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;
import java.util.WeakHashMap;

@Service
public class LearnCURD {
    @Autowired
    MongoTemplate mongoTemplate;

    public  static void save() {
//        FindIterable<Document> documents = mongoTemplate.getCollection("py").find(Filters.eq("shortAddr", 20));
        Integer reduce = Arrays.asList(1, 2, 3).parallelStream().reduce(10, (a, b) -> a + b,(a,b)->{
            System.out.println(a+"---a");
            System.out.println(b+"---b");
            return a + b;
        });
        System.out.print(reduce);

    }

    public static void main(String[] args) {
        save();
    }
}
