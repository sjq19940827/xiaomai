package com.order.controller;

import com.order.entity.OrderPay;
import com.order.service.OrderPayService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (OrderPay)表控制层
 *
 * @author makejava
 * @since 2018-12-20 19:15:02
 */
@RestController
@RequestMapping("orderPay")
public class OrderPayController {
    /**
     * 服务对象
     */
    @Resource
    private OrderPayService orderPayService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public OrderPay selectOne(Integer id) {
        return this.orderPayService.queryById(id);
    }

}