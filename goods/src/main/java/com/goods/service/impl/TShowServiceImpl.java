package com.goods.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.goods.dao.TShowDao;
import com.goods.pojo.TCategorie;
import com.goods.pojo.TShow;
import com.goods.service.TShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("gsi")
public class TShowServiceImpl implements TShowService {
    @Autowired
    private TShowDao tShowDao;
    /**
     * 查询全部
     * @return
     */
    @Override
    public String getAll(int index, int pagesize) {
        PageHelper.startPage (index, pagesize);
        List<TShow> allINfo = tShowDao.getAll ();
        PageInfo<TShow> pageInfo = new PageInfo<TShow> (allINfo);

        return JSON.toJSONString (pageInfo.getList ());
    }
    /**
     * 查询全部分类信息
     * @return
     */
    @Override
    public String getAlll(int index,int pagesize) {
        PageHelper.startPage (index, pagesize);
        List<TCategorie> fl = tShowDao.getAlll ();
        PageInfo<TCategorie> pageInfo = new PageInfo<TCategorie> (fl);

        return JSON.toJSONString (pageInfo.getList ());

    }
    /**
     * 根据商品分类展示用户信息
     * @return
     */
    @Override
    public String getInfoByType(Integer categorie_id,int index,int pagesize) {
        PageHelper.startPage (index,pagesize);
        List<TShow> ById = tShowDao.getInfoByType (categorie_id);
        PageInfo<TShow> pageInfo = new PageInfo<TShow> (ById);
        return JSON.toJSONString (pageInfo.getList ());
    }
}