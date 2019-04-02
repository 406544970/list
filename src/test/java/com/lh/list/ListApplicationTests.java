package com.lh.list;

import com.google.gson.Gson;
import com.lh.list.controller.GradeController;
import com.lh.list.controller.TeacherController;
import com.lh.list.controller.UseController;
import com.lh.list.controller.UserGradeController;
import com.lh.list.dto.AllUserGrade;
import com.lh.list.model.Grade;
import com.lh.list.model.Teacher;
import com.lh.list.model.User;
import com.lh.list.model.UserGrade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ListApplicationTests {
    @Autowired
    UseController useController;

    @Autowired
    GradeController gradeController;

    @Autowired
    TeacherController teacherController;

    @Autowired
    UserGradeController userGradeController;

    @Autowired
    Gson gson;

    /**
     * 得到学生列表数量
     */
    @Test
    public void getListCount() {
        System.out.println(useController.getListCount());
    }

    /**
     * 根据标识，按年龄排序
     */
    @Test
    public void getUserSortByAge() {
        List<User> userSortByAge = useController.getUserSortByAge(true);
        for (User user : userSortByAge
                ) {
            System.out.println(user.getUserName() + ":" + user.getAge());
        }
    }

    /**
     * 根据起点至终点，得到子列表
     */
    @Test
    public void getSubList() {
        int listCount = useController.getListCount();
        List<User> userList = useController.getSubList(0, listCount - 5);
        System.out.println("总数：" + listCount);
        if (userList != null)
            System.out.println(gson.toJson(userList));
    }

    /**
     * 根据列表序号，得到内容
     */
    @Test
    public void getValue() {
        User value = useController.getValue(2);
        System.out.println(gson.toJson(value));
    }

    /**
     * 根据性别去掉重复
     */
    @Test
    public void getDeleteSame() {
        List<User> deleteSame = useController.getDeleteSame();
        if (deleteSame != null) {
            System.out.println(gson.toJson(deleteSame));
        }
    }

    /**
     * 得到分页的列表
     */
    @Test
    public void getPageList() {
        List<User> pageList = useController.getPageList(1, 6);
        if (pageList != null) {
            System.out.println(gson.toJson(pageList));
        }
    }

    /**
     * 根据性别，分组
     */
    @Test
    public void getListGroup() {
        Map<Boolean, List<User>> sexMap = useController.getListGroupBySex();
        System.out.println(gson.toJson(sexMap));
    }

    /**
     * 根据性别，统计人数，返回Map
     */
    @Test
    public void getMapGroupByHavingSex() {
        System.out.println(gson.toJson(useController.getMapGroupByHavingSex(0)));
    }

    /**
     * 根据性别，统计人数，返回list
     */
    @Test
    public void getListGroupByHavingSex() {
        System.out.println(gson.toJson(useController.getListGroupByHavingSex(0)));
    }

    /**
     * 初始化学生成绩列表
     */
    @Test
    public void getUserGradeList() {
        System.out.println(gson.toJson(_getUserGradeList()));
    }

    /**
     * 根据学生成绩关系列表，Inner Join 得到全信息
     */
    @Test
    public void getInnerJoinList() {
        List<UserGrade> userGradeList = _getUserGradeList();
        if (userGradeList != null) {
            List<User> userList = useController.getUserList();
            List<Grade> gradeList = gradeController.getGradeList();
            List<Teacher> teacherList = teacherController.getTeacherList();
            List<AllUserGrade> allUserGradeList = new ArrayList<>();
            for (UserGrade row : userGradeList
                    ) {
                AllUserGrade allUserGrade = new AllUserGrade();
                allUserGrade.setUserGrade(row);
                allUserGradeList.add(allUserGrade);
            }
            for (int i = 0; i < allUserGradeList.size(); i++) {
                String userId = allUserGradeList.get(i).getUserGrade().getUserId();
                String gradeId = allUserGradeList.get(i).getUserGrade().getClassId();
                List<User> users = userList.stream()
                        .filter(a -> a.getId().equals(userId))
                        .collect(Collectors.toList());
                List<Grade> grades = gradeList.stream()
                        .filter(b -> b.getId().equals(gradeId))
                        .collect(Collectors.toList());
                List<Teacher> teachers = null;
                if (grades != null && !grades.isEmpty()) {
                    String teacherId = grades.get(0).getTeacherId();
                    teachers = teacherList.stream()
                            .filter(c -> c.getId().equals(teacherId))
                            .collect(Collectors.toList());
                }
                if (users != null && !users.isEmpty() && grades != null && !grades.isEmpty() && teachers != null && !teachers.isEmpty()) {
                    allUserGradeList.get(i).setUser(users.get(0));
                    allUserGradeList.get(i).setGrade(grades.get(0));
                    allUserGradeList.get(i).setTeacher(teachers.get(0));
                } else
                    allUserGradeList.remove(i);
            }
            System.out.println(gson.toJson(allUserGradeList));
        }
    }

    /**
     * 根据学生成绩关系列表，Left Join 得到全信息
     */
    @Test
    public void getLeftJoinList() {
        List<UserGrade> userGradeList = _getUserGradeList();
        if (userGradeList != null) {
            List<User> userList = useController.getUserList();
            List<Grade> gradeList = gradeController.getGradeList();
            List<Teacher> teacherList = teacherController.getTeacherList();
            List<AllUserGrade> allUserGradeList = new ArrayList<>();
            for (UserGrade row : userGradeList
                    ) {
                AllUserGrade allUserGrade = new AllUserGrade();
                allUserGrade.setUserGrade(row);
                allUserGradeList.add(allUserGrade);
            }
            for (AllUserGrade item : allUserGradeList) {
                List<User> users = userList.stream()
                        .filter(a -> a.getId().equals(item.getUseId()))
                        .collect(Collectors.toList());
                List<Grade> grades = gradeList.stream()
                        .filter(b -> b.getId().equals(item.getUserGrade().getClassId()))
                        .collect(Collectors.toList());
                List<Teacher> teachers = null;
                if (grades != null && grades.size() > 0) {
                    teachers = teacherList.stream()
                            .filter(c -> c.getId().equals(grades.get(0).getTeacherId()))
                            .collect(Collectors.toList());
                }
                if (users != null && users.size() > 0) {
                    item.setUser(users.get(0));
                }
                if (grades != null && grades.size() > 0) {
                    item.setGrade(grades.get(0));
                }
                if (teachers != null && teachers.size() > 0) {
                    item.setTeacher(teachers.get(0));
                }
            }
            System.out.println(gson.toJson(allUserGradeList));
        }
    }

    /**
     * 得到姓名单列List
     */
    @Test
    public void getUserNameList() {
        System.out.println(gson.toJson(useController.getUserNameList()));
    }

    /**
     * 初始化学生成绩列表
     *
     * @return 学生成绩关系列表
     */
    private List<UserGrade> _getUserGradeList() {
        List<UserGrade> userGradeList = new ArrayList<>();
        int count = 1;
        UserGrade userGrade = new UserGrade();
        userGrade.setId(count++);
        userGrade.setUserId(useController.getUserList().get(0).getId());
        userGrade.setClassId(gradeController.getGradeList().get(0).getId());
        userGrade.setGrade((float) 89.5);
        userGradeList.add(userGrade);

        userGrade = new UserGrade();
        userGrade.setId(count++);
        userGrade.setUserId(useController.getUserList().get(0).getId());
        userGrade.setClassId(gradeController.getGradeList().get(1).getId());
        userGrade.setGrade((float) 89.5 + count);

        userGradeList.add(userGrade);
        userGrade = new UserGrade();
        userGrade.setId(count++);
        userGrade.setUserId(useController.getUserList().get(1).getId());
        userGrade.setClassId(gradeController.getGradeList().get(2).getId());
        userGrade.setGrade((float) 89.5 + count);
        userGradeList.add(userGrade);
        return userGradeList;
    }

//    下面为与mybatis基本方法

    /**
     * 根据主键，查询一个User列表对象，returnMap返回
     */
    @Test
    public void selectByPrimaryKeyUser() {
        System.out.println(gson.toJson(useController.selectByPrimaryKeyUser(null)));
    }

    /**
     * 根据主键，查询一个User对象，returnType返回
     */
    @Test
    public void selectByPrimaryKeyUser2() {
        System.out.println(gson.toJson(useController.selectByPrimaryKey2("id3")));
    }

    @Test
    public void selectByPrimaryKeyUser3() {
        System.out.println(gson.toJson(useController.selectByPrimaryKey3("i", "name", 11, true)));
    }

}
