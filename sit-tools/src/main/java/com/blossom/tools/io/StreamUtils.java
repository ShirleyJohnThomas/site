package com.blossom.tools.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;


/**
 * @Description: 将字节流转换为字符串
 * @author Blossom
 * @time 2017年2月27日 下午1:50:08
 */
public class StreamUtils {

	private final static int BUFFER_SIZE = 4096;

	/**
	 * @Description: 将InputStream转换成String
	 * @author Blossom
	 * @time 2017年2月27日 下午1:51:11
	 * @return_type String
	 *
	 */
	public static String InputStreamTOString(InputStream in) {

		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		byte[] data = new byte[BUFFER_SIZE];
		String string = null;
		int count = 0;
		try {
			while ((count = in.read(data, 0, BUFFER_SIZE)) != -1)
				outStream.write(data, 0, count);
		} catch (IOException e) {
			e.printStackTrace();
		}

		data = null;
		try {
			string = new String(outStream.toByteArray(), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return string;
	}

	/**
	 * @Description: 将InputStream转换成某种字符编码的String
	 * @author Blossom
	 * @time 2017年2月27日 下午1:51:32
	 * @return_type String
	 *
	 */
	public static String InputStreamTOString(InputStream in, String encoding) {
		String string = null;
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		byte[] data = new byte[BUFFER_SIZE];
		int count = -1;
		try {
			while ((count = in.read(data, 0, BUFFER_SIZE)) != -1)
				outStream.write(data, 0, count);
		} catch (IOException e) {
			e.printStackTrace();
		}

		data = null;
		try {
			string = new String(outStream.toByteArray(), encoding);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return string;
	}

	/**
	 * @Description: 将String转换成InputStream
	 * @author Blossom
	 * @time 2017年2月27日 下午1:51:45
	 * @return_type InputStream
	 *
	 */
	public static InputStream StringTOInputStream(String in) throws Exception {

		ByteArrayInputStream is = new ByteArrayInputStream(in.getBytes("UTF-8"));
		return is;
	}

	/**
	 * @Description:将String转换成InputStream
	 * @author Blossom
	 * @time 2017年2月27日 下午1:51:59
	 * @return_type byte[]
	 *
	 */
	public static byte[] StringTObyte(String in) {
		byte[] bytes = null;
		try {
			bytes = InputStreamTOByte(StringTOInputStream(in));
		} catch (IOException e) {
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bytes;
	}

	/**
	 * 将InputStream转换成byte数组
	 * 
	 * @param in
	 *            InputStream
	 * @return byte[]
	 * @throws IOException
	 */
	public static byte[] InputStreamTOByte(InputStream in) throws IOException {

		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		byte[] data = new byte[BUFFER_SIZE];
		int count = -1;
		while ((count = in.read(data, 0, BUFFER_SIZE)) != -1)
			outStream.write(data, 0, count);

		data = null;
		return outStream.toByteArray();
	}

	/**
	 * @Description: 将byte数组转换成InputStream
	 * @author Blossom
	 * @time 2017年2月27日 下午1:52:09
	 * @return_type InputStream
	 *
	 */
	public static InputStream byteTOInputStream(byte[] in) throws Exception {

		ByteArrayInputStream is = new ByteArrayInputStream(in);
		return is;
	}

	/**
	 * @Description: 将byte数组转换成String
	 * @author Blossom
	 * @time 2017年2月27日 下午1:52:19
	 * @return_type String
	 *
	 */
	public static String byteTOString(byte[] in) {

		String result = null;
		InputStream is = null;
		try {
			is = byteTOInputStream(in);
			result = InputStreamTOString(is, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * @Description:
	 * @author Blossom
	 * @time 2017年2月27日 下午1:52:30
	 * @return_type String
	 *
	 */
	public static String getString(String in) {

		String is = null;
		try {
			is = byteTOString(StringTObyte(in));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return is;
	}

	/**
	 * @Description: InputStream 转换成byte[]
	 * @author Blossom
	 * @time 2017年2月27日 下午1:53:01
	 * @return_type byte[]
	 *
	 */
	public byte[] getBytes(InputStream is) throws IOException {

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] b = new byte[BUFFER_SIZE];
		int len = 0;

		while ((len = is.read(b, 0, BUFFER_SIZE)) != -1) {
			baos.write(b, 0, len);
		}

		baos.flush();

		byte[] bytes = baos.toByteArray();

		System.out.println(new String(bytes));

		return bytes;
	}

	/**
	 * @Description:根据文件路径创建文件输入流处理
	 * @author Blossom
	 * @time 2017年2月27日 下午1:53:26
	 * @return_type FileInputStream
	 *
	 */
	public static FileInputStream getFileInputStream(String filepath) {
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(filepath);
		} catch (FileNotFoundException e) {
			System.out.print("错误信息:文件不存在");
			e.printStackTrace();
		}
		return fileInputStream;
	}

	/**
	 * @Description: 根据文件对象创建文件输入流处理
	 * @author Blossom
	 * @time 2017年2月27日 下午1:54:05
	 * @return_type FileInputStream
	 *
	 */
	public static FileInputStream getFileInputStream(File file) {
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			System.out.print("错误信息:文件不存在");
			e.printStackTrace();
		}
		return fileInputStream;
	}

	/**
	 * @Description: 根据文件对象创建文件输出流处理
	 * @author Blossom
	 * @time 2017年2月27日 下午1:54:34 以字节为单位（非 unicode ）
	 * @param file
	 * @param append
	 *            true:文件以追加方式打开,false:则覆盖原文件的内容
	 * @return_type FileOutputStream
	 *
	 */
	public static FileOutputStream getFileOutputStream(File file, boolean append) {
		FileOutputStream fileOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream(file, append);
		} catch (FileNotFoundException e) {
			System.out.print("错误信息:文件不存在");
			e.printStackTrace();
		}
		return fileOutputStream;
	}

	/**
	 * @Description: 根据文件路径创建文件输出流处理 以字节为单位（非 unicode ）
	 * @param path
	 * @param append
	 *            true:文件以追加方式打开,false:则覆盖原文件的内容
	 * @author Blossom
	 * @time 2017年2月27日 下午1:54:59
	 * @return_type FileOutputStream
	 *
	 */
	public static FileOutputStream getFileOutputStream(String filepath, boolean append) {
		FileOutputStream fileOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream(filepath, append);
		} catch (FileNotFoundException e) {
			System.out.print("错误信息:文件不存在");
			e.printStackTrace();
		}
		return fileOutputStream;
	}

	public static File getFile(String filepath) {
		return new File(filepath);
	}

	public static ByteArrayOutputStream getByteArrayOutputStream() {
		return new ByteArrayOutputStream();
	}

}
