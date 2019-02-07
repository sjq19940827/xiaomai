package com.discount.dao;

import com.discount.pojo.TDiscount;
import com.discount.pojo.TReduce;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.repository.query.Param;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Date;
import java.util.List;

@SpringBootApplication
@EnableSwagger2
@MapperScan("com.discount.dao.DiscountDao")
public interface DiscountDao {

    /**
     * 修改优惠劵状态
     * @return
     */
    int updata(@Param("user_id") Integer user_id,@Param("reduce_id") Integer reduce_id);
    /**
     * 新增优惠券(用户新增优惠劵)
     * @return
     */
    int insetred(Integer user_id,String create,String exitss);

    /**
     * 查询用户优惠劵的详细信息
     * @param user_id
     * @return
     */
    List<TDiscount> getAll(Integer user_id);

    /**
     * 减少库存
     * @param sub
     * @return
     */
    int updatetr(@Param("sub") Integer sub,@Param("reduce_id")Integer reduce_id);

    /**
     * 根据优惠券id查询优惠券库存
     * @param reduce_id
     * @return
     */
    TReduce select(@Param("reduce_id") Integer reduce_id );

    /* *//**
     * 设置用户优惠券时间
     * @param create
     * @param exitss
     * @param reduceid
     * @param userid
     * @return
     *//*
    int xg(@Param("create") Date create,@Param("exitss") Date exitss,@Param("reduceid") Integer reduceid,@Param("userid") Integer userid);*/
}
