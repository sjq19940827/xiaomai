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

    @GetMapping("/InfoByAnswer")
    public String ds(Integer answer_id){
        return tTalkService.getAllInfoByShowid(answer_id);
    }


    @GetMapping("/InfoByUser")
    public String pds(Integer user_id){

        return JSON.toJSONString(tTalkService.getTTalkInfoByUser(user_id));
    }


    @GetMapping("/NumByUser")
    public int pl(Integer user_id){
        int i = tTalkService.selTalkNum(user_id);
        return i;
    }
    @GetMapping("/NumByAnswer")
    public String sdv(int answer_id){
        String s = tTalkService.NumByAnswer(answer_id);
        return s;
    }

    @GetMapping("/ByUserAndAnswer")
    public int  dz(  @ApiParam(name = "answer_id",value = "商品ID")Integer answer_id){
        int i = tTalkService.selDzByUserAndShow(answer_id);
        return i;
    }


    @ResponseBody
    @RequestMapping("/publish")
    public String addTalk(TTalk talk){
        System.out.println(talk.getCreatetime());
        return tTalkService.addTalkByUser(talk);
    }



    @RequestMapping("/upInfo")
    public String up(TTalk tTalk){
        return tTalkService.updateTalkInfo(tTalk);
    }


    @GetMapping("/selNumByUaT")
    public int dz(int talk_id){
        return tTalkService.selNum(talk_id);
    }


    @RequestMapping("/like")
    public String dzf( int talk_id){ return tTalkService.qdz(talk_id);
    }

    @GetMapping("/banner")
    public String dfv(int show_mark,String show_place){
        return JSON.toJSONString(tTalkService.getTalkIsBanner(show_mark,show_place));
    }

}
