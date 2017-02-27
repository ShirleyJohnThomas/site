package com.blossom.site.base;


import com.blossom.site.util.SystemExceptionEnum;
import com.blossom.tools.exception.SystemExceptionUtils;
import com.blossom.tools.object.ObjectUtils;
import com.blossom.tools.string.StringUtils;
import com.mongodb.DB;
import com.mongodb.MongoClient;

/**
 * @Description:数据库操作
 * @author Blossom
 * @time 2017年2月27日 下午4:56:23
 */
public class DBBase {
	
	private static final DBBase DB_BASE = new DBBase();
	private static MongoClient mongoClient = null;
	
	//私有化构造方法
	private DBBase(){};
	
	/**
	 * @Description: 获取DBBase对象
	 * @author Blossom
	 * @throws SystemExceptionUtils 
	 * @time 2017年2月27日 下午4:59:10 
	 * @return_type DBBase
	 *
	 */
	public static DBBase getInstall(MongoClient mongoClient) throws SystemExceptionUtils{
		if (ObjectUtils.isEmpty(mongoClient)) {
			throw new SystemExceptionUtils(SystemExceptionEnum.SYSTEM_INVOMPLELE_CONFIGDATABASE_ERROR.toString());
		}
		DBBase.mongoClient = mongoClient;
		return DB_BASE;
	}

	/**
	 * @Description: 获取DB实例
	 * @author Blossom
	 * @time 2017年2月27日 下午5:02:48 
	 * @return_type DB
	 *
	 */
	@SuppressWarnings("deprecation")
	public DB getDB(String dbName) throws SystemExceptionUtils{
		if (StringUtils.isEmpty(dbName)) {
			throw new SystemExceptionUtils(SystemExceptionEnum.SYSTEM_INVOMPLELE_DATABASE_ERROR.toString());
		}
		return DBBase.mongoClient.getDB(dbName);
	}
	
	/**
	 * @Description: 关闭MongoDB连接
	 * @author Blossom
	 * @time 2017年2月27日 下午5:03:34 
	 * @return_type void
	 *
	 */
	public void close(){
		DBBase.mongoClient.close();
	}
	
}
