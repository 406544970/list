package com.lh.list.model;

/**
 * @author 梁昊
 * @date 2019/3/30
 * @function 性别统计类
 * @editLog
 */
public class SexHaving {
    private Boolean sex;
    private Integer count;

    public Boolean getSex() {
        return sex;
    }

    public SexHaving setSex(Boolean sex) {
        this.sex = sex;
        return this;
    }

    public Integer getCount() {
        return count;
    }

    public SexHaving setCount(Integer count) {
        this.count = count;
        return this;
    }
}
