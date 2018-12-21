package com.order.dao;

import com.order.pojo.OrderPay;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (OrderPay)表数据库访问层
 *
 * @author makejava
 * @since 2018-12-20 19:59:54
 */
public interface OrderPayDao {

    /**
     * 通过ID查询单条数据
     *
     * @param payid 主键
     * @return 实例对象
     */
    OrderPay queryById(Integer payid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<OrderPay> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param orderPay 实例对象
     * @return 对象列表
     */
    List<OrderPay> queryAll(OrderPay orderPay);

    /**
     * 新增数据
     *
     * @param orderPay 实例对象
     * @return 影响行数
     */
    int insert(OrderPay orderPay);

    /**
     * 修改数据
     *
     * @param orderPay 实例对象
     * @return 影响行数
     */
    int update(OrderPay orderPay);

    /**
     * 通过主键删除数据
     *
     * @param payid 主键
     * @return 影响行数
     */
    int deleteById(Integer payid);

}