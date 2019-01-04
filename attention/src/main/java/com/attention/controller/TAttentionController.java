package com.attention.controller;

import com.alibaba.fastjson.JSON;
import com.attention.pojo.TAttention;
import com.attention.service.TAttentionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
    @Resource
    private TAttentionService tAttentionService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public String selectOne(Integer id) {
        TAttention tAttention = this.tAttentionService.queryById(id);
        return JSON.toJSONString(tAttention);
    }

    @RequestMapping(value = "insert",method = RequestMethod.POST)
    @ApiOperation(value = "关注",notes = "相应结果")
    public String guanzhu(@RequestParam("attshow")int attshow){
        String insert = tAttentionService.insert(attshow);
        return insert;
    }

    @GetMapping("getall")
    @ApiOperation(value = "分页显示全部关注信息",httpMethod = "GET",notes = "关注json数组")
    public String getall(@RequestParam("pagenum")int pagenum , @RequestParam("pagesize") int pagesize){
        List<TAttention> s = tAttentionService.queryAllByLimit(pagenum, pagesize);
        return JSON.toJSONString(s);
    }

    @GetMapping("del")
    @ApiOperation(value = "取消关注",notes = "相应结果")
    public String del(@ApiParam(required = true, name ="", value ="attid") @RequestParam("attid") Integer attid){
        String s = tAttentionService.deleteById(attid);
        return s;
    }

}