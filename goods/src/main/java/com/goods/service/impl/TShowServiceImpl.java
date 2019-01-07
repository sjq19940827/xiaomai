package com.goods.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.goods.dao.TShowDao;
import com.goods.pojo.TCategorie;
import com.goods.pojo.TShow;
import com.goods.service.TShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("gsi")
public class TShowServiceImpl implements TShowService {
    @Autowired
    @Qualifier("td")
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
     * 根据商品分类和商品名字展示商品信息
     * @param categorieId
     * @param index
     * @param pagesize
     * @return
     */
    @Override
    public String getInfoByType(@Param ("categorieId") Integer categorieId,@Param ("show_name") String show_name,Integer index,Integer pagesize) {
        PageHelper.startPage (index,pagesize);
        List<TShow> ById = tShowDao.getInfoByType (categorieId,show_name);
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
     * @return
     */
    @Override
    public String getTShowByCityName(@Param("city_name") String city_name, @Param("show_place")String show_place) {
        if(city_name==null&&show_place==null&&city_name!=show_place){
            return "您的输入有误";
        }else{
            return JSON.toJSONString(tShowDao.getTShowByCityName (city_name,show_place));
        }

    }


    /**
     * 根据商品ID查询
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
    /**
     * 根据商品特殊标识进行查询
     * @param show_mark
     * @return
     */
    @Override
    public String getTShowByMarkID(@Param ("show_mark") Integer show_mark,@Param ("show_name")String show_name,Integer index,Integer pagesize) {
        PageHelper.startPage (index,pagesize);
        List<TShow> ByMarkID = tShowDao.getTShowByMarkID (show_mark,show_name);
        PageInfo<TShow> pageInfo = new PageInfo<TShow> (ByMarkID);
        return JSON.toJSONString (pageInfo.getList ());
    }

    /**
     * 根据地区热度进行商品查询
     * @param areainfoID
     * @return
     */
    @Override
    public String getAreainfoID(Integer areainfoID,Integer index,Integer pagesize) {
        PageHelper.startPage (index,pagesize);
        List<TShow> ByAreainfoID = tShowDao.getTShowByAreainfoId (areainfoID);
        PageInfo<TShow> pageInfo = new PageInfo<TShow> (ByAreainfoID);
        return JSON.toJSONString (pageInfo.getList ());
    }
}