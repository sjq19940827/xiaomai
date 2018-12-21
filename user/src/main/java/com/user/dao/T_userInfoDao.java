package com.user.dao;

import com.user.pojo.T_user;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@MapperScan(value = "com.user.dao.T_userInfoDao")
public interface T_userInfoDao {

    /**
     * 修改密码
     * @param user
     * @return
     */
    int updaUserPwd(T_user user);

    /**
     * 修改用户其他信息
     * @param user
     * @return
     */
    int updaUserInfo(T_user user);

    /**
     * 查询用户信息
     * @param user 用户信息
     * @return 返回查询结果
     */
    T_user seleinfo(T_user user);

}
