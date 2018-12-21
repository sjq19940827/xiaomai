package com.order.service.impl;

import com.alibaba.fastjson.JSON;
import com.order.RabbitMQ.DelaySender;
import com.order.pojo.TOrder;
import com.order.dao.TOrderDao;
import com.order.service.TOrderService;
import com.order.util.DateGenerate;
import com.order.util.SystemSerialUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

import static com.order.util.DateGenerate.getStringDate;

/**
 * 订单表(TOrder)表服务实现类
 *
 * @author makejava
 * @since 2018-12-19 14:54:09
 */
@Service("tOrderService")
public class TOrderServiceImpl implements TOrderService {
    @Resource
    private TOrderDao tOrderDao;
    @Resource
    private DelaySender delaySender;

    /**
     * 通过ID查询单条数据
     *
     * @param orderId 主键
     * @return 实例对象
     */
    @Override
    public String queryById(Integer orderId) {
        TOrder tOrder = tOrderDao.queryById(orderId);
        String jsonString = JSON.toJSONString(tOrder);
        return jsonString;
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public String queryAllByLimit(int offset, int limit) {
        List<TOrder> queryAllByLimit = tOrderDao.queryAllByLimit(offset, limit);
        String jsonString = JSON.toJSONString(queryAllByLimit);
        return jsonString;
    }

    /**
     * 创建订单数据
     * @param tOrder 实例对象
     * @return
     */
    @Override
    public String createByOrderInfo(TOrder tOrder) {
        Timestamp stringDate = Timestamp.valueOf(getStringDate());     //创建时间
        SystemSerialUtil systemSerialUtil = new SystemSerialUtil();
        String orderIdByUUId = systemSerialUtil.getOrderIdByUUId();     //订单编号
        tOrder.setOrderNumber(orderIdByUUId);
        tOrder.setCreatedate(stringDate);
        tOrder.setStatus(1);
        int insert = tOrderDao.insert(tOrder);
        if(insert != 0){
            try {
                delaySender.sendDelay(tOrder);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return JSON.toJSONString(insert);
        }else {
            return "创建失败啦";
        }
    }

    /**
     * 修改数据
     *
     * @param tOrder 实例对象
     * @return 实例对象
     */
    @Override
    public String update(TOrder tOrder) {
        this.tOrderDao.update(tOrder);
        return this.queryById(tOrder.getOrderId());
    }

    /**
     * 通过主键删除数据
     *
     * @param orderId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer orderId) {
        return this.tOrderDao.deleteById(orderId) > 0;
    }

    /**
     * 通过实体作为筛选条件查询
     * @param tOrder
     * @return
     */
    @Override
    public String selectAllByEntity(TOrder tOrder) {
        List<TOrder> tOrders = tOrderDao.queryAll(tOrder);
        String jsonString = JSON.toJSONString(tOrders);
        return jsonString;
    }

    /**
     * 根据用户ID查询全部订单信息
     * @param userId
     * @return
     */
    @Override
    public String selectAllByUserID(Integer userId) {
        List<TOrder> selectAllByUserID = tOrderDao.selectAllByUserID(userId);
        String jsonString = JSON.toJSONString(selectAllByUserID);
        return jsonString;
    }

    /**
     * 根据用户ID查询待支付订单信息
     * @param userId
     * @return
     */
    @Override
    public String unpaidAllByUserID(Integer userId) {
        List<TOrder> unpaidAllByUserID = tOrderDao.unpaidAllByUserID(userId);
        String jsonString = JSON.toJSONString(unpaidAllByUserID);
        return jsonString;
    }

    /**
     * 根据用户ID查询待出票订单信息
     * @param userId
     * @return
     */
    @Override
    public String ticketAllByUserID(Integer userId) {
        List<TOrder> ticketAllByUserID = tOrderDao.ticketAllByUserID(userId);
        String jsonString = JSON.toJSONString(ticketAllByUserID);
        return jsonString;
    }

    /**
     * 根据用户ID查询待收货订单信息
     * @param userId
     * @return
     */
    @Override
    public String receivingAllByUserID(Integer userId) {
        List<TOrder> receivingAllByUserID = tOrderDao.receivingAllByUserID(userId);
        String jsonString = JSON.toJSONString(receivingAllByUserID);
        return jsonString;
    }

    /**
     * 根据用户ID查询已完成订单信息
     * @param userId
     * @return
     */
    @Override
    public String doneAllByUserID(Integer userId) {
        List<TOrder> doneAllByUserID = tOrderDao.doneAllByUserID(userId);
        String jsonString = JSON.toJSONString(doneAllByUserID);
        return jsonString;
    }

    /**
     * 根据用户ID查询已取消订单信息
     * @param userId
     * @return
     */
    @Override
    public String cancAllByUserID(Integer userId) {
        List<TOrder> cancAllByUserID = tOrderDao.cancAllByUserID(userId);
        String jsonString = JSON.toJSONString(cancAllByUserID);
        return jsonString;
    }

    /**
     * 根据用户ID查询已退款订单信息
     * @param userId
     * @return
     */
    @Override
    public String refundedAllByUserID(Integer userId) {
        List<TOrder> refundedAllByUserID = tOrderDao.refundedAllByUserID(userId);
        String jsonString = JSON.toJSONString(refundedAllByUserID);
        return jsonString;
    }


}