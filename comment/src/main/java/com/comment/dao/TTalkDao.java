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
     * 查询某用户的评论次数
     * @param
     * @return
     */
   int selTalkNum(@Param("user_id") Integer user_id);

   int selDzByUserAndShow(@Param("user_id")Integer user_id,@Param("answer_id") Integer answer_id);

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

    /**
     * 根据用户ID 对评论点赞
     * @param tTalk
     * @return
     */
    int insert(TTalk tTalk);


}
