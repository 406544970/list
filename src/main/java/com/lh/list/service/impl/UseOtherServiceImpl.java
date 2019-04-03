package com.lh.list.service.impl;

import com.lh.list.dao.UseOtherMapper;
import com.lh.list.model.UseOther;
import com.lh.list.service.UseOtherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 梁昊
 * @create 2019-04-03 09:18
 * @function
 * @editLog
 */
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Service
public class UseOtherServiceImpl implements UseOtherService {
    @Autowired
    UseOtherMapper useOtherDao;
    /**
     * 查询ListMain，根据主键
     *
     * @param useOther 查询ListMain，根据主键
     * @return 返回一个用户其它信息对象
     */
    @Override
    public List<UseOther> selectUserOtherByAll(UseOther useOther) {
        return useOtherDao.selectUserOtherByAll(useOther);
    }
}
