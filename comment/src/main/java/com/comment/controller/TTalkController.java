package com.comment.controller;


import com.alibaba.fastjson.JSON;


import com.comment.service.TTalkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cs")
public class TTalkController {
    @Autowired
   private TTalkService tTalkService;

    @ResponseBody
    @GetMapping("/all")
    public String ds(int answer_id){

        return JSON.toJSONString(tTalkService.getAllInfoByShowid(answer_id));
    }

    @GetMapping("/uid")
    public String pds(int user_id){

        return JSON.toJSONString(tTalkService.getTTalkInfoByUser(user_id));
    }


}
