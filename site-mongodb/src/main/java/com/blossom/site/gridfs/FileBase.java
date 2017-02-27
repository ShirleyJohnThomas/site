package com.blossom.site.gridfs;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import com.blossom.site.util.SystemExceptionEnum;
import com.blossom.tools.exception.SystemExceptionUtils;
import com.blossom.tools.object.ObjectUtils;
import com.blossom.tools.string.StringUtils;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSFile;

/**
 * @Description:上传下载文件
 * @author Blossom
 * @time 2017年2月27日 下午5:25:33
 */
public class FileBase {

	private static final FileBase FILE_BASE = new FileBase();

	private static GridFS gridFS = null;

	// 私有化构造方法
	private FileBase() {
	}

	/**
	 * @Description: 获取FileBase对象
	 * @author Blossom
	 * @time 2017年2月27日 下午5:27:33 
	 * @return_type FileBase
	 *
	 */
	public static FileBase getInstall(GridFS gridFS) throws SystemExceptionUtils {
		if (ObjectUtils.isEmpty(gridFS)) {
			throw new SystemExceptionUtils(SystemExceptionEnum.SYSTEM_INCOMPLETE_PARAMETER_ERROR.toString());
		}
		FileBase.gridFS = gridFS;
		return FILE_BASE;
	}
	
	/**
	 * @Description: 上传文件
	 * @author Blossom
	 * @time 2017年2月24日 下午3:06:47
	 * @param file
	 *            ：文件，File类型
	 * @param id
	 *            ：唯一标示文件，可根据id查询到文件.必须设置
	 * @param map：放入你想要保存的属性，例如文件类型（“congtentType”".jpg"）,字符串类型，区分大小写，
	 *            如果属性没有的话会自动创建并保存
	 * @throws IOException
	 * @throws SystemExceptionUtils
	 * @return_type void
	 *
	 */
	public void uploadFile(File file, String id, LinkedHashMap<String, Object> map)
			throws IOException, SystemExceptionUtils {

		if (ObjectUtils.isEmpty(file) || StringUtils.isEmpty(id)) {
			throw new SystemExceptionUtils(SystemExceptionEnum.SYSTEM_INCOMPLETE_PARAMETER_ERROR.toString());
		}

		// 创建文件
		GridFSFile gridFSFile = gridFS.createFile(file);
		// 判断文件是否存在，如果存在则删除
		GridFSDBFile gridFSDBFile=getFileById(id);
		if (gridFSDBFile != null) {
			deleteFile(id);
		}
		// 设置文件属性
		gridFSFile.put("_id", id);
		// 循环设置参数
		if (map != null && map.size() > 0) {
			for (String key : map.keySet()) {
				gridFSFile.put(key, map.get(key));
			}
		}
		// 保存上传
		gridFSFile.save();
	}

	/**
	 * @Description: 删除文件
	 * @author Blossom
	 * @time 2017年2月24日 下午3:14:38
	 * @param id：文件对应的id
	 * @throws SystemExceptionUtils
	 * @return_type void
	 *
	 */
	public void deleteFile(String id) throws SystemExceptionUtils {
		if (StringUtils.isEmpty(id)) {
			throw new SystemExceptionUtils(SystemExceptionEnum.SYSTEM_INCOMPLETE_PARAMETER_ERROR.toString());
		}
		DBObject dbObject = new BasicDBObject("_id", id);
		gridFS.remove(dbObject);
	}

	/**
	 * @Description: 批量删除文件
	 * @author Blossom
	 * @throws SystemExceptionUtils
	 * @time 2017年2月24日 下午3:19:34
	 * @return_type void
	 *
	 */
	public void deleteFileByIds(String[] ids) throws SystemExceptionUtils {
		if (ids == null || ids.length <= 0) {
			throw new SystemExceptionUtils(SystemExceptionEnum.SYSTEM_INCOMPLETE_PARAMETER_ERROR.toString());
		}
		int length = ids.length;
		DBObject dbObject = null;
		for (int i = 0; i < length; i++) {
			dbObject = new BasicDBObject("_id", ids[i]);
			gridFS.remove(dbObject);
		}
	}
	
	/**
	 * @Description: 根据ID获取文件
	 * @author Blossom
	 * @throws SystemExceptionUtils 
	 * @time 2017年2月24日 下午3:23:00 
	 * @return_type GridFSFile
	 *
	 */
	public GridFSDBFile getFileById(String id) throws SystemExceptionUtils{
		if (StringUtils.isEmpty(id)) {
			throw new SystemExceptionUtils(SystemExceptionEnum.SYSTEM_INCOMPLETE_PARAMETER_ERROR.toString());
		}
		DBObject dbObject = new BasicDBObject("_id", id);
		return gridFS.findOne(dbObject);
	}
	
	/**
	 * @Description: 获取集合中所有文件
	 * @author Blossom
	 * @time 2017年2月24日 下午3:25:53 
	 * @return_type List<GridFSDBFile>
	 *
	 */
	public List<GridFSDBFile> getAllFile(){
		DBObject dbObject = new BasicDBObject();
		return gridFS.find(dbObject);
	}
}
