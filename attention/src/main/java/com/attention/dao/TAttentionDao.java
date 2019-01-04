package com.attention.dao;

import com.attention.pojo.TAttention;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (TAttention)表数据库访问层
 *
 * @author makejava
 * @since 2019-01-04 10:56:25
 */
public interface TAttentionDao {

    /**
     * 通过ID查询单条数据
     *
     * @param attuser 主键
     * @return 实例对象
     */
    TAttention queryById(Integer attuser);

    /**
     * 查询指定行数据
     *
     * @return 对象列表
     */
    List<TAttention> queryAllByLimit();


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tAttention 实例对象
     * @return 对象列表
     */
    List<TAttention> queryAll(TAttention tAttention);

    /**
     * 新增数据
     *
     * @param attuser 用户ID
     * @param attshow 演出ID
     * @return 影响行数
     */
    int insert(@Param("attuser") int attuser, @Param("attshow") int attshow);

    /**
     * 修改数据
     *
     * @param tAttention 实例对象
     * @return 影响行数
     */
    int update(TAttention tAttention);

    /**
     * 通过主键删除数据
     *
     * @param attid 主键
     * @return 影响行数
     */
    int deleteById(Integer attid);

}