package com.discount.service;

import com.discount.pojo.TReduce;
import org.springframework.data.repository.query.Param;

public interface DiscountService {
    /**
     * 修改优惠券状态
     * @param user_id
     * @return
     */
    int updateDiscount(Integer user_id, Integer reduce_id);

    /**
     * 新增优惠券
     * @param user_id
     * @return
     */
    int insets(@Param("user_id") Integer user_id);

    /**
     *查询用户优惠券
     * @param
     * @return
     */
    String all(@Param("user_id")Integer user_id);

    /**
     * 减少优惠券库存
     * @param
     * @return
     */
    int updates(@Param("sub") Integer sub,@Param("reduce_id") Integer reduce_id);

    /**
     * 查询优惠券库存
     * @param reduce_id
     * @return
     */
    TReduce select(@Param("reduce_id") Integer reduce_id);

    /**
     * 设置优惠劵时间
     * @param reduceid
     * @param userid
     * @return
     */
    /*int xgs(@Param("reduceid") Integer reduceid,@Param("userid") Integer userid);*/
}
