package com.example.sqlswt.model;

/**
 * @program: sqlswt
 * @description: sql信息情况
 * @author: Mr.Wang
 * @create: 2018-11-02 18:24
 **/
public class ClassInfoSql {
    private String field;
    private String type;
    private String comment;

    public ClassInfoSql(String field, String type, String comment) {
        this.field = field;
        this.type = type;
        this.comment = comment;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
