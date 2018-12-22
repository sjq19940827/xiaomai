package com.find.cn.service.serviceImpl;

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
    public List<TFind> getAllInfo(Integer show_id) {
        return tFindDao.getAllInfo(show_id);
    }
}
