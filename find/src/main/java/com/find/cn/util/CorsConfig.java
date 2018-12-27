/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: Corsconfig
 * Author:   13654
 * Date:     2018/11/24 18:04
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.find.cn.util;
/**
 * @author Tzy
 * @date 2018/11/21 9:08 AM
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {
    private CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        //1
        corsConfiguration.addAllowedOrigin("*");
        //2
        corsConfiguration.addAllowedHeader("*");
        //3
        corsConfiguration.addAllowedMethod("*");
        return corsConfiguration;
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        //4
        source.registerCorsConfiguration("/**", buildConfig());
        return new CorsFilter(source);
    }
}

