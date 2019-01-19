package com.comment.controller;


import com.alibaba.fastjson.JSON;


import com.comment.pojo.TTalk;
import com.comment.service.TTalkService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
public class TTalkController {
    @Autowired
   private TTalkService tTalkService;

    /**
     * 根据商品ID查评论
     * @param answer_id
     * @return
     */
    @GetMapping("/InfoByAnswer")
    public String ds(Integer answer_id){
        return tTalkService.getAllInfoByShowid(answer_id);
    }


    /**
     * 查用户的评论信息
     * @param user_id
     * @return
     */
    @GetMapping("/InfoByUser")
    public String pds(Integer user_id){

        return JSON.toJSONString(tTalkService.getTTalkInfoByUser(user_id));
    }


    /**
     * 查询用户的评论次数
     * @param user_id
     * @return
     */
    @GetMapping("/NumByUser")
    public int pl(Integer user_id){
        int i = tTalkService.selTalkNum(user_id);
        return i;
    }

    /**
     * 查询商品是否有评论
     * @param answer_id
     * @return
     */
    @GetMapping("/NumByAnswer")
    public String sdv(int answer_id){
        String s = tTalkService.NumByAnswer(answer_id);
        return s;
    }

    /**
     * 商品点赞数
     * @param answer_id
     * @return
     */
    @GetMapping("/ByUserAndAnswer")
    public int  dz( Integer answer_id){
        int i = tTalkService.selDzByUserAndShow(answer_id);
        return i;
    }


    /**
     * 发布评论
     * @param talk
     * @return
     */
    @ResponseBody
    @RequestMapping("/publish")
    public String addTalk(TTalk talk){
        System.out.println(talk.getGrade());
        return tTalkService.addTalkByUser(talk);
    }


    /**
     * 修改评论
     * @param tTalk
     * @return
     */
    @RequestMapping("/upInfo")
    public String up(TTalk tTalk){
        return tTalkService.updateTalkInfo(tTalk);
    }


    /**
     * 数据库点赞状态
     * @param talk_id
     * @return
     */
    @GetMapping("/selNumByUaT")
    public int dz(int talk_id){
        return tTalkService.selNum(talk_id);
    }


    /**
     * 点赞
     * @param talk_id
     * @return
     */
    @RequestMapping("/like")
    public String dzf( int talk_id){ return tTalkService.qdz(talk_id);
    }

    /**
     * 评论轮播
     * @param show_mark
     * @param show_place
     * @return
     */
    @GetMapping("/banner")
    public String dfv(int show_mark,String show_place){
        return JSON.toJSONString(tTalkService.getTalkIsBanner(show_mark,show_place));
    }

    @GetMapping("/avg")
    public double pjf(int answer_id){
        return tTalkService.resultByAnswer(answer_id);
    }

}
