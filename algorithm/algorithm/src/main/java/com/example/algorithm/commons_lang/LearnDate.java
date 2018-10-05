package com.example.algorithm.commons_lang;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Date;

/**
 * Created by k on 2018/6/12.
 */
public class LearnDate {
    public static void learn() {
        String format = DateFormatUtils.ISO_8601_EXTENDED_DATE_FORMAT.format(new Date());
        System.out.println(format);
    }

    public static void main(String[] args) {
        learn();
    }
}
