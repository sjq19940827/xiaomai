package com.goods.service.impl;

import com.alibaba.fastjson.JSON;
import com.goods.dao.TAttentionDao;
import com.goods.dao.TShowDao;
import com.goods.pojo.TAttention;
import com.goods.pojo.TShow;
import com.goods.service.TAttentionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;

/**
 * (TAttention)表服务实现类
 *
 * @author makejava
 * @since 2019-01-04 10:56:25
 */
@Service("tAttentionService")
public class TAttentionServiceImpl implements TAttentionService {
    @Autowired
    @Qualifier("tad")
    private TAttentionDao tAttentionDao;

    @Autowired
    @Qualifier("td")
    private TShowDao tShowDao;

    /**
     * 通过ID查询单条数据
     *
     * @param attuser 主键
     * @return 实例对象
     */
    @Override
    public List<TAttention> queryById(Integer attuser) {

        return tAttentionDao.queryById(attuser);
    }

    /**
     * 查询多条数据
     *
     * @return 对象列表
     */
    @Override
    public String queryAllBygoodsid() {
//        TAttentionServiceImpl t=new TAttentionServiceImpl();
        Jedis jedis= new Jedis("148.70.68.230",6379);
        Integer attuser = Integer.valueOf(jedis.get("userid"));
        List<TAttention> tAttentions = this.queryById(attuser);
        List<TShow> tShowByGoodsID = new ArrayList<>();
        for (TAttention ta:tAttentions) {
            if (ta.getAttmark()!=1){
                tShowByGoodsID.add(tShowDao.gettshowbyid(ta.getAttshow()));
            }
        }

        System.out.println(tShowByGoodsID);
        if (tShowByGoodsID!=null){
            return JSON.toJSONString(tShowByGoodsID);
        }else {
            return "啥都没！";
        }

    }

    @Override
    public String queryOutBygoodsid() {
        Jedis jedis= new Jedis("148.70.68.230",6379);
        Integer attuser = Integer.valueOf(jedis.get("userid"));
        List<TAttention> tAttentions = this.queryById(attuser);
        List<TShow> tShowByGoodsID = new ArrayList<>();
        for (TAttention ta:tAttentions) {
            if (ta.getAttmark() ==1){
                tShowByGoodsID.add(tShowDao.gettshowbyid(ta.getAttshow()));
            }
        }
        if (tShowByGoodsID!=null){
            return JSON.toJSONString(tShowByGoodsID);
        }else {
            return "啥都没！";
        }

    }

    /**
     * 新增数据
     *
     * @param attshow
     * @return 实例对象
     */
    @Override
    public String insert(int attshow) {
        Jedis jedis= new Jedis("148.70.68.230",6379);
        Integer attuser = Integer.valueOf(jedis.get("userid"));
        int insert = this.tAttentionDao.insert(attuser, attshow);
        if (insert>0){
            return "关注成功";
        }else {
            return "关注失败";
        }

    }

    /**
     * 修改数据
     *
     * @param tAttention 实例对象
     * @return 实例对象
     */
    @Override
    public String update(TAttention tAttention) {
        int update = this.tAttentionDao.update(tAttention);
        List<TAttention> tAttentions = this.queryById(tAttention.getAttid());
        return JSON.toJSONString(tAttention);
    }

    /**
     * 通过主键删除数据
     *
     * @param attshow 主键
     * @return 是否成功
     */
    @Override
    public String deleteById(Integer attshow) {
        Jedis jedis= new Jedis("148.70.68.230",6379);
        Integer attuser = Integer.valueOf(jedis.get("userid"));
        int i = this.tAttentionDao.deleteById(attshow,attuser);
        if (i>0){
            return "取关成功";
        }else {
            return "取关失败";
        }

    }
}