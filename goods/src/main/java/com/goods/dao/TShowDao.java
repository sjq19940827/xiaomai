package com.goods.dao;

import com.goods.pojo.TAreainfo;
import com.goods.pojo.TCategorie;
import com.goods.pojo.TShow;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface TShowDao {
    /**
     * 查询全部
     * @return
     */
  List<TShow> getAll();

    /**
     * 查询全部分类信息
     * @return
     */
  List<TCategorie> getAlll();

    /**
     * 根据商品分类展示用户信息
     * @return
     */
  List<TShow> getInfoByType(Integer categorie_id);

 }
