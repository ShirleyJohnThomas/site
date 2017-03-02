package com.blossom.log.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.blossom.log.dao.ILogSystemDao;
import com.blossom.log.mapper.LogSystemMapper;
import com.blossom.log.model.LogSystemModel;

/**
 * @Description:
 * @author Blossom
 * @time 2017年3月2日 下午3:52:35
 */
@Repository
public class LogSysetmDaoImpl implements ILogSystemDao {

	@Autowired
	private LogSystemMapper logSystemMapper;
	
	/**
	 * @Description: 
	 * @author Blossom
	 * @time 2017年3月2日 下午3:52:35
	 * @see com.blossom.log.dao.ILogSystemDao#queryLogHandle(java.util.Map)
	 */
	public List<LogSystemModel> queryLogHandle(Map<String, Object> pMap) {
		
		return logSystemMapper.queryLogSystem(pMap);
	}

}
