package com.attention.service.impl;

import com.alibaba.fastjson.JSON;
import com.attention.dao.TAttentionDao;
import com.attention.pojo.TAttention;
import com.attention.service.TAttentionService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

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

    /**
     * 通过ID查询单条数据
     *
     * @param attid 主键
     * @return 实例对象
     */
    @Override
    public TAttention queryById(Integer attid) {
        return this.tAttentionDao.queryById(attid);
    }

    /**
     * 查询多条数据
     *
     * @param pagenum 查询起始位置
     * @param pagsize 查询条数
     * @return 对象列表
     */
    @Override
    public String queryAllByLimit(int pagenum, int pagsize) {
        PageHelper.startPage(pagenum, pagsize);
        List<TAttention> tAttentions = tAttentionDao.queryAllByLimit();
        return JSON.toJSONString(tAttentions);
    }

    /**
     * 新增数据
     *
     * @param attuser
     * @param attshow
     * @return 实例对象
     */
    @Override
    public String insert(int attuser,  int attshow) {
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