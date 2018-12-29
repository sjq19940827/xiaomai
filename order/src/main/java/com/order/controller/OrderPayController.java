package com.order.controller;

import com.order.pojo.OrderPay;
import com.order.service.OrderPayService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (OrderPay)表控制层
 *
 * @author makejava
 * @since 2018-12-27 17:34:31
 */
@RestController
@RequestMapping("orderPay")
@Api(value="orderPay",description="订单支付接口测试")
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

    /**
     * 根据订单编号查询支付宝交易号
     * @param orderNumber
     * @return
     */
    @GetMapping("selectorderNumberByPay")
    @ApiOperation(value = "根据订单编号查询支付宝交易号", httpMethod ="GET", response = String.class, notes ="根据订单编号查询支付宝交易号")
    public String selectorderNumberByPay(String orderNumber){
        return orderPayService.selectorderNumberByPay(orderNumber);
    }

}