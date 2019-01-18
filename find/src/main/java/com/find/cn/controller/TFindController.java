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
public class TFindController {
    @Autowired
    private TFindService tFindService;
    @GetMapping("/selAll")
    public String ff(int user_id){
        return JSON.toJSONString(tFindService.getAllInfo(user_id));
    }

    /**
     *通过find_id 查询资讯信息
     * @param find_id
     * @return
     */
    @GetMapping("/selOne")
    public String df(int find_id){
        return JSON.toJSONString(tFindService.getOneInfo(find_id));
    }

    /**
     * 通过findid查询用户评论信息
     * @param findid
     * @return
     */
    @GetMapping("/findID")
    public String fd(int findid){
        return JSON.toJSONString(tFindService.getAllTalk(findid));
    }

    /**
     * 发布评论
     * @param tFtalk
     * @return
     */
    @ResponseBody
    @RequestMapping("/insert")
    public String cvxv(TFtalk tFtalk){
        return tFindService.addTalkByUser(tFtalk);
    }

    /**
     * 回复评论
     * @param tFtalk
     * @return
     */
    @ResponseBody
    @RequestMapping("/reply")
    public String cvxdv(TFtalk tFtalk){

        return tFindService.addReplyInfo(tFtalk);
    }

    /**
     * 查状态
     * @param
     * @return
     */
    @GetMapping("/selzt")
   public int czt(int find_id){
       return tFindService.selNum(find_id);
   }

    /**
     * 点赞操作
     * @param find_id
     * @return
     */
    @RequestMapping("/like")
   public String like(int find_id){
       return tFindService.qdz(find_id);
   }

}
