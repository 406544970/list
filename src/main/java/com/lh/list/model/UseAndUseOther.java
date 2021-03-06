package com.lh.list.model;

/**
 * @author: 梁昊
 * @version: v1.0
 * @description: 项目[list]: com.lh.list.model
 * @date:2019/4/3
 */
public class UseAndUseOther {
    /**
     * 主键
     */
    private String id;
    /**
     * 姓名
     */
    private String userName;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 性别
     */
    private Boolean sex;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public UseOther getUseOther() {
        return useOther;
    }

    public void setUseOther(UseOther useOther) {
        this.useOther = useOther;
    }

    private UseOther useOther;
}
