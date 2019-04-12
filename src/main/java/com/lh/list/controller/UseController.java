package com.lh.list.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lh.list.model.*;
import com.lh.list.service.UseOtherService;
import com.lh.list.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
@Api(value = "用户控制层", description = "专用于用户相关业务")
public class UseController {
    @Value("${server.port}")
    String myPort;

    @Value("${mySetUp.pageSize}")
    int pageSize;

    @Autowired
    UserService userService;

    @Autowired
    UseOtherService useOtherService;

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
     * 根据主键，查询一个User列表对象
     *
     * @param id 主键
     * @return returnMap返回：一个User列表对象
     */
    @ApiOperation(value = "根据主键查询User单个对象", notes = "returnMap返回：一个User对象")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键", required = true, dataType = "String")
    })
    @PostMapping("/selectByPrimaryKeyUser")
    public List<User> selectByPrimaryKeyUser(String id) {
        return userService.selectByPrimaryKey(id);
    }

    /**
     * 主键查询获得user对象
     *
     * @param id 主键
     * @return 根据ID，得到一个用户实体对象
     */
    @ApiOperation(value = "主键查询获得user对象", notes = "根据ID，得到一个用户实体对象")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键", required = true, dataType = "String")
    })
    @PostMapping("/selectByPrimaryKey2")
    public User selectByPrimaryKey2(@RequestParam(value = "id") String id) {

//      请在这里写逻辑代码

        return userService.selectByPrimaryKey2(id);
    }

    /**
     * 转对象得到UserList
     *
     * @param id       主键
     * @param userName 姓名
     * @param age      年龄
     * @param sex      性别
     * @return 根据ID，得到一个用户实体对象
     */
    @ApiOperation(value = "转对象得到UserList", notes = "根据ID，得到一个用户实体对象")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键", required = true, dataType = "String"),
            @ApiImplicitParam(name = "userName", value = "姓名", required = true, dataType = "String"),
            @ApiImplicitParam(name = "age", value = "年龄", required = true, dataType = "int"),
            @ApiImplicitParam(name = "sex", value = "性别", required = true, dataType = "boolean")
    })
    @PostMapping("/selectByPrimaryKey3")
    public List<User> selectByPrimaryKey3(@RequestParam(value = "id") String id
            , @RequestParam(value = "userName") String userName
            , @RequestParam(value = "age") int age
            , @RequestParam(value = "sex") boolean sex) {
        PageHelper.startPage(2, pageSize);

        User userPara = new User();
//        userPara.setId(id);
        userPara.setUserName("userName");
//        userPara.setAge(age);
//        userPara.setSex(sex);

//      请在这里写逻辑代码
        List<User> users = userService.selectByPrimaryKey3(userPara);
        return users;
    }

    @PostMapping("/selectByPrimaryKey3Page")
    public PageInfo<User> selectByPrimaryKey3Page(@RequestParam(value = "id") String id
            , @RequestParam(value = "userName") String userName
            , @RequestParam(value = "age") int age
            , @RequestParam(value = "sex") boolean sex){
        List<User> users = this.selectByPrimaryKey3(id, userName, age, sex);
        PageInfo<User> pageInfo = new PageInfo(users);
        return pageInfo;
    }

    /**
     * @return 返回列表数量
     */
    @ApiOperation(value = "返回列表数量", notes = "返回列表数量")
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
    @ApiOperation(value = "得到姓名列表", notes = "得到姓名列表", response = List.class)
    @PostMapping("/getUserNameList")
    public List<String> getUserNameList() {
        Map<String, List<User>> nameMap = userList.stream()
                .collect(Collectors.groupingBy(User::getUserName));
        Collection<String> keyCollection = nameMap.keySet();
        return new ArrayList(keyCollection);
    }

    @ApiOperation(value = "查看该站点端口", notes = "以便观察负载均衡")
    @PostMapping(value = "/myPort")
    public String myPort() {
        return "myPort: " + this.myPort;
    }

    /**
     * 查询ListMain，根据主键
     *
     * @param id        主键
     * @param useHeight 身高
     * @param remark    备注
     * @return 返回一个用户其它信息对象
     */
    @ApiOperation(value = "查询ListMain，根据主键", notes = "返回一个用户其它信息对象")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键", required = true, dataType = "String"),
            @ApiImplicitParam(name = "useHeight", value = "身高", required = true, dataType = "int"),
            @ApiImplicitParam(name = "remark", value = "备注", required = true, dataType = "String")
    })
    @PostMapping("/selectUserOtherByAll")
    public List<UseOther> selectUserOtherByAll(@RequestParam(value = "id") String id
            , @RequestParam(value = "useHeight") int useHeight
            , @RequestParam(value = "remark") String remark) {
        UseOther useOtherPara = new UseOther();
        useOtherPara.setId(id);
        useOtherPara.setUseHeight(useHeight);
        useOtherPara.setRemark(remark);

//      请在这里写逻辑代码

        return useOtherService.selectUserOtherByAll(useOtherPara);
    }

    @PostMapping("/selectUserAndUserOtherByAll")
    public UseAndUseOther2 selectUserAndUserOtherByAll(){
        return userService.selectUserAndUserOtherByAll();
    }

    @PostMapping("/selectUserAndUserOtherByAll2")
    public UseAndUseOther selectUserAndUserOtherByAll2(){
        return userService.selectUserAndUserOtherByAll2();
    }

    @PostMapping("/selectUserAndUserOtherByAll3")
    public UseAndUseOther3 selectUserAndUserOtherByAll3(){
        return userService.selectUserAndUserOtherByAll3();
    }

    @PostMapping("/selectUserByListKey")
    public List<User> selectUserByListKey(List<String> list){
        return userService.selectByListKey(list);
    }

}
