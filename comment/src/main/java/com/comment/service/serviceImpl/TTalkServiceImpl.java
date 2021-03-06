package com.comment.service.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.comment.dao.TTalkDao;
import com.comment.pojo.TTalk;
import com.comment.service.TTalkService;
import com.comment.util.Dates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

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
    public String getAllInfoByShowid(Integer answer_id) {
        int i = tTalkDao.NumByAnswer(answer_id);
        if(i > 0){
            return JSON.toJSONString(tTalkDao.getAllTalk(answer_id));
        }else {
            return "该商品暂无评论";
        }

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
     * 发布一条评论
     * @param
     * @param
     * @param
     * @return
     */
    @Override
    public String addTalkByUser(TTalk tTalk) {
      String info = null;
        Jedis jedis = new Jedis("47.94.12.237 ",6379);
        Integer userid = Integer.valueOf(jedis.get("userid"));
        tTalk.setUser_id(userid);

        if(tTalk.getAnswer_id()!= null && tTalk.getUser_id()!= null &&  tTalk.getTalk_info()!= null ){
          tTalk.setCreatetime(Dates.dates());//获取当前时间

          if(tTalkDao.addTalkByUser(tTalk) == 0){
              info ="评论发布失败";
          }else {
              info = "评论发布成功";
          }
      }else {
          info = "评论信息为空,未发布成功";
      }
        return info;
    }

    /**登录状态下
     * 根据用户ID 商品ID 修改信息
     * @param tTalk
     * @return
     */
    @Override
    public String  updateTalkInfo(TTalk tTalk) {
       String info = null;
         Jedis jedis = new Jedis("47.94.12.237 ",6379);
        Integer userid = Integer.valueOf(jedis.get("userid"));
        tTalk.setUser_id(userid);

        if(tTalk.getUser_id() !=  null && tTalk.getTalk_id() != null && tTalk.getTalk_info() != null){
            int i = tTalkDao.updTalkInfo(tTalk);
            if(i > 0 ){
                info = "修改成功";

            }else if(i<0){
                info = "修改失败";

            }
        }else {
            return "输入不完整";
        }

        return info ;
    }

    //查数据库状态
    @Override
    public int selNum( Integer talk_id) {
        return tTalkDao.selNum(talk_id);
    }

    @Override
    public String qdz(Integer talk_id) {
        int c = selNum( talk_id);
        if( c  == 1){
            int i = tTalkDao.upNum1(talk_id);
            return "取消点赞";
        }else if(c == 0){
            int i = tTalkDao.upNum2( talk_id);
        }
        return "点赞成功";
    }

    /**
     * 查看某商品是否有评论
     * @param answer_id
     * @return
     */
    @Override
    public String  NumByAnswer(Integer answer_id) {
        String info = null;
        int i = tTalkDao.NumByAnswer(answer_id);
        if(i > 0){
            info ="有评论信息";
        }else {
            info = "该商品无评论信息";
        }
        return info;
    }

    /**
     * 商品页轮播评论
     * @param show_mark
     * @param show_place
     * @return
     */
    @Override
    public List<TTalk> getTalkIsBanner(Integer show_mark, String show_place) {
        return tTalkDao.getTalkInfoIsBanner(show_mark, show_place);
    }

    /**
     * 查询商品的平均分
     * @param answer_id
     * @return
     */
    @Override
    public double resultByAnswer(Integer answer_id) {
        return tTalkDao.resultByAnswer(answer_id);
    }

    /**
     * 查询某用户对某商品的评论的被点赞数
     * @param answer_id
     * @return
     */
    @Override
    public int selDzByUserAndShow( Integer answer_id) {
        int i = tTalkDao.selDzByUserAndShow( answer_id);
        return i;
    }

}







