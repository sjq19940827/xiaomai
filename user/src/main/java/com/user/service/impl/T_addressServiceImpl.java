package com.user.service.impl;

import com.alibaba.fastjson.JSON;
import com.user.dao.T_addressDao;
import com.user.pojo.T_address;
import com.user.pojo.T_user;
import com.user.service.T_addressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service("TASI")
public class T_addressServiceImpl implements T_addressService {
    @Autowired
    private T_addressDao tad;
    public T_addressDao getTad() {
        return tad;
    }
    public void setTad(T_addressDao tad) {
        this.tad = tad;
    }

    /**
     * 获取用户的收货地址
     * @return
     */
    @Override
    public String getUserAddress() {
        Jedis jedis = new Jedis("148.70.68.230",6379);
        T_address address = new T_address();
        if(getuserid() == null){
            return "没有用户";
        }else {
            address.setUser_id(getuserid());
            if(tad.seleaddress(address) == null){
                return "您还没有添加收货地址呢，快去添加哦";
            }else {
                String userAddress = JSON.toJSONString(tad.seleaddress(address));
                return userAddress;
            }
        }
    }

    /**
     * 获取用户的id
     * @return
     */
    public Integer getuserid() {
        Jedis jedis = new Jedis("148.70.68.230",6379);
        T_user user = new T_user();
        user.setLogin_phone(jedis.get("loginphone"));
        System.out.println(jedis.get("loginphone"));
        if(tad.seleuserid(user) != null){
            System.out.println(999999);
            Integer userid = tad.seleuserid(user).getId();
            return userid;
        }else {
            return null;
        }
    }

    /**
     * 新增收货地址
     * @param address
     * @return
     */
    @Override
    public String addAddress(T_address address) {
        address.setAddress_id(Long.valueOf(0));
        address.setAddress_alias("新增地址");
        address.setTele_phone("111111");
        address.setPreferred(0);
        System.out.println(getuserid()+"654321");
        address.setUser_id(getuserid());
        Jedis jedis = new Jedis("148.70.68.230",6379);
        if(address.getAddress_addressee().length() < 1 || address.getAddress_addressee().length() > 10){
            return "用户名不合理";
        }else {
            if(judgephone(jedis.get("loginphone"))){
                int judge = tad.addAddress(address);
                if(judge > 0){
                    return "新增成功";
                }else {
                    return "新增失败";
                }
            }else {
                return "手机号不合理";
            }
        }
    }

    /**
     * 删除收货地址
     * @param id
     * @return
     */
    @Override
    public String delAddress(Long id) {
        T_address address = new T_address();
        address.setAddress_id(id);
        int judge = tad.delAddress(address);
        if(judge > 0){
            return "删除成功";
        }else {
            return "删除失败";
        }
    }

    /**
     * 判断手机号的合法性
     * @param phone
     * @return
     */
    public boolean judgephone(String phone){
        String regex = "^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\\d{8}$" ;
        if(phone.length() == 11){
            System.out.println(1);
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(phone);
            boolean judgephone = matcher.matches();
            System.out.println(judgephone);
            if(judgephone == true){
                return true;
            }else {
                System.out.println(2);
                return false;
            }
        }else {
            System.out.println(3);
            return false;
        }
    }
}
