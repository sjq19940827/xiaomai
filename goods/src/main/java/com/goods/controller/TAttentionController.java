package com.goods.controller;

import com.alibaba.fastjson.JSON;
import com.goods.pojo.TAttention;
import com.goods.pojo.TShow;
import com.goods.service.TAttentionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TAttention)表控制层
 *
 * @author makejava
 * @since 2019-01-04 10:56:26
 */
@RestController
@RequestMapping("tAttention")
@Api(value = "tattention/",description = "我的关注")
public class TAttentionController {
    /**
     * 服务对象
     */
    @Autowired
    @Qualifier("tAttentionService")
    private TAttentionService tAttentionService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public String selectOne(Integer id) {
        List<TAttention> tAttentions = this.tAttentionService.queryById(id);
        return JSON.toJSONString(tAttentions);
    }

    @RequestMapping(value = "insert",method = RequestMethod.POST)
    @ApiOperation(value = "关注",notes = "相应结果")
    public String guanzhu(@RequestParam("attshow")int attshow){
        String insert = tAttentionService.insert(attshow);
        return insert;
    }

    @GetMapping("getgoods")
    @ApiOperation(value = " 我的关注",notes = "关注商品信息json")
    public String wode(){
        String s = tAttentionService.queryAllBygoodsid();
        return s;
    }

    @GetMapping("outgoods")
    @ApiOperation(value = " 过期关注",notes = "关注商品信息json")
    public String guoqi(){
        String s = tAttentionService.queryOutBygoodsid();
        return s;
    }

    @GetMapping("del")
    @ApiOperation(value = "取消关注",notes = "相应结果")
    public String del(@ApiParam(required = true, name ="商品ID", value ="attshow") Integer attshow){
        String s = tAttentionService.deleteById(attshow);
        return s;
    }
}