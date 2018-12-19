package com.user.controller;

import com.user.service.T_userService;
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
@RequestMapping("login")
@Api(value = "用户登录与注册")
public class T_userController {
    @Autowired
    private T_userService tus;
    public T_userService getTus() {
        return tus;
    }
    public void setTus(T_userService tus) {
        this.tus = tus;
    }


    @ResponseBody
    @RequestMapping(value = "mobilephone",method = RequestMethod.POST)
    @ApiOperation(value = "向手机发送验证码",notes = "查询数据库",response = String.class)
    @ApiImplicitParam(paramType = "query",required = false,name = "phone",value = "手机号")
    public String MobilePhone(@RequestParam("phone") String phone){
        return tus.judgeUserExist(phone);
    }

    @ResponseBody
    @RequestMapping(value = "authcode",method = RequestMethod.POST)
    @ApiOperation(value = "判断用户输入的验证码与发送的验证码是否一致，并且对首次用手机登录的用户进行添加数据库",notes = "添加数据库",response = String.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",required = false,name = "authcode",value = "验证码"),
            @ApiImplicitParam(paramType = "query",required = false,name = "phone",value = "手机号")
    })
    public String JudgeAuthCodeLogin(@RequestParam("authcode") String authcode,@RequestParam("phone") String phone){
        return tus.judgeAuthcode(authcode,phone);
    }

}
