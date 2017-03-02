package com.blossom.log.dao;

import java.util.List;
import java.util.Map;

import com.blossom.log.model.LogSystemModel;

/**
 * @Description: 系统日志dao接口
 * @author Blossom
 * @time 2017年3月2日 下午3:44:52
 */
public interface ILogSystemDao {

	/**
	 * @Description: 获取系统日志
	 * @author Blossom
	 * @time 2017年3月2日 下午3:50:19 
	 * @return_type List<LogSystemModel>
	 *
	 */
	List<LogSystemModel> queryLogHandle(Map<String, Object> pMap);
	
}
