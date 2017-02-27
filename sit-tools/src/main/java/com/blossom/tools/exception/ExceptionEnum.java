package com.blossom.tools.exception;


/**
 * @Description: 异常枚举模板
 * @author Blossom
 * @time 2017年2月19日 上午10:19:23
 */
public enum ExceptionEnum {
	
	SYSTEM_INCOMPLETE_PARAMETER_ERROR("404","参数不全!");
	
	 private String key;
	 private String value;
	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}
	/**
	 * @param key the key to set
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
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
	/**
	 * @author Blossom
	 * @time 2017年2月19日 上午10:33:38
	 * @param key
	 * @param value
	 */
	private ExceptionEnum(String key, String value) {
		this.key = key;
		this.value = value;
	}
	
	//重新toString方法，默认的toString方法返回的就是枚举变量的名字，和name()方法返回值一样  
    @Override  
    public String toString()  
    {  
    	StringBuilder builder = new StringBuilder();
    	builder.append("{").append("'key' : ").append(this.key).append(" ;")
    	.append("'value' : ").append(this.value).append("}");
    	return builder.toString();	
       // return this.key+":"+this.value;  
    } 
	 

}
