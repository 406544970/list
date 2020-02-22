package com.lh.list.model;

import java.util.Date;

/**
 * 针对，迁入、迁出
 */
public final class RoomCRCModel extends AbsCRCModel {
    private String pictureId;

    public String getPictureId() {
        return pictureId;
    }

    public void setPictureId(String pictureId) {
        this.pictureId = pictureId;
    }

    @Override
    public String getPersonId() {
        return super.getPersonId();
    }

    @Override
    public void setPersonId(String personId) {
        super.setPersonId(personId);
    }

    @Override
    public Date getEndDays() {
        return super.getEndDays();
    }

    @Override
    public void setEndDays(Date endDays) {
        super.setEndDays(endDays);
    }
}
