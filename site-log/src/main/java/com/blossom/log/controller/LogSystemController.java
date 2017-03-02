package com.blossom.log.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blossom.log.annotation.ControllerLogAnnotation;
import com.blossom.log.service.ILogSystemService;

import net.sf.json.JSONObject;

/**
 * @Description: 系统日志API接口
 * @author Blossom
 * @time 2017年3月2日 下午4:11:15
 */
@Controller
@RequestMapping("/systemLog")
public class LogSystemController {
	
	@Resource(name="logSystemServie")
	private ILogSystemService logSystemService;
	
	/**
	 * @Description: 获取日志 
	 * @author Blossom
	 * @time 2017年3月2日 下午4:14:24 
	 * @return_type JSONObject
	 *
	 */
	@RequestMapping("/query")
	@ControllerLogAnnotation(description="获取日志")
	public @ResponseBody JSONObject queryLogSystem(HttpServletRequest request,
			HttpServletResponse response){
		JSONObject json = new JSONObject();
		json = logSystemService.queryLogSystem(json);
		return json;
	}

}
