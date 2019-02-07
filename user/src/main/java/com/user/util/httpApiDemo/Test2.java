package com.user.util.httpApiDemo;

import redis.clients.jedis.Jedis;

public class Test2 {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("148.70.68.230",6379);
       /* jedis.auth("shuai918");*/

        jedis.set("userid","1111");
        System.out.println(jedis.get("lll"));
    }
}
