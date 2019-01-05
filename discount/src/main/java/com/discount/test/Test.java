package com.discount.test;

import redis.clients.jedis.Jedis;

public class Test {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("148.70.68.230",6379);

        System.out.println(jedis.get("userid"));
    }
}
