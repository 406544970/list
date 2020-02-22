package com.lh.list.model;

import java.util.Date;

/**
 * CRC参数抽象类
 */
public abstract class AbsCRCModel {
    /**
     * 居民ID
     */
    private String personId;
    /**
     * 使用结束日期，不包括当天
     */
    private Date endDays;

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public Date getEndDays() {
        return endDays;
    }

    public void setEndDays(Date endDays) {
        this.endDays = endDays;
    }
}
