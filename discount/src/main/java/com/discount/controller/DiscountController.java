package com.discount.controller;

import com.discount.pojo.TDiscount;
import com.discount.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("dis/")
public class DiscountController {
    @Autowired
    private DiscountService discountService;

    @RequestMapping(value = "update")
    public String update(TDiscount tDiscount){
        String s = discountService.updateDiscount(tDiscount);
        return s;
    }
}
