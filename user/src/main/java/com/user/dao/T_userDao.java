package com.user.dao;

import com.user.pojo.T_user;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@MapperScan(value = "com.user.dao.T_userDao")
public interface T_userDao {
    /**
     * 查询数据库中存在的用户
     * @param user 用户对象
     * @return 返回该用户全部信息
     */
    T_user seleUser(T_user user);

    /**
     * 新增一个用户
     * @param user 参数为用户对象
     * @return 返回添加结果
     */
    int addUser(T_user user);
}
