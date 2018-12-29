package com.order.dao;

import com.order.pojo.OrderPay;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (OrderPay)表数据库访问层
 *
 * @author makejava
 * @since 2018-12-27 17:34:30
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

    /**
     * 查询订单编号是否存在
     * @param paynumber
     * @return
     */
    Integer selectPayNumber(String paynumber);

    /**
     * 根据订单编号获取订单交易明细表里的ID
     * @param paynumber
     * @return
     */
    Integer selectPayNumberByPayID(String paynumber);

    /**
     *
     * @param price  退款金额
     * @param cause  退款原因
     * @param refundtime  退款时间
     * @param ID    订单明细ID
     * @return
     */
    Integer updateRefund(String price, String cause,String refundtime,Integer ID);

    /**
     * 根据订单编号获取订单交易明细表里的交易号
     * @param paynumber
     * @return
     */
    String selectPayNumberByPayalipay(String paynumber);
}