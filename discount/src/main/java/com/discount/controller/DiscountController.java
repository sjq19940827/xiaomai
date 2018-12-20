package com.discount.controller;

import com.discount.pojo.TDiscount;
import com.discount.service.DiscountService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("dis/")
public class DiscountController {
    @Autowired
    private DiscountService discountService;

    @ResponseBody
    @RequestMapping(value = "upadte",method = RequestMethod.POST)
    @ApiOperation(value = "优惠券",notes = "修改优惠券状态",response = String.class)
    @ApiImplicitParam(paramType = "query",required = false,name = "discount",value = "优惠券")
    public String update(TDiscount tDiscount){
        String s = discountService.updateDiscount(tDiscount);
        return s;
    }
}
