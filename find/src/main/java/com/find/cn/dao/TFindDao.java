package com.find.cn.dao;

import com.find.cn.pojo.TFind;
import com.find.cn.pojo.TFtalk;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TFindDao {
    /**
     * 查询咨询
     * @param user_id
     * @return
     */
    List<TFind> getAllInfo(Integer user_id);

    List<TFind> getOneInfo(Integer find_id);

    /**
     * 查询某咨询下的评论信息
     * @param findid
     * @return
     */
    List<TFtalk> getAllTalk(Integer findid);

    /**
     * 发布评论
     * @param tFtalk
     * @return
     */
    int addTalkByUser(TFtalk tFtalk);

    int addReplyInfo(TFtalk tFtalk);

}
