package com.blossom.redis.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.blossom.redis.JedisUtils;

/**
 * @Description:哈希类型操作
 * @author Blossom
 * @time 2017年2月28日 下午5:57:42
 */
public class HashDao {

	/**
	 * @Description:删除一个或多个哈希表字段
	 * @author Blossom
	 * @time 2017年3月1日 上午10:48:04 
	 * @return_type void
	 *
	 */
	public void hdel(String key,String...fields){
		JedisUtils.getJedis().hdel(key, fields);
	}
	
	/**
	 * @Description: 删除一个或多个哈希表字段
	 * @author Blossom
	 * @time 2017年3月1日 上午10:48:55 
	 * @return_type void
	 *
	 */
	public void hdel(byte[] key,byte[]...fields){
		JedisUtils.getJedis().hdel(key, fields);
	}
	
	/**
	 * @Description:查看哈希表 key 中，指定的字段是否存在 
	 * @author Blossom
	 * @time 2017年3月1日 上午10:50:25 
	 * @return_type void
	 *
	 */
	public void hexists(String key,String field){
		JedisUtils.getJedis().hexists(key, field);
	}
	
	/**
	 * @Description:查看哈希表 key 中，指定的字段是否存在 
	 * @author Blossom
	 * @time 2017年3月1日 上午10:51:19 
	 * @return_type void
	 *
	 */
	public void hexists(byte[] key,byte[] field){
		JedisUtils.getJedis().hexists(key, field);
	}
	
	/**
	 * @Description:获取存储在哈希表中指定字段的值
	 * @author Blossom
	 * @time 2017年3月1日 上午10:52:16 
	 * @return_type String
	 *
	 */
	public String hget(String key,String field){
		return JedisUtils.getJedis().hget(key, field);
	}
	
	/**
	 * @Description:获取存储在哈希表中指定字段的值 
	 * @author Blossom
	 * @time 2017年3月1日 上午10:53:00 
	 * @return_type byte[]
	 *
	 */
	public byte[] hget(byte[] key,byte[] field){
		return JedisUtils.getJedis().hget(key, field);
	}
	
	/**
	 * @Description: 获取在哈希表中指定 key 的所有字段和值
	 * @author Blossom
	 * @time 2017年3月1日 上午10:54:03 
	 * @return_type Map<String,String>
	 *
	 */
	public Map<String, String> hgetAll(String key){
		return JedisUtils.getJedis().hgetAll(key);
	}
	
	/**
	 * @Description: 获取在哈希表中指定 key 的所有字段和值
	 * @author Blossom
	 * @time 2017年3月1日 上午10:54:47 
	 * @return_type Map<byte[],byte[]>
	 *
	 */
	public Map<byte[], byte[]> hgetAll(byte[] key){
		return JedisUtils.getJedis().hgetAll(key);
	}
	
	/**
	 * @Description:获取所有哈希表中的字段 
	 * @author Blossom
	 * @time 2017年3月1日 上午10:56:02 
	 * @return_type Set<String>
	 *
	 */
	public Set<String> getKey(String key){
		return JedisUtils.getJedis().hkeys(key);
	}
	
	/**
	 * @Description:获取所有哈希表中的字段
	 * @author Blossom
	 * @time 2017年3月1日 上午10:56:33 
	 * @return_type Set<byte[]>
	 *
	 */
	public Set<byte[]> getKey(byte[] key){
		return JedisUtils.getJedis().hkeys(key);
	}
	
	/**
	 * @Description:获取所有给定字段的值 
	 * @author Blossom
	 * @time 2017年3月1日 上午10:57:39 
	 * @return_type List<String>
	 *
	 */
	public List<String> hmget(String key,String...fields){
		return JedisUtils.getJedis().hmget(key, fields);
	}
	
	/**
	 * @Description:获取所有给定字段的值 
	 * @author Blossom
	 * @time 2017年3月1日 上午10:57:39 
	 * @return_type List<String>
	 *
	 */
	public List<byte[]> hmget(byte[] key,byte[]...fields){
		return JedisUtils.getJedis().hmget(key, fields);
	}
	
	/**
	 * @Description:同时将多个 field-value (域-值)对设置到哈希表 key 中。 
	 * @author Blossom
	 * @time 2017年3月1日 上午10:59:17 
	 * @return_type void
	 *
	 */
	public void hmset(String key, Map<String, String> hash){
		 JedisUtils.getJedis().hmset(key, hash);
	}
	
	/**
	 * @Description:同时将多个 field-value (域-值)对设置到哈希表 key 中。 
	 * @author Blossom
	 * @time 2017年3月1日 上午10:59:17 
	 * @return_type void
	 *
	 */
	public void hmset(byte[] key, Map<byte[], byte[]> hash){
		 JedisUtils.getJedis().hmset(key, hash);
	}
	
	/**
	 * @Description:将哈希表 key 中的字段 field 的值设为 value 。 
	 * @author Blossom
	 * @time 2017年3月1日 上午11:00:25 
	 * @return_type void
	 *
	 */
	public void hset(String key,String field,String value){
		JedisUtils.getJedis().hset(key, field, value);
	}
	
	/**
	 * @Description:将哈希表 key 中的字段 field 的值设为 value 。 
	 * @author Blossom
	 * @time 2017年3月1日 上午11:00:25 
	 * @return_type void
	 *
	 */
	public void hset(byte[] key,byte[] field,byte[] value){
		JedisUtils.getJedis().hset(key, field, value);
	}
	
	/**
	 * @Description:只有在字段 field 不存在时，设置哈希表字段的值 
	 * @author Blossom
	 * @time 2017年3月1日 上午11:01:33 
	 * @return_type void
	 *
	 */
	public void hsetnx(String key,String field,String value){
		JedisUtils.getJedis().hsetnx(key, field, value);
	}
	
	/**
	 * @Description:只有在字段 field 不存在时，设置哈希表字段的值 
	 * @author Blossom
	 * @time 2017年3月1日 上午11:01:33 
	 * @return_type void
	 *
	 */
	public void hsetnx(byte[] key,byte[] field,byte[] value){
		JedisUtils.getJedis().hsetnx(key, field, value);
	}
}
 