package com.discount.dao;

import com.discount.pojo.TDiscount;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@MapperScan("com.discount.dao.DiscountDao")
public interface DiscountDao {

    /**
     * 修改优惠劵状态
     * @return
     */
    int updataDiscount(TDiscount tDiscount);
}
