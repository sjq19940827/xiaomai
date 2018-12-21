package com.order.RabbitMQ;

import com.order.config.DelayRabbitConfig;
import com.order.pojo.TOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

@Component
@Slf4j
public class DelaySender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendDelay(TOrder order) throws Exception {
        byte[] bytes = getBytesFromObject(order);
        this.amqpTemplate.convertAndSend(DelayRabbitConfig.ORDER_DELAY_EXCHANGE, DelayRabbitConfig.ORDER_DELAY_ROUTING_KEY, bytes, message -> {
            // 如果配置了 params.put("x-message-ttl", 15 * 1000 * 60); 那么这一句也可以省略,具体根据业务需要是声明 Queue 的时候就指定好延迟时间还是在发送自己控制时间
            message.getMessageProperties().setExpiration(15 * 1000 * 60 + "");
            return message;
        });
    }
    //对象转化为字节码
        public  byte[] getBytesFromObject(Serializable obj) throws Exception {
            if (obj == null) {
                return null;
            }
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            ObjectOutputStream oo = new ObjectOutputStream(bo);
            oo.writeObject(obj);
            return bo.toByteArray();
        }

}
