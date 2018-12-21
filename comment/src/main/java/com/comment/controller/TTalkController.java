package com.comment.controller;


import com.alibaba.fastjson.JSON;


import com.comment.pojo.TReplytalk;
import com.comment.pojo.TTalk;
import com.comment.service.TTalkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cs")
public class TTalkController {
    @Autowired
   private TTalkService tTalkService;

    /**
     * 通过商品ID查询评论
     * @param answer_id
     * @return
     */
    @GetMapping("/showpl")
    public String ds(Integer answer_id){

        return JSON.toJSONString(tTalkService.getAllInfoByShowid(answer_id));
    }

    /**
     * 通过用户ID查询该用户的评论信息
     * @param user_id
     * @return
     */
    @GetMapping("/hpinfo")
    public String pds(Integer user_id){

        return JSON.toJSONString(tTalkService.getTTalkInfoByUser(user_id));
    }

    /**
     * 通过用户ID查询评论数量
     * @param user_id
     * @return
     */
    @GetMapping("/pls")
    public int pl(Integer user_id){
        int i = tTalkService.selTalkNum(user_id);
        return i;
    }

    /**
     * 通过用户ID与上商品ID查询点赞数
     * @param user_id
     * @param answer_id
     * @return
     */
    @GetMapping("/dz")
    public int  dz(Integer user_id,Integer answer_id){
        int i = tTalkService.selDzByUserAndShow(user_id, answer_id);
        return i;
    }

    /**
     * 发布一条评论
     * @param talk
     * @return
     */
    @ResponseBody
    @RequestMapping("/insert")
    public String addTalk( TTalk talk){
        return tTalkService.addTalkByUser(talk);
    }


    /**
     * 修改评论信息
     * @param tTalk
     * @return
     */
    @RequestMapping("/update")
    public int up(TTalk tTalk){
        return tTalkService.updateTalkInfo(tTalk);
    }

}
