package com.blossom.redis.dao;

import java.util.Set;

import com.blossom.redis.JedisUtils;

/**
 * @Description:集合类型操作
 * @author Blossom
 * @time 2017年2月28日 下午5:57:29
 */
public class SetDao {

	/**
	 * @Description:向集合添加一个或多个成员 
	 * @author Blossom
	 * @time 2017年3月1日 上午11:04:07 
	 * @return_type void
	 *
	 */
	public void sadd(String key,String...values){
		JedisUtils.getJedis().sadd(key, values);
	}
	
	/**
	 * @Description:向集合添加一个或多个成员 
	 * @author Blossom
	 * @time 2017年3月1日 上午11:04:07 
	 * @return_type void
	 *
	 */
	public void sadd(byte[] key,byte[]...values){
		JedisUtils.getJedis().sadd(key, values);
	}
	
	/**
	 * @Description:获取集合的成员数 
	 * @author Blossom
	 * @time 2017年3月1日 上午11:05:31 
	 * @return_type Long
	 *
	 */
	public Long scard(String key){
		return JedisUtils.getJedis().scard(key);
	}
	
	/**
	 * @Description:获取集合的成员数 
	 * @author Blossom
	 * @time 2017年3月1日 上午11:05:31 
	 * @return_type Long
	 *
	 */
	public Long scard(byte[] key){
		return JedisUtils.getJedis().scard(key);
	}
	
	/**
	 * @Description:返回集合中的所有成员 
	 * @author Blossom
	 * @time 2017年3月1日 上午11:07:22 
	 * @return_type Set<String>
	 *
	 */
	public Set<String> smembers(String key){
		return JedisUtils.getJedis().smembers(key);
	}
	
	/**
	 * @Description:返回集合中的所有成员 
	 * @author Blossom
	 * @time 2017年3月1日 上午11:07:22 
	 * @return_type Set<String>
	 *
	 */
	public Set<byte[]> smembers(byte[] key){
		return JedisUtils.getJedis().smembers(key);
	}
	
}
