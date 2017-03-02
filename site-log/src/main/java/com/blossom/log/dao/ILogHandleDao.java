package com.blossom.log.dao;

import com.blossom.log.model.LogHandleModel;

/**
 * @Description: 操作日志dao接口
 * @author Blossom
 * @time 2017年3月2日 下午3:44:36
 */
public interface ILogHandleDao {

	/**
	 * @Description: 添加日志
	 * @author Blossom
	 * @time 2017年3月2日 下午3:57:37 
	 * @return_type Integer
	 *
	 */
	Integer insertLogHandleInfo(LogHandleModel logHandle) throws Exception;
	
}
