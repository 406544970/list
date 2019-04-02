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

    /**
     * 主键查询获得user对象
     *
     * @param id 主键
     * @return 根据ID，得到一个用户实体对象
     */
    User selectByPrimaryKey2(@Param("id") String id);
}