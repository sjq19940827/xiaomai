package com.user.controller;

import com.user.pojo.T_address;
import com.user.service.T_addressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("arddress")
@Api(value = "用户修改信息")
public class T_addressController {
    @Autowired
    private T_addressService tas;
    public T_addressService getTas() {
        return tas;
    }
    public void setTas(T_addressService tas) {
        this.tas = tas;
    }

    @ResponseBody
    @RequestMapping(value = "show",method = RequestMethod.GET)
    @ApiOperation(value = "展示用户的收货地址",notes = "查询数据库",response = String.class)
    public String shoaddress(){
        return tas.getUserAddress();
    }
    @ResponseBody
    @RequestMapping(value = "addAdress",method = RequestMethod.POST)
    @ApiOperation(value = "新增用户收货地址",notes = "新增数据库")
    public String addAddress(@RequestBody T_address address){
        System.out.println("进来了");
        return tas.addAddress(address);
    }

    @ResponseBody
    @RequestMapping(value = "deladdress",method = RequestMethod.POST)
    @ApiOperation(value = "删除用户收货地址",notes = "删除数据库",response = String.class)
    @ApiImplicitParam(paramType = "query",required = false,name = "id",value = "地址id")
    public String delAddress(@RequestParam("id")Long id){
        return tas.delAddress(id);
    }





}
