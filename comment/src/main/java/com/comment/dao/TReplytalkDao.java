package com.comment.dao;




import com.comment.pojo.TReplytalk;

import org.apache.ibatis.annotations.Mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface TReplytalkDao {
    /**
     * 用户回复信息
     * @param tReplytalk
     * @return
     */
    int addreply(TReplytalk tReplytalk);

    /**
     * 某商品下的评论/回复信息
     * @param replyuser_id
     * @return
     */
    List<TReplytalk> allInfo(@Param("replyuser_id") Integer replyuser_id);

}
