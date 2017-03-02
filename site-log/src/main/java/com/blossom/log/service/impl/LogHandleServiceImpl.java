package com.blossom.log.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blossom.log.dao.ILogHandleDao;
import com.blossom.log.model.LogHandleModel;
import com.blossom.log.service.ILogHandleService;

import net.sf.json.JSONObject;

/**
 * @Description: 操作日志服务接口实现
 * @author Blossom
 * @time 2017年3月2日 下午4:02:14
 */
@Service("logHandleService")
public class LogHandleServiceImpl implements ILogHandleService {

	@Autowired
	private ILogHandleDao logHandleDaoImpl;
	
	/**
	 * @Description: 
	 * @author Blossom
	 * @time 2017年3月2日 下午4:02:14
	 * @see com.blossom.log.service.ILogHandleService#insertLogHandle(net.sf.json.JSONObject)
	 */
	public JSONObject insertLogHandle(JSONObject pJson) {
        JSONObject resultJSON = new JSONObject();
        try {
            LogHandleModel log = new LogHandleModel();
            String uuid = null;
//            if (!JsonUtils.checkJSONKey(pJson, "uuid")) {
                uuid = pJson.getString("uuid");
//            }
            log.setId(uuid);
            String url = null;
//            if (!JsonUtils.checkJSONKey(pJson, "url")) {
                url = pJson.getString("url");
//            }
            log.setHttpUrl(url);
            String httpMethod = null;
//            if (!JsonUtils.checkJSONKey(pJson, "httpMethod")) {
                httpMethod = pJson.getString("httpMethod");
//            }
            log.setHttpMethod(httpMethod);
            String broswer = pJson.getString("broswer");
//            if (!JsonUtils.checkJSONKey(pJson, "broswer")) {
                broswer = pJson.getString("broswer");
//            }
            log.setBroswer(broswer);
            String description = pJson.getString("description");
//            if (!JsonUtils.checkJSONKey(pJson, "description")) {
                description = pJson.getString("description");
//            }
            log.setDescription(description);
            String exceptionCode = null;
//            if (!JsonUtils.checkJSONKey(pJson, "exceptionCode")) {
                exceptionCode = pJson.getString("exceptionCode");
//            }
            log.setExceptionCode(exceptionCode);
            String exceptionDetail = null;
//            if (!JsonUtils.checkJSONKey(pJson, "exceptionDetail")) {
                exceptionDetail = pJson.getString("exceptionDetail");
//            }
            log.setExceptionDetail(exceptionDetail);
            String type = null;
//            if (!JsonUtils.checkJSONKey(pJson, "type")) {
                type = pJson.getString("type");
//            }
            log.setLogType(Integer.parseInt(type));
            String method = null;
//            if (!JsonUtils.checkJSONKey(pJson, "method")) {
                method = pJson.getString("method");
//            }
            log.setMethod(method);
            String params = null;
//            if (!JsonUtils.checkJSONKey(pJson, "params")) {
                params = pJson.getString("params");
//            }
            log.setParams(params);
            String createBy = null;
//            if (!JsonUtils.checkJSONKey(pJson, "createBy")) {
                createBy = pJson.getString("createBy");
//            }
            log.setUserName(createBy);
            String createDate = null;
//            if (!JsonUtils.checkJSONKey(pJson, "createDate")) {
                createDate = pJson.getString("createDate");
//            }
            log.setCreateDate(createDate);
            String requestIp = null;
//            if (!JsonUtils.checkJSONKey(pJson, "requestIp")) {
                requestIp = pJson.getString("requestIp");
//            }
            log.setRequestIp(requestIp);

           int tagInt =  logHandleDaoImpl.insertLogHandleInfo(log);
           if (tagInt == 0){
               resultJSON.put("status",-1);
               resultJSON.put("message","添加失败!");
               return resultJSON;
           }
            resultJSON.put("status",1);
            resultJSON.put("message","添加成功!");

        }catch (Exception e){
            resultJSON.put("status",0);
            resultJSON.put("message",e.getMessage());
        }
        return resultJSON;
	}

}
