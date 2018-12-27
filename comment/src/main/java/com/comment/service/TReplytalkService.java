package com.comment.service;

import com.comment.pojo.TReplytalk;

import javax.validation.constraints.Null;
import java.util.List;

public interface TReplytalkService {
    /**
     * 新增一条回复信息
     * @param tReplytalk
     * @return
     */
    String addreply(TReplytalk tReplytalk);

    /**
     *某商品下的评论/回复信息
     * @param replyuser_id
     * @return
     */
    List<TReplytalk> allInfo(Integer replyuser_id);
}
