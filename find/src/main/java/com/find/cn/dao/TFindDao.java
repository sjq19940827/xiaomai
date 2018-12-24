package com.find.cn.dao;

import com.find.cn.pojo.TFind;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TFindDao {
    /**
     * 查询咨询
     * @param show_id
     * @return
     */
    List<TFind> getAllInfo(Integer show_id);
}
