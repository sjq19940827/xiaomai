package com.user.service;

import com.user.pojo.T_address;

public interface T_addressService {
    /**
     * 展示登录用户的收货地址
     * @return
     */
    String getUserAddress();



    /**
     * 新增收货地址
     * @param address
     * @return
     */
    String addAddress(T_address address);

    /**
     * 删除地址
     * @param id
     * @return
     */
    String delAddress(Long id);
}
