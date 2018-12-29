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
        SystemSerialUtil systemSerialUtil = new SystemSerialUtil();
        String orderIdByUUId = systemSerialUtil.getOrderIdByUUId();     //订单编号
        tOrder.setOrderNumber(orderIdByUUId);
        tOrder.setCreatedate(getStringDate());
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
     * 根据用户ID查询订单状态信息
     * @param userId
     * @param status
     * @return
     */
    @Override
    public String selectAllByUserIdANDStatus(Integer userId, Integer status) {
        if(status == 0){
            status = null;
        }
        List<TOrder> tOrders = tOrderDao.selectAllByUserIdANDStatus(userId, status);
        String jsonString = JSON.toJSONString(tOrders);
        return jsonString;
    }

    /**
     * 取消订单（订单状态：已取消）
     * @param orderNumber
     * @return
     */
    @Override
    public String updateByOrderState(String orderNumber) {
        Integer selectByOrderNumber = tOrderDao.selectByOrderNumber(orderNumber);
        if(selectByOrderNumber != null){
            int updateByOrderState = tOrderDao.updateByOrderState(orderNumber);
            if(updateByOrderState != 0){
                return "取消成功";
            }else {
                return "取消失败";
            }
        }else {
            return "该订单不存在，请确认订单！";
        }
    }

    /**
     * 根据订单编号查询订单ID,根据订单ID获取订单信息
     * @param orderNumber
     * @return
     */
    @Override
    public String selectOrderIDByorderNumber(String orderNumber) {
        Integer OrderID = tOrderDao.selectOrderIDByorderNumber(orderNumber);
        if(OrderID != null){
            TOrder order = tOrderDao.queryById(OrderID);
            if(order != null){
                return JSON.toJSONString(order);
            }else {
                return "订单悄悄溜走了~";
            }
        }else {
            return "商品名称出错了哟~";
        }
    }

    /**
     * 根据用户ID查询待支付的订单信息
     * @param userId
     * @return
     */
    @Override
    public String selectUserIDAndStatusByOrderInfo(Integer userId) {
        Integer selectByUserID = tOrderDao.selectByUserID(userId);
        if(selectByUserID != null){
            List<TOrder> tOrders = tOrderDao.selectUserIDAndStatusByOrderInfo(userId);
            String jsonString = JSON.toJSONString(tOrders);
            return jsonString;
        }else {
            return "该用户不存在，请登录！";
        }
    }


}