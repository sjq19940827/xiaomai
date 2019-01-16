package com.goods.controller;

import com.alibaba.fastjson.JSON;
import com.goods.pojo.TRecommend;
import com.goods.service.TRecommendService;
import com.goods.service.TShowService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TRecommend)表控制层
 *
 * @author makejava
 * @since 2019-01-16 09:10:30
 */
@RestController
@RequestMapping("tRecommend")
public class TRecommendController {
    /**
     * 服务对象
     */
    @Resource
    private TRecommendService tRecommendService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TRecommend selectOne(Integer id) {
        return this.tRecommendService.queryById(id);
    }

    /**
     * 根据商品特殊标识和城市进行查询
     * city 城市
     * @return
     */
    @GetMapping("/getrebycity")
    public String getrecommendbycity(@RequestParam("city")String city) {
        List<TRecommend> tRecommends = tRecommendService.queryAllByLimit(city);
        String s = JSON.toJSONString(tRecommends);
        return s;
    }

}