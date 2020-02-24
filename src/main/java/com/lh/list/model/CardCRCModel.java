package com.lh.list.model;

import java.util.Date;

/**
 * 针对，RFID(手环)卡
 */
public final class CardCRCModel extends AbsCRCModel {
    /**
     * inf_person_bracelet表中的：cardId字段
     * RFID（手环）卡号
     */
    private String cardId;

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
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
