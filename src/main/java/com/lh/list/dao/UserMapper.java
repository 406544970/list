package com.lh.list.dao;

import com.lh.list.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 梁昊
 * @date 2019/4/1
 * @function
 * @editLog
 */
@Mapper
public interface UserMapper {

    /**
     * 根据主键，查询一个User对象
     *
     * @param id 主键
     * @return 一个User对象
     */
    List<User> selectByPrimaryKey(@Param("id") String id);

    User selectByPrimaryKey2(@Param("id") String id);
}