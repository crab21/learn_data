package com.example.sqlswt.sqlcreate;

import com.example.sqlswt.model.ClassInfoSql;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

/**
 * @program: sqlswt
 * @description: 表处理
 * @author: Mr.Wang
 * @create: 2018-11-02 18:12
 **/
public class TablePanelDeal {

    private static final String FILE_MAKE_PATH = "d://tttttttttt//";

    /**
     * 生成实体类
     *
     * @param tableName
     */
    public static void reduceTable(String tableName) {
        List<ClassInfoSql> result = SqlFind.getColumnComments(tableName);
        System.out.println(result.size() + "大小....");

        File file = new File(FILE_MAKE_PATH + tableName + ".java");
        StringBuffer resultStr = new StringBuffer();
        FileWriter input = null;
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            input = new FileWriter(file);
            resultStr.append("public class " + tableName + " {\n");

            result.stream().forEach(v -> {
                resultStr.append("// " + v.getComment() + "\n");
                resultStr.append("private String " + v.getField() + "\n");

                System.out.println(v);
            });
            resultStr.append("}");
            input.write(resultStr.toString());
            System.out.println(resultStr.toString());
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
