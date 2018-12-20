package com.discount.service.impl;

import com.alibaba.fastjson.JSON;
import com.discount.dao.ReduceDao;
import com.discount.pojo.T_Reduce;
import com.discount.service.ReduceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("reduceservice")
public class ReduceServiceImpl implements ReduceService {
    @Autowired

    private ReduceDao reduceDao;


    @Override
    public String ReduceInfo(Integer reduce_id) {
        List<T_Reduce> all = reduceDao.getAll(reduce_id);
        return JSON.toJSONString(all);
    }
}
