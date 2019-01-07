package com.goods.dao;


import com.goods.pojo.TCategorie;
import com.goods.pojo.TShow;
import org.apache.ibatis.annotations.Mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("td")
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
     * 根据商品分类和商品名字展示商品信息
     * @param categorieId
     * @param show_name
     * @return
     */
    List<TShow> getInfoByType(@Param ("categorieId") Integer categorieId,@Param ("show_name") String show_name);

    /**
     * 根据城市ID查询商品信息
     * @param areainfoId
     * @return
     */
    List<TShow> getTShowByAreainfoId(Integer areainfoId);

    /**
     * 根据城市名字模糊查询
     * @param city_name
     * @param show_place
     * @return
     */
    List<TShow> getTShowByCityName(@Param("city_name") String city_name, @Param("show_place")String show_place);

    /**
     * 根据商品ID查询显示
     * @param goodsID
     * @return
     */
    List<TShow> getTShowByGoodsID(Integer goodsID);

    TShow gettshowbyid(Integer goodsID);

    /**
     * 根据商品特殊标识和城市进行查询
     * @param show_mark
     * @param show_name
     * @return
     */
    List<TShow> getTShowByMarkID(@Param ("show_mark") Integer show_mark,@Param ("show_name") String show_name);

    /**
     * 根据地区热度进行商品查询
     * @param areainfoID
     * @return
     */
    List<TShow> getAreainfoID(@Param ("areainfoID")Integer areainfoID);
}
