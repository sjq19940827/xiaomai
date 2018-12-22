package com.find.cn.controller;

import com.alibaba.fastjson.JSON;
import com.find.cn.service.TFindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/find")
public class TFindController {
    @Autowired
    private TFindService tFindService;

    @GetMapping("/cs")
    public String ff(int show_id){

        return JSON.toJSONString(tFindService.getAllInfo(show_id));
    }
}
