package com.goods.service;


import com.goods.pojo.TAttention;
import com.goods.pojo.TShow;
import org.springframework.stereotype.Service;

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
    List<TAttention> queryById(Integer attuser);

    /**
     * 查询多条数据
     *
     * @return 对象列表
     */
    String queryAllBygoodsid();

    String queryOutBygoodsid();

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
    String update(TAttention tAttention);

    /**
     * 通过主键删除数据
     *
     * @param attshow 主键
     * @return 是否成功
     */
    String deleteById(Integer attshow);



}