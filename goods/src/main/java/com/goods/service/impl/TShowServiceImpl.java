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
     * 查询全部商品
     * @param index
     * @param pagesize
     * @return
     */
    @Override
    public String getAllGoods(Integer index, Integer pagesize) {
        PageHelper.startPage (index, pagesize);
        List<TShow> allINfo = tShowDao.getAllGoods ();
        PageInfo<TShow> pageInfo = new PageInfo<TShow> (allINfo);
        return JSON.toJSONString (pageInfo.getList ());
    }

    /**
     * 查询全部分类信息
     * @param index
     * @param pagesize
     * @return
     */
    @Override
    public String getAllType(Integer index,Integer pagesize) {
        PageHelper.startPage (index, pagesize);
        List<TCategorie> fl = tShowDao.getAllType ();
        PageInfo<TCategorie> pageInfo = new PageInfo<TCategorie> (fl);
        return JSON.toJSONString (pageInfo.getList ());

    }

    /**
     * 根据商品分类展示商品信息
     * @param categorieId
     * @param index
     * @param pagesize
     * @return
     */
    @Override
    public String getInfoByType(Integer categorieId,Integer index,Integer pagesize) {
        PageHelper.startPage (index,pagesize);
        List<TShow> ById = tShowDao.getInfoByType (categorieId);
        PageInfo<TShow> pageInfo = new PageInfo<TShow> (ById);
        return JSON.toJSONString (pageInfo.getList ());
    }

    /**
     * 根据城市ID查询商品信息
     * @param areainfoId
     * @param index
     * @param pagesize
     * @return
     */
    @Override
    public String getTShowByAreainfoId(Integer areainfoId,Integer index,Integer pagesize)
    {
        PageHelper.startPage (index,pagesize);
        List<TShow> ByAreainfoId = tShowDao.getTShowByAreainfoId (areainfoId);
        PageInfo<TShow> pageInfo = new PageInfo<TShow> (ByAreainfoId);
        return JSON.toJSONString (pageInfo.getList ());
    }

    /**
     * 根据城市名字模糊查询
     * @param city_name
     * @param index
     * @param pagesize
     * @return
     */
    @Override
    public String getTShowByCityName(String city_name,Integer index,Integer pagesize) {
        PageHelper.startPage (index,pagesize);
        List<TShow> ByName = tShowDao.getTShowByCityName (city_name);
        PageInfo<TShow> pageInfo = new PageInfo<TShow> (ByName);
        return JSON.toJSONString (pageInfo.getList ());
    }

    /**
     * 根据商品名字模糊查询
     * @param show_name
     * @param index
     * @param pagesize
     * @return
     */
    @Override
    public String getAllByGoodsName(String show_name, Integer index, Integer pagesize) {
        PageHelper.startPage (index,pagesize);
        List<TShow> ByGoodsName = tShowDao.getAllByGoodsName(show_name);
        PageInfo<TShow> pageInfo = new PageInfo<TShow> (ByGoodsName);
        return JSON.toJSONString (pageInfo.getList ());
    }

    /**
     * 根据商品ID模糊查询
     * @param goodsID
     * @param index
     * @param pagesize
     * @return
     */
    @Override
    public String getTShowByGoodsID(Integer goodsID, Integer index, Integer pagesize) {
        PageHelper.startPage (index,pagesize);
        List<TShow> ByGoodsID = tShowDao.getTShowByGoodsID(goodsID);
        PageInfo<TShow> pageInfo = new PageInfo<TShow> (ByGoodsID);
        return JSON.toJSONString (pageInfo.getList ());
    }
}