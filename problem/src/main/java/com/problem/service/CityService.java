/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: CityService
 * Author:   Administrator
 * Date:     2018/12/19 9:30
 * Description:
 * History:
 * 作者姓名           修改时间           版本号              描述
 * <p>
 * <p>
 * /**
 * _ooOoo_
 * o8888888o
 * 88" . "88
 * (| -_- |)
 * O\ = /O
 * ___/`---'\____
 * .   ' \\| |// `.
 * / \\||| : |||// \
 * / _||||| -:- |||||- \
 * | | \\\ - /// | |
 * | \_| ''\---/'' | |
 * \ .-\__ `-` ___/-. /
 * ___`. .' /--.--\ `. . __
 * ."" '< `.___\_<|>_/___.' >'"".
 * | | : `- \`.;`\ _ /`;.`/ - ` : | |
 * \ \ `-. \_ __\ /__ _/ .-` / /
 * ======`-.____`-.___\_____/___.-`____.-'======
 * `=---='
 * .............................................
 * 佛曰：bug泛滥，我已瘫痪！
 */

package com.problem.service;

import com.alibaba.fastjson.JSON;
import com.problem.dao.CityDao;
import com.problem.pojo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2018/12/19
 * @since 1.0.0
 */
@Service
public class CityService{
    @Autowired
    @Qualifier("cd")
    private CityDao cityDao;

    public String getall(){
        List<City> getall = cityDao.getall();
        String s = JSON.toJSONString(getall);
        return s;
    }
}
