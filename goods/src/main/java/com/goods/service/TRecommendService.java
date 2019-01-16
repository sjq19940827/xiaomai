package com.goods.service;

import com.goods.pojo.TRecommend;
import java.util.List;

/**
 * (TRecommend)表服务接口
 *
 * @author makejava
 * @since 2019-01-16 09:10:30
 */
public interface TRecommendService {

    /**
     * 通过ID查询单条数据
     *
     * @param rId 主键
     * @return 实例对象
     */
    TRecommend queryById(Integer rId);

    /**
     * 查询多条数据
     *
     * @return 对象列表
     */
    List<TRecommend> queryAllByLimit(String city);

    /**
     * 新增数据
     *
     * @param tRecommend 实例对象
     * @return 实例对象
     */
    TRecommend insert(TRecommend tRecommend);

    /**
     * 修改数据
     *
     * @param tRecommend 实例对象
     * @return 实例对象
     */
    TRecommend update(TRecommend tRecommend);

    /**
     * 通过主键删除数据
     *
     * @param rId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer rId);

}