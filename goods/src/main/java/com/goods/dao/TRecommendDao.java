package com.goods.dao;

import com.goods.pojo.TRecommend;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (TRecommend)表数据库访问层
 *
 * @author makejava
 * @since 2019-01-16 09:10:30
 */
public interface TRecommendDao {

    /**
     * 通过ID查询单条数据
     *
     * @param rId 主键
     * @return 实例对象
     */
    TRecommend queryById(Integer rId);

    /**
     * 查询指定行数据
     *
     * @return 对象列表
     */
    List<TRecommend> queryAllByLimit(@Param("city") String city);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tRecommend 实例对象
     * @return 对象列表
     */
    List<TRecommend> queryAll(TRecommend tRecommend);

    /**
     * 新增数据
     *
     * @param tRecommend 实例对象
     * @return 影响行数
     */
    int insert(TRecommend tRecommend);

    /**
     * 修改数据
     *
     * @param tRecommend 实例对象
     * @return 影响行数
     */
    int update(TRecommend tRecommend);

    /**
     * 通过主键删除数据
     *
     * @param rId 主键
     * @return 影响行数
     */
    int deleteById(Integer rId);

}