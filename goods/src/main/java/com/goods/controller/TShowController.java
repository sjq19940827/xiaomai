package com.goods.controller;


import com.alibaba.fastjson.JSON;
import com.goods.service.impl.TShowServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
public class TShowController {
    @Autowired
    @Qualifier("gsi")
    private TShowServiceImpl TShowService;
    /**
     * 查询全部
     * @return
     */
    @GetMapping("/getAll")
    public String getAll(int index,int pagesize){

        return TShowService.getAll (index, pagesize);
    }
    /**
     * 查询全部分类信息
     * @return
     */
    @GetMapping("/getAlll")
    public String getAlll(int index,int pagesize){
       
        return TShowService.getAlll(index, pagesize);
    }
    /**
     * 根据商品分类展示商品信息
     * @return
     */
    @GetMapping("/getInfoByType")
    public String getInfoByType(Integer categorie_id,int index,int pagesize) {
        return JSON.toJSONString (TShowService.getInfoByType (categorie_id, index, pagesize));
    }
}
