package com.lh.list.model;

/**
 * @author: 梁昊
 * @version: v1.0
 * @description: 项目[list]: com.lh.list.model
 * @date:2019/4/3
 */
public class UseOther {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    /**
     * 主键
     */
    private String id;
    /**
     * 身高
     */
    private Integer useHeight;
    /**
     * 备注
     */
    private String remark;
}
