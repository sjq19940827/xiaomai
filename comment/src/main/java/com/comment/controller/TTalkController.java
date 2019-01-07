package com.comment.controller;


import com.alibaba.fastjson.JSON;


import com.comment.pojo.TTalk;
import com.comment.service.TTalkService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
@Api(value = "评论表")
public class TTalkController {
    @Autowired
   private TTalkService tTalkService;

    @ApiOperation(value = "查询某商品下的评论信息",httpMethod = "GET",response = String.class,notes = "查某商品下的评论信息")
    @ApiImplicitParam(name = "answer_id",value = "商品ID")
    @GetMapping("/InfoByAnswer")
    public String ds(Integer answer_id){
        return tTalkService.getAllInfoByShowid(answer_id);
    }


    @ApiOperation(value = "查询某用户参与的评论",httpMethod = "GET",response = String.class,notes = "查某用户的评论信息")
    @ApiImplicitParam(name = "user_id",value = "用户ID")
    @GetMapping("/InfoByUser")
    public String pds(Integer user_id){

        return JSON.toJSONString(tTalkService.getTTalkInfoByUser(user_id));
    }


    @ApiOperation(value = "查询某用户参与的评论数量",httpMethod = "GET",response = String.class,notes = "查某用户的评论数量")
    @ApiImplicitParam(name = "user_id",value = "用户ID")
    @GetMapping("/NumByUser")
    public int pl(Integer user_id){
        int i = tTalkService.selTalkNum(user_id);
        return i;
    }
    @ApiOperation(value = "查询某商品是否有评论",httpMethod = "GET",response = String.class,notes = "查询某商品是否有评论")
    @ApiParam(name = "answer_id",value = "商品ID")
    @GetMapping("/NumByAnswer")
    public String sdv(int answer_id){
        String s = tTalkService.NumByAnswer(answer_id);
        return s;
    }

    @ApiOperation(value = "查询用户对评论的点赞数",httpMethod = "GET",response = String.class,notes = "查询用户对评论的点赞数")
    @GetMapping("/ByUserAndAnswer")
    public int  dz(  @ApiParam(name = "answer_id",value = "商品ID")Integer answer_id){
        int i = tTalkService.selDzByUserAndShow(answer_id);
        return i;
    }


    @ApiOperation(value = "发布一条评论",httpMethod = "POST",response = String.class,notes = "发布一条评论信息")
    @ResponseBody
    @RequestMapping("/publish")
    public String addTalk(TTalk talk){
        System.out.println(talk.getCreatetime());
        return tTalkService.addTalkByUser(talk);
    }



    @ApiOperation(value = "修改评论信息",httpMethod = "POST",response = String.class,notes = "修改一条评论信息")
    @RequestMapping("/upInfo")
    public String up(TTalk tTalk){
        return tTalkService.updateTalkInfo(tTalk);
    }


    @ApiOperation(value = "查询点赞状态",httpMethod = "GET",response = String.class,notes = "通过用户ID与评论表ID查询点赞状态")
    @GetMapping("/selNumByUaT")
    public int dz(int talk_id){
        return tTalkService.selNum(talk_id);
    }


    @ApiOperation(value = "点赞",httpMethod = "POST",response = String.class,notes = "通过用户ID与评论表ID进行点赞")
    @RequestMapping("/like")
    @ApiImplicitParams({@ApiImplicitParam(name = "talk_id",value = "评论信息ID")})
    public String dzf( int talk_id){ return tTalkService.qdz(talk_id);
    }

}
