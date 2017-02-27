package com.blossom.site.gridfs;

import com.blossom.site.util.SystemExceptionEnum;
import com.blossom.tools.exception.SystemExceptionUtils;
import com.blossom.tools.object.ObjectUtils;
import com.blossom.tools.string.StringUtils;
import com.mongodb.DB;
import com.mongodb.gridfs.GridFS;

/**
 * @Description:文件操作(一般是比较大的文件)
 * @author Blossom
 * @time 2017年2月27日 下午5:24:30
 */
public class GridFs {

private static final GridFs GRID_FS = new GridFs();
	
	private static DB db = null;
	private static String collectionName = null;
	
	//私有化构造方法
	private GridFs(){};
	
	/**
	 * @Description: 初始化参数并且单例模式
	 * @author Blossom
	 * @throws SystemExceptionUtils 
	 * @time 2017年2月24日 下午2:41:51 
	 * @return_type GridFs
	 *
	 */
	public static GridFs getInstall(DB db,String collectionName) throws SystemExceptionUtils{
		if (ObjectUtils.isEmpty(db) || StringUtils.isEmpty(collectionName)) {
			throw new SystemExceptionUtils(SystemExceptionEnum.SYSTEM_INCOMPLETE_PARAMETER_ERROR.toString());
		}
		GridFs.db = db;
		GridFs.collectionName = collectionName;
		return GRID_FS;
	}
	
	/**
	 * @Description: 获取GridFS对象
	 * @author Blossom
	 * @time 2017年2月24日 下午2:49:55 
	 * @return_type GridFS
	 *
	 */
	public GridFS getGridFs(){
		 GridFS gridFS= new GridFS(db,collectionName);
		 return gridFS;
	}
	
}
