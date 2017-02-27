package com.blossom.tools.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description:关于异常的工具类
 * @author Blossom
 * @time 2016年12月25日 下午2:27:53
 */
public class SystemExceptionUtils extends Throwable {

	private static final long serialVersionUID = 1454212178309997924L;

	public static final String SYSTEM_INCOMPLETE_PARAMETER_ERROR = "参数不全!";

	public static void main(String[] args) {
		System.out.println(ExceptionEnum.SYSTEM_INCOMPLETE_PARAMETER_ERROR.toString());
	}

	/**
	 * @author Blossom
	 * @time 2016年12月25日
	 */
	public SystemExceptionUtils() {

		super();

	}

	/**
	 * @author Blossom
	 * @time 2016年12月25日
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public SystemExceptionUtils(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {

		super(message, cause, enableSuppression, writableStackTrace);

	}

	/**
	 * @author Blossom
	 * @time 2016年12月25日
	 * @param message
	 * @param cause
	 */
	public SystemExceptionUtils(String message, Throwable cause) {

		super(message, cause);

	}

	/**
	 * @author Blossom
	 * @time 2016年12月25日
	 * @param message
	 */
	public SystemExceptionUtils(String message) {

		super(message);

	}

	/**
	 * @author Blossom
	 * @time 2016年12月25日
	 * @param cause
	 */
	public SystemExceptionUtils(Throwable cause) {

		super(cause);

	}

	/**
	 * @Description: 将CheckedException转换为UncheckedException.
	 * @author Blossom
	 * @time 2017年2月27日 下午3:17:04 
	 * @return_type RuntimeException
	 *
	 */
	public static RuntimeException unchecked(Exception e) {
		if (e instanceof RuntimeException) {
			return (RuntimeException) e;
		} else {
			return new RuntimeException(e);
		}
	}

	/**
	 * @Description: 将ErrorStack转化为String.
	 * @author Blossom
	 * @time 2017年2月27日 下午3:17:12 
	 * @return_type String
	 *
	 */
	public static String getStackTraceAsString(Throwable e) {
		if (e == null) {
			return "";
		}
		StringWriter stringWriter = new StringWriter();
		e.printStackTrace(new PrintWriter(stringWriter));
		return stringWriter.toString();
	}

	/**
	 * @Description: 判断异常是否由某些底层的异常引起.
	 * @author Blossom
	 * @time 2017年2月27日 下午3:17:21 
	 * @return_type boolean
	 *
	 */
	public static boolean isCausedBy(Exception ex, Class<? extends Exception>... causeExceptionClasses) {
		Throwable cause = ex.getCause();
		while (cause != null) {
			for (Class<? extends Exception> causeClass : causeExceptionClasses) {
				if (causeClass.isInstance(cause)) {
					return true;
				}
			}
			cause = cause.getCause();
		}
		return false;
	}

	/**
	 * @Description: 在request中获取异常类
	 * @author Blossom
	 * @time 2017年2月27日 下午3:17:30 
	 * @return_type Throwable
	 *
	 */
	public static Throwable getThrowable(HttpServletRequest request) {
		Throwable ex = null;
		if (request.getAttribute("exception") != null) {
			ex = (Throwable) request.getAttribute("exception");
		} else if (request.getAttribute("javax.servlet.error.exception") != null) {
			ex = (Throwable) request.getAttribute("javax.servlet.error.exception");
		}
		return ex;
	}

}
