package com.problem.service.impl;

import com.alibaba.fastjson.JSON;
import com.problem.dao.ProblemDao;
import com.problem.pojo.TProblem;
import com.problem.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("ProblemService")
public class ProblemServiceImpl implements ProblemService {
    @Autowired
    private ProblemDao problemDao;
    @Override
    public String select() {
        List<TProblem> tProblems = problemDao.selectAll();
        return JSON.toJSONString(tProblems);
    }
}
