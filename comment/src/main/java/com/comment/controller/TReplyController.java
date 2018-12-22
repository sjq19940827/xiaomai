package com.comment.controller;

import com.alibaba.fastjson.JSON;
import com.comment.pojo.TReplytalk;
import com.comment.service.TReplytalkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hf")
public class TReplyController {

  @Autowired
  private TReplytalkService tReplytalkService;
  @ResponseBody
  @RequestMapping("/info")
  /**
   * 增加一条回复消息
   */
  public String addhu(TReplytalk tReplytalk){
    return tReplytalkService.addreply(tReplytalk);
  }

  /**
   * 通过商品ID查询某商品下的评论/回复信息
   * @param answer_id
   * @return
   */
  @GetMapping("/hfinfo")
  public String rtg(Integer answer_id){
    return JSON.toJSONString(tReplytalkService.allInfo(answer_id));
  }
}
