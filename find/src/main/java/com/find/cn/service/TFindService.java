package com.find.cn.service;

import com.find.cn.pojo.TFind;

import java.util.List;

public interface TFindService {
    /**
     * 查询咨询
     * @param user_id
     * @return
     */
    List<TFind> getAllInfo(Integer user_id);

}
