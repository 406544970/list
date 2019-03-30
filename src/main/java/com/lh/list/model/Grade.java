package com.lh.list.model;

/**
 * @author 梁昊
 * @date 2018/11/8
 * @function 成绩
 * @editLog
 */
public class Grade {
    private String id;
    private String className;
    private String teacherId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }


    public String getTeacherId() {
        return teacherId;
    }

    public Grade setTeacherId(String teacherId) {
        this.teacherId = teacherId;
        return this;
    }
}
