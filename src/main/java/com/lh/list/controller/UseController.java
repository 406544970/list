package com.lh.list.controller;

import com.lh.list.model.SexHaving;
import com.lh.list.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import unit.PageList;
import unit.SortList;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 梁昊
 * @date 2019/3/29
 * @function 学生信息控制层
 * @editLog
 */
@RestController
@RequestMapping(value = "/users")     // 通过这里配置使下面的映射都在/users下，可去除
@Api(value = "用户控制类", description = "用户控制类")
public class UseController {
    private List<User> userList;

    public UseController() {
        super();
        userList = new ArrayList<>();
        for (int i = 1; i < 11; i++) {
            User user = new User();
            user.setId("id" + i);
            user.setAge(20 + i);
            user.setUserName("Name" + i);
            user.setSex(i / 2 == 1 ? true : false);
            userList.add(user);
        }
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        userList.clear();
    }

    /**
     * @return 返回列表数量
     */
    @ApiOperation(value = "获取用户列表", notes = "哈哈哈")
    @PostMapping("/getListCount")
    public int getListCount() {
        return this.userList.size();
    }


    /**
     * 根据标识，按年龄排序
     *
     * @param ascSign true:升，false:降
     * @return 列表
     */
    @ApiOperation(value = "根据标识，按年龄排序", notes = "true:升序、false:降序")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ascSign", value = "升序或降序", required = true, dataType = "Boolean")
    })
    @PostMapping("/getListSortByAge")
    public List<User> getUserSortByAge(Boolean ascSign) {
        SortList<User> sortList = new SortList<>();
        sortList.Sort(userList, "getAge", ascSign ? "asc" : "desc");
        return userList;
    }

    public List<User> getUserList() {
        return userList;
    }

    /**
     * 根据起点至终点，得到子列表
     *
     * @param beginIndex 起点
     * @param endIndex   终点
     * @return 子列表
     */
    @ApiOperation(value = "根据起点至终点，得到子列表", notes = "根据起点至终点，得到子列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "beginIndex", value = "开始数", required = true, dataType = "int"),
            @ApiImplicitParam(name = "endIndex", value = "结束数", required = true, dataType = "int")
    })
    @PostMapping("/getSubList")
    public List<User> getSubList(int beginIndex, int endIndex) {
        if (beginIndex < 0)
            return null;
        if (endIndex > userList.size())
            return null;
        return userList.subList(beginIndex, endIndex);
    }

    /**
     * 根据列表序号，得到内容
     *
     * @param index 列表序号
     * @return 对应的内容
     */
    @ApiOperation(value = "根据列表序号，得到内容", notes = "根据列表序号，得到内容")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "index", value = "序号", required = true, dataType = "int")
    })
    @PostMapping("/getValue")
    public User getValue(int index) {
        if (index > -1 && index < userList.size()) {
            return userList.get(index);
        } else {
            return null;
        }
    }

    /**
     * 根据性别去掉重复
     *
     * @return 仅返回两种性别的信息
     */
    @ApiOperation(value = "根据性别去掉重复", notes = "根据性别去掉重复")
    @PostMapping
    public List<User> getDeleteSame() {
        List<User> listTemp = new ArrayList();
        listTemp.addAll(userList);
        if (listTemp != null)
            for (int i = 0; i < listTemp.size() - 1; i++) {
                for (int j = listTemp.size() - 1; j > i; j--) {
                    if (listTemp.get(j).getSex().equals(listTemp.get(i).getSex())) {
                        listTemp.remove(j);
                    }
                }
            }
        return listTemp;
    }

    /**
     * 得到分页的列表
     *
     * @param pageIndex 当前页数
     * @param pageSize  每页条数
     * @return 列表
     */
    @ApiOperation(value = "得到分页的列表", notes = "得到分页的列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageIndex", value = "当前页数", required = true, dataType = "int"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", required = true, dataType = "int")
    })
    @PostMapping("/getPageList")
    public List<User> getPageList(int pageIndex, int pageSize) {
        return (List<User>) PageList.getPageList(pageIndex, pageSize, userList);
    }

    /**
     * 根据性别，分组
     *
     * @return 返回Key：性别，Value：分组内容
     */
    @ApiOperation(value = "根据性别，分组", notes = "根据性别，分组")
    @PostMapping("/getListGroupBySex")
    public Map<Boolean, List<User>> getListGroupBySex() {
        Map<Boolean, List<User>> sexMap = userList.stream()
                .collect(Collectors.groupingBy(User::getSex));
        return sexMap;
    }

    /**
     * 根据性别，统计人数
     *
     * @param havingCount 数量限制
     * @return 根据性别，统计人数，返回HashMap
     */
    @ApiOperation(value = "根据性别，统计人数", notes = "根据性别，统计人数", response = Map.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "havingCount", value = "数量限制", required = true, dataType = "int")
    })
    @PostMapping("/getMapGroupByHavingSex")
    public Map<Boolean, Integer> getMapGroupByHavingSex(int havingCount) {
        Map<Boolean, List<User>> sexMap = userList.stream()
                .collect(Collectors.groupingBy(User::getSex));
        Map<Boolean, Integer> resultMap = new HashMap<>();
        Iterator iterator = sexMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            if (((List<String>) entry.getValue()).size() > havingCount) //having count(sex) > 1
                resultMap.put((Boolean) entry.getKey(), ((List<String>) entry.getValue()).size());
        }
        return resultMap;
    }

    /**
     * 根据性别，统计人数
     *
     * @param havingCount 数量限制
     * @return 根据性别，统计人数，返回list
     */
    @ApiOperation(value = "根据性别，统计人数", notes = "根据性别，统计人数", response = List.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "havingCount", value = "数量限制", required = true, dataType = "int")
    })
    @PostMapping("/getListGroupByHavingSex")
    public List<SexHaving> getListGroupByHavingSex(int havingCount) {
        List<SexHaving> sexHavingList = new ArrayList<>();
        Map<Boolean, List<User>> sexMap = userList.stream()
                .collect(Collectors.groupingBy(User::getSex));
        for (Map.Entry<Boolean, List<User>> entry : sexMap.entrySet()) {
            if (entry.getValue().size() > havingCount) {
                SexHaving sexHaving = new SexHaving();
                sexHaving.setSex(entry.getKey());
                sexHaving.setCount(entry.getValue().size());
                sexHavingList.add(sexHaving);
            }
        }
        return sexHavingList;
    }


    /**
     * 得到姓名列表
     *
     * @return 姓名集合，而且去掉了重复
     */
    @ApiOperation(value = "得到姓名列表", notes = "得到姓名列表",response = List.class)
    @PostMapping("/getUserNameList")
    public List<String> getUserNameList() {
        Map<String, List<User>> nameMap = userList.stream()
                .collect(Collectors.groupingBy(User::getUserName));
        Collection<String> keyCollection = nameMap.keySet();
        return new ArrayList(keyCollection);
    }
}
