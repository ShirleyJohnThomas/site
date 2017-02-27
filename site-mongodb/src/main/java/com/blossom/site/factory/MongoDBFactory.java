package com.blossom.site.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.blossom.site.base.Connection;
import com.blossom.site.base.DBBase;
import com.blossom.site.collection.Collection;
import com.blossom.site.collection.DataBase;
import com.blossom.site.gridfs.FileBase;
import com.blossom.site.gridfs.GridFs;
import com.blossom.site.util.SystemExceptionEnum;
import com.blossom.tools.exception.SystemExceptionUtils;
import com.blossom.tools.string.StringUtils;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.gridfs.GridFS;


/**
 * @Description:mongodb工厂
 * @author Blossom
 * @time 2017年2月27日 下午4:27:08
 */
public class MongoDBFactory {
	
	private static final MongoDBFactory MONGO_DB_FACTORY = new MongoDBFactory();
	private static MongoClient mongoClient = null;
	private static DB db = null;
	private static DBCollection dbCollection  = null;
	private static DataBase dataBase = null;
	private static String dbName = null;
	private static String collectionName = null;
	private static GridFS gridFs = null;
	private static FileBase fileBase = null;
	private static String host = null;
	private static Integer port = null;
	
	/**
	 * @Description: 获取MongoDBFactory对象
	 * @author Blossom
	 * @time 2017年2月27日 下午5:38:02 
	 * @return_type MongoDBFactory
	 *
	 */
	public static MongoDBFactory getInstall(String ConfigPath,String dbName,String collectionName) throws SystemExceptionUtils, IOException{
		if (StringUtils.isEmpty(ConfigPath)) {
			throw new SystemExceptionUtils(SystemExceptionEnum.SYSTEM_INCOMPLETE_PARAMETER_ERROR.toString());
		}
		MongoDBFactory.dbName = dbName;
		MongoDBFactory.collectionName = collectionName;
		InputStream input = MongoDBFactory.class.getClassLoader().getResourceAsStream(ConfigPath);
		Properties properties = new Properties();
		properties.load(input);
		host = properties.getProperty("mongo.host");
		port = Integer.parseInt(properties.getProperty("mongo.port"));
		return MONGO_DB_FACTORY;
	}
	
	/**
	 * @Description: 获取MongoClient
	 * @author Blossom
	 * @time 2017年2月24日 下午2:22:47 
	 * @return_type MongoClient
	 *
	 */
	public MongoClient getMongoClient() throws SystemExceptionUtils{
		mongoClient =  Connection.getInstall(host,port);
		return mongoClient;
	}
	
	/**
	 * @Description: 获取DB对象
	 * @author Blossom
	 * @time 2017年2月24日 下午2:26:07 
	 * @return_type DB
	 *
	 */
	public DB getDB() throws SystemExceptionUtils{
		mongoClient = getMongoClient();
		DBBase dbUtils = DBBase.getInstall(mongoClient);
		db = dbUtils.getDB(dbName);
		return db;
	}

	/**
	 * @Description: 获取DBCollection对象
	 * @author Blossom
	 * @time 2017年2月24日 下午2:30:59 
	 * @return_type DBCollection
	 *
	 */
	public DBCollection getDBCollection() throws SystemExceptionUtils{
		db = getDB();
		Collection collection = Collection.getInstall(db);
		dbCollection = collection.getDBCollection(collectionName);
		return dbCollection;
	}
	
	/**
	 * @Description: 获取FileBase对象
	 * @author Blossom
	 * @throws SystemExceptionUtils 
	 * @time 2017年2月24日 下午2:32:54 
	 * @return_type DataOperation
	 *
	 */
	public DataBase getDataOperation() throws SystemExceptionUtils{
		dbCollection = getDBCollection();
		dataBase = DataBase.getInstall(dbCollection);
		return dataBase;
	}
	
	/**
	 * @Description:获取GridFS对象 
	 * @author Blossom
	 * @time 2017年2月24日 下午2:56:45 
	 * @return_type GridFs
	 *
	 */
	public GridFS getGridFs() throws SystemExceptionUtils{
		db = getDB();
		GridFs gridFS = GridFs.getInstall(db, collectionName);
		gridFs = gridFS.getGridFs();
		return gridFs;
	}
	
	/**
	 * @Description:获取FileBase对象 
	 * @author Blossom
	 * @time 2017年2月24日 下午3:05:14 
	 * @return_type FileOperation
	 *
	 */
	public FileBase getFileBase() throws SystemExceptionUtils{
		gridFs = getGridFs();
		fileBase = FileBase.getInstall(gridFs);
		return fileBase;
	}

}
