package com.example.algorithm.commons_lang;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.io.File;
import java.util.Date;

/**
 * Created by k on 2018/6/12.
 */
public class LearnDate {
    public void learn() {
        String format = DateFormatUtils.ISO_8601_EXTENDED_DATETIME_FORMAT.format(new Date());

        System.out.println(format);

    }

    public static void main(String[] args) {
        new LearnDate().learn();
        File[] files = File.listRoots();
        for (File file :
                files) {
            System.out.println(file.getName() + "---" + file.getAbsolutePath());
        }
    }
}
