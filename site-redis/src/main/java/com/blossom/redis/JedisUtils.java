package com.blossom.redis;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @Description:reids连接池设置
 * @author Blossom
 * @time 2017年2月28日 下午5:30:51
 */
public class JedisUtils {

	private static String jedisIp;
	private static Integer jedisPort;
	// private static String jedisPassword;
	// private static String jedisUserName;
	private static JedisPool jedisPool;
	private static JedisPoolConfig config;
	private static Properties properties;
	private static InputStream input;

	static {
		try {
			input = JedisUtils.class.getClassLoader().getResourceAsStream("redis.properties");
			properties = new Properties();
			properties.load(input);
			config = new JedisPoolConfig();
			config.setMinIdle(256);
			config.setMaxWaitMillis(5000L);
			config.setTestOnBorrow(true);
			config.setTestOnReturn(true);
			config.setTestWhileIdle(true);
			config.setMinEvictableIdleTimeMillis(60000L);
			config.setTimeBetweenEvictionRunsMillis(3000L);
			config.setNumTestsPerEvictionRun(-1);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("EXCEPTION: " + e.getMessage());
		}

	}

	/**
	 * @Description: 获取JedisPool实例
	 * @author Blossom
	 * @time 2017年2月28日 下午5:45:17
	 * @return_type JedisPool
	 *
	 */
	public static JedisPool getJedisPool() {
		jedisPool = new JedisPool(config, jedisIp, jedisPort);
		return jedisPool;
	}

	/**
	 * @Description: 获取Jedis对象
	 * @author Blossom
	 * @time 2017年2月28日 下午5:47:02
	 * @return_type Jedis
	 *
	 */
	public static Jedis getJedis() {
		return getJedisPool().getResource();
	}

	/**
	 * @Description: 释放资源
	 * @author Blossom
	 * @time 2017年2月28日 下午5:54:19
	 * @return_type void
	 *
	 */
	public static void close(Jedis jedis) {
		try {
			jedisPool.returnResource(jedis);
		} catch (Exception e) {
			if (jedis.isConnected()) {
				jedis.quit();
				jedis.disconnect();
			}
		}
	}

}
