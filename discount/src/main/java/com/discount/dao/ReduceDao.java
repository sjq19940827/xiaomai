package com.discount.dao;

import com.discount.pojo.T_Reduce;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.repository.query.Param;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;


@SpringBootApplication
@EnableSwagger2
@MapperScan("com.discount.dao.ReduceDao")
public interface ReduceDao {

    /**
     * 查询优惠券
     * @param reduce_Id
     * @return
     */
    List<T_Reduce> getAll(@Param("reduce_id") Integer reduce_Id);


}
