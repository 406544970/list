package com.lh.list.model;

/**
 * @author: 姊佹槉
 * @version: v1.0
 * @description: 项目[list]: com.lh.list.model
 * @date:2019/4/3
 */
public class UseAndUseOther2 {
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
    /**
     * 身高
     */
    private Integer useHeight;
    /**
     * 备注
     */
    private String remark;

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

    public Integer getUseHeight() {
        return useHeight;
    }

    public void setUseHeight(Integer useHeight) {
        this.useHeight = useHeight;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
