package com.goods.dao;


import com.goods.pojo.TCategorie;
import com.goods.pojo.TShow;
import org.apache.ibatis.annotations.Mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface TShowDao {
    /**
     * 查询全部商品
     * @return
     */
    List<TShow> getAllGoods();

    /**
     * 查询全部分类信息
     * @return
     */
    List<TCategorie> getAllType();


    /**
     * 根据商品分类展示商品信息
     * @return
     */
    List<TShow> getInfoByType(Integer categorieId);

    /**
     * 根据城市ID查询商品信息
     * @param areainfoId
     * @return
     */
    List<TShow> getTShowByAreainfoId(Integer areainfoId);

    /**
     * 根据城市名字模糊查询
     * @param city_name
     * @return
     */
    List<TShow> getTShowByCityName(@Param("city_name") String city_name, @Param("show_place")String show_place);

    /**
     * 根据商品ID查询显示
     * @param goodsID
     * @return
     */
    List<TShow> getTShowByGoodsID(Integer goodsID);

    /**
     * 根据商品特殊标识进行查询
     * @param show_mark
     * @return
     */
    List<TShow> getTShowByMarkID(Integer show_mark);

}
