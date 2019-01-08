package com.find.cn.service;

import com.find.cn.pojo.TFind;
import com.find.cn.pojo.TFtalk;

import java.util.List;

public interface TFindService {
    /**
     * 查询咨询
     * @param user_id
     * @return
     */
    List<TFind> getAllInfo(Integer user_id);
    List<TFind> getOneInfo(Integer find_id);
    List<TFtalk> getAllTalk(Integer findid);
    String  addTalkByUser(TFtalk tFtalk);
    String  addReplyInfo(TFtalk tFtalk);

}
