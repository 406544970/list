package com.lh.list.model;

import java.io.Serializable;

/**
 * @author 梁昊
 * @date 2018/11/8
 * @function 学生
 * @editLog
 */
public class User implements Serializable {
    private String id;
    private String userName;
    private Integer age;
    private Boolean sex;

    public User() {
        super();
    }

    public String getId() {
        return id;
    }

    public Boolean getSex() {
        return sex;
    }

    public User setSex(Boolean sex) {
        this.sex = sex;
        return this;
    }

    /**
     * 设置ID
     *
     * @param id 主键ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 得到用户名
     *
     * @return 返回用户名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户名
     *
     * @param userName 用户名内容
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
