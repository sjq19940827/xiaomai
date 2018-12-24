package com.problem.dao;

import com.problem.pojo.TProblem;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;
@SpringBootApplication
@EnableSwagger2
@MapperScan("com.problem.dao.ProblemDao")
public interface ProblemDao {
    /**
     * 查询常见问题
     * @param
     * @return
     */
    List<TProblem> selectAll();
}
