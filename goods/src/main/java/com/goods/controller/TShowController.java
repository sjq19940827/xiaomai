package com.goods.controller;


import com.goods.service.SolrService;
import com.goods.service.impl.TShowServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
     * 根据商品分类展示商品信息
     * @param categorieId
     * @param index
     * @param pagesize
     * @return
     */
    @GetMapping("/getInfoByType")
    public String getInfoByType(Integer categorieId, Integer index, Integer pagesize) {
        return TShowService.getInfoByType (categorieId, index, pagesize);
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
     * 根据城市名字模糊查询
     * @param city_name
     * @param index
     * @param pagesize
     * @return
     */
    @GetMapping("/getTShowByCityName")
    public String getTShowByCityName(String city_name, Integer index, Integer pagesize) {
        return TShowService.getTShowByCityName (city_name, index, pagesize);
    }

    /**
     * 根据商品名字模糊查询
     * @param show_name
     * @param index
     * @param pagesize
     * @return
     */
    @GetMapping("/getAllByGoodsName")
    public String getAllByGoodsName(String show_name, Integer index, Integer pagesize) {
        return TShowService.getAllByGoodsName (show_name, index, pagesize);
    }

    /**
     * 根据商品ID模糊查询
     * @param goodsID
     * @param index
     * @param pagesize
     * @return
     */
    @GetMapping("/getTShowByGoodsID")
    public String getTShowByGoodsID(Integer goodsID, Integer index, Integer pagesize) {
        return TShowService.getTShowByGoodsID (goodsID,index,pagesize);
    }
    @GetMapping("/solr")
    public String solrSearch(@RequestParam("goodsName") String goodsName) {
        return solrService.shopSearch (goodsName);
    }
}