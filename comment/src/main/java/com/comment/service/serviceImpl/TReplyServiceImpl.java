package com.comment.service.serviceImpl;

import com.comment.dao.TReplytalkDao;
import com.comment.pojo.TReplytalk;
import com.comment.service.TReplytalkService;
import com.comment.util.Dates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.List;

@Service
public class TReplyServiceImpl implements TReplytalkService {
    @Autowired
    private TReplytalkDao tReplytalkDao;
    @Override
    /**登录状态下
     * 回复一条评论
     */
    public String addreply(TReplytalk tReplytalk) {
        String info = null;
       Jedis jedis = new Jedis("47.94.12.237 ",6379);
        Integer userid = Integer.valueOf(jedis.get("userid"));
        tReplytalk.setReplyuser_id(userid);
        if(tReplytalk.getTalk_id() != null && tReplytalk.getReply_info() != null && tReplytalk.getReplyuser_id() != null){
            tReplytalk.setCreatetime(Dates.dates());
            if(tReplytalkDao.addreply(tReplytalk) == 0){
                info ="评论发布失败";
            }else {
                info = "评论发布成功";
            }
        }else {
            info = "评论信息为空,未发布成功";
        }
        return info;
    }

    /**
     * 查看回复信息
     * @param replyuser_id
     * @return
     */
    public List<TReplytalk> allInfo(Integer replyuser_id) {

        return tReplytalkDao.allInfo(replyuser_id);
    }
}
