package com.order.RabbitMQ;

import com.order.config.DelayRabbitConfig;
import com.order.dao.TOrderDao;
import com.order.pojo.TOrder;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;

@Component
@Slf4j
public class DelayReceiver {
    @Resource
    private TOrderDao tOrderDao;

    @RabbitListener(queues = {DelayRabbitConfig.ORDER_QUEUE_NAME})
    public void orderDelayQueue(byte[] bytes, Message message, Channel channel) throws Exception {
        System.out.println("###########################################");
        TOrder order = (TOrder) getObjectFromBytes(bytes);
//    log.info("【orderDelayQueue 监听的消息】 - 【消费时间】 - [{}]- 【订单内容】 - [{}]",  new Date(), order.toString());
        int orderNumber = tOrderDao.selectByOrderNumber(order.getOrderNumber());
        if(orderNumber == 1) {
            tOrderDao.updateByOrderState(order.getOrderNumber());
            System.out.println("【该订单未支付，取消订单】");
        }
    }
    //字节码转化为对象
    public  Object getObjectFromBytes(byte[] objBytes) throws Exception {
        if (objBytes == null || objBytes.length == 0) {
            return null;
        }
        ByteArrayInputStream bi = new ByteArrayInputStream(objBytes);
        ObjectInputStream oi = new ObjectInputStream(bi);
        return oi.readObject();
    }
}
