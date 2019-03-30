package com.lh.list.controller;

import com.lh.list.model.Grade;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 梁昊
 * @date 2019/3/30
 * @function 课程控制层
 * @editLog
 */
@RestController
public class GradeController {
    private List<Grade> gradeList;

    public GradeController() {
        super();
        gradeList = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            Grade grade = new Grade();
            grade.setId("ClassId" + i);
            grade.setClassName("ClassName" + i);
            if (i > 2)
                grade.setTeacherId("TeacherId" + (i + 10));
            else
                grade.setTeacherId("TeacherId" + i);
            gradeList.add(grade);
        }

    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        gradeList.clear();
    }

    /**
     * 得到所有课程
     *
     * @return 课程列表
     */
    @PostMapping("/getGradeList")
    public List<Grade> getGradeList() {
        return this.gradeList;
    }
}
