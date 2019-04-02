package com.lh.list.service;


import com.lh.list.model.User;

import java.util.List;


/**
 * @author panjin
 * @create 2019-01-31 11:50
 */
public interface UserService {
//    /**
//     * 通过主键删除
//     * @param id 主键ID
//     * @return
//     */
//    R deleteByPrimaryKey(Long id);
//
//    /**
//     * 根据用户删除
//     * @param user
//     * @return
//     */
//    R deleteByUser(User user);
//
//    /**
//     * 添加更新
//     * @param user
//     * @return
//     */
//    R insertOrUpdate(User user);
//
//    /**
//     * 批量插入
//     * @param user
//     * @return
//     */
//    R insertBatch(List<User> user);
//
//    /**
//     * 同时添加用户和用户信息
//     * @param map
//     * @return
//     */
//    R insertUserAndUserInfo(Map map);
//

    /**
     * 主键查询获得user对象
     *
     * @param id 用户ID
     * @return User对象
     */
    List<User> selectByPrimaryKey(String id);

    /**
     * 主键查询获得user对象
     *
     * @param id 主键
     * @return 根据ID，得到一个用户实体对象
     */
    User selectByPrimaryKey2(String id);
    /**
     * 转对象得到UserList
     *
     * @param user 转对象得到UserList
     * @return 根据ID，得到一个用户实体对象
     */
    List<User> selectByPrimaryKey3(User user);
//
//    /**
//     * 获得用户列表
//     * @param user 用户对象
//     * @return List<User>
//     */
//    R selectUserList(User user);
//
//    /**
//     * 角色ID查询角色
//     * @param id 角色ID
//     * @return
//     */
//    R selectRoleById(long id);
//
//    /**
//     * 查询用户详细信息
//     * @param user
//     * @return
//     */
//    R selectUserAndUserInfo(User user);
//
//    /**
//     * 分组排序查询
//     * @param map
//     * @return
//     */
//    R selectUserList(Map map);
}
