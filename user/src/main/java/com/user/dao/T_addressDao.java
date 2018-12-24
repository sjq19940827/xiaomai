package com.user.dao;

import com.user.pojo.T_address;
import com.user.pojo.T_user;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;
@SpringBootApplication
@EnableSwagger2
@MapperScan(value = "com.user.dao.T_addressDao")
public interface T_addressDao {
    /**
     * 按照 用户id查找收货地址
     * @param address
     * @return
     */
    List<T_address> seleaddress(T_address address);

    /**
     * 根据用户手机号查找用户id
     * @param user
     * @return
     */
    T_user seleuserid(T_user user);

    /**
     * 新增收货地址
     * @param address
     * @return
     */
    int addAddress(T_address address);

    /**
     * 删除收货地址
     * @param address
     * @return
     */
    int delAddress(T_address address);
}
