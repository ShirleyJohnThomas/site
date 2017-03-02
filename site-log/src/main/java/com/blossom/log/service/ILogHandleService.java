package com.blossom.log.service;

import net.sf.json.JSONObject;

/**
 * @Description: 日志操作服务接口
 * @author Blossom
 * @time 2017年3月2日 下午4:00:43
 */
public interface ILogHandleService {
	
	/**
	 * @Description: 添加操作日志 
	 * @author Blossom
	 * @time 2017年3月2日 下午4:01:35 
	 * @return_type JSONObject
	 *
	 */
	JSONObject insertLogHandle(JSONObject pJson);

}
