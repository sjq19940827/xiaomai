package com.user.util.httpApiDemo;

import redis.clients.jedis.Jedis;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Jedis jedis = new Jedis();

		String asd = "aaas";
		jedis.set(asd,"范文泽是傻逼");
		jedis.get(asd);
		String asdf = "utf" + jedis.get(asd) + "asd";
		jedis.set(asdf,"17254241325");
		System.out.println(jedis.get(asdf));

	}

}
