package com.lh.list.model;

import java.util.Date;

/**
 * CRC参数抽象类
 */
public abstract class AbsCRCModel {
    /**
     * 使用结束日期，不包括当天
     * 若是RFID卡的使用结束日期，则为：inf_person_bracelet中的:validTime
     * 若是人脸照的使用结束日期，则为：inf_person_to_room中的:outDate--实际选出日期
     */
    private Date endDays;

    public Date getEndDays() {
        return endDays;
    }

    public void setEndDays(Date endDays) {
        this.endDays = endDays;
    }
}
