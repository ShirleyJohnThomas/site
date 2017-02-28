package com.blossom.site.collection;

import com.blossom.site.util.SystemExceptionEnum;
import com.blossom.tools.exception.SystemExceptionUtils;
import com.blossom.tools.log.LoggerUtils;
import com.blossom.tools.object.ObjectUtils;
import com.blossom.tools.string.StringUtils;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

/**
 * @Description:集合操作(表)
 * @author Blossom
 * @time 2017年2月27日 下午5:05:41
 */
public class Collection {
	
	private static final Class<?> CLAZZ = Collection.class;
	
	private static final Collection COLLECTION = new Collection();
	private static DB db = null;
	
	private Collection(){}
	
	/**
	 * @Description: 获取Collection实例
	 * @author Blossom
	 * @throws SystemExceptionUtils 
	 * @time 2017年2月27日 下午5:07:28 
	 * @return_type Collection
	 *
	 */
	public static Collection getInstall(DB db) throws SystemExceptionUtils{
		if (ObjectUtils.isEmpty(db)) {
			LoggerUtils.addLoggerError(CLAZZ, "getInstall", "数据库不存在!");
			throw new SystemExceptionUtils(SystemExceptionEnum.SYSTEM_INVOMPLELE_COLLECTION_ERROR.toString());
		}
		Collection.db = db;
		return COLLECTION;
	}
	
	/**
	 * @Description: 获取指定的集合
	 * @author Blossom
	 * @time 2017年2月27日 下午5:10:43 
	 * @return_type DBCollection
	 *
	 */
	public DBCollection getDBCollection(String collectionName) throws SystemExceptionUtils{
		if (StringUtils.isEmpty(collectionName)) {
			LoggerUtils.addLoggerError(CLAZZ, "getDBCollection", "集合名不能为空!");
			throw new SystemExceptionUtils(SystemExceptionEnum.SYSTEM_INCOMPLETE_PARAMETER_ERROR.toString());
		}
		if (ObjectUtils.isEmpty(Collection.db)) {
			LoggerUtils.addLoggerError(CLAZZ, "getDBCollection", "数据库未连接!");
			return null;
		}
		return Collection.db.getCollection(collectionName);
	}
	
	/**
	 * @Description: 创建文档
	 * @author Blossom
	 * @time 2017年2月27日 下午5:13:23 
	 * @return_type DBCollection
	 *
	 */
	public DBCollection createCollection(String collectionName,DBObject object) throws SystemExceptionUtils{
		if (ObjectUtils.isEmpty(object) || StringUtils.isEmpty(collectionName)) {
			LoggerUtils.addLoggerError(CLAZZ, "createCollection", "参数不全!");
			throw new SystemExceptionUtils(SystemExceptionEnum.SYSTEM_INCOMPLETE_PARAMETER_ERROR.toString());
		}
		if (ObjectUtils.isEmpty(Collection.db)) {
			LoggerUtils.addLoggerError(CLAZZ, "createCollection", "数据库未连接!");
			return null;
		}
		
		return Collection.db.createCollection(collectionName, object);
	}

}
