package com.lh.list.service;

import com.lh.list.model.UseOther;

import java.util.List;

/**
 * @author 梁昊
 * @create 2019-04-03 09:18
 * @function
 * @editLog
 */
public interface UseOtherService {
    /**
     * 查询ListMain，根据主键
     *
     * @param useOther 查询ListMain，根据主键
     * @return 返回一个用户其它信息对象
     */
    List<UseOther> selectUserOtherByAll(UseOther useOther);
}
