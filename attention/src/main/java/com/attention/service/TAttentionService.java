package com.attention.service;

import com.attention.pojo.TAttention;

import java.time.Year;
import java.util.List;

/**
 * (TAttention)表服务接口
 *
 * @author makejava
 * @since 2019-01-04 10:56:25
 */
public interface TAttentionService {

    /**
     * 通过ID查询单条数据
     *
     * @param attuser 主键
     * @return 实例对象
     */
    TAttention queryById(Integer attuser);

    /**
     * 查询多条数据
     *
     * @return 对象列表
     */
    List<TAttention> queryAllBygoodsid(Integer goodsID);

    /**
     * 新增数据
     *
     * @param attshow 演出ID
     * @return 影响行数
     */
    String insert(int attshow);

    /**
     * 修改数据
     *
     * @param tAttention 实例对象
     * @return 实例对象
     */
    TAttention update(TAttention tAttention);

    /**
     * 通过主键删除数据
     *
     * @param attid 主键
     * @return 是否成功
     */
    String deleteById(Integer attid);

}