package com.blossom.log.service;



import net.sf.json.JSONObject;

/**
 * @Description: 系统日志服务接口
 * @author Blossom
 * @time 2017年3月2日 下午4:05:55
 */
public interface ILogSystemService {

	/**
	 * @Description: 获取系统日志
	 * @author Blossom
	 * @time 2017年3月2日 下午4:06:39 
	 * @return_type JSONObject
	 *
	 */
	JSONObject queryLogSystem(JSONObject pJson);
}
