package com.comment.service.serviceImpl;

import com.comment.dao.TReplytalkDao;
import com.comment.pojo.TReplytalk;
import com.comment.service.TReplytalkService;
import com.comment.util.Dates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        if(tReplytalk != null){
            tReplytalk.setCreatetime(Dates.dates());
            if(tReplytalkDao.addreply(tReplytalk) == 0){
                info ="评论发布失败";
            }else {
                info = "评论发布成功";
            }
        }else {
            info = "评论信息为空,为发布成功";
        }
        return info;
    }

    /**
     * 查看回复信息
     * @param answer_id
     * @return
     */
    public List<TReplytalk> allInfo(Integer answer_id) {

        return tReplytalkDao.allInfo(answer_id);
    }
}
