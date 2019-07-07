package com.example.algorithm.learnlist;

import com.google.gson.Gson;
import io.netty.buffer.ByteBuf;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.logging.jdbc.ResultSetLogger;
import org.apache.ibatis.type.TypeAliasRegistry;
import org.apache.ibatis.type.TypeHandler;
import org.apache.ibatis.type.TypeHandlerRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.Unsafe;

import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * Created by k on 2018/9/9.
 */
@RestController
public class learnArrayList {
    private static UserObject userObjects;

    public static void main(String[] args) throws InterruptedException {
        List map;
        try {
            map = new learnArrayList().findList();
            Unsafe.getUnsafe().fullFence();

            System.out.println(map.size());
        } catch (Exception e) {
            System.out.println("name");
//            map = Collections.emptyList();
        }
        System.gc();
        System.out.println("---");
        while (true) {
            Thread.sleep(10);
            break;
        }
        System.gc();
        while (true) {

            System.gc();

            Thread.sleep(1000);
        }

    }

    public List<UserObject> findList() throws Exception {
        UserObject userObject = new UserObject();
        userObject.setAge("1");
        userObject.setName("2");
        List<UserObject> list = new ArrayList() {
            @Override
            protected void finalize() throws Throwable {
                System.out.println("shi fang list");
            }
        };
        list.add(userObject);
        list.stream().forEach(k -> System.out.println(k));
        WeakHashMap map = new WeakHashMap() {
            @Override
            protected void finalize() throws Throwable {
                System.out.println("map cccccc");
            }
        };
        map.put("ff", userObject);
        try {
            int i = 2 / 0;
        } catch (Exception e) {
            System.out.println("ff");
        }

        return list;
    }


    @Override
    protected void finalize() throws Throwable {
        System.out.println("ssssss要死了要死了要死了!");
    }

    @RequestMapping("/hello")
    public String hello(@RequestParam("id") String id) throws ParseException {
        System.out.println(id);
        return "ok";
    }

    public void ConcurrentListInfo() {

    }


}
