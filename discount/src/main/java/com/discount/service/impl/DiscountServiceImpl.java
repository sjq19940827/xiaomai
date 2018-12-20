package com.discount.service.impl;

import com.alibaba.fastjson.JSON;
import com.discount.pojo.TDiscount;
import com.discount.service.DiscountService;
import org.springframework.stereotype.Service;

@Service("DiscountService")
public class DiscountServiceImpl implements DiscountService {

    @Override
    public String updateDiscount(TDiscount tDiscount) {
        tDiscount.setDiscountMark(1);
        tDiscount.setDiscountId(1);
        tDiscount.setReduceId(1);
        tDiscount.setUserId(2);
        return JSON.toJSONString(tDiscount);
    }
}
