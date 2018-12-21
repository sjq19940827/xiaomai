package com.order.controller;

import com.order.pojo.OrderPay;
import com.order.service.OrderPayService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (OrderPay)表控制层
 *
 * @author makejava
 * @since 2018-12-20 19:59:55
 */
@RestController
@RequestMapping("orderPay")
@Api(value="orderPay",description="订单明细接口测试")
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
    @ApiOperation(value = "根据明细ID查询订单明细信息", httpMethod ="GET", response = String.class, notes ="根据明细ID查询订单明细信息")
    public OrderPay selectOne(Integer id) {
        return this.orderPayService.queryById(id);
    }

}