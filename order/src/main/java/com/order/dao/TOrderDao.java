package com.order.dao;

import com.order.pojo.TOrder;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 订单表(TOrder)表数据库访问层
 *
 * @author makejava
 * @since 2018-12-19 14:54:08
 */
public interface TOrderDao {

    /**
     * 通过订单ID查询单条数据
     *
     * @param orderId 主键
     * @return 实例对象
     */
    TOrder queryById(Integer orderId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TOrder> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tOrder 实例对象
     * @return 对象列表
     */
    List<TOrder> queryAll(TOrder tOrder);

    /**
     * 新增数据
     *
     * @param tOrder 实例对象
     * @return 影响行数
     */
    int insert(TOrder tOrder);

    /**
     * 修改数据
     *
     * @param tOrder 实例对象
     * @return 影响行数
     */
    int update(TOrder tOrder);

    /**
     * 通过主键删除数据
     *
     * @param orderId 主键
     * @return 影响行数
     */
    int deleteById(Integer orderId);

    /**
     * 根据用户ID查询全部订单信息
     * @param user_id
     * @return
     */
    List<TOrder> selectAllByUserID(Integer user_id);

    /**
     * 根据用户ID查询订单状态信息
     * @param user_id
     * @param status
     * @return
     */
    List<TOrder> selectAllByUserIdANDStatus(@Param("user_id") Integer user_id, @Param("status") Integer status);


    /**
     * 查询订单编号状态
     * @param orderNumber
     * @return
     */
    int selectByOrderNumberState(String orderNumber);

    /**
     * 取消订单（订单状态已取消）
     * @param orderNumber
     * @return
     */
    int updateByOrderState(String orderNumber);

    /**
     * 订单状态已支付（待出票）
     * @param orderNumber
     * @return
     */
    int updateByOrderStatePay(String orderNumber,String deliverydate);
    /**
     * 查询订单号是否存在
     * @param orderNumber
     * @return
     */
    int selectByOrderNumber(String orderNumber);

    /**
     * 根据商品名称查询商品ID
     * @param orderNumber
     * @return
     */
    Integer selectOrderIDByorderNumber(String orderNumber);

    /**
     * 根据用户ID查询待支付的订单信息
     * @param userId
     * @return
     */
    List<TOrder> selectUserIDAndStatusByOrderInfo(Integer userId);

    /**
     * 查询用户ID是否存在
     * @param userId
     * @return
     */
    Integer selectByUserID(Integer userId);

}