package com.find.cn.service.serviceImpl;

import com.comment.dao.TTalkDao;
import com.find.cn.dao.TFindDao;
import com.find.cn.pojo.TFind;
import com.find.cn.service.TFindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


}
