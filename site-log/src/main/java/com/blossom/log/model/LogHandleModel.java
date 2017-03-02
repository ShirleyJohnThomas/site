package com.blossom.log.model;

import java.io.Serializable;

/**
 * @Description: 操作日志模型
 * @author Blossom
 * @time 2017年3月2日 下午3:21:15
 */
public class LogHandleModel implements Serializable{

    private static final long serialVersionUID = 6498460786806531797L;
	//编号
    private String id;
    //日志类型
    private Integer logType;
    //请求url
    private String httpUrl;
    //请求类型(post,get)
    private String httpMethod;
    //说明
    private String description;
    //方法
    private String method;
    //请求IP
    private String requestIp;
    //异常编码
    private String exceptionCode;
    //异常信息
    private String exceptionDetail;
    //参数
    private String params;
    //操作用户
    private String userName;
    //操作时间
    private String createDate;
    //浏览器
    private String broswer;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getLogType() {
        return logType;
    }

    public void setLogType(Integer logType) {
        this.logType = logType;
    }

    public String getHttpUrl() {
        return httpUrl;
    }

    public void setHttpUrl(String httpUrl) {
        this.httpUrl = httpUrl;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getRequestIp() {
        return requestIp;
    }

    public void setRequestIp(String requestIp) {
        this.requestIp = requestIp;
    }

    public String getExceptionCode() {
        return exceptionCode;
    }

    public void setExceptionCode(String exceptionCode) {
        this.exceptionCode = exceptionCode;
    }

    public String getExceptionDetail() {
        return exceptionDetail;
    }

    public void setExceptionDetail(String exceptionDetail) {
        this.exceptionDetail = exceptionDetail;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getBroswer() {
        return broswer;
    }

    public void setBroswer(String broswer) {
        this.broswer = broswer;
    }

    @Override
    public String toString() {
        return "LogModel{" +
                "id='" + id + '\'' +
                ", logType=" + logType +
                ", httpUrl='" + httpUrl + '\'' +
                ", httpMethod='" + httpMethod + '\'' +
                ", description='" + description + '\'' +
                ", method='" + method + '\'' +
                ", requestIp='" + requestIp + '\'' +
                ", exceptionCode='" + exceptionCode + '\'' +
                ", exceptionDetail='" + exceptionDetail + '\'' +
                ", params='" + params + '\'' +
                ", userName='" + userName + '\'' +
                ", createDate='" + createDate + '\'' +
                ", broswer='" + broswer + '\'' +
                '}';
    }

}
