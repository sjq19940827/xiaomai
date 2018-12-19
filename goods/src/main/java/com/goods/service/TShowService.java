package com.goods.service;

import com.goods.pojo.TShow;

import java.util.List;

public interface TShowService {

//    /**
//     * 菜品信息分页展示
//     *
//     * @param index    页码
//     * @param pagesize 每页显示量
//     * @return 商品信息集合的json字符串
//     */
//    String getPageByIndex(int index, int pagesize);

    /**
     * 查询全部
     * @return
     */
    String  getAll(int index,int pagesize);

    /**
     * 查询全部分类信息
     * @return
     */
    String getAlll(int index,int pagesize);

    /**
     * 根据商品分类展示用户信息
     * @return
     */
    String getInfoByType(Integer categorie_id,int index,int pagesize);
}
