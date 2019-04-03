package com.lh.list.dao;

import com.lh.list.model.UseOther;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 梁昊
 * @create 2019-04-03 09:18
 * @function
 * @editLog
 */
@Mapper
public interface UseOtherMapper {
    /**
     * 查询ListMain，根据主键
     *
     * @param useOther 查询ListMain，根据主键
     * @return 返回一个用户其它信息对象
     */
    List<UseOther> selectUserOtherByAll(UseOther useOther);
}
