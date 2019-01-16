package com.find.cn.dao;

import com.find.cn.pojo.TFind;
import com.find.cn.pojo.TFtalk;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TFindDao {
    /**
     * 查询管理员发布的咨询
     * @param user_id
     * @return
     */
    List<TFind> getAllInfo(Integer user_id);

    /**
     * 根据资讯ID查询某资讯的资讯信息
     * @param find_id
     * @return
     */
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

    /**
     * 回复评论
     * @param tFtalk
     * @return
     */
    int addReplyInfo(TFtalk tFtalk);

    //根据用户ID与评论表ID查询点赞数是否存在 1标识存在
    int selNum( @Param("find_id") Integer find_id);
    //点赞数存在则1改为0,表示已经点赞过,取消点赞
    int upNum1( @Param("find_id") Integer find_id);
    //点赞数存在则0改为1,表示点赞成功
    int upNum2(@Param("find_id") Integer find_id);

}
