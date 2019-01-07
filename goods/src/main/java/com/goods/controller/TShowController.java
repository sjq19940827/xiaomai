package com.goods.controller;


import com.alibaba.fastjson.JSON;
import com.goods.service.SolrService;
import com.goods.service.impl.TShowServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

@RestController
public class TShowController {
    @Autowired
    @Qualifier("gsi")
    private TShowServiceImpl TShowService;

    @Autowired
    private SolrService solrService;
    /**
     * 查询全部商品
     * @param index
     * @param pagesize
     * @return
     */
    @GetMapping("/getAllGoods")
    public String getAllGoods(Integer index, Integer pagesize) {

        return TShowService.getAllGoods (index, pagesize);
    }

    /**
     * 查询全部分类信息
     * @param index
     * @param pagesize
     * @return
     */
    @GetMapping("/getAllType")
    public String getAllType(Integer index, Integer pagesize) {

        return TShowService.getAllType (index, pagesize);
    }

    /**
     * 根据商品分类和商品名字展示商品信息
     * @param categorieId
     * @param index
     * @param pagesize
     * @return
     */
    @GetMapping("/getInfoByType")
    public String getInfoByType(@Param ("categorieId") Integer categorieId,@Param ("show_name") String show_name,Integer index,Integer pagesize) {
        return TShowService.getInfoByType (categorieId, show_name,index, pagesize);
    }

    /**
     *  根据城市ID查询商品信息
     * @param areainfoId
     * @param index
     * @param pagesize
     * @return
     */
    @GetMapping("/getTShowByAreainfoId")
    public String getTShowByAreainfoId(Integer areainfoId, Integer index, Integer pagesize) {
        return TShowService.getTShowByAreainfoId (areainfoId, index, pagesize);
    }

    /**
     *
     * @param city_name
     * @param show_place
     * @return
     */
    @GetMapping("/getTShowByCityName")
    public String  getTShowByCityName(@Param("city_name") String city_name, @Param("show_place")String show_place ) {
        return TShowService.getTShowByCityName (city_name,show_place);
    }

    /**
     * 根据商品ID查询
     * @param goodsID
     * @param index
     * @param pagesize
     * @return
     */
    @GetMapping("/getTShowByGoodsID")
    public String getTShowByGoodsID(Integer goodsID, Integer index, Integer pagesize) {
        return TShowService.getTShowByGoodsID (goodsID,index,pagesize);
    }

    /**
     * solr全局查询
     * @param goodsName
     * @return
     */
    @GetMapping("/solr")
    public String solrSearch(@RequestParam("goodsName") String goodsName) {
        return solrService.shopSearch (goodsName);
    }

    /**
     * 根据商品特殊标识和城市进行查询
     * @param show_mark
     * @param index
     * @param pagesize
     * @return
     */
    @GetMapping("/getTShowByMarkID")
    public String getTShowByMarkID(@Param ("show_mark") Integer show_mark,@Param ("show_name")String show_name,Integer index,Integer pagesize ) {
        return TShowService.getTShowByMarkID (show_mark,show_name,index,pagesize);
    }

    /**
     * 根据地区热度进行商品查询
     * @param areainfoID
     * @param index
     * @param pagesize
     * @return
     */
    public String getAreainfoID(Integer areainfoID,Integer index,Integer pagesize) {
        return TShowService.getAreainfoID (areainfoID,index,pagesize);
    }
}