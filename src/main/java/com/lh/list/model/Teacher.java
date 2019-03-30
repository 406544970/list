package com.lh.list.model;

/**
 * @author 梁昊
 * @date 2019/3/29
 * @function 老师
 * @editLog
 */
public class Teacher {
    private String id;

    public String getId() {
        return id;
    }

    public Teacher setId(String id) {
        this.id = id;
        return this;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public Teacher setTeacherName(String teacherName) {
        this.teacherName = teacherName;
        return this;
    }

    public short getAge() {
        return age;
    }

    public Teacher setAge(short age) {
        this.age = age;
        return this;
    }

    private String teacherName;
    private short age;
}
