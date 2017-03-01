package com.blossom.redis.dao;

import java.util.Map;

import com.blossom.redis.JedisUtils;

/**
 * @Description:有序集合类型操作
 * @author Blossom
 * @time 2017年2月28日 下午5:57:56
 */
public class SortSetDao {

	/**
	 * @Description: 向有序集合添加一个或多个成员，或者更新已存在成员的分数
	 * @author Blossom
	 * @time 2017年3月1日 上午11:11:17 
	 * @return_type void
	 *
	 */
	public void zadd(String key,Map<String, Double> scoreMembers){
		JedisUtils.getJedis().zadd(key, scoreMembers);
	}
	
	/**
	 * @Description: 向有序集合添加一个或多个成员，或者更新已存在成员的分数
	 * @author Blossom
	 * @time 2017年3月1日 上午11:11:17 
	 * @return_type void
	 *
	 */
	public void zadd(byte[] key,Map<byte[], Double> scoreMembers){
		JedisUtils.getJedis().zadd(key, scoreMembers);
	}
	
	/**
	 * @Description:获取有序集合的成员数 
	 * @author Blossom
	 * @time 2017年3月1日 上午11:12:23 
	 * @return_type Long
	 *
	 */
	public Long zcard(String key){
		return JedisUtils.getJedis().zcard(key);
	}
	
	/**
	 * @Description:获取有序集合的成员数 
	 * @author Blossom
	 * @time 2017年3月1日 上午11:12:52 
	 * @return_type Long
	 *
	 */
	public Long zcard(byte[] key){
		return JedisUtils.getJedis().zcard(key);
	}
}
