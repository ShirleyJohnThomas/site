package com.blossom.tools.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.blossom.tools.date.DateFormatUtil;

/**
 * @description: Logger 工具类
 * @author Blossom
 * @time 2017年2月21日 下午4:33:47
 */
public class LoggerUtils {

	private static Logger logger = null;

	/**
	 * @description: 获取Logger对象
	 * @author Blossom
	 * @time 2017年2月21日 下午4:35:11
	 * @param clazz
	 * @return
	 */
	public static Logger getLogger(Class<?> clazz) {
		return LoggerFactory.getLogger(clazz);
	}

	/**
	 * @description: 添加info信息
	 * @author Blossom
	 * @time 2017年2月21日 下午4:36:48
	 */
	public static void addLoggerInfo(Class<?> clazz, String methodName, Object object) {
		logger = getLogger(clazz);

		StringBuilder builder = new StringBuilder();
		builder.append("INFO===【DATE】: ").append(DateFormatUtil.getNow()).append("  ").append("【CLASS】 : ").append(clazz)
				.append("  ").append("【METHOD】 : ").append(methodName).append("  ").append("【MESSAGE】 : ")
				.append(object);

		logger.info(builder.toString());
	}

	/**
	 * @description:添加error信息
	 * @author Blossom
	 * @time 2017年2月21日 下午4:37:15
	 */
	public static void addLoggerError(Class<?> clazz, String methodName, Object object) {
		logger = getLogger(clazz);

		StringBuilder builder = new StringBuilder();
		builder.append("ERROR===【DATE】: ").append(DateFormatUtil.getNow()).append("  ").append("【CLASS】 : ").append(clazz)
				.append("  ").append("【METHOD】 : ").append(methodName).append("  ").append("【ERROR】 : ").append(object);

		logger.error(builder.toString());
		logger.debug("");
	}
	
	/**
	 * @Description: 添加debug信息
	 * @author Blossom
	 * @time 2017年2月23日 上午10:13:05 
	 * @return_type void
	 *
	 */
	public static void addLoggerDebug(Class<?> clazz, String methodName, Object object){
		logger = getLogger(clazz);

		StringBuilder builder = new StringBuilder();
		builder.append("DEBUG===【DATE】: ").append(DateFormatUtil.getNow()).append("  ").append("【CLASS】 : ").append(clazz)
				.append("  ").append("【METHOD】 : ").append(methodName).append("  ").append("【ERROR】 : ").append(object);

		logger.debug(builder.toString());
	}
	
	/**
	 * @Description: 添加warn信息
	 * @author Blossom
	 * @time 2017年2月23日 上午10:14:22 
	 * @return_type void
	 *
	 */
	public static void addLoggerWarn(Class<?> clazz, String methodName, Object object){
		logger = getLogger(clazz);

		StringBuilder builder = new StringBuilder();
		builder.append("DEBUG===【DATE】: ").append(DateFormatUtil.getNow()).append("  ").append("【CLASS】 : ").append(clazz)
				.append("  ").append("【METHOD】 : ").append(methodName).append("  ").append("【ERROR】 : ").append(object);
		
		logger.warn(builder.toString());
	}

}
