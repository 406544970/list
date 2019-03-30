package com.lh.list.model;

import java.util.Date;
import java.util.List;

/**
 * @author 梁昊
 * @date 2018/11/8
 * @function 学生成绩
 * @editLog
 */
public class UserGrade {
    public UserGrade() {
        super();
        this.myDate = new Date();
    }

    private Integer id;
    private String userId;
    private String classId;
    private Date myDate;
    private Float grade;

    public Integer getId() {
        return id;
    }

    public UserGrade setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public UserGrade setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public Date getMyDate() {
        return myDate;
    }

    public UserGrade setMyDate(Date myDate) {
        this.myDate = myDate;
        return this;
    }

    public Float getGrade() {
        return grade;
    }

    public UserGrade setGrade(Float grade) {
        this.grade = grade;
        return this;
    }


    public String getClassId() {
        return classId;
    }

    public UserGrade setClassId(String classId) {
        this.classId = classId;
        return this;
    }
}
