package com.goods.service;


import org.springframework.data.repository.query.Param;



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
     *根据商品分类和商品名字展示商品信息
     * @return
     */
    String getInfoByType(@Param ("categorieId") Integer categorieId,@Param ("show_name") String show_name,Integer index,Integer pagesize);
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
    String getTShowByCityName(@Param("city_name") String city_name, @Param("show_place")String show_place);


    /**
     * 根据商品ID查询
     * @param goodsID
     * @return
     */
    String getTShowByGoodsID(Integer goodsID,Integer index,Integer pagesize);
    /**
     * 根据商品特殊标识进行查询
     * @param show_mark
     * @return
     */
    String getTShowByMarkID(@Param ("show_mark") Integer show_mark,@Param ("show_name") String show_name,Integer index,Integer pagesize);

    /**
     * 根据地区热度进行商品查询
     * @param areainfoID
     * @return
     */
    String getAreainfoID(@Param("areainfoID")Integer areainfoID,Integer index,Integer pagesize);


}


