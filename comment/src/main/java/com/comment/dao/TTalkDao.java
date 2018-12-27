package com.comment.dao;




import com.comment.pojo.TReplytalk;
import com.comment.pojo.TTalk;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface TTalkDao {
    /**
     * 查询全部评论
     * @return
     */
    List<TTalk> getAllTalk(@Param("answer_id") Integer answer_id);

    /**
     * 查询某用户的所有评论
     * @param user_id
     * @return
     */
    List<TTalk> getTTalkInfoByUser(@Param("user_id") Integer user_id);

    /**
     * 用户发布评论
     * @param
     */

    int addTalkByUser(TTalk tTalk);

    /**
     * 用户修改评论
     * @param tTalk
     * @return
     */
    int updTalkInfo(TTalk tTalk);

    //根据用户ID与评论表ID查询点赞数是否存在 1标识存在
    int selNum(@Param("user_id") Integer user_id, @Param("talk_id") Integer talk_id);
    //点赞数存在则1改为0,表示已经点赞过,取消点赞
    int upNum1(@Param("user_id") Integer user_id, @Param("talk_id") Integer talk_id);
    //点赞数存在则0改为1,表示点赞成功
    int upNum2(@Param("user_id") Integer user_id, @Param("talk_id") Integer talk_id);

    /**
     * 查询某用户的评论次数
     * @param
     * @return
     */
    int selTalkNum(@Param("user_id") Integer user_id);

    /**
     * 根据商品ID 用户ID 查点赞数
     * @param user_id
     * @param answer_id
     * @return
     */
    int selDzByUserAndShow(@Param("user_id") Integer user_id, @Param("answer_id") Integer answer_id);


}
