package com.find.cn.controller;

import com.alibaba.fastjson.JSON;
import com.find.cn.pojo.TFtalk;
import com.find.cn.service.TFindService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/find")
@Api(value = "查询发现模块资讯信息")
public class TFindController {
    @Autowired
    private TFindService tFindService;
    @ApiOperation(value = "查询某商品下的咨询信息",httpMethod = "GET",response = String.class,notes = "查某商品下的评论信息")
    @ApiImplicitParam(name = "user_id",value = "用户ID")
    @GetMapping("/selAll")
    public String ff(int user_id){
        return JSON.toJSONString(tFindService.getAllInfo(user_id));
    }
    @GetMapping("/selOne")
    public String df(int find_id){
        return JSON.toJSONString(tFindService.getOneInfo(find_id));
    }
    @GetMapping("/findID")
    public String fd(int findid){
        return JSON.toJSONString(tFindService.getAllTalk(findid));
    }
    @ResponseBody
    @RequestMapping("/insert")
    public String cvxv(TFtalk tFtalk){
        return tFindService.addTalkByUser(tFtalk);
    }

    @ResponseBody
    @RequestMapping("/reply")
    public String cvxdv(TFtalk tFtalk){
        return tFindService.addReplyInfo(tFtalk);
    }


}
