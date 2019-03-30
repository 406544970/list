package com.lh.list.controller;

import com.lh.list.model.UserGrade;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 梁昊
 * @date 2019/3/30
 * @function 学生成绩控制层
 * @editLog
 */
@RestController
public class UserGradeController {
    private List<UserGrade> userGradeList;

    public UserGradeController() {
        super();
        userGradeList = new ArrayList<>();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        userGradeList.clear();
    }

    @PostMapping("/getUserGradeList")
    public List<UserGrade> getUserGradeList() {
        return userGradeList;
    }
}
