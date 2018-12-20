package com.order.service;

import com.order.pojo.TOrder;

/**
 * 订单表(TOrder)表服务接口
 *
 * @author makejava
 * @since 2018-12-19 14:54:09
 */
public interface TOrderService {

    /**
     * 通过ID查询单条数据
     *
     * @param orderId 主键
     * @return 实例对象
     */
    String queryById(Integer orderId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    String queryAllByLimit(int offset, int limit);

    /**
     * 新增订单数据
     *
     * @param tOrder 实例对象
     * @return 实例对象
     */
    String createByOrderInfo(TOrder tOrder);

    /**
     * 修改数据
     *
     * @param tOrder 实例对象
     * @return 实例对象
     */
    String update(TOrder tOrder);

    /**
     * 通过主键删除数据
     *
     * @param orderId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer orderId);

    /**
     * 通过实体作为筛选条件查询
     * @param tOrder
     * @return
     */
    String selectAllByEntity(TOrder tOrder);

    /**
     * 根据用户ID查询全部订单信息
     * @param userId
     * @return
     */
    String selectAllByUserID(Integer userId);

    /**
     * 根据用户ID查询待支付订单信息
     * @param userId
     * @return
     */
    String unpaidAllByUserID(Integer userId);

    /**
     * 根据用户ID查询待出票订单信息
     * @param userId
     * @return
     */
    String ticketAllByUserID(Integer userId);

    /**
     * 根据用户ID查询待收货订单信息
     * @param userId
     * @return
     */
    String receivingAllByUserID(Integer userId);

    /**
     * 根据用户ID查询已完成订单信息
     * @param userId
     * @return
     */
    String doneAllByUserID(Integer userId);

    /**
     * 根据用户ID查询已取消订单信息
     * @param userId
     * @return
     */
    String cancAllByUserID(Integer userId);

    /**
     * 根据用户ID查询已退款订单信息
     * @param userId
     * @return
     */
    String refundedAllByUserID(Integer userId);
}