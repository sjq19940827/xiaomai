package com.order.controller;

import com.alibaba.fastjson.JSON;
import com.order.pojo.TOrder;
import com.order.service.TOrderService;
import com.order.util.DateGenerate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

import static com.order.util.DateGenerate.getStringDate;

/**
 * 订单表(TOrder)表控制层
 *
 * @author makejava
 * @since 2018-12-19 14:54:10
 */
@RestController
@RequestMapping("tOrder")
@Api(value="order",description="订单接口测试")
public class TOrderController {
    /**
     * 服务对象
     */
    @Resource
    private TOrderService tOrderService;

    /**
     * 通过主键查询单条数据
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOneByID")
    @ApiOperation(value = "根据ID查询订单", httpMethod ="GET", response = String.class, notes ="根据ID查询订单")
    public String selectOne(Integer id) {
        return tOrderService.queryById(id);
    }

    /**
     * 分页查询全部
     * @param offset
     * @param limit
     * @return
     */
    @GetMapping("selectAllByLimit")
    @ApiOperation(value = "分页查询", httpMethod ="GET", response = String.class, notes ="分页查询")
    public String selectAll(int offset, int limit){
        return tOrderService.queryAllByLimit(offset, limit);
    }

    /**
     * 通过实体作为筛选条件查询
     * @param tOrder
     * @return
     */
    @GetMapping("selectAllByEntity")
    @ApiOperation(value = "通过实体作为筛选条件查询", httpMethod ="GET", response = String.class, notes ="通过实体作为筛选条件查询")
    public String selectAllByEntity(TOrder tOrder){
        return tOrderService.selectAllByEntity(tOrder);
    }

    /**
     * 根据用户ID查询全部订单信息
     * @param userId
     * @return
     */
    @GetMapping("selectAllByUserID")
    @ApiOperation(value = "根据用户ID查询全部订单信息", httpMethod ="GET", response = String.class, notes ="根据用户ID查询全部订单信息")
    public String selectAllByUserID(Integer userId){
        String selectAllByUserID = tOrderService.selectAllByUserID(userId);
        return selectAllByUserID;
    }

    /**
     * 创建订单数据
     * @param tOrder
     * @return
     */
    @PostMapping("createByOrderInfo")
    @ApiOperation(value = "创建订单数据", httpMethod ="POST", response = String.class, notes ="创建订单数据")
    public String createByOrderInfo(TOrder tOrder){
        String byOrderInfo = tOrderService.createByOrderInfo(tOrder);
        return byOrderInfo;
    }

    /**
     * 根据用户ID查询订单状态信息
     * @param userid
     * @param status
     * @return
     */
    @GetMapping("selectAllByUserIdANDStatus")
    @ApiOperation(value = "根据用户ID查询订单状态信息", httpMethod ="GET", response = String.class, notes ="根据用户ID查询订单状态信息")
    public String selectAllByUserIdANDStatus(Integer userid,Integer status){
        return tOrderService.selectAllByUserIdANDStatus(userid, status);
    }

    /**
     * 取消订单（订单状态：已取消）
     * @param orderNumber
     * @return
     */
    @GetMapping("updateByOrderState")
    @ApiOperation(value = "取消订单（订单状态：已取消）", httpMethod ="GET", response = String.class, notes ="取消订单（订单状态：已取消）")
    public String updateByOrderState(String orderNumber){
        return tOrderService.updateByOrderState(orderNumber);
    }

    /**
     * 根据订单编号查询订单ID,根据订单ID获取订单信息
     * @param orderNumber
     * @return
     */
    @GetMapping("selectOrderIDByorderNumber")
    @ApiOperation(value = "根据订单编号查询订单ID,根据订单ID获取订单信息", httpMethod ="GET", response = String.class, notes ="根据订单编号查询订单ID,根据订单ID获取订单信息")
    public String selectOrderIDByorderNumber(String orderNumber){
        return tOrderService.selectOrderIDByorderNumber(orderNumber);
    }

    /**
     * 根据用户ID查询待支付的订单信息
     * @param userId
     * @return
     */
    @GetMapping("selectUserIDAndStatusByOrderInfo")
    @ApiOperation(value = "根据用户ID查询待支付的订单信息", httpMethod ="GET", response = String.class, notes ="根据用户ID查询待支付的订单信息")
    public String selectUserIDAndStatusByOrderInfo(Integer userId){
        return tOrderService.selectUserIDAndStatusByOrderInfo(userId);
    }
}