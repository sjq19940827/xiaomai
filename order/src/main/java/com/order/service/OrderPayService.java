package com.order.service;

import com.order.pojo.OrderPay;

import java.util.List;

/**
 * (OrderPay)表服务接口
 *
 * @author makejava
 * @since 2018-12-27 17:34:30
 */
public interface OrderPayService {

    /**
     * 通过ID查询单条数据
     *
     * @param payid 主键
     * @return 实例对象
     */
    OrderPay queryById(Integer payid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<OrderPay> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param orderPay 实例对象
     * @return 实例对象
     */
    OrderPay insert(OrderPay orderPay);

    /**
     * 修改数据
     *
     * @param orderPay 实例对象
     * @return 实例对象
     */
    OrderPay update(OrderPay orderPay);

    /**
     * 通过主键删除数据
     *
     * @param payid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer payid);

    /**
     * 新增数据
     *
     * @param orderPay 实例对象
     * @return 实例对象
     */
    int insertByOrderPayInfo(OrderPay orderPay);

    /**
     * 根据订单编号查询支付宝交易号
     * @param orderNumber
     * @return
     */
    String selectorderNumberByPay(String orderNumber);
}