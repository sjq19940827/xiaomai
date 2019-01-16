package com.goods.service.impl;

import com.github.pagehelper.PageHelper;
import com.goods.pojo.TRecommend;
import com.goods.dao.TRecommendDao;
import com.goods.service.TRecommendService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TRecommend)表服务实现类
 *
 * @author makejava
 * @since 2019-01-16 09:10:30
 */
@Service("tRecommendService")
public class TRecommendServiceImpl implements TRecommendService {
    @Resource
    private TRecommendDao tRecommendDao;

    /**
     * 通过ID查询单条数据
     *
     * @param rId 主键
     * @return 实例对象
     */
    @Override
    public TRecommend queryById(Integer rId) {
        return this.tRecommendDao.queryById(rId);
    }

    /**
     * 查询多条数据
     *
     * @return 对象列表
     */
    @Override
    public List<TRecommend> queryAllByLimit(String city) {
        PageHelper.startPage(1,3);
        List<TRecommend> tRecommends = this.tRecommendDao.queryAllByLimit(city);
        return tRecommends;
    }

    /**
     * 新增数据
     *
     * @param tRecommend 实例对象
     * @return 实例对象
     */
    @Override
    public TRecommend insert(TRecommend tRecommend) {
        this.tRecommendDao.insert(tRecommend);
        return tRecommend;
    }

    /**
     * 修改数据
     *
     * @param tRecommend 实例对象
     * @return 实例对象
     */
    @Override
    public TRecommend update(TRecommend tRecommend) {
        this.tRecommendDao.update(tRecommend);
        return this.queryById(tRecommend.getRId());
    }

    /**
     * 通过主键删除数据
     *
     * @param rId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer rId) {
        return this.tRecommendDao.deleteById(rId) > 0;
    }
}