package com.problem.controller;

import com.problem.service.ProblemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("que/")
@Api(value = "que",description = "常见问题")
public class ProblemController {
    @Autowired
    private ProblemService problemService;
    @ResponseBody
    @RequestMapping(value = "all")
    @ApiOperation(value = "查询常见问题",notes = "查询数据库")
    public String all(){
        String select = problemService.select();
        return select;
    }

}
