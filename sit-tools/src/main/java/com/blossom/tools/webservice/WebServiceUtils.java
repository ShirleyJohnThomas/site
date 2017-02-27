package com.blossom.tools.webservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

/**
 * @Description: webService服务接口操作工具类
 * @author Blossom
 * @time 2016年12月25日 下午2:24:19
 */
public class WebServiceUtils {
	
	/**
	 * @Description: 接入接口：此方法只能接入普通接口，对于那些要传递参数的接口没法调用
	 * @author Blossom
	 * @time 2016年12月26日 下午8:41:18
	 * @return_type String
	 *
	 */
	public static String accessInterface(String pInterfaceUrl)
			throws IOException {

		URL url = new URL(pInterfaceUrl);
		URLConnection connection = url.openConnection();
		connection.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
		connection.setRequestProperty("Content-Length", "256");

		BufferedReader buffered = new BufferedReader(new InputStreamReader(
				connection.getInputStream(), "UTF-8"));
		String line = "";
		StringBuffer buffer = new StringBuffer();
		while ((line = buffered.readLine()) != null) {
			buffer.append(line);
		}
		buffered.close();

		return buffer.toString();

	}

	/**
	 * @Description: 接出接口：此方法可以接入普通接口，也可以接入webservice接口或其他形式的接口
	 * @author Blossom
	 * @time 2016年12月26日 下午8:42:30
	 * @return_type String
	 *
	 */
	public static String outputInterface(String pInterfaceUrl, String param)
			throws IOException {

		URL url = new URL(pInterfaceUrl);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		// 设置连接参数
		connection.setRequestMethod("POST");
		connection.setDoOutput(true);
		connection.setDoInput(true);
		connection.setAllowUserInteraction(true);
		connection.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
		connection.setRequestProperty("Content-Length", "256");

		// 开启流写入数据
		OutputStream out = connection.getOutputStream();
		System.out.println("发送报文....");
		out.write(param.getBytes());
		out.flush();
		out.close();

		// 获取返回的数据
		InputStream input = connection.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(input));
		String line = "";
		StringBuffer buffer = new StringBuffer();
		while ((line = reader.readLine()) != null) {
			buffer.append(line);
		}
		reader.close();

		return buffer.toString();
	}
	
	/**
	 * @Description: soap1请求格式
	 * @author Blossom
	 * @time 2016年12月26日 下午8:38:13
	 * @return_type String
	 *
	 */
	public static String requestFormatSOAP1(String functionName,Map<String, String> pMap){
		
		StringBuilder builder = new StringBuilder();
		String paramStr = paramFormat(pMap);
		builder.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>")
		.append("<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">")
		.append("<soap:Body><")
		.append(functionName).append(" xmlns=\"http://WebXml.com.cn/\">")
		.append(paramStr)
		.append("</").append(functionName).append("></soap:Body></soap:Envelope>");
		
		return builder.toString();
	}
	
	/**
	 * @Description: soap2请求格式
	 * @author Blossom
	 * @time 2016年12月26日 下午8:38:28
	 * @return_type String
	 *
	 */
	public static String requestFromatSOAP2(String functionName,Map<String, String> pMap){
		
		StringBuilder builder = new StringBuilder();
		String paramStr = paramFormat(pMap);
		builder.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>")
		.append("<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">")
		.append("<soap12:Body><")
		.append(functionName).append(" xmlns=\"http://WebXml.com.cn/\" >")
		.append(paramStr)
		.append("</").append(functionName).append("></soap12:Body></soap12:Envelope>");
		
		return builder.toString();
	}
	
	/**
	 * @Description: 参数格式化
	 * @author Blossom
	 * @time 2016年12月26日 下午8:38:54
	 * @return_type String
	 *
	 */
	private static String paramFormat(Map<String, String> pMap){
		
		StringBuilder builder = new StringBuilder();
		for (Map.Entry<String, String> entry : pMap.entrySet()) {
			String mKey = entry.getKey();
			String mValue = entry.getValue();
			builder.append("<").append(mKey).append(">").append(mValue).append("</").append(mKey).append(">");
		}
		return builder.toString();
	}
}
