package com.lh.list.model;

import java.util.Date;
import java.util.List;

/**
 * 针对，脸照
 */
public final class FaceCRCModel extends AbsCRCModel {
    /**
     * inf_person_to_room：personId
     */
    private String personId;
    /**
     * inf_person_picture表中的：id字段
     * 即，静态资源站点的ID
     * 根据inf_person_to_room的personId,在inf_person_picture中，得到所有id
     */
    private List<String> pictureIdList;

    @Override
    public Date getEndDays() {
        return super.getEndDays();
    }

    @Override
    public void setEndDays(Date endDays) {
        super.setEndDays(endDays);
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public List<String> getPictureIdList() {
        return pictureIdList;
    }

    public void setPictureIdList(List<String> pictureIdList) {
        this.pictureIdList = pictureIdList;
    }
}
