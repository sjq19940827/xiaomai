package com.order.service.impl;

import com.alibaba.fastjson.JSON;
import com.order.dao.OrderPayDao;
import com.order.pay.Pay;
import com.order.pay.Return_url;
import com.order.pojo.OrderPay;
import com.order.service.OrderPayService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

import static com.order.util.DateGenerate.getStringDate;

/**
 * (OrderPay)表服务实现类
 *
 * @author makejava
 * @since 2018-12-20 19:59:55
 */
@Service("orderPayService")
public class OrderPayServiceImpl implements OrderPayService {
    @Resource
    private OrderPayDao orderPayDao;

    /**
     * 通过ID查询单条数据
     *
     * @param payid 主键
     * @return 实例对象
     */
    @Override
    public OrderPay queryById(Integer payid) {
        return this.orderPayDao.queryById(payid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<OrderPay> queryAllByLimit(int offset, int limit) {
        return this.orderPayDao.queryAllByLimit(offset, limit);
    }

    /**
     * 创建订单交易数据
     *
     * @param orderPay 实例对象
     * @return 实例对象
     */
    @Override
    public int insertByOrderPayInfo(OrderPay orderPay) {
        int insert = orderPayDao.insert(orderPay);
        if(insert != 0){
            return 1;
        }
        return 0;
    }

    /**
     * 修改数据
     *
     * @param orderPay 实例对象
     * @return 实例对象
     */
    @Override
    public OrderPay update(OrderPay orderPay) {
        this.orderPayDao.update(orderPay);
        return this.queryById(orderPay.getPayid());
    }

    /**
     * 通过主键删除数据
     *
     * @param payid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer payid) {
        return this.orderPayDao.deleteById(payid) > 0;
    }
}