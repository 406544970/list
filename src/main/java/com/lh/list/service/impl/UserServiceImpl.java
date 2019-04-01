package com.lh.list.service.impl;

import com.lh.list.dao.UserMapper;
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
    UserMapper userMapper;
    /**
     * 主键查询获得user对象
     *
     * @param id 用户ID
     * @return User对象
     */
    @Override
    public List<User> selectByPrimaryKey(String id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public User selectByPrimaryKey2(String id) {
        return userMapper.selectByPrimaryKey2(id);
    }

}