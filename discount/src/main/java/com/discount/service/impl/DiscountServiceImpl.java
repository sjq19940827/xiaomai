package com.discount.service.impl;

import com.alibaba.fastjson.JSON;
import com.discount.dao.DiscountDao;
import com.discount.pojo.TDiscount;
import com.discount.pojo.TReduce;
import com.discount.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;

import static com.discount.util.DateGenerate.getNowDate;
import static com.discount.util.DateGenerate.getStringDate;

@Service("DiscountService")
public class DiscountServiceImpl implements DiscountService {
    @Autowired
    private DiscountDao discountDao;
    private TReduce treduce;

    /* *//**
 * 修改优惠劵状态
 * @param user_id
 * @return
 */
@Override
public int updateDiscount(Integer user_id, Integer reduce_id) {
    int updata = discountDao.updata(user_id, reduce_id);
    if (updata > 0){
        return updata;
    }
    return 0;
}



    /**
     * 用户添加优惠券
     * @param
     * @return
     */
    @Override
    public int insets(Integer user_id,Integer reduce_id) {
        TDiscount tDiscount = new TDiscount();
        SimpleDateFormat dateFm = new SimpleDateFormat("yyyy-MM-dd");
        tDiscount.setCreate(getStringDate());
        tDiscount.setExitss(getStringDate() + 3);
        int insetred = (int) discountDao.insetred(user_id,reduce_id,tDiscount.getCreate(),tDiscount.getExitss());
        if (insetred > 0){
            return insetred;
        }
        return -1;
    }



    /**
     * 用户查询优惠券
     * @param
     * @return
     */
    @Override
    public String all(Integer user_id) {
        /*Jedis jedis = new Jedis("148.70.68.230",6379);
        user_id = Integer.valueOf(jedis.get("userid"));*/
        if (user_id != null){
            List<TDiscount> all = discountDao.getAll(user_id);
            System.out.println(JSON.toJSONString(all));
            if (all != null){
                return JSON.toJSONString(all);
            }
        }
        return null;
    }

    /**
     * 查询优惠券库存
     * @param reduce_id
     * @return
     */
    @Override
    public TReduce select(Integer reduce_id) {
        if (reduce_id != null){
            TReduce select = discountDao.select(reduce_id);
            if (select != null){
                return select;
            }
        }
        return null;
    }



    /**
     * 减少优惠券库存
     * @param subs
     * @return
     */
    @Override
    public int updates(Integer subs,Integer reduce_id) {
        int sub = subs-1;
        System.out.println(reduce_id);
        int update = discountDao.updatetr(sub,reduce_id);

        if (update > 0 ){
            return 1;
        }
        return 0;
    }

    /**
     *设置用户优惠劵开始与到期时间时间
     * @param reduceid
     * @param userid
     * @return
     */
    /*@Override
    public int xgs(Integer reduceid, Integer userid) {
       *//* Date dNow = new Date();   //当前时间
        Date dBefore = new Date();
        Calendar calendar = Calendar.getInstance(); //得到日历
        calendar.setTime(dNow);//把当前时间赋给日历
        calendar.add(Calendar.MONTH, +3);  //设置为前3月
        dBefore = calendar.getTime();   //得到前3月的时间
       // SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //设置时间格式
        Date exitss = dBefore;    //格式化前3月的时间
        Date create = dNow; //格式化当前时间i*//*
        int xg = discountDao.xg(create,exitss,reduceid,userid);
        return xg ;
    }*/
}
