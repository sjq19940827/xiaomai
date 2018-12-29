package com.user.util.httpApiDemo;

import redis.clients.jedis.Jedis;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Jedis jedis = new Jedis("localhost",6379);
		jedis.set("fsb","范文泽是傻逼");
		jedis.get("fsb");
		System.out.println(jedis.get("fsb") != null ? "y" : "e");

	}

}
