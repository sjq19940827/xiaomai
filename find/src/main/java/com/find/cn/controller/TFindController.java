package com.find.cn.controller;

import com.alibaba.fastjson.JSON;
import com.find.cn.service.TFindService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/find")
@Api(value = "查询发现模块资讯信息")
public class TFindController {
    @Autowired
    private TFindService tFindService;
    @ApiOperation(value = "查询某商品下的咨询信息",httpMethod = "GET",response = String.class,notes = "查某商品下的评论信息")
    @ApiImplicitParam(name = "show_id",value = "商品ID")
    @GetMapping("/selAll")
    public String ff(int show_id){
        return JSON.toJSONString(tFindService.getAllInfo(show_id));
    }
}
