package com.user.controller;

import com.user.service.T_userService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;

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
    public String MobilePhone(@RequestParam("phone") String phone/*, HttpServletRequest request*/){
        return tus.judgeUserExist(phone/*,request*/);
    }

    @ResponseBody
    @RequestMapping(value = "authcode",method = RequestMethod.POST)
    @ApiOperation(value = "判断用户输入的验证码与发送的验证码是否一致，并且对首次用手机登录的用户进行添加数据库",notes = "添加数据库",response = String.class)
    @ApiImplicitParam(paramType = "query",required = false,name = "authcode",value = "验证码")
    public String JudgeAuthCodeLogin(@RequestParam("authcode") String authcode){
        System.out.println(authcode);
        return tus.judgeAuthcode(authcode);
    }

    @ResponseBody
    @RequestMapping(value = "judgePAP",method = RequestMethod.POST)
    @ApiOperation(value = "判断用户输入的手机号是否已经被注册过",notes = "查询数据库",response = String.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",required = false,name = "phone",value = "手机号"),
            @ApiImplicitParam(paramType = "query",required = false,name = "pwd1",value = "密码一"),
            @ApiImplicitParam(paramType = "query",required = false,name = "pwd2",value = "密码二")
    })
    public String JudgePhoneAndPwd(@RequestParam("phone")String phone,@RequestParam("pwd1")String pwd1,@RequestParam("pwd2")String pwd2,Model mo){
        Jedis jedis = new Jedis("148.70.68.230",6379);
        jedis.get("phone");
        mo.addAttribute("phone",jedis.get("phone"));
        return tus.judgePhoneAndPwd(phone,pwd1,pwd2/*,request*/);
    }
    @ResponseBody
    @RequestMapping(value = "getauthcode",method = RequestMethod.POST)
    @ApiOperation(value = "发送验证码",notes = "",response = String.class)
    public String getAuthcode(){
        return tus.getAuthcode(/*request*/);
    }

    @ResponseBody
    @RequestMapping(value = "addPP",method = RequestMethod.POST)
    @ApiOperation(value = "新增一条数据到数据库",notes = "新增一条数据",response = String.class)
    @ApiImplicitParam(paramType = "query",required = false,name = "authcode",value = "验证码")
    public String addPhoneAndPwd(@RequestParam("authcode")String authcode/*, HttpServletRequest request*/){

        return tus.addUserPwd(authcode/*, request*/);
    }

    @ResponseBody
    @RequestMapping(value = "loginPP",method = RequestMethod.POST)
    @ApiOperation(value = "用户通过手机号密码登录",notes = "查询数据库",response = String.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",required = false,name = "phone",value = "手机号"),
            @ApiImplicitParam(paramType = "query",required = false,name = "pwd",value = "密码")
    })
    public String phoneAndPwd(@RequestParam("phone")String phone,@RequestParam("pwd")String pwd/*, HttpServletRequest request*/){
        System.out.println(pwd);
        System.out.println(phone);
        return tus.phoneAndPwdLogin(phone,pwd/*,request*/);
    }

    @ResponseBody
    @RequestMapping(value = "logout",method = RequestMethod.GET)
    @ApiOperation(value = "用户注销，退出登录状态",notes = "清除用户登录状态的缓存",response = String.class)
    public String userLogout(){
        return tus.userLogout();
    }
}
