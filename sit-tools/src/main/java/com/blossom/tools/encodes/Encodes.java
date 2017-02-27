package com.blossom.tools.encodes;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.StringEscapeUtils;

import com.blossom.tools.exception.SystemExceptionUtils;

/**
 * @Description:封装各种格式的编码解码工具类.
 * @author Blossom
 * @time 2017年2月27日 下午2:20:55
 */
public class Encodes {

	private static final String DEFAULT_URL_ENCODING = "UTF-8";
	private static final char[] BASE62 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();

	/**
	 * @Description: Hex编码
	 * @author Blossom
	 * @time 2017年2月27日 下午3:09:00
	 * @return_type String
	 *
	 */
	public static String encodeHex(byte[] input) {
		return new String(Hex.encodeHex(input));
	}

	/**
	 * @Description:Hex解码
	 * @author Blossom
	 * @time 2017年2月27日 下午3:09:09
	 * @return_type byte[]
	 *
	 */
	public static byte[] decodeHex(String input) {
		try {
			return Hex.decodeHex(input.toCharArray());
		} catch (DecoderException e) {
			throw SystemExceptionUtils.unchecked(e);
		}
	}

	/**
	 * @Description: Base64编码
	 * @author Blossom
	 * @time 2017年2月27日 下午3:09:18
	 * @return_type String
	 *
	 */
	public static String encodeBase64(byte[] input) {
		return new String(Base64.encodeBase64(input));
	}

	/**
	 * @Description: Base64编码
	 * @author Blossom
	 * @time 2017年2月27日 下午3:09:28
	 * @return_type String
	 *
	 */
	public static String encodeBase64(String input) {
		try {
			return new String(Base64.encodeBase64(input.getBytes(DEFAULT_URL_ENCODING)));
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}

	// /**
	// * Base64编码, URL安全(将Base64中的URL非法字符'+'和'/'转为'-'和'_', 见RFC3548).
	// */
	// public static String encodeUrlSafeBase64(byte[] input) {
	// return Base64.encodeBase64URLSafe(input);
	// }

	/**
	 * @Description: Base64解码
	 * @author Blossom
	 * @time 2017年2月27日 下午3:09:37
	 * @return_type byte[]
	 *
	 */
	public static byte[] decodeBase64(String input) {
		return Base64.decodeBase64(input.getBytes());
	}

	/**
	 * @Description: Base64解码
	 * @author Blossom
	 * @time 2017年2月27日 下午3:09:45
	 * @return_type String
	 *
	 */
	public static String decodeBase64String(String input) {
		try {
			return new String(Base64.decodeBase64(input.getBytes()), DEFAULT_URL_ENCODING);
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}

	/**
	 * @Description:Base62编码
	 * @author Blossom
	 * @time 2017年2月27日 下午3:09:53
	 * @return_type String
	 *
	 */
	public static String encodeBase62(byte[] input) {
		char[] chars = new char[input.length];
		for (int i = 0; i < input.length; i++) {
			chars[i] = BASE62[((input[i] & 0xFF) % BASE62.length)];
		}
		return new String(chars);
	}

	/**
	 * @Description:Html 转码
	 * @author Blossom
	 * @time 2017年2月27日 下午3:10:01
	 * @return_type String
	 *
	 */
	public static String escapeHtml(String html) {
		return StringEscapeUtils.escapeHtml4(html);
	}

	/**
	 * @Description:Html 解码
	 * @author Blossom
	 * @time 2017年2月27日 下午3:10:08
	 * @return_type String
	 *
	 */
	public static String unescapeHtml(String htmlEscaped) {
		return StringEscapeUtils.unescapeHtml4(htmlEscaped);
	}

	/**
	 * @Description:Xml 转码
	 * @author Blossom
	 * @time 2017年2月27日 下午3:10:16
	 * @return_type String
	 *
	 */
	public static String escapeXml(String xml) {
		return StringEscapeUtils.escapeXml10(xml);
	}

	/**
	 * @Description: Xml 解码
	 * @author Blossom
	 * @time 2017年2月27日 下午3:10:28
	 * @return_type String
	 *
	 */
	public static String unescapeXml(String xmlEscaped) {
		return StringEscapeUtils.unescapeXml(xmlEscaped);
	}

	/**
	 * @Description: URL 编码, Encode默认为UTF-8
	 * @author Blossom
	 * @time 2017年2月27日 下午3:10:42
	 * @return_type String
	 *
	 */
	public static String urlEncode(String part) {
		try {
			return URLEncoder.encode(part, DEFAULT_URL_ENCODING);
		} catch (UnsupportedEncodingException e) {
			throw SystemExceptionUtils.unchecked(e);
		}
	}

	/**
	 * @Description: URL 解码, Encode默认为UTF-8
	 * @author Blossom
	 * @time 2017年2月27日 下午3:10:51
	 * @return_type String
	 *
	 */
	public static String urlDecode(String part) {

		try {
			return URLDecoder.decode(part, DEFAULT_URL_ENCODING);
		} catch (UnsupportedEncodingException e) {
			throw SystemExceptionUtils.unchecked(e);
		}
	}

}
