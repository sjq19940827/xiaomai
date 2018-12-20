package com.discount.controller;

import com.discount.service.ReduceService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("reduce/")
public class ReduceController {
    @Autowired
    private ReduceService reduceService;


    @ResponseBody
    @RequestMapping(value = "all",method = RequestMethod.POST)
    @ApiOperation(value = "优惠券",notes = "查询数据库",response = String.class)
    @ApiImplicitParam(paramType = "query",required = false,name = "reduceid",value = "优惠券")
    public String all(@RequestParam("reduceid") Integer reduceid){
        /* String tReduces = reduceService.ReduceInfo(reduceid);*/
        return reduceService.ReduceInfo(reduceid);
    }
}
