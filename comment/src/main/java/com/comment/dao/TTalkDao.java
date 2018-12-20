package com.comment.dao;




import com.comment.pojo.TTalk;
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

}
