package com.discount.controller;

import com.discount.pojo.TReduce;
import com.discount.service.DiscountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("dis/")
@Api(value = "dis",description = "优惠劵")
public class DiscountController {
    @Autowired
    private DiscountService discountService;
    @ResponseBody
    @RequestMapping(value = "insert")
    @ApiOperation(value = "用户获取优惠券",notes = "查询数据库",response = String.class,httpMethod = "POST")
    public String insert(Integer user_id,Integer reduce_id){
        /*Jedis jedis = new Jedis("148.70.68.230",6379);
        Integer user_id = Integer.valueOf(jedis.get("userid"));
        System.out.println(jedis.get("userid"));
        */
        int insets = discountService.insets(user_id);
        if (insets > 0){
            TReduce select = discountService.select(reduce_id);
            if (select != null){
                int subs = select.getSub();
                int updates = discountService.updates(subs,reduce_id);
                if (updates == 1){
                    return "优惠券获取成功";
                }
            }
        }
        return "获取优惠劵失败";
    }

    @ResponseBody
    @RequestMapping(value = "select")
    @ApiOperation(value = "查询用户优惠券详细信息",notes = "查询数据库",response = String.class,httpMethod = "POST")
    @ApiImplicitParam(paramType = "query",required = false,name = "user_id",value = "用户id")
    public String select(@RequestParam("user_id")Integer user_id){
        String all = discountService.all(user_id);
        if (all != null){
            return all;

        }
        return "查询失败";
    }

    @ResponseBody
    @RequestMapping(value = "upate")
    @ApiOperation(value = "修改优惠券状态",notes = "查询数据库",response = String.class,httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",required = false,name = "user_id",value = "用户id"),
            @ApiImplicitParam(paramType = "query",required = false,name = "reduce_id",value = "优惠劵id")
    })
    public String update(@RequestParam("user_id")Integer user_id,@RequestParam("reduce_id") Integer reduce_id){
        int i = discountService.updateDiscount(user_id, reduce_id);
        if (i > 0){
            return "修改状态完成";
        }
        return "修改状态失败";
    }

   /* @ResponseBody
    @RequestMapping(value = "xg")
    @ApiOperation(value = "设置用户优惠劵时间",notes = "查询数据库",response = String.class,httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",required = false,name = "userid",value = "用户id"),
            @ApiImplicitParam(paramType = "query",required = false,name = "reduceid",value = "优惠劵id")
    })
    public String xg(@RequestParam("reduceid") Integer reduceid,@RequestParam("userid") Integer userid){
        int xgs = discountService.xgs(reduceid,userid);
        if (xgs > 0){
            return "你的优惠劵已获取成功，可到你的优惠劵中查看";
        }
        return  null;

    }*/
}


