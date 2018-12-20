package com.comment.service;


import com.comment.pojo.TTalk;

import java.util.List;

public interface TTalkService {

    /**
     * 根据商品ID查询该商品的所有评论信息
     * @param answer_id
     * @return
     */
  List<TTalk> getAllInfoByShowid(int answer_id);

   /**
   * 查询某用户的评论信息
   * @param user_id
   * @return
    */
   List<TTalk> getTTalkInfoByUser(int user_id);
}
