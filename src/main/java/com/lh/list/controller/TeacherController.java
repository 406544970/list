package com.lh.list.controller;

import com.lh.list.model.Teacher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 梁昊
 * @date 2019/3/30
 * @function 老师控制层
 * @editLog
 */
@RestController
public class TeacherController {
    private List<Teacher> teacherList;

    public TeacherController() {
        super();
        teacherList = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            Teacher teacher = new Teacher();
            teacher.setId("TeacherId" + i);
            teacher.setTeacherName("TeacherName" +i);
            teacher.setAge((short) (30 + i));
            teacherList.add(teacher);
        }
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        teacherList.clear();
    }

    @PostMapping("/getTeacherList")
    public List<Teacher> getTeacherList() {
        return teacherList;
    }
}
