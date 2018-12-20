package com.order.controller;

import com.order.service.TOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("OrderState")
@Api(value="OrderState",description="订单状态接口测试")
public class OrderStateController {
    /**
     * 服务对象
     */
    @Resource
    private TOrderService tOrderService;

    /**
     * 根据用户ID查询待支付订单信息
     * @param userID
     * @return
     */
    @GetMapping("unpaidAllByUserID")
    @ApiOperation(value = "根据用户ID查询待支付订单信息", httpMethod ="GET", response = String.class, notes ="根据用户ID查询待支付订单信息")
    public String unpaidAllByUserID(Integer userID){
        return tOrderService.unpaidAllByUserID(userID);
    }

    /**
     * 根据用户ID查询待出票订单信息
     * @param userID
     * @return
     */
    @GetMapping("ticketAllByUserID")
    @ApiOperation(value = "根据用户ID查询待出票订单信息", httpMethod ="GET", response = String.class, notes ="根据用户ID查询待出票订单信息")
    public String ticketAllByUserID(Integer userID){
        return tOrderService.ticketAllByUserID(userID);
    }

    /**
     * 根据用户ID查询待收货订单信息
     * @param userID
     * @return
     */
    @GetMapping("receivingAllByUserID")
    @ApiOperation(value = "根据用户ID查询待收货订单信息", httpMethod ="GET", response = String.class, notes ="根据用户ID查询待收货订单信息")
    public String receivingAllByUserID(Integer userID){
        return tOrderService.receivingAllByUserID(userID);
    }

    /**
     * 根据用户ID查询已完成订单信息
     * @param userID
     * @return
     */
    @GetMapping("doneAllByUserID")
    @ApiOperation(value = "根据用户ID查询已完成订单信息", httpMethod ="GET", response = String.class, notes ="根据用户ID查询已完成订单信息")
    public String doneAllByUserID(Integer userID){
        return tOrderService.doneAllByUserID(userID);
    }

    /**
     * 根据用户ID查询已取消订单信息
     * @param userID
     * @return
     */
    @GetMapping("cancAllByUserID")
    @ApiOperation(value = "根据用户ID查询已取消订单信息", httpMethod ="GET", response = String.class, notes ="根据用户ID查询已取消订单信息")
    public String cancAllByUserID(Integer userID){
        return tOrderService.cancAllByUserID(userID);
    }

    /**
     * 根据用户ID查询已退款订单信息
     * @param userID
     * @return
     */
    @GetMapping("refundedAllByUserID")
    @ApiOperation(value = "根据用户ID查询已退款订单信息", httpMethod ="GET", response = String.class, notes ="根据用户ID查询已退款订单信息")
    public String refundedAllByUserID(Integer userID){
        return tOrderService.refundedAllByUserID(userID);
    }

}
