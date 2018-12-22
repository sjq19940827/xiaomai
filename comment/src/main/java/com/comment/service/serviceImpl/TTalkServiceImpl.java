package com.comment.service.serviceImpl;



import com.alibaba.fastjson.JSON;
import com.comment.dao.TTalkDao;
import com.comment.pojo.TReplytalk;
import com.comment.pojo.TTalk;
import com.comment.service.TTalkService;
import com.comment.util.Dates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TTalkServiceImpl implements TTalkService {
    @Autowired
    private TTalkDao tTalkDao;

    /**
     * 根据商品ID查询该商品的所有评论
     * @param
     * @return
     */
    @Override
    public List<TTalk> getAllInfoByShowid(Integer answer_id) {

        return tTalkDao.getAllTalk(answer_id);
    }

    /**
     * 根据用户ID查询该用户参与过的评论
     * @param user_id
     * @return
     */
    @Override
    public List<TTalk> getTTalkInfoByUser(Integer user_id) {

        return tTalkDao.getTTalkInfoByUser(user_id);
    }

    /**
     *查询用户参与的评论次数
     * @param user_id
     * @return
     */
    @Override
    public int selTalkNum(Integer user_id) {
        int i = tTalkDao.selTalkNum(user_id);
        return i;
    }

    /**
     * 查询某用户对某商品的评论的被点赞数
     * @param user_id
     * @param answer_id
     * @return
     */
    @Override
    public int selDzByUserAndShow(Integer user_id, Integer answer_id) {
        int i = tTalkDao.selDzByUserAndShow(user_id, answer_id);
        return i;
    }

    /**登录状态下
     * 用户发布一条评论
     * @param tTalk
     * @return
     */
    @Override
    public String addTalkByUser(TTalk tTalk) {
       String info = null;
        if(tTalk != null){
            tTalk.setCreatetime(Dates.dates());

            tTalk.setTalk_info(tTalk.getTalk_info());
            if(tTalkDao.addTalkByUser(tTalk) == 0){
                info ="评论发布失败";
            }else {
                info = "评论发布成功";
            }
        }else {
            info = "评论信息为空,为发布成功";
        }
        return info;

    }

    /**登录状态下
     * 根据用户ID 商品ID 修改信息
     * @param tTalk
     * @return
     */
    @Override
    public int updateTalkInfo(TTalk tTalk) {
        return tTalkDao.updTalkInfo(tTalk);
    }






}
