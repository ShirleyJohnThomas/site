package com.blossom.site.base;

import com.blossom.site.util.SystemExceptionEnum;
import com.blossom.tools.exception.SystemExceptionUtils;
import com.blossom.tools.log.LoggerUtils;
import com.blossom.tools.object.ObjectUtils;
import com.blossom.tools.string.StringUtils;
import com.mongodb.MongoClient;

/**
 * @Description: 连接mongoDB数据库
 * @author Blossom
 * @time 2017年2月27日 下午4:30:45
 */
public class Connection {
	
	private static final Class<?> CLASS = Connection.class;

	//私有化构造方法
	private Connection(){}
	
	/**
	 * @Description: 获取mongoClient对象
	 * @author Blossom
	 * @time 2017年2月27日 下午4:51:41 
	 * @return_type MongoClient
	 *
	 */
	public static MongoClient getInstall(String host,Integer port) throws SystemExceptionUtils{
		if (StringUtils.isEmpty(host) || ObjectUtils.isEmpty(port)) {
			LoggerUtils.addLoggerError(CLASS, "getInstall", "连接参数不全!");
			throw new SystemExceptionUtils(SystemExceptionEnum.SYSTEM_INCOMPLETE_PARAMETER_ERROR.toString());
		}
		return new MongoClient(host,port);
	}
	
}
