package com.comment.service.serviceImpl;



import com.comment.dao.TTalkDao;
import com.comment.pojo.TTalk;
import com.comment.service.TTalkService;
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
    public List<TTalk> getAllInfoByShowid(int answer_id) {

        return tTalkDao.getAllTalk(answer_id);
    }

    /**
     * 根据用户ID查询该用户参与过的评论
     * @param user_id
     * @return
     */
    @Override
    public List<TTalk> getTTalkInfoByUser(int user_id) {
        return tTalkDao.getTTalkInfoByUser(user_id);
    }

}
