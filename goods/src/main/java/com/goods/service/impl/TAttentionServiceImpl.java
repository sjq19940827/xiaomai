package com.goods.service.impl;

import com.goods.dao.TAttentionDao;
import com.goods.dao.TShowDao;
import com.goods.pojo.TAttention;
import com.goods.pojo.TShow;
import com.goods.service.TAttentionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TAttention)表服务实现类
 *
 * @author makejava
 * @since 2019-01-04 10:56:25
 */
@Service("tAttentionService")
public class TAttentionServiceImpl implements TAttentionService {
    @Resource
    private TAttentionDao tAttentionDao;

    @Autowired
    private TShowDao tShowDao;

    /**
     * 通过ID查询单条数据
     *
     * @param attuser 主键
     * @return 实例对象
     */
    @Override
    public TAttention queryById(Integer attuser) {
        return this.tAttentionDao.queryById(attuser);
    }

    /**
     * 查询多条数据
     *
     * @return 对象列表
     */
    @Override
    public List<TShow> queryAllBygoodsid() {
        TAttentionServiceImpl t=new TAttentionServiceImpl();
        Jedis jedis= new Jedis("148.70.68.230",6379);
        Integer attuser = Integer.valueOf(jedis.get("userid"));
        TAttention tAttention = t.queryById(attuser);
        List<TShow> tShowByGoodsID = tShowDao.getTShowByGoodsID(tAttention.getAttshow());
        return tShowByGoodsID;
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
    public TAttention update(TAttention tAttention) {
        this.tAttentionDao.update(tAttention);
        return this.queryById(tAttention.getAttid());
    }

    /**
     * 通过主键删除数据
     *
     * @param attid 主键
     * @return 是否成功
     */
    @Override
    public String deleteById(Integer attid) {
        int i = this.tAttentionDao.deleteById(attid);
        if (i>0){
            return "取关成功";
        }else {
            return "取关失败";
        }

    }
}