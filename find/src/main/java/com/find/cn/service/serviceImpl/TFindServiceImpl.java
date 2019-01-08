package com.find.cn.service.serviceImpl;

import com.find.cn.dao.TFindDao;
import com.find.cn.pojo.TFind;
import com.find.cn.pojo.TFtalk;
import com.find.cn.service.TFindService;
import com.find.cn.util.Dates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.Date;
import java.util.List;

@Service
public class TFindServiceImpl implements TFindService {
    @Autowired
    private TFindDao tFindDao;

    @Override
    /**
     * 查询咨询
     * @param user_id
     * @return
     */
    public List<TFind> getAllInfo(Integer user_id) {
        return tFindDao.getAllInfo(user_id);
    }

    @Override
    public List<TFind> getOneInfo(Integer find_id) {
        return tFindDao.getOneInfo(find_id);
    }

    @Override
    public List<TFtalk> getAllTalk(Integer findid) {

        return tFindDao.getAllTalk(findid);
    }

    @Override
    public String addTalkByUser(TFtalk tFtalk) {
        String info = null;
        if(tFtalk.getUserid() != null && tFtalk.getFindid() != null && tFtalk.getTalkinfo() != null){
            tFtalk.setCreatetime(Dates.dates());
            tFtalk.setTalkinfo(tFtalk.getTalkinfo());
            if(tFindDao.addTalkByUser(tFtalk) == 0){
                info="评论发布失败";
            }else {
                info="评论发布成功";
            }
        }else {
            info="未填写完毕，发布失败";
        }
        return info;
       /* String info = null;
        Jedis jedis = new Jedis("148.70.68.230",6379);
        Integer userid = Integer.valueOf(jedis.get("userid"));
        tTalk.setUser_id(userid);
        if(tTalk.getAnswer_id()!= null && tTalk.getUser_id() != null &&  tTalk.getTalk_info()!= null){
            tTalk.setCreatetime(Dates.dates());//获取当前时间
            tTalk.setTalk_info(tTalk.getTalk_info());
            if(tTalkDao.addTalkByUser(tTalk) == 0){
                info ="评论发布失败";
            }else {
                info = "评论发布成功";
            }
        }else {
            info = "评论信息为空,未发布成功";
        }
        return info;*/
    }

    @Override
    public String addReplyInfo(TFtalk tFtalk) {
        String info = null;
        if(tFtalk.getReplyuserid()!= null && tFtalk.getUserid() != null && tFtalk.getFindid() != null && tFtalk.getTalkinfo() != null){
            tFtalk.setCreatetime(Dates.dates());
            tFtalk.setTalkinfo(tFtalk.getTalkinfo());
            if(tFindDao.addReplyInfo(tFtalk) ==0){
                info="回复发布失败";
            }else {
                info="回复发布成功";
            }
        }else {
            info="未填写完毕，发布失败";
        }
        return info;
    }


}
