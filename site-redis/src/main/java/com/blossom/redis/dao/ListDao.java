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
}
