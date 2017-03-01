package com.blossom.redis.dao;

import java.util.List;


import com.blossom.redis.JedisUtils;


/**
 * @Description:String类型操作
 * @author Blossom
 * @time 2017年2月28日 下午5:56:58
 */
public class StringDao {
	
	/**
	 * @Description: 添加数据
	 * @author Blossom
	 * @time 2017年2月28日 下午6:03:59 
	 * @return_type void
	 *
	 */
	public void save(String key,String value){
		 JedisUtils.getJedis().set(key, value);
	}
	
	/**
	 * @Description: 添加数据并且设置有效期
	 * @author Blossom
	 * @time 2017年2月28日 下午6:11:44 
	 * @return_type void
	 *
	 */
	public void save(String key,String value,int time){
		 JedisUtils.getJedis().set(key, value);
		 JedisUtils.getJedis().expire(key,time);
	}
	
	/**
	 * @Description: 添加数据
	 * @author Blossom
	 * @time 2017年2月28日 下午6:09:55 
	 * @return_type String
	 *
	 */
	public void save(byte[] key,byte[] value){
		 JedisUtils.getJedis().set(key, value);
	}
	
	/**
	 * @Description: 添加数据并设置有效期
	 * @author Blossom
	 * @time 2017年2月28日 下午6:12:19 
	 * @return_type void
	 *
	 */
	public void save(byte[] key,byte[] value,int time){
		 JedisUtils.getJedis().set(key, value);
		 JedisUtils.getJedis().expire(key, time);
	}
	
	/**
	 * @Description: 同时设置多个keyvalue值
	 * @author Blossom
	 * @time 2017年3月1日 上午10:18:48 
	 * @return_type void
	 *
	 */
	public void msave(String...keysvalues){
		JedisUtils.getJedis().mset(keysvalues);
	}
	
	/**
	 * @Description:同时设置多个keyvalue值 
	 * @author Blossom
	 * @time 2017年3月1日 上午10:19:41 
	 * @return_type void
	 *
	 */
	public void msave(byte[]...keysvalues){
		JedisUtils.getJedis().mset(keysvalues);
	}
	
	/**
	 * @Description: 设置key对应的value值（只有当key不存在才能执行成功）
	 * @author Blossom
	 * @time 2017年3月1日 上午10:21:05 
	 * @return_type void
	 *
	 */
	public void savenx(String key,String value){
		JedisUtils.getJedis().setnx(key, value);
	}
	
	/**
	 * @Description: 设置key对应的value值（只有当key不存在才能执行成功）
	 * @author Blossom
	 * @time 2017年3月1日 上午10:21:05 
	 * @return_type void
	 *
	 */
	public void savenx(byte[] key,byte[] value){
		JedisUtils.getJedis().setnx(key, value);
	}
	
	/**
	 * @Description:同时设置多个keyvalue值 （只有当key不存在才能执行成功） 
	 * @author Blossom
	 * @time 2017年3月1日 上午10:23:09 
	 * @return_type void
	 *
	 */
	public void msavenx(byte[]...keysvalues){
		JedisUtils.getJedis().msetnx(keysvalues);
	}

	/**
	 * @Description:同时设置多个keyvalue值  （只有当key不存在才能执行成功）
	 * @author Blossom
	 * @time 2017年3月1日 上午10:23:35 
	 * @return_type void
	 *
	 */
	public void msavenx(String...keysvalues){
		JedisUtils.getJedis().msetnx(keysvalues);
	}

	
	/**
	 * @Description: 追加字符串
	 * @author Blossom
	 * @time 2017年2月28日 下午6:35:19 
	 * @return_type void
	 *
	 */
	public void append(String key,String value){
		JedisUtils.getJedis().append(key, value);
	}
	
	/**
	 * @Description: 追加字符串
	 * @author Blossom
	 * @time 2017年2月28日 下午6:36:08 
	 * @return_type void
	 *
	 */
	public void append(byte[] key,byte[] value){
		JedisUtils.getJedis().append(key, value);
	}
	
	/**
	 * @Description: 获取指定的值
	 * @author Blossom
	 * @time 2017年2月28日 下午6:17:25 
	 * @return_type String
	 *
	 */
	public String get(String key){
		return JedisUtils.getJedis().get(key);
	}
	
	/**
	 * @Description: 获取指定的值
	 * @author Blossom
	 * @time 2017年2月28日 下午6:18:16 
	 * @return_type byte[]
	 *
	 */
	public byte[] get(byte[] key){
		return JedisUtils.getJedis().get(key);
	}
	
	/**
	 * @Description: 获取多个key对应的值
	 * @author Blossom
	 * @time 2017年3月1日 上午10:15:37 
	 * @return_type List<String>
	 *
	 */
	public List<String> mget(String...keys){
		return JedisUtils.getJedis().mget(keys);
	}
	
	/**
	 * @Description: 获取多个key对应的值
	 * @author Blossom
	 * @time 2017年3月1日 上午10:17:16 
	 * @return_type List<byte[]>
	 *
	 */
	public List<byte[]> mget(byte[]...keys){
		return JedisUtils.getJedis().mget(keys);
	}
	
	/**
	 * @Description: 获取指定位置的数据
	 * @author Blossom
	 * @time 2017年2月28日 下午6:32:54 
	 * @return_type String
	 *
	 */
	public String getrange(String key,long startOffset,long endOffset){
		return JedisUtils.getJedis().getrange(key, startOffset, endOffset);
	}
	
	/**
	 * @Description: 获取指定位置的数据
	 * @author Blossom
	 * @time 2017年2月28日 下午6:34:01 
	 * @return_type byte[]
	 *
	 */
	public byte[] getrange(byte[]key,long startOffset,long endOffset){
		return JedisUtils.getJedis().getrange(key, startOffset, endOffset);
	}
	
	/**
	 * @Description: 更新值，并且返回旧的值
	 * @author Blossom
	 * @time 2017年2月28日 下午6:19:36 
	 * @return_type String
	 *
	 */
	public String update(String key,String value){
		return JedisUtils.getJedis().getSet(key, value);
	}
	
	/**
	 * @Description: 更新值并且返回旧的值
	 * @author Blossom
	 * @time 2017年2月28日 下午6:20:24 
	 * @return_type byte[]
	 *
	 */
	public byte[] update(byte[] key,byte[] value){
		return JedisUtils.getJedis().getSet(key, value);
	}

	/**
	 * @Description: 删除数据
	 * @author Blossom
	 * @time 2017年2月28日 下午6:27:27 
	 * @return_type void
	 *
	 */
	public void delete(String key){
		JedisUtils.getJedis().del(key);
	}
	
	/**
	 * @Description: 删除数据
	 * @author Blossom
	 * @time 2017年2月28日 下午6:28:09 
	 * @return_type void
	 *
	 */
	public void delete(byte[] key){
		JedisUtils.getJedis().del(key);
	}
	
	/**
	 * @Description: 批量删除数据
	 * @author Blossom
	 * @time 2017年2月28日 下午6:29:14 
	 * @return_type void
	 *
	 */
	public void batchDelete(String...keys){
		JedisUtils.getJedis().del(keys);
	}
	
	/**
	 * @Description: 批量删除数据
	 * @author Blossom
	 * @time 2017年2月28日 下午6:30:00 
	 * @return_type void
	 *
	 */
	public void batchDelete(byte[]...keys){
		JedisUtils.getJedis().del(keys);
	}
}
