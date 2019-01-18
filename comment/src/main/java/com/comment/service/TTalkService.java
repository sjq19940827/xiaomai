package com.comment.service;


import com.comment.pojo.TTalk;
import java.util.List;
public interface TTalkService {

    /**
     * 根据商品ID查询该商品的所有评论信息
     * @param answer_id
     * @return
     */
  String getAllInfoByShowid(Integer answer_id);

   /**
   * 查询某用户的评论信息
   * @param user_id
   * @return
    */
   List<TTalk> getTTalkInfoByUser(Integer user_id);

    /**
     * 查询某用户的评论数
     * @param user_id
     * @return
     */
   int selTalkNum(Integer user_id);

    /**
     * 查询某用户对某商品的评论的被点赞数
     * @param answer_id
     * @return
     */
   int selDzByUserAndShow( Integer answer_id);

    /**
     * 用户发布一条评论
     * @param tTalk
     * @return
     */
   String  addTalkByUser(TTalk tTalk);


     /**
      * 修改评论信息
      * @param tTalk
      * @return
      */
    String updateTalkInfo(TTalk tTalk);

    /*
    * 查询点赞状态
    */
    int selNum( Integer talk_id);

    /**
     * 进行点赞操作
 d
     * @param talk_id
     * @return
     */
    String qdz( Integer talk_id);

    // 查看某商品是否有评论
    String  NumByAnswer(Integer answer_id);

    List<TTalk> getTalkIsBanner(Integer show_mark,String show_place);

}
