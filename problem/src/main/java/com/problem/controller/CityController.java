package com.problem.controller;

import com.problem.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: CityController
 * Author:   Administrator
 * Date:     2018/12/19 9:37
 * Description:
 * History:
 * 作者姓名           修改时间           版本号              描述
 * <p>
 * //                            _ooOoo_  
 * //                           o8888888o  
 * //                           88" . "88  
 * //                           (| -_- |)  
 * //                            O\ = /O  
 * //                        ____/`---'\____  
 * //                      .   ' \\| |// `.  
 * //                       / \\||| : |||// \  
 * //                     / _||||| -:- |||||- \  
 * //                       | | \\\ - /// | |  
 * //                     | \_| ''\---/'' | |  
 * //                      \ .-\__ `-` ___/-. /  
 * //                   ___`. .' /--.--\ `. . __  
 * //                ."" '< `.___\_<|>_/___.' >'"".  
 * //               | | : `- \`.;`\ _ /`;.`/ - ` : | |  
 * //                 \ \ `-. \_ __\ /__ _/ .-` / /  
 * //         ======`-.____`-.___\_____/___.-`____.-'======  
 * //                            `=---='  
 * //  
 * //         .............................................  
 * //                  佛祖镇楼                 BUG辟易  
 * //          佛曰:  
 * //                  写字楼里写字间，写字间里程序员；  
 * //                  程序人员写程序，又拿程序换酒钱。  
 * //                  酒醒只在网上坐，酒醉还来网下眠；  
 * //                  酒醉酒醒日复日，网上网下年复年。  
 * //                  但愿老死电脑间，不愿鞠躬老板前；  
 * //                  奔驰宝马贵者趣，公交自行程序员。  
 * //                  别人笑我忒疯癫，我笑自己命太贱；  
 * //                  不见满街漂亮妹，哪个归得程序员？ 
 * <p>
 * package com.problem.controller;
 * <p>
 * /**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2018/12/19
 * @since 1.0.0
 */
@RequestMapping("city/")
@Controller
public class CityController {
    @Autowired
    private CityService cityService;

    @ResponseBody
    @RequestMapping("city")
    public String getall(){
        String getall = cityService.getall();
        return getall;
    }
}