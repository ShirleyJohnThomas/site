package com.blossom.redis.dao;

import com.blossom.redis.JedisUtils;

import redis.clients.jedis.BinaryClient.LIST_POSITION;

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
	 * @Description:添加数据到队列 (顺序存储)
	 * @author Blossom
	 * @time 2017年3月1日 上午10:33:26 
	 * @return_type void
	 *
	 */
	public void savenx(String key,String...values){
		JedisUtils.getJedis().lpushx(key, values);
	}
	
	/**
	 * @Description: 添加数据到队列 (顺序存储)
	 * @author Blossom
	 * @time 2017年3月1日 上午10:34:20 
	 * @return_type void
	 *
	 */
	public void savenx(byte[] key,byte[]...values){
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
	
	/**
	 * @Description: 为已经存在的列表添加值(反向存储)
	 * @author Blossom
	 * @time 2017年3月1日 上午10:30:32 
	 * @return_type void
	 *
	 */
	public void rsavenx(String key,String...values){
		JedisUtils.getJedis().rpushx(key, values);
	}
	
	/**
	 * @Description: 为已经存在的列表添加值(反向存储) 
	 * @author Blossom
	 * @time 2017年3月1日 上午10:31:37 
	 * @return_type void
	 *
	 */
	public void rsavenx(byte[] key,byte[]...values){
		JedisUtils.getJedis().rpushx(key, values);
	}
	
	/**
	 * @Description: 将列表最后一个元素弹出，并返回给客户端
	 * @author Blossom
	 * @time 2017年2月28日 下午6:57:50 
	 * @return_type void
	 *
	 */
	public void rget(String srckey,String dstkey){
		JedisUtils.getJedis().rpoplpush(srckey, dstkey);
	}
	
	/**
	 * @Description: 将列表最后一个元素弹出，并返回给客户端
	 * @author Blossom
	 * @time 2017年2月28日 下午6:57:50 
	 * @return_type void
	 *
	 */
	public void rget(byte[] srckey,byte[] dstkey){
		JedisUtils.getJedis().rpoplpush(srckey, dstkey);
	}
	
	/**
	 * @Description: 获取队列数据(顺序)
	 * @author Blossom
	 * @time 2017年2月28日 下午6:59:57 
	 * @return_type byte[]
	 *
	 */
	public byte[] getList(byte[] key){
		return JedisUtils.getJedis().lpop(key);
	}
	
	/**
	 * @Description: 获取队列数据(顺序)
	 * @author Blossom
	 * @time 2017年2月28日 下午7:00:49 
	 * @return_type String
	 *
	 */
	public String getList(String key){
		return JedisUtils.getJedis().lpop(key);
	}
	
	/**
	 * @Description:获取队列数据(反向) 
	 * @author Blossom
	 * @time 2017年2月28日 下午7:01:45 
	 * @return_type String
	 *
	 */
	public String rgetList(String key){
		return JedisUtils.getJedis().rpop(key);
	}
	
	/**
	 * @Description:获取队列数据(反向)  
	 * @author Blossom
	 * @time 2017年2月28日 下午7:02:44 
	 * @return_type byte[]
	 *
	 */
	public byte[] rgetList(byte[] key){
		return JedisUtils.getJedis().rpop(key);
	}
	
	/**
	 * @Description: 获取指定索引的值
	 * @author Blossom
	 * @time 2017年3月1日 上午10:35:37 
	 * @return_type String
	 *
	 */
	public String getByIndex(String key,Long index){
		return JedisUtils.getJedis().lindex(key, index);
	}
	
	/**
	 * @Description: 获取指定索引的值
	 * @author Blossom
	 * @time 2017年3月1日 上午10:36:16 
	 * @return_type byte[]
	 *
	 */
	public byte[] getByIndex(byte[] key,Long index){
		return JedisUtils.getJedis().lindex(key, index);
	}
	
	/**
	 * @Description:获取列表长度 
	 * @author Blossom
	 * @time 2017年3月1日 上午10:37:46 
	 * @return_type Long
	 *
	 */
	public Long getListLength(String key){
		return JedisUtils.getJedis().llen(key);
	}
	
	/**
	 * @Description:获取列表长度 
	 * @author Blossom
	 * @time 2017年3月1日 上午10:37:46 
	 * @return_type Long
	 *
	 */
	public Long getListLength(byte[] key){
		return JedisUtils.getJedis().llen(key);
	}
	
	/**
	 * @Description: 在列表的元素前或者后插入元素
	 * @author Blossom
	 * @time 2017年3月1日 上午10:39:51 
	 * @return_type void
	 *
	 */
	public void linsert(String key, LIST_POSITION where, String pivot, String value){
		JedisUtils.getJedis().linsert(key, where, pivot, value);
	}
	
	/**
	 * @Description: 在列表的元素前或者后插入元素
	 * @author Blossom
	 * @time 2017年3月1日 上午10:39:51 
	 * @return_type void
	 *
	 */
	public void linsert(byte[] key, LIST_POSITION where, byte[] pivot, byte[] value){
		JedisUtils.getJedis().linsert(key, where, pivot, value);
	}
}
