package com.goods.service;

import com.goods.pojo.TShow;

import java.util.List;

public interface TShowService {



    /**
     * 查询全部商品
     * @return
     */
    String  getAllGoods(Integer index,Integer pagesize);

    /**
     * 查询全部分类信息
     * @return
     */
    String getAllType(Integer index,Integer pagesize);

    /**
     *根据商品分类展示商品信息
     * @return
     */
    String getInfoByType(Integer categorieId,Integer index,Integer pagesize);
    /**
     * 根据城市ID查询商品信息
     * @param areainfoId
     * @return
     */
    String getTShowByAreainfoId(Integer areainfoId,Integer index,Integer pagesize);

    /**
     * 根据城市名字模糊查询
     * @param city_name
     * @return
     */
    String getTShowByCityName(String city_name,Integer index,Integer pagesize);

    /**
     * 根据商品名字模糊查询
     * @return
     */
    String getAllByGoodsName(String show_name,Integer index,Integer pagesize);

    /**
     * 根据商品ID模糊查询
     * @param goodsID
     * @return
     */
    String getTShowByGoodsID(Integer goodsID,Integer index,Integer pagesize);

}

