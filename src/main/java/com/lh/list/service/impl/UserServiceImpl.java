package com.lh.list.service.impl;

import com.lh.list.dao.UserMapper;
import com.lh.list.model.UseAndUseOther;
import com.lh.list.model.User;
import com.lh.list.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 梁昊
 * @date 2019/4/1
 * @function
 * @editLog
 */
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userDao;
    /**
     * 主键查询获得user对象
     *
     * @param id 用户ID
     * @return User对象
     */
    @Override
    public List<User> selectByPrimaryKey(String id) {
        return userDao.selectByPrimaryKey(id);
    }

    /**
     * 主键查询获得user对象
     *
     * @param id 主键
     * @return 根据ID，得到一个用户实体对象
     */
    @Override
    public User selectByPrimaryKey2(String id) {
        return userDao.selectByPrimaryKey2(id);
    }

    /**
     * 转对象得到UserList
     *
     * @param user 转对象得到UserList
     * @return 根据ID，得到一个用户实体对象
     */
    @Override
    public List<User> selectByPrimaryKey3(User user) {
        return userDao.selectByPrimaryKey3(user);
    }

    @Override
    public UseAndUseOther selectUserAndUserOtherByAll() {
        return userDao.selectUserAndUserOtherByAll();
    }
}
