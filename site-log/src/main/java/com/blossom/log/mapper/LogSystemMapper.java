package com.blossom.log.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.blossom.log.model.LogSystemModel;

/**
 * @Description:
 * @author Blossom
 * @time 2017年3月2日 下午3:34:18
 */
@Mapper
public interface LogSystemMapper {
	
	/**
	 * @Description: 获取系统日志
	 * @author Blossom
	 * @time 2017年3月2日 下午3:35:19 
	 * @return_type List<LogSystemModel>
	 *
	 */
	List<LogSystemModel> queryLogSystem(Map<String, Object> pMap);

}
