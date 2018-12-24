package com.user.controller;

import com.user.service.T_userInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("upda")
@Api(value = "用户修改信息")
public class T_userInfoController {
    @Autowired
    private T_userInfoService tuis;
    public T_userInfoService getTuis() {
        return tuis;
    }
    public void setTuis(T_userInfoService tuis) {
        this.tuis = tuis;
    }

    @ResponseBody
    @RequestMapping(value = "showinfo",method = RequestMethod.GET)
    @ApiOperation(value = "展示用户登录后的用户信息（昵称，头像，个性签名）",notes = "查询数据库",response = String.class)
    public String Showinfo(){
        return tuis.userInfo();
    }
    @ResponseBody
    @RequestMapping(value = "updapwdfirst",method = RequestMethod.GET)
    @ApiOperation(value = "修改密码，该用户第一次通过快捷登录，数据库中没有密码",notes = "修改数据库",response = String.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",required = false,name = "pwd1",value = "新密码"),
            @ApiImplicitParam(paramType = "query",required = false,name = "pwd2",value = "再次输入新密码密码")
    })
    public String updafirstpwd(@RequestParam("pwd1") String pwd1,@RequestParam("pwd2")String pwd2){

        return tuis.updaFirstPwd(pwd1, pwd2);
    }

    @ResponseBody
    @RequestMapping(value = "updapwd",method = RequestMethod.GET)
    @ApiOperation(value = "修改密码，正常修改密码",notes = "修改数据库",response = String.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",required = false,name = "pwd",value = "旧密码"),
            @ApiImplicitParam(paramType = "query",required = false,name = "pwd1",value = "新密码"),
            @ApiImplicitParam(paramType = "query",required = false,name = "pwd2",value = "再次输入新密码密码")
    })
    public String updapwd(@RequestParam("pwd")String pwd,@RequestParam("pwd1")String pwd1,@RequestParam("pwd2")String pwd2){
        System.out.println(pwd);
        System.out.println(pwd1);
        System.out.println(pwd2);

        return tuis.updaPwd(pwd,pwd1,pwd2);
    }


    @ResponseBody
    @RequestMapping(value = "showpage",method = RequestMethod.GET)
    @ApiOperation(value = "根据用户是否存在密码，而现实不同的修改页面",notes = "查询数据库",response = String.class)
    public String Showpwdpage(){
        return tuis.judgeUserExistPwd();
    }

    @ResponseBody
    @RequestMapping(value = "updainfo",method = RequestMethod.GET)
    @ApiOperation(value = "修改用户信息",notes = "修改数据库",response = String.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",required = false,name = "nickname",value = "昵称"),
            @ApiImplicitParam(paramType = "query",required = false,name = "loginname",value = "个性签名")
    })
    public String updapwd(@RequestParam("nickname") String nickname,@RequestParam("loginname") String loginname){
        return tuis.updaUserInfo(nickname, loginname);
    }





}
