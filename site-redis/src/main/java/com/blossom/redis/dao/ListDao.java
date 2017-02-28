package com.blossom.redis.dao;

import com.blossom.redis.JedisUtils;

/**
 * @Description:list类型操作
 * @author Blossom
 * @time 2017年2月28日 下午5:57:21
 */
public class ListDao {
	
	/**
	 * @Description: 添加数据到队列(顺序存储)
	 * @author Blossom
	 * @time 2017年2月28日 下午6:45:08 
	 * @return_type void
	 *
	 */
	public void save(String key,String...valus){
		JedisUtils.getJedis().lpush(key, valus);
	}
	
	/**
	 * @Description: 添加数据到队列(顺序存储)
	 * @author Blossom
	 * @time 2017年2月28日 下午6:46:38 
	 * @return_type void
	 *
	 */
	public void save(byte[]key,byte[]...values){
		JedisUtils.getJedis().lpush(key, values);
	}

	/**
	 * @Description:添加数据到队列(反向存储) 
	 * @author Blossom
	 * @time 2017年2月28日 下午6:47:41 
	 * @return_type void
	 *
	 */
	public void rsave(String key,String...values){
		JedisUtils.getJedis().rpush(key, values);
	}
	
	/**
	 * @Description: 添加数据到队列(反向存储) 
	 * @author Blossom
	 * @time 2017年2月28日 下午6:48:37 
	 * @return_type void
	 *
	 */
	public void rsave(byte[] key,byte[]...values){
		JedisUtils.getJedis().rpush(key, values);
	}
}
