package com.lh.list.dto;

import com.lh.list.model.Grade;
import com.lh.list.model.Teacher;
import com.lh.list.model.User;
import com.lh.list.model.UserGrade;

/**
 * @author 梁昊
 * @date 2019/3/30
 * @function 成绩全信息：包括学生、课程、老师、成绩
 * @editLog
 */
public class AllUserGrade {
    private User user;
    private UserGrade userGrade;
    private Grade grade;
    private Teacher teacher;

    public String getUseId(){
        return userGrade.getUserId();
    }
    public UserGrade getUserGrade() {
        return userGrade;
    }

    public AllUserGrade setUserGrade(UserGrade userGrade) {
        this.userGrade = userGrade;
        return this;
    }

    public Grade getGrade() {
        return grade;
    }

    public AllUserGrade setGrade(Grade grade) {
        this.grade = grade;
        return this;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public AllUserGrade setTeacher(Teacher teacher) {
        this.teacher = teacher;
        return this;
    }

    public User getUser() {
        return user;
    }

    public AllUserGrade setUser(User user) {
        this.user = user;
        return this;
    }
}
