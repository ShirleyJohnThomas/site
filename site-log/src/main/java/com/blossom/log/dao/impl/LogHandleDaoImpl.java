package com.blossom.log.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.blossom.log.dao.ILogHandleDao;
import com.blossom.log.mapper.LogHandleMapper;
import com.blossom.log.model.LogHandleModel;

/**
 * @Description:
 * @author Blossom
 * @time 2017年3月2日 下午3:50:59
 */
@Repository
public class LogHandleDaoImpl implements ILogHandleDao {

	@Autowired
	private LogHandleMapper logHandleMapper;
	
	/**
	 * @Description: 
	 * @author Blossom
	 * @throws Exception 
	 * @throws SystemExceptionUtils 
	 * @time 2017年3月2日 下午3:50:59
	 * @see com.blossom.log.dao.ILogHandleDao#insertLogHandleInfo(com.blossom.log.model.LogHandleModel)
	 */
	public Integer insertLogHandleInfo(LogHandleModel logHandle) throws Exception {
		if (logHandle == null) {
			throw new Exception("参数不全!");
		}
		return logHandleMapper.insertLogHandleInfo(logHandle);
	}

}
