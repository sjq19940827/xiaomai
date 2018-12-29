package com.comment.controller;

import com.alibaba.fastjson.JSON;
import com.comment.pojo.TReplytalk;
import com.comment.service.TReplytalkService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reply")
@Api(value = "回复表接口")
public class TReplyController {

  @Autowired
  private TReplytalkService tReplytalkService;
  @ResponseBody
  @RequestMapping("/insert")
  @ApiOperation(value = "回复一条评论",httpMethod = "POST",response = String.class,notes = "回复一条评论信息")
  public String addhu(TReplytalk tReplytalk){
    return tReplytalkService.addreply(tReplytalk);
  }

  /**
   * 通过商品ID查询某商品下的评论/回复信息
   * @param replyuser_id
   * @return
   */
  @ApiOperation(value = "查询某用户下评论与回复",httpMethod = "GET",response = String.class,notes = "查询某商品下评论与回复")
  @ApiImplicitParam (name ="replyuser_id",value = "回复者ID")
  @GetMapping("/selAllTalk")
  public String rtg(Integer replyuser_id){
    return JSON.toJSONString(tReplytalkService.allInfo(replyuser_id));
  }

}
