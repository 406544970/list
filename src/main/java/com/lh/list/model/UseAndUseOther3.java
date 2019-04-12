package com.lh.list.model;

import java.util.List;

/**
 * @author 梁昊
 * @date 2019/4/12
 * @function
 * @editLog
 */
public class UseAndUseOther3 {
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


    public List<UseOther> getUseOthers() {
        return useOthers;
    }

    public void setUseOthers(List<UseOther> useOthers) {
        this.useOthers = useOthers;
    }

    private List<UseOther> useOthers;

}
