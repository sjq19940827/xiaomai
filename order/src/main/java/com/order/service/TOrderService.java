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
     * 根据用户ID查询订单状态信息
     * @param userId
     * @param status
     * @return
     */
    String selectAllByUserIdANDStatus(Integer userId,Integer status);

    /**
     * 取消订单（订单状态：已取消）
     * @param orderNumber
     * @return
     */
    String updateByOrderState(String orderNumber);

    /**
     * 根据订单编号查询订单ID,根据订单ID获取订单信息
     */
    String selectOrderIDByorderNumber(String orderNumber);

    /**
     * 根据用户ID查询待支付的订单信息
     * @param userId
     * @return
     */
    String selectUserIDAndStatusByOrderInfo(Integer userId);

}