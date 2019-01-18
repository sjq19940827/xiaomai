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
        Jedis jedis = new Jedis("47.94.12.237 ", 6379);
        Integer userid = Integer.valueOf(jedis.get("userid"));
        tFtalk.setUserid(userid);
        if (tFtalk.getUserid() != null && tFtalk.getFindid() != null && tFtalk.getTalkinfo() != null) {
            tFtalk.setCreatetime(Dates.dates());
            tFtalk.setTalkinfo(tFtalk.getTalkinfo());
            if (tFindDao.addTalkByUser(tFtalk) == 0) {
                info = "评论发布失败";
            } else {
                info = "评论发布成功";
            }
        } else {
            info = "未填写完毕，发布失败";
        }
        return info;

    }

    @Override
    public String addReplyInfo(TFtalk tFtalk) {
        String info = null;
        Jedis jedis = new Jedis("47.94.12.237 ", 6379);
        Integer userid = Integer.valueOf(jedis.get("userid"));
        tFtalk.setUserid(userid);
        if (tFtalk.getReplyuserid() != null && tFtalk.getUserid() != null && tFtalk.getFindid() != null && tFtalk.getTalkinfo() != null) {

            tFtalk.setCreatetime(Dates.dates());

            tFtalk.setTalkinfo(tFtalk.getTalkinfo());

            if (tFindDao.addReplyInfo(tFtalk) == 0) {

                info = "回复发布失败";

            } else {

                info = "回复发布成功";

            }

        } else {

            info = "未填写完毕，发布失败";

        }

        return info;
    }

    /**
     * 查询数据库该评论状态
     *
     * @param fid
     * @return
     */
    @Override
    public int selNum(Integer fid) {
        return tFindDao.selNum(fid);
    }

    /**
     * 进行点赞操作
     *
     * @param find_id
     * @return
     */
    @Override
    public String qdz(Integer find_id) {
        int i = selNum(find_id);
        if (i == 1) {
            int i1 = tFindDao.upNum1(find_id);
            return "取消点赞";

        } else if (i == 0) {
            int i1 = tFindDao.upNum2(find_id);
        }
        return "点赞成功";
    }
}