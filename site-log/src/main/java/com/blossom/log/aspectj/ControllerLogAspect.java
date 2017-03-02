package com.blossom.log.aspectj;

import java.lang.reflect.Method;
import java.util.Arrays;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.blossom.log.annotation.ControllerLogAnnotation;
import com.blossom.log.service.ILogHandleService;

import net.sf.json.JSONObject;

/**
 * @Description: controller层日志切面
 * @author Blossom
 * @time 2017年3月2日 下午4:18:54
 */
@Aspect
@Component
public class ControllerLogAspect {

	@Resource(name = "logHandleService")
	private ILogHandleService logHandleService;

	@Pointcut("@annotation(com.blossom.log.annotation.ControllerLogAnnotation)")
	public void controllerAspect() {
	}

	/**
	 * @Description: 前置通知
	 * @author Blossom
	 * @time 2017年3月2日 下午4:22:25
	 * @return_type void
	 *
	 */
	@SuppressWarnings("unused")
	@Before("controllerAspect()")
	public void doBefore(JoinPoint joinPoint) {
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = (HttpServletRequest) attributes.getRequest();
		HttpSession session = request.getSession();
		// 读取session中的用户
		/*
		 * UserModel user = (UserModel)session.getAttribute("user"); if
		 * (ObjectUtils.isEmpty(user)) { user = new UserModel(); }
		 */
		// 获取请求IP
		String ip = request.getRemoteAddr();
		try {
			
			// *========数据库日志=========*//
			// 保存日志到数据库
			JSONObject json = new JSONObject();
			json.put("uuid", "1234567890");
			json.put("url", request.getRequestURL().toString());
			json.put("httpMethod", request.getMethod());
			// json.put("broswer",BrowserUtils.checkBrowse(request));
			json.put("broswer", "google");
			json.put("description", getMthodDescription(joinPoint));
			json.put("exceptionCode", "无异常");
			json.put("type", "0");
			json.put("exceptionDetail", "无异常");
			json.put("method",
					(joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));
			json.put("params", Arrays.toString(joinPoint.getArgs()));
			// json.put("createBy",user.getUserId());
			json.put("createBy", "admin");
			// json.put("createDate",DateFormatUtil.getNow());
			json.put("createDate", "1234567890");
			json.put("requestIp", ip);

			json = logHandleService.insertLogHandle(json);
			System.out.println("return json=======" + json.toString());
			System.out.println("=====前置通知结束=====");
		} catch (Exception e) {
			// 记录本地异常日志
			// logger.error(e.getMessage());
			e.printStackTrace();
			System.out.print("异常信息: " + e.getMessage());
		}
	}

	/**
	 * @Description: 获取注解参数当中的值
	 * @author Blossom
	 * @time 2017年3月2日 下午4:24:43
	 * @return_type String
	 *
	 */
	@SuppressWarnings("rawtypes")
	private String getMthodDescription(JoinPoint joinPoint) throws ClassNotFoundException {
		String targetName = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		Object[] arguments = joinPoint.getArgs();
		Class targetClass = Class.forName(targetName);
		Method[] methods = targetClass.getMethods();
		String description = "";
		for (Method method : methods) {
			if (method.getName().equals(methodName)) {
				Class[] clazzs = method.getParameterTypes();
				if (clazzs.length == arguments.length) {
					description = method.getAnnotation(ControllerLogAnnotation.class).description();
					break;
				}
			}
		}
		return description;
	}

}
