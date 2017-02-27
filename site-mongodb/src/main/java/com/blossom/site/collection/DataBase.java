package com.blossom.site.collection;

import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

import com.blossom.site.util.SystemExceptionEnum;
import com.blossom.tools.exception.SystemExceptionUtils;
import com.blossom.tools.object.ObjectUtils;
import com.blossom.tools.string.StringUtils;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

/**
 * @Description:数据基本操作
 * @author Blossom
 * @time 2017年2月27日 下午5:17:00
 */
public class DataBase {
	
	private static final DataBase DATA_BASE = new DataBase();
	private static DBCollection dbCollection = null;
	
	private DataBase(){};
	
	/**
	 * @Description: 获取DataBase对象
	 * @author Blossom
	 * @time 2017年2月27日 下午5:19:27 
	 * @return_type DataBase
	 *
	 */
	public static DataBase getInstall(DBCollection dbCollection) throws SystemExceptionUtils{
		if (ObjectUtils.isEmpty(dbCollection)) {
			throw new SystemExceptionUtils(SystemExceptionEnum.SYSTEM_INVOMPLELE_COLLECTION_ERROR.toString());
		}
		DataBase.dbCollection = dbCollection;
		return DATA_BASE;
	}
	
	/**
	 * @Description: 插入数据(文档)
	 * @author Blossom
	 * @throws SystemExceptionUtils 
	 * @time 2017年2月24日 上午9:37:57 
	 * @return_type void
	 *
	 */
	public void insert(DBObject object) throws SystemExceptionUtils{
		if (ObjectUtils.isEmpty(object)) {
			throw new SystemExceptionUtils(SystemExceptionEnum.SYSTEM_INCOMPLETE_PARAMETER_ERROR.toString());
		}
		dbCollection.insert(object);
	}
	
	/**
	 * @Description: 删除指定的数据(文档)
	 * @author Blossom
	 * @throws SystemExceptionUtils 
	 * @time 2017年2月24日 上午9:42:38 
	 * @return_type void
	 *
	 */
	public void remove(DBObject object) throws SystemExceptionUtils{
		if (ObjectUtils.isEmpty(object)) {
			throw new SystemExceptionUtils(SystemExceptionEnum.SYSTEM_INCOMPLETE_PARAMETER_ERROR.toString());
		}
		dbCollection.remove(object);
	}
	
	/**
	 * @Description: 清空集合
	 * @author Blossom
	 * @time 2017年2月24日 上午9:43:25 
	 * @return_type void
	 *
	 */
	public void deleteAll(){
		List<DBObject> objects = findAll();
		for (int i = 0; i < objects.size(); i++) {
			dbCollection.remove(objects.get(i));
		}
	}
	
	/**
	 * @Description: 获取全部的数据(文档)
	 * @author Blossom
	 * @time 2017年2月24日 上午9:45:32 
	 * @return_type List<DBObject>
	 *
	 */
	public List<DBObject> findAll(){
		return dbCollection.find().toArray();
	}
	
	/**
	 * @Description: 获取1条记录
	 * @author Blossom
	 * @throws SystemExceptionUtils 
	 * @time 2017年2月24日 上午10:00:12 
	 * @return_type DBObject
	 *
	 */
	public DBObject findOne(DBObject object) throws SystemExceptionUtils{
		if (ObjectUtils.isEmpty(object)) {
			throw new SystemExceptionUtils(SystemExceptionEnum.SYSTEM_INCOMPLETE_PARAMETER_ERROR.toString());
		}
		return dbCollection.findOne(object);
	}
	
	/**
	 * @Description: 查询指定条数记录
	 * @author Blossom
	 * @throws SystemExceptionUtils 
	 * @time 2017年2月24日 上午10:01:32 
	 * @return_type List<DBObject>
	 *
	 */
	public List<DBObject> find(DBObject object,int limit) throws SystemExceptionUtils{
		if (ObjectUtils.isEmpty(object)) {
			throw new SystemExceptionUtils(SystemExceptionEnum.SYSTEM_INCOMPLETE_PARAMETER_ERROR.toString());
		}
		return dbCollection.find(object).limit(limit).toArray();
	}
	
	/**
	 * @Description: 查询符合的全部数据
	 * @author Blossom
	 * @throws SystemExceptionUtils 
	 * @time 2017年2月24日 上午10:02:33 
	 * @return_type List<DBObject>
	 *
	 */
	public List<DBObject> find(DBObject object) throws SystemExceptionUtils{
		if (ObjectUtils.isEmpty(object)) {
			throw new SystemExceptionUtils(SystemExceptionEnum.SYSTEM_INCOMPLETE_PARAMETER_ERROR.toString());
		}
		return dbCollection.find(object).toArray();
	}
	
	/**
	 * @Description: 返回Queue的查询
	 * @author Blossom
	 * @throws SystemExceptionUtils 
	 * @time 2017年2月24日 上午10:08:26 
	 * @return_type LinkedBlockingQueue<DBObject>
	 *
	 */
	public LinkedBlockingQueue<DBObject> findQueue(DBObject object) throws SystemExceptionUtils{
		if (ObjectUtils.isEmpty(object)) {
			throw new SystemExceptionUtils(SystemExceptionEnum.SYSTEM_INCOMPLETE_PARAMETER_ERROR.toString());
		}
		LinkedBlockingQueue<DBObject> queue = new LinkedBlockingQueue<DBObject>();
		DBCursor dBCursor = dbCollection.find(object);
		
		for (DBObject dbObject : dBCursor) {
			dbObject = dBCursor.next();
			queue.offer(dbObject);
		}
		return queue;
		
	}
	
	/**
	 * @Description:如果更新的数据 不存在 插入一条数据 
	 * @author Blossom
	 * @throws SystemExceptionUtils 
	 * @time 2017年2月24日 上午9:48:56 
	 * @return_type void
	 *
	 */
	public void updateOrInsert(DBObject set,DBObject where) throws SystemExceptionUtils{
		if (ObjectUtils.isEmpty(set) || ObjectUtils.isEmpty(where)) {
			throw new SystemExceptionUtils(SystemExceptionEnum.SYSTEM_INCOMPLETE_PARAMETER_ERROR.toString());
		}
		dbCollection.update(where, set, true, false);
	}
	
	/**
	 * @Description: 只更新存在的数据,不会新增. 批量更新.
	 * @author Blossom
	 * @throws SystemExceptionUtils 
	 * @time 2017年2月24日 上午9:51:19 
	 * @return_type void
	 *
	 */
	public void updateExistDataWithBatch(DBObject set,DBObject where) throws SystemExceptionUtils{
		if (ObjectUtils.isEmpty(set) || ObjectUtils.isEmpty(where)) {
			throw new SystemExceptionUtils(SystemExceptionEnum.SYSTEM_INCOMPLETE_PARAMETER_ERROR.toString());
		}
		dbCollection.update(where, new BasicDBObject("$set",set),true,false);
	}
	
	/**
	 * @Description: 按照ObjectId,批量更新
	 * @author Blossom
	 * @throws SystemExceptionUtils
	 * @time 2017年2月24日 上午9:54:38
	 * @return_type void
	 *
	 */
	public void updateBatchByObjectId(String ids, DBObject set) throws SystemExceptionUtils{
		if (StringUtils.isEmpty(ids) || ObjectUtils.isEmpty(set)) {
			throw new SystemExceptionUtils(SystemExceptionEnum.SYSTEM_INCOMPLETE_PARAMETER_ERROR.toString());
		}
		 String[] id = ids.split(",");
		 BasicDBObject dest = null;
		 BasicDBObject doc = null;
         for (int i = 0; i < id.length; i++) {
              
             dest = new BasicDBObject();
             doc = new BasicDBObject();
           //  dest.put("_id", ObjectId.);
             doc.put("$set", set);
             dbCollection.update(dest, doc, false, true);
              
         }
	}

}
