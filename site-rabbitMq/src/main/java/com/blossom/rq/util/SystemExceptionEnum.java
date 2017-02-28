package com.blossom.rq.util;

/**
 * @Description: 异常类型枚举
 * @author Blossom
 * @time 2017年2月27日 下午4:21:18
 */
public enum SystemExceptionEnum {

	SYSTEM_INVOMPLELE_GRIDFS_ERROR("404","文件库不存在!"),
	SYSTEM_INVOMPLELE_COLLECTION_ERROR("403","集合不存在!"),
	SYSTEM_INVOMPLELE_DATABASE_ERROR("402","数据库不存在!"),
	SYSTEM_INVOMPLELE_CONFIGDATABASE_ERROR("401", "参数错误!"),
	SYSTEM_INCOMPLETE_PARAMETER_ERROR("400", "参数不全!");

	private String key;
	private String value;

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key
	 *            the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * @author Blossom
	 * @time 2017年2月27日 下午4:22:33
	 * @param key
	 * @param value
	 */
	private SystemExceptionEnum(String key, String value) {
		this.key = key;
		this.value = value;
	}

	// 重新toString方法，默认的toString方法返回的就是枚举变量的名字，和name()方法返回值一样
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{").append("'key' : ").append(this.key).append(" ;").append("'value' : ").append(this.value)
				.append("}");
		return builder.toString();
		// return this.key+":"+this.value;
	}

}
