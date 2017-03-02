package com.blossom.log.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blossom.log.dao.ILogSystemDao;
import com.blossom.log.model.LogSystemModel;
import com.blossom.log.service.ILogSystemService;

import net.sf.json.JSONObject;

/**
 * @Description: 系统日志服务接口实现
 * @author Blossom
 * @time 2017年3月2日 下午4:07:38
 */
@Service("logSystemServie")
public class LogSystemServiceImpl implements ILogSystemService {

	private static final Logger logger = Logger.getLogger(LogSystemServiceImpl.class.getName());
	
	@Autowired
	private ILogSystemDao logSystemDaoImpl;
	
	/**
	 * @Description: 
	 * @author Blossom
	 * @time 2017年3月2日 下午4:07:38
	 * @see com.blossom.log.service.ILogSystemService#queryLogSystem(net.sf.json.JSONObject)
	 */
	public JSONObject queryLogSystem(JSONObject pJson) {
		logger.info("获取系统日志!");
		JSONObject resultJSON = new JSONObject();
		Map<String, Object> map = new HashMap<String, Object>();
		List<LogSystemModel> logSystems = logSystemDaoImpl.queryLogHandle(map);
		resultJSON.put("logSystems", logSystems);
		resultJSON.put("status", 1);
		resultJSON.put("message", "");
		return resultJSON;
	}

}
