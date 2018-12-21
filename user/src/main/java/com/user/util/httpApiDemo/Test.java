package com.user.util.httpApiDemo;

import redis.clients.jedis.Jedis;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Jedis jedis = new Jedis("localhost",6379);
		System.out.println("-------------");

		/*jedis.set("authcode","123456");
		jedis.set("authcode","123456789");

		System.out.println(jedis.get("authcode"));*/


	}

}
